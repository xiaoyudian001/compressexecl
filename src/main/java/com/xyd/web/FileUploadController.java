package com.xyd.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
@Controller
public class FileUploadController {
    @RequestMapping("/")
    public String welcome() {
        return "upload.html";
    }
    @RequestMapping("/uploadFile")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
           //
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = sdf.format(new Date());
        File folder = new File(realPath + format);
        String filePath = "";
        if (!folder.isDirectory()) {
            folder.mkdirs();
            String oldName = file.getOriginalFilename();
            String newName = UUID.randomUUID().toString() +
                    oldName.substring(oldName.lastIndexOf("."), oldName.length());
            try {
                file.transferTo(new File(folder, newName));
                filePath = request.getScheme() + "://" + request.getServerName() + ":" +
                        request.getServerPort() + "/uploadFile/" + format + newName;

            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败! ";
            }
        }
        return filePath;
    }

    int count = 0;
}
