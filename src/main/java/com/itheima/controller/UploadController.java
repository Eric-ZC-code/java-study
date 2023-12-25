package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{}, {}, {}", username, age, image);

        //构造唯一文件名-uuid
        String originalFilename = image.getOriginalFilename();
        String newFilename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));


        //将文件存储在本地
        image.transferTo(new File("D:\\图片\\Saved Pictures\\"+newFilename));
        return Result.success();
    }
}
