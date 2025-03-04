package vn.myquyen.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.myquyen.laptopshop.domain.Order;
import vn.myquyen.laptopshop.domain.User;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
