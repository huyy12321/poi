package com.example.poi.common.aop;

import com.example.poi.common.note.DateLogNote;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author hyy
 */
@Aspect
@Component
public class DataLog {

    /**
     * 配置织入点
     */
    @Pointcut("@annotation(com.example.poi.common.note.DateLogNote)")
    public void addDateLog() {
    }

    @Before("addDateLog()")
    public void doBefore(JoinPoint point){
        if(getAnnotationLog(point) != null) {
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert requestAttributes != null;
            HttpServletRequest request = requestAttributes.getRequest();
            System.out.println("请求的文件路径"+point.toLongString());
            System.out.println("请求的接口路径"+request.getServletPath());
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private DateLogNote getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            return method.getAnnotation(DateLogNote.class);
        }
        return null;
    }
}
