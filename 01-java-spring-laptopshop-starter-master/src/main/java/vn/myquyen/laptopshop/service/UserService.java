package vn.myquyen.laptopshop.service;

import org.springframework.stereotype.Service;
import vn.myquyen.laptopshop.domain.Role;
import vn.myquyen.laptopshop.domain.User;
import vn.myquyen.laptopshop.domain.dto.RegisterDTO;
import vn.myquyen.laptopshop.repository.RoleRepository;
import vn.myquyen.laptopshop.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "Hello from service";
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByEmail(String email) {
        return this.userRepository.findOneByEmail(email);
    }

    public User getUserById(long id) {
        return this.userRepository.findOneById(id).orElse(null);
    }

    public User handleSaveUser(User user) {
        User myquyen = this.userRepository.save(user);
        System.out.println("Run service here" + myquyen);
        return myquyen;
    }

    public void deleteAUser(long id) {
        this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    public boolean checkEmailExist(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public User registerDTOtoUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        return user;
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
