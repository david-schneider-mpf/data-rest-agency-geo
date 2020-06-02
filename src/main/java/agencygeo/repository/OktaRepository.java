package agencygeo.repository;

import agencygeo.model.User;

import java.util.List;
import java.util.Optional;

public interface OktaRepository  {

    public User save(User u);
    public List<User> findAll();
    public Optional<User> findById(String id);
    public Optional<User> findByEmail(String email);
/*
    @Autowired
    private final Client client = Clients.builder()
            .setCacheManager(Caches.newDisabledCacheManager()).setOrgUrl("https://dev-256811.oktapreview.com")
            .setClientCredentials(new TokenClientCredentials("009B6EJ1koenFUshhRlahs8134QCLd2_g1oxJD6IZw")).build();

    @Override
    public Iterable<User> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable<User> saveAll(Iterable iterable) {
        return null;
    }

    @Override
    public <S extends User> S save(S s) {
        return null;
    }

    @Override
    public Optional<User> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<User> findAll() {
        return client.getDataStore().getResource("https://dev-256811.oktapreview.com/api/v1/users", UserList.class);
    }

    @Override
    public Iterable<User> findAllById(Iterable iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void deleteAll(Iterable iterable) {

    }

    @Override
    public void deleteAll() {

    }
*/
}