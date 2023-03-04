package com.example.interviewcustomrestservice.api.controller;


import com.example.interviewcustomrestservice.api.models.User;
import com.example.interviewcustomrestservice.responses.ResponsesHandler;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import com.example.interviewcustomrestservice.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class MultiRequestController {

    private UserService UserSvce;

    @Autowired
    public MultiRequestController(UserService userService) {
        this.UserSvce = userService;
    }
//    public User getUser () {
        @GetMapping("/idResp")
    public ResponseEntity<Object> getExceptionResp(@RequestParam String id){

        User retrirvedUsr = UserSvce.getUser(id);
        return ResponsesHandler.Responsemaker( "User found", HttpStatus.OK, retrirvedUsr);
    }

    @RequestMapping(value = "/createUser",method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<Object>  postUser (@RequestBody User ReqBdy_user) {

        HttpStatus Pst_status1;
        HttpStatus Pst_status2;
        String CustomRespMessage;
        List<User> retrirvedUsrs = new ArrayList<>();

        User retrirvedUsr= ReqBdy_user;

        retrirvedUsrs.add(retrirvedUsr);

        UserSvce.UsrDB_Cache = retrirvedUsrs;

        if (UserSvce.ValidateUserIDDuplication() || !UserSvce.UserIDValididty_Check()) {

            CustomRespMessage = " Invalid ID ,Please Check your ID Entry and Verify that your ID is valid...";
            Pst_status1 = HttpStatus.BAD_REQUEST;

        }
        else if (UserSvce.ValidateMobileNumbDuplication()){
            CustomRespMessage = " Mobile Number already exists, Please verify mobile number entry...";
            Pst_status1 = HttpStatus.BAD_REQUEST;
        }
        else
        {

            UserSvce.UsrDB_Simulation.add(retrirvedUsrs.get(retrirvedUsrs.size() - 1));

            Pst_status1 = HttpStatus.CREATED;

            CustomRespMessage = "Welcome to Our System "+" "+retrirvedUsr.getFirstName()+" "+"You are a regitered User now";


        }

        return ResponsesHandler.Responsemaker( CustomRespMessage, Pst_status1, retrirvedUsr);



    }



   //@RequestMapping(value = "/updateUser/{userId}", method = RequestMethod.PUT,consumes = "application/json")
    @PutMapping(value="/updateUser/{userId}")
    public ResponseEntity<Object>  updateUser (@PathVariable String userId,  @RequestBody User ReqBdy_user) {

        HttpStatus Pst_status1;
        HttpStatus Pst_status2;
        String CustomRespMessage;
        List<User> retrirvedUsrs = new ArrayList<>();

        User retrirvedUsr= ReqBdy_user;

       retrirvedUsrs.add(retrirvedUsr);

        //retrirvedUsr.getIdNumber();

       UserSvce.UpdateUser(userId, retrirvedUsr);


       //UserSvce.UsrDB_Cache = retrirvedUsrs;

        if (UserSvce.UserNotFound) {

            CustomRespMessage = " User does not exist. Verify that your ID is valid...";
            Pst_status1 = HttpStatus.BAD_REQUEST;

        }
        else
        {

            UserSvce.UsrDB_Simulation.contains(UserSvce.getUser(userId));  //.add(retrirvedUsrs.get(retrirvedUsrs.size() - 1));

            Pst_status1 = HttpStatus.OK;

            CustomRespMessage = "User updated";


        }

        return ResponsesHandler.Responsemaker( CustomRespMessage, Pst_status1, UserSvce.UsrDB_Simulation.get(UserSvce.userIndx) ); //(UserSvce.getUser(userId)));

    }

    @GetMapping("/user")
   public User getUser (@RequestParam String id) {

        User retrirvedUsr = UserSvce.getUser(id);

//            id = "ZN676380";
            return retrirvedUsr;

    }
}
