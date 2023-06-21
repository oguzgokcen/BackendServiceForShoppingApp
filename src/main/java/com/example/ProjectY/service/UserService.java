package com.example.ProjectY.service;

import com.example.ProjectY.models.ImageData;
import com.example.ProjectY.models.ItemData;
import com.example.ProjectY.models.User;
import com.example.ProjectY.repository.ItemRepository;
import com.example.ProjectY.repository.StorageRepository;
import com.example.ProjectY.repository.UserRepository;
import com.example.ProjectY.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    StorageRepository repository;

    @Autowired
    ItemRepository itemRepository;
    public User registerNewUserServiceMethod(User user){
        return userRepository.save(user);
    }
    public List<String> checkUserEmail(String email){
        return userRepository.checkUserEmail(email);
    }
    // End Of Check User Email Services Method.

    public String checkUserPasswordByEmail(String email){
        return userRepository.checkUserPasswordByEmail(email);
    }
    // End Of Check User Password Services Method.

    public User getUserDetailsByEmail(String email){
        return userRepository.GetUserDetailsByEmail(email);
    }

    // METHODS FOR ITEMDATA
    public ItemData saveItemData(ItemData itemData){return itemRepository.save(itemData);}
    public List<ItemData> getItemData(){return itemRepository.findAll();}

    // END OF ITEMDATA

    //GET IMAGE FROM POST MAPPING
    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        System.out.println("UPLOADED"+ file.getOriginalFilename());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }
    //RETURN IMAGE BY NAME
    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
