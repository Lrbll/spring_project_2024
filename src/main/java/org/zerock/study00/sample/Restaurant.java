package org.zerock.study00.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor // 생성자 자동 생성
@Component
@ToString
public class Restaurant {

    private final Chef chef;

    // Generate로 생성자 만들기
//    public Restaurant(Chef chef) {
//        this.chef = chef;
//    }
}
