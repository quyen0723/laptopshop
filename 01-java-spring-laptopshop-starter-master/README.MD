# Java Spring Starter template

## Thông tin tác giả

- **Tên**: Nguyễn Ngọc Mỹ Quyên
- **Nguồn học**: Hoi Dan IT

## Công nghệ sử dụng

### Backend (Java)

- **Spring Boot**: Bootstrapping project, giúp khởi tạo nhanh chóng các thành phần cần thiết.
- **Spring MVC**: Sử dụng mô hình Model-View-Controller để tổ chức mã nguồn.
- **Spring Security**: Bảo vệ route với role (dạng basic authentication & authorization).
- **Spring Data (Hibernate/JPA)**: Sử dụng ORM (Object Relational Mapping) để mô hình hóa Model.
    - Học cách tư duy phân tích database và ràng buộc relationship.
- **Build Tool**: Maven

### Frontend

- **Ngôn ngữ**: HTML, CSS, JavaScript
- **View Engine**: JSP (JavaServer Pages)
- **AJAX**: Gọi APIs mà không cần reload trang.

### Database

- **Hệ Quản Trị CSDL**: MySQL
- **Phần mềm quản lý**: MySQL WorkBench

## Hướng dẫn cài đặt & Chạy dự án

1. **Clone repo**:
   ```sh
   git clone <repo-link>
   ```
2. **Import project vào IDE** (IntelliJ IDEA, Eclipse...)
3. **Cài đặt dependencies**:
   ```sh
   mvn clean install
   ```
4. **Chỉnh sửa `application.properties` để kết nối database**
5. **Chạy project**:
   ```sh
   mvn spring-boot:run
   ```

## Ghi chú

- Luôn kiểm tra các dependency trong `pom.xml` để đảm bảo không bị xung đột.
- Kiểm tra console log khi chạy server để phát hiện lỗi nhanh chóng.

---
Có thể cập nhật README khi có tính năng mới hoặc thay đổi quan trọng!



