package persnal.practice.lotto.commons.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CheckExceptionAop {

    @Around("execution(* persnal.practice.lotto..*(..))")
    public Object checkException(ProceedingJoinPoint joinPoint) throws Throwable {
        try{
            return joinPoint.proceed();
        }
        catch (Exception e){
            log.warn("Exception location : " + joinPoint.getSourceLocation() + "error : " + e.getMessage());
        }
        finally {
            log.warn("End location : " + joinPoint.getSourceLocation());
            return joinPoint.proceed();
        }
    }
}
