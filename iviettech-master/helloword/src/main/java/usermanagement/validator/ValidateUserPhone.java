package usermanagement.validator;

import org.springframework.stereotype.Component;
import usermanagement.entity.User;
import usermanagement.repository.IUserRepository;

@Component
public class ValidateUserPhone implements IValidator{
    @Override
    public void validate(User user) {
        if (user.getPhone().isEmpty()){
            throw new RuntimeException("Số điện thoại không được để trống !");
        }
        if (!user.getPhone().startsWith("0") || user.getPhone().length() > 10){
            throw new RuntimeException("Vui lòng nhập số điện thoại theo đúng định dạng");
        }
    }
}
