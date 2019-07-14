package blog.yujun.leo.service;

import blog.yujun.leo.dto.UserDTO;
import blog.yujun.leo.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public UserDTO getUserInfo() throws Exception{
        return userDAO.getUserInfo();
    }
}
