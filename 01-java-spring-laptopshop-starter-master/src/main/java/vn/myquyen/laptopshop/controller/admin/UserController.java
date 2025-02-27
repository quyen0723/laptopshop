package vn.myquyen.laptopshop.controller.admin;

import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.myquyen.laptopshop.domain.Role;
import vn.myquyen.laptopshop.domain.User;
import vn.myquyen.laptopshop.repository.UserRepository;
import vn.myquyen.laptopshop.service.RoleService;
import vn.myquyen.laptopshop.service.UploadService;
import vn.myquyen.laptopshop.service.UserService;

import java.util.List;

//Mô hình MCV
@Controller
public class UserController {


    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    //    DI : dependency ịnection
    private UserService userService;

    public UserController(UploadService uploadService,
                          UserRepository userRepository,
                          UserService userService,
                          PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> users = this.userService.getAllUsersByEmail("test1@gmail.com");
        System.out.println("Homepage list user" + users);
        model.addAttribute("myquyen", "test");
        model.addAttribute("test", "test 1");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("userList", users);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        System.out.println("Check path id" + id);
        User user = this.userService.getUserById(id);
        if (user == null) {
            model.addAttribute("errorMessage", "User not found!");
            return "admin/user/error"; // Hiển thị trang lỗi nếu không tìm thấy
        }
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/detail";
    }


    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") @Valid User user,
                                 BindingResult newUserBindingResult,
                                 @RequestParam("hoidanitFile") MultipartFile file) {


        if (newUserBindingResult.hasErrors()) {
            return "admin/user/create";
        }

        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(user.getPassword());
        System.out.println("Run here" + user);

        user.setAvatar(avatar);
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName(user.getRole().getName()));
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("newUser", currentUser);
        model.addAttribute("roles", roles);
        model.addAttribute("id", id);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") @Valid User user,
                                 @RequestParam("hoidanitFile") MultipartFile file, RedirectAttributes redirectAttributes) {
        System.out.println("🔄 Bắt đầu cập nhật User ID: " + user.getId());
        User currentUser = this.userService.getUserById(user.getId());
        if (currentUser != null) {
            System.out.println("✅ User tồn tại: " + currentUser.getFullName());
            currentUser.setAddress(user.getAddress());
            currentUser.setFullName(user.getFullName());
            currentUser.setPhone(user.getPhone());
            // Xử lý cập nhật role
            Role newRole = roleService.getRoleById(user.getRole().getId());
            currentUser.setRole(newRole);
            System.out.println("✅ Role đã cập nhật: " + newRole.getName());
//            currentUser.setRole(user.getRole());


            if (!file.isEmpty()) {
                // Lưu ảnh vào thư mục images/avatar
                String avatarFileName = uploadService.handleSaveUploadFile(file, "avatar");
                System.out.println("📸 Avatar mới upload: " + avatarFileName);
                if (!avatarFileName.isEmpty()) {
                    String avatarPath = "/images/avatar/" + avatarFileName;
                    currentUser.setAvatar(avatarPath);
                    System.out.println("✅ Cập nhật avatar thành công: " + avatarPath);
                } else {
                    System.out.println("❌ Không có avatar mới, giữ nguyên avatar cũ.");
                }
            }

            // Lưu user vào database
            this.userService.handleSaveUser(currentUser);
            System.out.println("✅ User cập nhật thành công!");

            redirectAttributes.addFlashAttribute("success", "User updated successfully!");
        } else {
            System.out.println("❌ Không tìm thấy user với ID: " + user.getId());
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String deleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
//        User user = new User();
//        user.setId(id);

        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUserUser(Model model, @ModelAttribute("newUser") User user) {

        this.userService.deleteAUser(user.getId());
        return "redirect:/admin/user";
    }
}
