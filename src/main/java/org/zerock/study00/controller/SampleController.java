package org.zerock.study00.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.study00.domain.SampleDTO;
import org.zerock.study00.domain.SampleDTOList;
import org.zerock.study00.domain.TodoDTO;

import java.util.Arrays;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/basic")
    public void basic() {
        log.info("basic");
    }

//    @GetMapping("/ex1")
//    public void ex1(SampleDTO sampleDTO) {
//        log.info("ex1");
//        log.info(sampleDTO);
//    }

    @GetMapping("/ex1")
    public void ex1(
            @RequestParam("name") String name, // http는 원래 문자열을 처리하는 프로토콜이기에 파라미터 type이 문자열이 기본
            @RequestParam(
                    value = "age",
                    required = false,
                    defaultValue = "10") int age
    ) {
        log.info("ex1");
        log.info(name);
        log.info(age);
    }
    
    // 파라미터 배열 처리
    @GetMapping("/ex02Array")
    public String ex02Array( String[] ids ) {
        log.info("ex02Array");
        log.info(Arrays.toString(ids));
        return "/sample/ex2"; // 단순히 경로랑 같은 이름의 jsp 파일을 찾아가기 때문에 return으로 지정해둔 것
    }

    // 파라미터 리스트 처리
    @GetMapping("/ex02Bean")
    public void ex02Bean(SampleDTOList list) {
        log.info("ex02Bean");
        log.info(list);
    }

    // 날짜 데이터를 포함한 리스트
    @GetMapping("/ex03")
    public void ex03(TodoDTO todoDTO) {
        log.info("ex03");
        log.info(todoDTO);
    }

    // 모델을 이용하여 파라미터에 입력된 데이터를 jsp로 전달
    @GetMapping("/ex04")
    public void ex04(
            // DTO는 이미 Model 안에 존재하기 때문에, 모델 안에 넣어 전달할 필요는 없지만, 무조건 하는 걸로 습관화하는 것이 좋다
            @ModelAttribute("todoDTO") TodoDTO todoDTO,
            @ModelAttribute("page") int page,
            Model model){

        model.addAttribute("list", new String[]{"AAA", "BBB", "CCC"});
    }

    // 리다이렉트 처리
    @GetMapping("/ex05")
    public String ex05(RedirectAttributes rttr){
        // 리다이렉트 될 때, 속성을 파라미터로 전달
        rttr.addAttribute("v1", "AA");
        rttr.addAttribute("v2", "BB");
    
        // 리다이렉트가 실행될 때 한번만 존재하는 속성, 새로고침하면 없음, 일반 addAtribute는 파라미터에 여전히 존재
        rttr.addFlashAttribute("core", "core = 99999");

        return "redirect:/sample/basic";

    }

}
