package com.example.realestate;

import com.example.realestate.services.FilesStorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class RealestateApplication implements CommandLineRunner {
    @Resource
    FilesStorageService storageService;
    public static void main(String[] args) {
        SpringApplication.run(RealestateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("create storage folder");
        storageService.init();
    }
}
