package blog.yujun.leo.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private static final String MAPPER_NAME_SPACE = "mapper.userMapper.";

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List getUserInfoAll(){
        return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectUserInfoAll");
    }
}
