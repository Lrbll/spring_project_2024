package org.zerock.study00.mappers;

import org.zerock.study00.domain.BoardVO;

//import java.util.List;

public interface BoardMapper {

    java.util.List<BoardVO> getList();
//    List<BoardVO> getList();

    int insert(BoardVO board);

    BoardVO select(Long bno);

    int update(BoardVO board);
}
