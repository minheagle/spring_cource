package usermanagement.validator;

import org.springframework.stereotype.Component;
import usermanagement.entity.User;
import usermanagement.repository.IUserRepository;

@Component
public class ValidateUserId implements IValidator{
    @Override
    public void validate(User user, IUserRepository userRepository) {
        if(userRepository.checkExist(user.getId())){
            throw new RuntimeException("User đã tồn tại.");
        }
    }
}
