package cn.wenyiguo.web;

import cn.wenyiguo.entity.SysLog;
import cn.wenyiguo.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author 德哲
 * @date 2018/7/2 17:08.
 */
@Aspect
@Component
public class SysLogs {

    @Autowired
    private HttpServletRequest request;

    private String methodName;

    @Autowired
    private LogService logService;

    @Before("execution(* cn.wenyiguo.web.*Controller.*(..))")
    public void logBefore(JoinPoint pp) throws Exception{
        // 获取到目的对象
        Class clazz= pp.getTarget().getClass();
        // 获取类名
        String simpleName = clazz.getSimpleName();
        // 获取到正在的执行的方法名称
        String name = pp.getSignature().getName();
        methodName = simpleName + "." + name;
        System.out.println(pp.getSignature().toShortString());


    }

    @After("execution(* cn.wenyiguo.web.*Controller.*(..))")
    public void logAfter() {
        SysLog sysLog = new SysLog();
        // 获取时间
        sysLog.setVisitTime(new Date());
        // 获取名称
        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication authentication = sc.getAuthentication();
        User user = (User) authentication.getPrincipal();
        sysLog.setUsername(user.getUsername());
        sysLog.setMethod(methodName);
        // 获取ip
        sysLog.setIp(request.getRemoteAddr());
        logService.savaLogs(sysLog);
    }
}
