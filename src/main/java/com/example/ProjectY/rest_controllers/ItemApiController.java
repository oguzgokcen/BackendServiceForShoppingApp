package com.example.ProjectY.rest_controllers;

import com.example.ProjectY.models.ItemData;
import com.example.ProjectY.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

// MANAGING ITEM CONTROLLER
@RestController
@RequestMapping("/api/v1")
public class ItemApiController {
    @Autowired
    private UserService service;

    @PostMapping("/addItem")
    public ResponseEntity<?> uploadImage(@RequestBody MultipartFile file) throws IOException {
        String uploadImage = service.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName){
        // GET BYTE ARRAY FROM SERVİCE AND SEND IT
        byte[] imageData=service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    // METHODS FOR ITEMDATA
    @PostMapping("/addItemObject")
    public ResponseEntity<?> enterItemData(@RequestBody ItemData itemData){
        ItemData result = service.saveItemData(itemData);
        if (result == null) {
            System.out.println("RESPONSE FAİL");
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
        System.out.println("RESPONSE SUCCESS");
        return new ResponseEntity<>("client success", HttpStatus.OK);
    }

    @GetMapping("/getItems")
    public ResponseEntity<?> getItemData(){
        List<ItemData> itemDataList = service.getItemData();
        if (itemDataList == null) {
            System.out.println("RESPONSE FAİL");
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(itemDataList,HttpStatus.OK);
    }
}
