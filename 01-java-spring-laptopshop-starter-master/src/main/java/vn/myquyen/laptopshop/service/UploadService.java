package vn.myquyen.laptopshop.service;

import jakarta.servlet.ServletContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UploadService {
    private final ServletContext servletContext;

    public UploadService(
            ServletContext servletContext) {

        this.servletContext = servletContext;
    }

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) {
        // don't upload file
        if (file.isEmpty()) {
            System.out.println("❌ File upload bị rỗng!");
            return "";
        }
        // relative path: absolute path
//        String rootPath = this.servletContext.getRealPath("/static/images");
        String rootPath = "D:/JAVAMVC/01-java-spring-laptopshop-starter-master/01-java-spring-laptopshop-starter-master/src/main/resources/static/images";

        System.out.println("🔍 Root Path: " + rootPath);
        String finalName = "";
        try {
            byte[] bytes = file.getBytes();

            File dir = new File(rootPath + File.separator + targetFolder);
            if (!dir.exists()) {
                System.out.println("📂 Folder không tồn tại, tạo mới: " + dir.getAbsolutePath());
                dir.mkdirs();
            }
            // Create the file on server
            finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();

            File serverFile = new File(dir.getAbsolutePath() + File.separator + finalName);
            // uuid

            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("❌ Lỗi khi lưu file!");
            e.printStackTrace();
        }
        return finalName;
    }

}
