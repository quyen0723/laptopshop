package vn.myquyen.laptopshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.myquyen.laptopshop.domain.Role;
import vn.myquyen.laptopshop.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleService() {
        System.out.println("✅ RoleService đã được khởi tạo!"); // Log kiểm tra
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
