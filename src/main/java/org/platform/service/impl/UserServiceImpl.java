package org.platform.service.impl;

import org.platform.enams.Status;
import org.platform.exception.userExceptions.UserAlreadyExistException;
import org.platform.exception.userExceptions.UserNotFoundException;
import org.platform.exception.userExceptions.UserValidationException;
import org.platform.helper.UserHelper;
import org.platform.model.User;
import org.platform.repozitory.UserRepozitory;
import org.platform.service.UserService;
import org.platform.util.TokenGeneration;

public class UserServiceImpl implements UserService {
    @Override
    public User createUser(String name,String surname,String year, String email, String password) {
        int newYear;
        String verifyCode = TokenGeneration.generatVerifyCode();

        try {
           newYear =  Integer.parseInt(year);
        }
        catch (NumberFormatException e){
            throw new UserValidationException("Invalid format of year");
        }
        User user = UserRepozitory.getByEmail(email);
        if (user!=null){
            throw new UserAlreadyExistException("User already exist with given email");
        }
        user = new User(0,name,surname,newYear,email,password, Status.INACTIVE,verifyCode,null);
        UserHelper.validateFields(user);
        UserRepozitory.saveUser(user);
        return UserRepozitory.saveUser(user);
    }

    @Override
    public boolean verification(String email,String verifyCode) {
        User user = UserRepozitory.getByEmail(email);
        if (user == null){
            throw new UserNotFoundException("User not found with given email");
        }

        if (user.getVerificationCode() != null && !user.getVerificationCode().equals(verifyCode)){
            throw new UserValidationException("Wrong verify code");
        }
        UserRepozitory.verification(email);
        return true;
    }
}
