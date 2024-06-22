package org.platform;

import org.platform.enams.Status;
import org.platform.helper.UserHelper;
import org.platform.model.User;
import org.platform.util.MyDataSource;

public class Test {
    public static void main(String[] args) {
        User user = new User(1,"Name","Surname",1998,"hayk-mkrtchyan-98@mail.ru " , "Password_123", Status.INACTIVE,"verifyCode",null);
        UserHelper.validateFields(user);
    }
}
