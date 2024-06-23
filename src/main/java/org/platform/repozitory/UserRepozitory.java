package org.platform.repozitory;

import org.platform.enams.Status;
import org.platform.model.User;
import org.platform.util.MyDataSource;
import org.platform.util.PasswordEncoder;
import org.platform.util.PasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepozitory {

    public static User saveUser(User user){
        Connection connection = MyDataSource.getConnection();
        String encodedPassword = PasswordEncoder.encode(user.getPassword());

        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into users values (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,user.getId());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getSurname());
            preparedStatement.setInt(4,user.getYear());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6, encodedPassword);
            preparedStatement.setString(7,String.valueOf(user.getStatus()));
            preparedStatement.setString(8,user.getVerificationCode());
            preparedStatement.setString(9,user.getResetToken());

            preparedStatement.executeUpdate();
            user.setPassword(encodedPassword);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public static User getByEmail(String email){
        Connection connection = MyDataSource.getConnection();
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where email = ?");
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                int year = resultSet.getInt("year");
                String password = resultSet.getString("password");
                String status = resultSet.getString("status");
                String verificationCode = resultSet.getString("verification_code");
                String resetToken = resultSet.getString("reset_token");

                user = new User(id,first_name,last_name,year,email,password,Enum.valueOf(Status.class,status),verificationCode,resetToken);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;

    }
    public static void verification(String email){
        Connection connection = MyDataSource.getConnection();
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("update users set verification_code = ?, status = ? where email = ?");
            preparedStatement.setString(1,null);
            preparedStatement.setString(2, String.valueOf(Status.INACTIVE));
            preparedStatement.setString(3,email);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
