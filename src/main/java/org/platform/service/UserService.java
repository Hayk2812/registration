package org.platform.service;

import org.platform.model.User;

public interface UserService {
    User createUser(String name,String surname,String year, String email, String password);
    boolean verification(String email,String verifyCode);
}
