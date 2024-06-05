package org.zerock.study00.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString // Lombok의 ToString은 객체의 상태, 즉 필드의 값들을 확인할 수 있다
public class TodoDTO {

    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd") // 대문자 MM은 month, 소문자 mm은 minute
    private Date dueDate;
}
