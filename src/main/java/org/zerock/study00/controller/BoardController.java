package org.zerock.study00.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.study00.domain.BoardVO;
import org.zerock.study00.service.BoardService;

@Controller
@Log4j2
@RequiredArgsConstructor // 의존성 주입을 위한 생성자 어노테이션
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public void list(Model model){

        log.info("list..................");

        java.util.List<BoardVO> list = boardService.list();

        log.info(list);
        model.addAttribute("list", list);

    }

    // 읽기 페이지에서 수정버튼을 누르면 수정 페이지로 이동한다 (GET)
    // 수정 페이지에서 수정버튼을 누르면 이 때서야, 데이터의 전송이 일어난다 (POST)
    // 즉, read와 modify 경로를 향한 GET 요청이 일어날 때, 사용자 입력을 통한 데이터 전송은 일어나지 않는다 => 같은 기능, 코드
    @GetMapping("/{job}/{bno}")
    public String read(
            @PathVariable(name = "job") String job,
            @PathVariable(name = "bno") Long bno, Model model) {

        log.info("job : " + job);
        log.info("bno : " + bno);

        if ( !(job.equals("read") || job.equals("modify")) ){

            throw new RuntimeException("Bad Request job");
        }

        BoardVO boardVO = boardService.get(bno);

        log.info(boardVO);

        model.addAttribute("vo", boardVO);

        return "/board/" + job;
    }

    @PostMapping("/modify/{bno}")
    public String modify(
            @PathVariable(name = "bno") Long bno,
            BoardVO boardVO) {

        boardVO.setBno(bno);

        log.info(boardVO);

        boardService.modify(boardVO);

        return "redirect:/board/read/" + bno;
    }

    @GetMapping("/register")
    public void register() {
        // 아무것도 작성하지 않아도 자동으로 경로 반환?
    }

    @PostMapping("/register")
    public String register(BoardVO boardVO, RedirectAttributes rttr) {

        Long bno = boardService.register(boardVO);

        log.info("boardVO : " + boardVO);

        rttr.addFlashAttribute("result", bno);

        return "redirect:/board/list";
    }

    @PostMapping("/remove/{bno}")
    public String remove(
            @PathVariable(name = "bno") Long bno,
            RedirectAttributes rttr) {

        BoardVO boardVO = new BoardVO();
        boardVO.setBno(bno);
        boardVO.setTitle("해당 글은 삭제되었습니다.");
        boardVO.setContent("해당 글은 삭제되었습니다.");

        boardService.modify(boardVO);
        rttr.addFlashAttribute("result", boardVO.getBno());
//        rttr.addFlashAttribute("result", bno); // 이건 안대나?

        return "redirect:/board/list";
    }
}
