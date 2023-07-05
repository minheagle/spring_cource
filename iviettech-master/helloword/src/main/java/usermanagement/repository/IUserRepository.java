package usermanagement.repository;

import usermanagement.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    User findById(long id);
    List<User> findListByName(String name);
    List<User> findListByEmail(String email);
    List<User> findListByPhone(String phone);
    List<User> findListByAddress(String address);
    User save(User user);
    User update(long id, User updateUser);
    User delete(long id);
    boolean checkExistId(long id);
    boolean checkExistEmail(String email);
    boolean checkExistPhone(String phone);
}
