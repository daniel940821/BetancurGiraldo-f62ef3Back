package fullStack.implementation.service;

import fullStack.implementation.persistence.entity.User;
import fullStack.implementation.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return this.userRepository.findAll();
    }

    public User getUser(int id){
        return this.userRepository.findById(id).orElse(null);
    }

    public Optional<User> getUserEmail(String email){
        return Optional.ofNullable(this.userRepository.findByEmail(email));
    }
    public User save (User user){
        return this.userRepository.save(user);
    }

    public boolean exist(int id){
        return this.userRepository.existsById(id);
    }

    public void delete(int id){
        this.userRepository.deleteById(id);
    }
}
