package agencygeo.repository;

import agencygeo.model.User;
import com.okta.sdk.authc.credentials.TokenClientCredentials;
import com.okta.sdk.cache.Caches;
import com.okta.sdk.client.Client;
import com.okta.sdk.client.Clients;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.sdk.resource.user.UserList;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OktaRepositoryImpl implements OktaRepository {

    private final Client client = Clients.builder()
            .setCacheManager(Caches.newDisabledCacheManager()).setOrgUrl("https://dev-256811.oktapreview.com")
            .setClientCredentials(new TokenClientCredentials("009B6EJ1koenFUshhRlahs8134QCLd2_g1oxJD6IZw")).build();

    public User save(User u) {
        com.okta.sdk.resource.user.User user = UserBuilder.instance()
                .setFirstName(u.getFirstName())
                .setLastName(u.getLastName())
                .setEmail(u.getEmail())
                .setLogin(u.getEmail())
                .buildAndCreate(client);
        return new User(user.getId(), user.getProfile().getFirstName(), user.getProfile().getLastName(), user.getProfile().getEmail());
    }

    public List<User> findAll() {
        return client.getDataStore().getResource("https://dev-256811.oktapreview.com/api/v1/users", UserList.class)
                .stream()
                .map(u -> new User(u.getId(), u.getProfile().getFirstName(), u.getProfile().getLastName(), u.getProfile().getLogin()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(client.getUser(id)).map(u -> new User(u.getId(), u.getProfile().getFirstName(), u.getProfile().getLastName(), u.getProfile().getLogin()));
    }

    @Override
    public Optional<User> findByEmail(@Param("email") String email) {
        return client.getDataStore().getResource("https://dev-256811.oktapreview.com/api/v1/users?filter=profile.login eq \"" + email + "\"", UserList.class)
                .stream().findFirst()
                .map(u -> new User(u.getId(), u.getProfile().getFirstName(), u.getProfile().getLastName(), u.getProfile().getLogin()));
    }

}