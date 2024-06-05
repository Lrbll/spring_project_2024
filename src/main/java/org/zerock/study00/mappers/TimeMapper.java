package org.zerock.study00.mappers;

import org.apache.ibatis.annotations.Select; // ibatis는 mybatis가 apache에 속해있던 시절 이름

public interface TimeMapper {

    @Select("select now()")
    String getTime();

    String getTime2();
}
