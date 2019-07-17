package blog.yujun.leo.service;

import blog.yujun.leo.dto.BoardDTO;
import blog.yujun.leo.repository.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	public void register(BoardDTO boardDTO) {
		boardDAO.register(boardDTO);
	}

	public void update(BoardDTO boardDTO) {
		boardDAO.update(boardDTO);
	}

	public boolean delete(int board_num) {
		return boardDAO.delete(board_num);
	}

	public BoardDTO read(int board_num) {
		return boardDAO.read(board_num);
	}

	public List<BoardDTO> readAll() {
		return boardDAO.readAll();
	}

	public void viewCount(int board_num) {
		boardDAO.viewCount(board_num);
	}

	public int pageCount() {
		return boardDAO.pageCount();
	}

	public List<BoardDTO> readAllPaging(int startCount, int endCount) {
		return boardDAO.readAllPaging(startCount, endCount);
	}

}
