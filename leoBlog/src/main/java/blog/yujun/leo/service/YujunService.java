package blog.yujun.leo.service;

import blog.yujun.leo.repository.YujunDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class YujunService {

	@Autowired
	YujunDAO yujunDAO;
	
	public boolean loginCheck(HashMap<String, String> forLogin) {
		return yujunDAO.loginCheck(forLogin);
	}

	
}
