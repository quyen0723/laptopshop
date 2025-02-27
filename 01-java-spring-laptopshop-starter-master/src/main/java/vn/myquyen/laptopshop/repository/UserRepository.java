package vn.myquyen.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.myquyen.laptopshop.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    void deleteById(Long id);

    List<User> findOneByEmail(String email);

    //    List<User> findOneById(long id);
    Optional<User> findOneById(long id);

    List<User> findAll();

    boolean existsByEmail(String email);

    User findByEmail(String email);
}
