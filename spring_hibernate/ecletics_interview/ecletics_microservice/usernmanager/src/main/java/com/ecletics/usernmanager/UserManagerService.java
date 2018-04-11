package com.ecletics.usernmanager;

/**
 *
 * @author duncan
 */
public class UserManagerService {
    public  User validateUser(String userName,String hash_password){
        //access db an validate user
        Boolean isUserFound=false;
        User user=new User();
        if (isUserFound) return user;
        else {
             user=null;
            return user;
        }
    }
 
}
