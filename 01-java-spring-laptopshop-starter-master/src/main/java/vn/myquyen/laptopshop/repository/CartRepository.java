package vn.myquyen.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.myquyen.laptopshop.domain.Cart;
import vn.myquyen.laptopshop.domain.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
