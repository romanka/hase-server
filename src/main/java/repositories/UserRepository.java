package repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
	User findByName(String name);
	User findByUsername(String username);
	User findByToken(String token);
}
