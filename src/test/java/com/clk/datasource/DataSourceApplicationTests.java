package com.clk.datasource;

import com.clk.datasource.bean.Member;
import com.clk.datasource.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceApplicationTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void testWrite() {
        Member member = new Member();
        member.setUserName("lisi");
        memberService.insert(member);
    }

}
