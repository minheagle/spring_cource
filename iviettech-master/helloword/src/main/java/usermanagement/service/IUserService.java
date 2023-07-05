package usermanagement.service;

import usermanagement.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User getUserById(long id);
    List<User> getListUserByName(String name);
    List<User> getListUserByEmail(String email);
    List<User> getListUserByPhone(String phone);
    List<User> getListUserByAddress(String address);
    User insert(User user);
    User edit(long id,User editUser);
    User remove(long id);
    boolean checkExist(long id);
}
