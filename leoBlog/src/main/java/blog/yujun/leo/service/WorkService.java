package blog.yujun.leo.service;

import blog.yujun.leo.dto.WorkDTO;
import blog.yujun.leo.repository.WorkDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkService {

	@Autowired
	WorkDAO workDAO;
	
	public List<WorkDTO> workList() {
		return workDAO.workList();
	}

	public WorkDTO workDetail(String work_number) {
		return workDAO.workDetail(work_number);
	}

	public void workViewCount(String work_number) { workDAO.workViewCount(work_number); }
	
}
