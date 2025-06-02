package com.example.Book_My_Show_May.Convertor;

import com.example.Book_My_Show_May.Entities.UserEntity;
import com.example.Book_My_Show_May.EntryDtos.UserEntryDto;

public class UserConvertor {

    /*public static UserEntity convertDtoToEntity (UserEntryDto userEntryDto){
        UserEntity userEntity=UserEntryDto.builder()
                .age(userEntryDto.getAge())
                .name(userEntryDto.getName())
                .mobNo(userEntryDto.getMobNo())
                .email(userEntryDto.getEmail())
                .address(userEntryDto.getAddress())
                .build();
        return userEntity;
    }*/

    public static UserEntity convertDtoToEntity (UserEntryDto userEntryDto){
        UserEntity userEntity = new UserEntity();

        // Set values using setters
        userEntity.setName(userEntryDto.getName());
        userEntity.setAge(userEntryDto.getAge());
        userEntity.setMobNo(userEntryDto.getMobNo());
        userEntity.setEmail(userEntryDto.getEmail());
        userEntity.setAddress(userEntryDto.getAddress());
        return  userEntity ;
    }
}
