package usermanagement.validator;

import org.springframework.stereotype.Component;
import usermanagement.entity.User;
import usermanagement.repository.IUserRepository;

@Component
public class ValidateUserEmail implements IValidator{
    @Override
    public void validate(User user, IUserRepository userRepository) {
        if(user.getEmail().endsWith("@gmail.com") || user.getEmail().endsWith("@outlook.com") || user.getEmail().endsWith("@yahoo.com")){
            throw new RuntimeException("Email không đúng định dạng");
        }
        if(user.getEmail().split("@")[0].length() == 0){
            throw new RuntimeException("Vui lòng nhập địa chỉ email");
        }
    }
}
