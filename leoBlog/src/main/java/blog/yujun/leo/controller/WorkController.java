package blog.yujun.leo.controller;

import blog.yujun.leo.dto.WorkDTO;
import blog.yujun.leo.service.WorkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/work")
public class WorkController {

	@Autowired
	WorkService workService;
	
	private static final Logger logger = LoggerFactory.getLogger(WorkController.class); 

	@GetMapping("")
	public String work(Model model)	{
		logger.info(": : : : work : : : :");
		try {
			List<WorkDTO> list = workService.workList();
			model.addAttribute("list",list);
			logger.info("list는 "+ list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(list.get(0));
		return "work";
	}
	
	@GetMapping("/{work_number}")
	public String workDetail(@PathVariable String work_number, Model model) {
		logger.info(": : : : detail : : : :");
		logger.info("work_number은 "+ work_number);
		WorkDTO workDTO;
		try {
			workService.workViewCount(work_number);
			workDTO = workService.workDetail(work_number);
			//workservice.viewcount(work_uid);
			model.addAttribute("work_number", work_number);
			model.addAttribute("workdto", workDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "detail";
	}
	
}
