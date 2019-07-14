package blog.yujun.leo.repository;

import blog.yujun.leo.dto.UserDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public UserDTO getUserInfo() {
        return sqlSessionTemplate.selectOne("user.getUserInfo");
    }

}
