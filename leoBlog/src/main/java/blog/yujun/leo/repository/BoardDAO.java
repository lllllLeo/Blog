package blog.yujun.leo.repository;

import blog.yujun.leo.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class BoardDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public void register(BoardDTO dto) {
		sqlSessionTemplate.insert("board.register", dto);
	}
	
	public void update(BoardDTO dto) {
		sqlSessionTemplate.update("board.update", dto);
	}

	public boolean delete(int board_num) {
		int result = sqlSessionTemplate.delete("board.delete", board_num);
		
		return result == 1 ? true : false;
	}

	public BoardDTO read(int board_num) {
		return sqlSessionTemplate.selectOne("board.read", board_num);
	}

	public List<BoardDTO> readAll() {
		return sqlSessionTemplate.selectList("board.readall");
	}

	public void viewCount(int board_num) {
		sqlSessionTemplate.update("board.viewcount", board_num);
	}

	public List<BoardDTO> readPage(int page) {
		return sqlSessionTemplate.selectList("board.readPage", page);
	}

	public int pageCount() {
		return sqlSessionTemplate.selectOne("board.pageCount");
	}

	public List<BoardDTO> readAllPaging(int startCount, int endCount) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("startCount",startCount);
		map.put("endCount",endCount);

		return sqlSessionTemplate.selectList("board.readAllPaging",map);
	}

}
