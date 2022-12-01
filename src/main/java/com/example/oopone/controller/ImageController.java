//package com.example.oopone.controller;
//
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@RestController
//@RequestMapping(path = "image")
//@CrossOrigin
//public class ImageController {
//    private static String imageDirectory = System.getProperty("user.dir")+"/images";
//
//    @RequestMapping(value = "/image",produces = {MediaType.IMAGE_PNG_VALUE,"application/json"})
//    public ResponseEntity<?> uploadImage(@RequestParam("imageFile") MultipartFile file,
//                                         @RequestParam("imageName") String name){
//        makeDirectoryIfNotExist(imageDirectory);
//        Path fileNamePath = Paths.get(imageDirectory,
//                name.concat(".").concat(FilenameUtils.getExtension(file.getOriginalFilename())));
//        try{
//            Files.write(fileNamePath,file.getBytes());
//            return new ResponseEntity<>(name,HttpStatus.CREATED);
//        }
//        catch (IOException io){
//            return new ResponseEntity<>("Image is not uploaded",HttpStatus.OK);
//        }
//    }
//
//    private void makeDirectoryIfNotExist(String imageDirectory){
//        File directory = new File(imageDirectory);
//        if(!directory.exists()){
//            directory.mkdir();
//        }
//    }
//}
