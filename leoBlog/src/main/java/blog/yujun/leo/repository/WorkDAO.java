package blog.yujun.leo.repository;

import blog.yujun.leo.dto.WorkDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WorkDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<WorkDTO> workList() {
		
		return sqlSessionTemplate.selectList("work.allwork");
	}

	public WorkDTO workDetail(String work_number) {
		
		return sqlSessionTemplate.selectOne("work.workDetail",work_number);
	}

	public void workViewCount(String work_number) {
		sqlSessionTemplate.update("work.workViewCount",work_number);
	}

}
