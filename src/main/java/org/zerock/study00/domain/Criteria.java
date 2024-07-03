package org.zerock.study00.domain;

import lombok.Data;

@Data
public class Criteria {

    // 페이지 처리에서 pageNum, amount, skip (페이지번호, 출력할 개수, 스킵 후 처음으로 시작되는 번호)의 상관관계
    // this.skip = (this.pageNum - 1) * this.amount;
    // 예를 들어, 한 페이지 당 10개의 목록을 출력할 때,
    // 아래의 페이지 목록에서 3페이지를 눌러 이동해보자.
    // 그럼 앞의 2페이지 분량의 목록들을 건너뛰고 다음의 목록이 출력되어야한다.
    // 따라서 skip의 값은 (3-1)*10 = 20이된다.
    // skip은 mySQL 구문에서 limit의 첫 offset값으로 설정됨
    // 즉 offset값이 20이므로, 21번째 행부터 출력이된다

    private int pageNum = 1; // 첫(기본) 페이지 번호

    private int amount = 10; // 한 페이지에 출력할 목록의 개수

    // skip 변수는 굳이 만들지 않아도 괜찮다. getter 메소드를 이용해 skip 변수를 사용할 수 있다.

    public void setPageNum(int pageNum) {

        if (pageNum <= 0) {
            this.pageNum = 1;
            return;
        }
        this.pageNum = pageNum;
    }

    public void setAmount(int amount) {

        if (amount <= 10 || amount > 100) {
            this.amount = 10;
            return;
        }
        this.amount = amount;
    }

    public int getSkip() {

        return (this.pageNum - 1) * this.amount;
    }
}
