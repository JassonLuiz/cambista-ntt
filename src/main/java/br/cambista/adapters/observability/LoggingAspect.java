package br.cambista.adapters.observability;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("within(@org.springframework.stereotype.Controller *)" +
            "within(@org.springframework.stereotype.Component *)" +
            "within(@org.springframework.stereotype.Service *)" +
            "execution(public * br.cambista.*.*(..))")
    private void publicMethodsFromLoggingPackage() {
    }

    @Around(value = "publicMethodsFromLoggingPackage()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        logger.info(">> {}() - {}", methodName, Arrays.toString(args));
        Object result = joinPoint.proceed();
        logger.info("<< {}() - {}", methodName, result);
        return result;
    }
}
