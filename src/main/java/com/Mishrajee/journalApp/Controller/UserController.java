package com.Mishrajee.journalApp.Controller;

import com.Mishrajee.journalApp.ApiResponse.WeatherResponse;
import com.Mishrajee.journalApp.Entity.User;
import com.Mishrajee.journalApp.Repository.UserRepo;
import com.Mishrajee.journalApp.Service.UserService;
import com.Mishrajee.journalApp.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WeatherService weatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User userInDb =userService.findByUserName(userName);
            userInDb.setUserName(userInDb.getUserName());
            userInDb.setPassword(userInDb.getPassword());
            userService.saveEntry(userInDb);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteByUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepo.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> weather(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse= weatherService.getWeather("Mumbai");
        String greeting="";
        if(weatherResponse!=null){
            greeting=" ,Weather feels like " + weatherResponse.getCurrent().getFeelsLike();
        }
        return new ResponseEntity<>("Hi "+authentication.getName()+greeting,HttpStatus.OK);
    }
}
