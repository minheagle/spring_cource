package usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import usermanagement.entity.User;
import usermanagement.repository.IUserRepository;
import usermanagement.validator.IValidator;

import java.util.List;

public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private List<IValidator> validators;
    @Override
    public List<User> getAll() {
        List<User> listUser;
        try{
            listUser = userRepository.findAll();
            if(listUser == null){
                throw new RuntimeException("Danh sách có ai đâu mà đòi lấy như đúng rồi thế trời.");
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return listUser;
    }

    @Override
    public User getUserById(long id) {
        User user;
        try {
            user = userRepository.findById(id);
            if (user == null){
                throw new RuntimeException("Không ai có Id là " + id);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> getListUserByName(String name) {
        List<User> listUser;
        try {
            listUser = userRepository.findListByName(name);
            if (listUser.isEmpty()){
                throw new RuntimeException("Không ai có tên là " + name);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return listUser;
    }

    @Override
    public List<User> getListUserByEmail(String email) {
        List<User> listUser;
        try {
            listUser = userRepository.findListByEmail(email);
            if (listUser.isEmpty()){
                throw new RuntimeException("Không ai có email là " + email);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return listUser;
    }

    @Override
    public List<User> getListUserByPhone(String phone) {
        List<User> listUser;
        try {
            listUser = userRepository.findListByPhone(phone);
            if (listUser.isEmpty()){
                throw new RuntimeException("Không ai có số điện thoại là " + phone);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return listUser;
    }

    @Override
    public List<User> getListUserByAddress(String address) {
        List<User> listUser;
        try {
            listUser = userRepository.findListByAddress(address);
            if (listUser.isEmpty()){
                throw new RuntimeException("Không ai sinh sống ở " + address);
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return listUser;
    }

    @Override
    public User insert(User user) {
        validateAccount(user);
        return userRepository.save(user);
    }

    private void validateAccount(final User user){
        validators.forEach(validator -> validator.validate(user));
    }

    @Override
    public User edit(long id, User editUser) {
        User user;
        try {
            user = userRepository.update(id, editUser);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return user;
    }

    @Override
    public User remove(long id) {
        User user;
        try {
            user = userRepository.delete(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean checkExist(long id) {
        return userRepository.checkExistId(id);
    }
}
