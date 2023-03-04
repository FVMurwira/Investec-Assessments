package com.example.interviewcustomrestservice.services;


import com.example.interviewcustomrestservice.api.models.User;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.locks.Condition;

@Service
public class UserService {

    public List<User> UsrDB_Simulation;
    public List<User> UsrDB_Cache;
    private int indexOf;

    public UserService() {
        UsrDB_Simulation = new ArrayList<>();

        User user1 = new User("Matthew","Bosh","MattBosh@gmail.com","+27847772972","XN796370","A24 San Ridge Village,Midrand, Gauteng");
        User user2 = new User("Tawa","Bosh","TawaBosh@gmail.com","+27844442972","ZN676380","A24 San Ridge Village,Midrand, Gauteng");
        User user3 = new User("Fadzai","Bosha","MattBosh@gmail.com","+27842222972","YN697260","A24 San Ridge Village,Midrand, Gauteng");

        UsrDB_Simulation.addAll(Arrays.asList(user1,user2,user3));

    }

Boolean Condition ; User cacheUsrList;
Boolean LoopCondition ;
public Boolean UserNotFound = false;
public int userIndx;


    public User UpdateUser(String id, User prmtr_value)
    {


            getUser(id);
            if (  cacheUsrList.equals(null))
            {
                UserNotFound = true;
            }
            else
            {
                userIndx = UsrDB_Simulation.indexOf(getUser(id));
            }


                if (prmtr_value.getFirstName().isEmpty()) {

                }
                else
                {

                    getUser(id).setFirstName(prmtr_value.getFirstName());

                }



                if (prmtr_value.getLastName().isEmpty()) {

                }
                else
                {

                    getUser(id).setLastName(prmtr_value.getLastName());

                }


                if (prmtr_value.getEmail().isEmpty()) {

                }
                else
                {

                    getUser(id).setEmail(prmtr_value.getEmail());

                }

                if (prmtr_value.getMobileNumber().isEmpty()) {

                }
                else
                {

                    getUser(id).setMobileNumber(prmtr_value.getMobileNumber());

                }

                if (prmtr_value.getAddress().isEmpty()) {

                }
                else
                {

                    getUser(id).setAddress(prmtr_value.getAddress());

                }

//            if (getUser(id).getFirstName().isEmpty()) {
//
//                if (getUser(id).getFirstName().isEmpty()) {
//
//                }
//                else
//                {
//
//                    getUser(id).setFirstName(getUser(id).getFirstName());
//
//                }
//
//            }
//
//            else if (getUser(id).getLastName().isEmpty())
//            {
//                if (getUser(id).getFirstName().isEmpty()) {
//
//                }
//                else
//                {
//
//                    getUser(id).setLastName(getUser(id).getLastName());
//
//                }
//
//            }
//            else if (getUser(id).getIdNumber().isEmpty())
//            {
//                if (getUser(id).getIdNumber().isEmpty()) {
//
//                }
//                else
//                {
//
//                    getUser(id).setIdNumber(getUser(id).getIdNumber());
//
//                }
//
//            }
//            else if (getUser(id).getEmail().isEmpty())
//            {
//                if (getUser(id).getEmail().isEmpty()) {
//
//                }
//                else
//                {
//
//                    getUser(id).setEmail(getUser(id).getAddress());
//
//                }
//            }
//            else if (getUser(id).getMobileNumber().isEmpty())
//            {
//                if (getUser(id).getMobileNumber().isEmpty()) {
//
//                }
//                else
//                {
//
//                    getUser(id).setMobileNumber(getUser(id).getMobileNumber());
//
//                }
//            }
//            else if (getUser(id).getAddress().isEmpty())
//            {
//                if (getUser(id).getAddress().isEmpty()) {
//
//                }
//                else
//                {
//
//                    getUser(id).setAddress(getUser(id).getAddress());
//
//                }
//            }
            return getUser(id);
    }



    public User getUser(String id)
    {


        for (User user_obj:UsrDB_Simulation) {
            String vrble = user_obj.getIdNumber();
            if (id.equals(vrble))
            {
                Condition = true;
                cacheUsrList=user_obj;

                break;

            }


        }

        if (Condition == true) {
            Condition = false;
            return cacheUsrList;
        } else
        {
            return  cacheUsrList=null;
        }
    }


        public  Boolean getIdentitySummationRL(String identities){
        char[] idchars = identities.toCharArray();
        int sum = 0;
        // loop over each digit, except the check-digit
        for (int i = 0; i < idchars.length - 1; i++) {
            int digit = Character.getNumericValue(idchars[i]);
            if ((i % 2) == 0) {
                sum += digit;
            } else {
                sum += digit < 5 ? digit * 2 : digit * 2 - 9;
            }
        }
        int checkdigit = Character.getNumericValue(idchars[idchars.length - 1]);
        int compdigit = (sum * 9) % 10;

        return checkdigit == compdigit;
    }

    String error_res;
    Boolean Dupilication_Check;
    Boolean Valididty_Check;


    public Boolean UserIDValididty_Check()
    {

        for (User user_obj2:UsrDB_Cache) {
            String vrble2 = user_obj2.getIdNumber();
            if (!getIdentitySummationRL(vrble2)) {
                Valididty_Check = false;
            }else
            {
                Valididty_Check = true;

            }
        }

        return Valididty_Check;
    }


    public Boolean ValidateUserIDDuplication()
    {

        var usrIDList= new ArrayList<String>();
        for (User user_obj1:UsrDB_Cache) {
            String vrble1 = user_obj1.getIdNumber();
            usrIDList.add(vrble1);
            if (usrIDList.contains(user_obj1.getIdNumber())) {
                Dupilication_Check = true;
            }else
            {
                Dupilication_Check = false;

            }
        }

        return Dupilication_Check;
        }

        public Boolean ValidateMobileNumbDuplication()
    {

        var usrIDList= new ArrayList<String>();
        for (User user_obj1:UsrDB_Cache) {
            String vrble1 = user_obj1.getMobileNumber();
            usrIDList.add(vrble1);
            if (usrIDList.contains(user_obj1.getIdNumber())) {
                Dupilication_Check = true;
            }else
            {
                Dupilication_Check = false;

            }
        }

        return Dupilication_Check;
        }

    }

