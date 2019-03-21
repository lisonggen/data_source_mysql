package com.clk.datasource.service;

import com.clk.datasource.annotation.Master;
import com.clk.datasource.bean.Member;
import com.clk.datasource.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: data_source
 * @description: MemberServiceImpl
 * @author: Reagan Li
 * @create: 2019-03-21 11:01
 **/
@Service
public class MemberServiceImpl implements  MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Transactional
    @Override
    public int insert(Member member) {
        return memberMapper.insert(member);
    }

    @Master
    @Override
    public int save(Member member) {
        return memberMapper.insert(member);
    }

    @Override
    public Member select(Long id) {
        return memberMapper.selectByPrimaryKey(id);
    }

    @Master
    @Override
    public String getToken(String appId) {
        //  有些读操作必须读主数据库
        //  比如，获取微信access_token，因为高峰时期主从同步可能延迟
        //  这种情况下就必须强制从主数据读
        return null;
    }
}
