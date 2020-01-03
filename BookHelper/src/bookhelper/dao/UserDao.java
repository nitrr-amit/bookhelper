package bookhelper.dao;

import bookhelper.pojo.User;

public interface UserDao {
   boolean addUser(User user);
   boolean deleteUser(User user);
   User loginValidation(String email_id,String password);
   boolean isUserExist(User user);
   
   
}
