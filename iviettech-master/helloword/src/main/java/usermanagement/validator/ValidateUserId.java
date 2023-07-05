package usermanagement.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import usermanagement.entity.User;
import usermanagement.repository.IUserRepository;

@Component
public class ValidateUserId implements IValidator{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void validate(User user) {
        if(userRepository.checkExistId(user.getId())){
            throw new RuntimeException("User đã tồn tại.");
        }
    }
}
