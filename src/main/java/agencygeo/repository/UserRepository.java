package agencygeo.repository;

import agencygeo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>, OktaRepository {
}
