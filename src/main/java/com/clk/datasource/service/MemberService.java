package com.clk.datasource.service;

import com.clk.datasource.bean.Member;

import java.util.List;

public interface MemberService {

    public int insert(Member member);

    public int save(Member member);

    public Member select(Long id);

    public String getToken(String appId);

}
