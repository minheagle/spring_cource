package usermanagement.validator;

import org.springframework.stereotype.Component;
import usermanagement.entity.User;
import usermanagement.repository.IUserRepository;
import usermanagement.service.IUserService;

@Component
public class ValidateUserAge implements IValidator{
    @Override
    public void validate(User user) {
        if (user.getAge() == 0){
            throw new RuntimeException("Vui lòng nhập tuổi !");
        }
        if (user.getAge() > 100){
            throw new RuntimeException("Vui lòng nhập tuổi chính xác !");
        }
    }
}
