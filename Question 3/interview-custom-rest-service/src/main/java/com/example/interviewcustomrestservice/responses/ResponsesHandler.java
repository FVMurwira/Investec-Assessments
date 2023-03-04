package com.example.interviewcustomrestservice.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponsesHandler {

    public static ResponseEntity<Object> Responsemaker(

            String message, HttpStatus httpStatus, Object respobj)
    {
        Map<String, Object> respmap = new HashMap<>();
            respmap.put("message", message);
            respmap.put("httpstatus", httpStatus);
            respmap.put("data", respobj);

            return new ResponseEntity<>(respmap, httpStatus);
    }
}
