package usermanagement.validator;

import org.springframework.stereotype.Component;
import usermanagement.entity.User;
import usermanagement.repository.IUserRepository;

@Component
public class ValidateUserName implements IValidator{
    @Override
    public void validate(User user) {
        if(user.getName().isEmpty()){
            throw new RuntimeException("Tên không được để trống !");
        }
        if (user.getName().length() > 255){
            throw new RuntimeException("Tên không được vượt quá 255 kí tự");
        }
    }
}
