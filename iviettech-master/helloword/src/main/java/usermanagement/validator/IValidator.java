package usermanagement.validator;

import usermanagement.entity.User;
import usermanagement.repository.IUserRepository;
import usermanagement.service.IUserService;

public interface IValidator {
    void validate(User user, IUserRepository userRepository);
}
