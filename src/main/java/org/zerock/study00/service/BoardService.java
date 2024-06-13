package org.zerock.study00.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.study00.domain.BoardVO;
import org.zerock.study00.mappers.BoardMapper;

@Service
@Log4j2
@RequiredArgsConstructor // 롬복의 생성자 어노테이션
public class BoardService {

    private final BoardMapper boardMapper; // final을 쓰면 이미 생성된 값이어야한다

//    public BoardService(BoardMapper boardMapper) {
//        this.boardMapper = boardMapper;
//    }

    public Long register(BoardVO boardVO){

        log.info("register board : {}", boardVO);

        int count = boardMapper.insert(boardVO);

        return boardVO.getBno();
    }

    public java.util.List<BoardVO> list(){

        return boardMapper.getList();
    }

    public BoardVO get(Long bno){

        return boardMapper.select(bno);
    }

    public boolean modify(BoardVO vo){

        return boardMapper.update(vo) == 1;
    }

    public boolean delete(Long bno){

        return true;
    }
}