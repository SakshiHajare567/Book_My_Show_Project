package com.example.Book_My_Show_May.Service;

import com.example.Book_My_Show_May.Controllers.UserController;
import com.example.Book_My_Show_May.Convertor.UserConvertor;
import com.example.Book_My_Show_May.Entities.UserEntity;
import com.example.Book_My_Show_May.EntryDtos.UserEntryDto;
import com.example.Book_My_Show_May.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    /*public void addUser(UserEntryDto userEntryDto){
        UserEntity userEntity = UserEntity.builder()
                .name(userEntryDto.getName())
                .age(userEntryDto.getAge())
                .mobNo(userEntryDto.getMobNo())
                .email(userEntryDto.getEmail())
                .address(userEntryDto.getAddress())
                .build();
        userRepository.save(userEntity);
    }*/

   /* public void addUser(UserEntryDto userEntryDto) {
        UserEntity userEntity = new UserEntity();

        // Set values using setters
        userEntity.setName(userEntryDto.getName());
        userEntity.setAge(userEntryDto.getAge());
        userEntity.setMobNo(userEntryDto.getMobNo());
        userEntity.setEmail(userEntryDto.getEmail());
        userEntity.setAddress(userEntryDto.getAddress());

        userRepository.save(userEntity);
    }*/

    //call the function of user convertor

    public String addUser(UserEntryDto userEntryDto) throws Exception {
        UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);
        return "User added successfully";
    }


}
