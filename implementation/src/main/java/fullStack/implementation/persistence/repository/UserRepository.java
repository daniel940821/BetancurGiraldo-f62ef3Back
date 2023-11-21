package fullStack.implementation.persistence.repository;

import fullStack.implementation.persistence.entity.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User,Integer> {
    User findByEmail(String email);
}
