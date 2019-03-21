package com.clk.datasource.aop;

import com.clk.datasource.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: data_source
 * @description: DataSourceAop
 * @author: Reagan Li
 * @create: 2019-03-21 10:38
 **/
@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.clk.datasource.annotation.Master) " +
            "&& (execution(* com.clk.datasource.service..*.select*(..)) " +
            "|| execution(* com.clk.datasource.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.clk.datasource.annotation.Master) " +
            "|| execution(* com.clk.datasource.service..*.insert*(..)) " +
            "|| execution(* com.clk.datasource.service..*.add*(..)) " +
            "|| execution(* com.clk.datasource.service..*.update*(..)) " +
            "|| execution(* com.clk.datasource.service..*.edit*(..)) " +
            "|| execution(* com.clk.datasource.service..*.delete*(..)) " +
            "|| execution(* com.clk.datasource.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
