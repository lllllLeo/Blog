package blog.yujun.leo.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class YujunDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public boolean loginCheck(HashMap<String, String> forLogin) {
		System.out.println(forLogin.get("yj_id"));
		System.out.println(forLogin.get("yj_password"));
		String result = sqlSessionTemplate.selectOne("yujun.loginCheck",forLogin);
		return result == null ? false : true; 
	}

}
