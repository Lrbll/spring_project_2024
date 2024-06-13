package org.zerock.study00.mappers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.study00.domain.BoardVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {

    @Autowired(required = false)
    BoardMapper boardMapper;

    @Test
    public void test1() {
        log.info(boardMapper);
    }

    @Test
    public void testList() {

        boardMapper.getList().forEach(boardVO -> log.info(boardVO));
    }

    @Test
    public void testInsert() {

        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("new question");
        boardVO.setContent("new question");
        boardVO.setWriter("mimi");

        log.info("COUNT : " + boardMapper.insert(boardVO));
        log.info("bno : " + boardVO.getBno());
    }

    @Test
    public void testSelect() {

        Long bno = 7L;

        log.info(boardMapper.select(bno));
    }

    @Test
    public void testUpdate() {

        BoardVO boardVO = new BoardVO();

        boardVO.setTitle("update title");
        boardVO.setContent("update content");
        boardVO.setBno(8L);

        int updateCount = boardMapper.update(boardVO);

        log.info("updateCount : " + updateCount);
    }
}
