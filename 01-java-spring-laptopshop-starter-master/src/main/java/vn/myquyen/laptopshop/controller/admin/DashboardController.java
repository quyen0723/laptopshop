package vn.myquyen.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.myquyen.laptopshop.service.OrderService;
import vn.myquyen.laptopshop.service.ProductService;
import vn.myquyen.laptopshop.service.UserService;

@Controller
public class DashboardController {
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    public DashboardController(UserService userService, ProductService productService, OrderService orderService) {
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }

    @GetMapping("/admin")
    public String getDashboard(Model model) {
        model.addAttribute("countUser", this.userService.countUsers());
        model.addAttribute("countProduct", this.productService.countProducts());
        model.addAttribute("countOrder", this.orderService.countOrders());
        return "admin/dashboard/show";
    }
}
