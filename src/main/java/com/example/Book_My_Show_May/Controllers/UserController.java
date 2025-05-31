package com.example.Book_My_Show_May.Controllers;

import com.example.Book_My_Show_May.EntryDtos.UserEntryDto;
import com.example.Book_My_Show_May.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add_user")
    public String addUser(@RequestBody UserEntryDto userEntryDto) {
        userService.addUser(userEntryDto);
        return "User added successfully!";
    }

}
