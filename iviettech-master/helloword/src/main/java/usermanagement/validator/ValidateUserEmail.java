package usermanagement.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import usermanagement.entity.User;
import usermanagement.repository.IUserRepository;

@Component
public class ValidateUserEmail implements IValidator{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public void validate(User user) {
        if(user.getEmail().split("@")[0].length() == 0 || user.getEmail().isEmpty()){
            throw new RuntimeException("Vui lòng nhập địa chỉ email !");
        }
        if(user.getEmail().endsWith("@gmail.com") || user.getEmail().endsWith("@outlook.com") || user.getEmail().endsWith("@yahoo.com")){
            throw new RuntimeException("Email không đúng định dạng !");
        }
        if (userRepository.checkExistEmail(user.getEmail())){
            throw new RuntimeException("Email đã tồn tại !");
        }
    }
}
