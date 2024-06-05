package org.zerock.study00.sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 해당 xml 파일의 설정을 가져온다
public class DITests {

    @Autowired // 자동으로 객체를 가져옴?
    Restaurant restaurant;

    @Autowired
    DataSource dataSource;

    @Test
    public void conTest() throws Exception {

        Connection con = dataSource.getConnection();
        System.out.println(con);


        con.close();
    }

    @Test
    public void testExist() {
        System.out.println(restaurant);
    }

}
