package org.zerock.study00.mappers;

import org.zerock.study00.domain.BoardVO;
import org.zerock.study00.domain.Criteria;

//import java.util.List;

public interface BoardMapper {

    java.util.List<BoardVO> getList();
    //    List<BoardVO> getList();

    java.util.List<BoardVO> getPage(Criteria criteria); // 위의 getList()와 같은 기능이지만, 페이지 처리를 함

    int insert(BoardVO board);

    BoardVO select(Long bno);

    int update(BoardVO board);
}
