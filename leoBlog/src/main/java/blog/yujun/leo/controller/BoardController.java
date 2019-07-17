package blog.yujun.leo.controller;

import blog.yujun.leo.dto.BoardDTO;
import blog.yujun.leo.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	/*
	 private : 외부에서 로그를 가로채지 못하도록 하기 위해서
	 static final : 로그 내용이 바뀌지 않으므로
	 
	 로그를 수집할 method에서 로그 수집 명령어 호출
	 logger.info("로그 타이틀", 출력할 값);
	*/
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	//게시판 글 전체 조회

   /* @RequestMapping(value="", method=RequestMethod.GET)
	public String boardlist(Model model) {
		logger.info(": : : : B o a r d : : : :");
		try {
			List <BoardDTO> list = service.readall();
			model.addAttribute("list",list);
			logger.info("list는 "+list);
			logger.info("list는 "+list.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board";
	}*/

    //게시판 글 전체 조회(페이징 처리)
    @GetMapping("")
    public String boardListPaging(Model model, @RequestParam int page){
        logger.info(": : : : B O A R D : : : :");
        logger.info("",page);
        int countPage =10;   // limit 1페이지당 10개 뽑음
        int nowpage = page;  // 현재 페이지
        int totalCount = 0;	  // 게시글 총 개수
        int startCount = (page - 1) * 10 + 1;  //  현재 3페이지면 게시글이 21부터 시작
        int endCount = page * countPage ;		//  현재 3페이지면 게시글이 30이 마지막 or startCount + limit -1;
		/*int startPage = ((page - 1) / 10) * 10 + 1;	// 하단의 페이지 start번호
		int endPage = startPage + countPage - 1;		// 하단의 페이지 end번호*/

		try {
			totalCount = boardService.pageCount(); //총 게시글 개수
			List <BoardDTO> list =  boardService.readAllPaging(startCount, endCount);
			int maxpage = (int) ((double) totalCount / countPage + 0.95);
			int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
			int endpage = maxpage;

			if (endpage > startpage + 10 - 1) {
				endpage = startpage + 10 - 1;
			}
			model.addAttribute("list",list);
			model.addAttribute("page",page);
			model.addAttribute("maxpage",maxpage);
			model.addAttribute("totalCount",totalCount);
			model.addAttribute("startpage",startpage);
			model.addAttribute("nowpage",nowpage);
			model.addAttribute("endpage",endpage);

		} catch (Exception e) {
            e.printStackTrace();
        }

        return "board";
    }

	// 글 조회
	@GetMapping("/{board_num}")
	public String readGET(@PathVariable int board_num, Model model, BoardDTO boardDTO, @RequestParam int page) {
		logger.info(": : : : R E A D : : : :");
		logger.info("board_num은 "+board_num);
		logger.info("page은 "+page);
		try {
			boardService.viewCount(board_num);
			boardDTO = boardService.read(board_num);
			logger.info("dto는 "+ boardDTO);
			model.addAttribute("boardDTO",boardDTO);
			model.addAttribute("page",page);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "read";
		
	}
	
	//글 등록페이지 GET
	@GetMapping("register")
	public String registerGET() {
		logger.info(" : : : : R E G I S T E R ( G E T ) : : : :");
		return "register";
	}
	
	//글 등록하기 POST 
	@PostMapping("register")
	public @ResponseBody
    void registerPOST(BoardDTO boardDTO, HttpServletResponse response) {
		logger.info(": : : : R E G I S T E R ( P O S T ) : : : :");
		logger.info("받아온 boardDTO content는 "+boardDTO.getBoard_content());
		
		try {
			boardService.register(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//글 수정페이지 GET
	@GetMapping("update/{board_num}")
	public String updateGET(@PathVariable int board_num, BoardDTO boardDTO, Model model) {
		logger.info(": : : : U P D A T E ( G E T ) : : : :");
		try {
			boardDTO = boardService.read(board_num);
			logger.info("boardDTO content는 "+boardDTO.getBoard_content());
			model.addAttribute("boardDTO",boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "update";
	}
	
	//글 수정페이지 POST
	@PostMapping("update/{board_num}")
	public String updatePOST(BoardDTO boardDTO) {
		logger.info(": : : : U P D A T E ( P O S T ) : : : :");
		try {
			logger.info(""+boardDTO);
			logger.info("수정 후 바뀐 내용 "+boardDTO.getBoard_title()+ " "+ boardDTO.getBoard_content());
			boardService.update(boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "board2";
	}
	
	//글 삭제
	// 굳이 error를 만들어줄필요있나 어처피 있는 게시글에서 그 게시글 번호를 받아서 삭제하는건데
	@PostMapping("delete/{board_num}")
	public @ResponseBody
    String delete(@PathVariable int board_num, HttpServletResponse response) {
		logger.info(": : : : D E L E T E : : : :");
		boolean result;
		String check = "success";
		try {
			result = boardService.delete(board_num);
			
			if(!result) {
				check = "error";
				return check;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
}

