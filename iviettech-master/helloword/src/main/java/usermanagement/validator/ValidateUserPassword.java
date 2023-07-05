package usermanagement.validator;

import org.springframework.stereotype.Component;
import usermanagement.entity.User;
import usermanagement.repository.IUserRepository;

@Component
public class ValidateUserPassword implements IValidator{
    @Override
    public void validate(User user) {
        if (user.getPassword().isEmpty()){
            throw new RuntimeException("Mật khẩu không được để trống");
        }
        if(user.getPassword().length() < 8 || user.getPassword().length() >= 17){
            throw new RuntimeException("Mật khẩu phải nằm trong khoảng 8-16 kí tự");
        }
    }
}
