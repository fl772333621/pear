package com.mfanw.pear.aspect;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mfanw.core.log.SystemLogger;
import com.mfanw.util.ThreadLocalUtil;

/**
 * <b>自动拦截Controller请求并记录日志</b>
 * 
 * @version 2017年12月8日 下午4:03:59
 * @author mengwei
 */
@Aspect
@Component
public class ControllerAspect {

    private SystemLogger systemLogger = SystemLogger.getInstance();

    @Around("execution(* com.mfanw.pear.controller..*.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Map<String, Object> event = Maps.newLinkedHashMap();
        event.put("ip", ThreadLocalUtil.getInstance().get(ThreadLocalUtil.CLIENT_IP));
        event.put("uid", ThreadLocalUtil.getInstance().get(ThreadLocalUtil.USER_ID));
        event.put("url", joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
        event.put("input", getCanEventArgs(joinPoint.getArgs()));
        // 必须调如下的方法，否则后续处理终断
        Object result = joinPoint.proceed();
        event.put("result", result);
        // toJson方法会破坏对象，所以请保证event内存储的都是可序列化的对象，严禁将request或者response进行toJson
        systemLogger.event(JSON.toJSONString(event));
        return result;
    }

    private Object[] getCanEventArgs(Object[] arguments) {
        if (arguments == null || arguments.length == 0) {
            return arguments;
        }
        List<Object> newArguments = Lists.newArrayList();
        for (Object argument : arguments) {
            if (argument instanceof Serializable) {
                newArguments.add(argument);
            }
        }
        return newArguments.toArray(new Object[0]);
    }

}
