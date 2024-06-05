package org.zerock.study00.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

// Data 어노테이션은 Getter, Setter, ToString, RequiredArgsConstructor, EqualsAndHashCode의 다섯가지 어노테이션을 축약한 것
@Data
public class SampleDTOList {
    
    // DTO 객체를 하나의 요소로 만들어 리스트안에 저장
    private List<SampleDTO> list = new ArrayList<>(); // <> 꺽쇠 안에 인수 생략 가능 : 제네릭 타입
    // private List<SampleDTO> list = new ArrayList<SampleDTO>();
    // 제네릭 타입 : 메서드가 사용할 데이터 타입을 명시하지 않고 필요할 때 지정
}
