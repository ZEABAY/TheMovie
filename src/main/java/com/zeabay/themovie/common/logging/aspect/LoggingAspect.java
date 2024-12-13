package com.zeabay.themovie.common.logging.aspect;

import com.zeabay.themovie.common.logging.aspect.jsons.LoggingAspectEXCEPTIONJson;
import com.zeabay.themovie.common.logging.aspect.jsons.LoggingAspectINFOJson;
import com.zeabay.themovie.common.logging.aspect.jsons.LoggingAspectSUCCESSJson;
import com.zeabay.themovie.common.utils.ANSIColorUtil;
import com.zeabay.themovie.common.utils.PrettyJsonFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LogManager.getLogger(LoggingAspect.class); // Log4j2 Logger

    @Pointcut(
            "execution(* com.zeabay.themovie.common.core.controller..*(..)) || " +
                    "within(com.zeabay.themovie.modules..controller..*) ")
    public void controllerPointcut() {
    }

    @Pointcut(
            "execution(* com.zeabay.themovie.common.core.controller..*(..)) || " +
                    "execution(* com.zeabay.themovie.common.core.service..*(..)) || " +
                    "execution(* com.zeabay.themovie.common.core.repository..*(..)) || " +

                    "within(com.zeabay.themovie.modules..controller..*) || " +
                    "within(com.zeabay.themovie.modules..services.concretes..*)" +
                    "execution(* com.zeabay.themovie.modules..repository..*(..)) || " +
                    "within(com.zeabay.themovie.modules..exceptions..*) || ")
    public void applicationPointcut() {
    }

    @Before("applicationPointcut() || controllerPointcut()")
    public void logBefore(JoinPoint joinPoint) {

        String coloredHeader = ANSIColorUtil.info("[INFO]");
        String coloredMessage = ANSIColorUtil.info(
                PrettyJsonFormatter.format(new LoggingAspectINFOJson(joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(),
                        joinPoint.getArgs(),
                        "method_entry"))
        );

        log.info("\n{}\n{}\n", coloredHeader, coloredMessage);
    }

    @AfterReturning(pointcut = "controllerPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {

        String coloredHeader = ANSIColorUtil.success("[SUCCESS]");
        String coloredMessage = ANSIColorUtil.success(
                PrettyJsonFormatter.format(new LoggingAspectSUCCESSJson(joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(),
                        joinPoint.getArgs(),
                        result,
                        "method_success"))
        );
        log.info("\n{}\n{}\n", coloredHeader, coloredMessage);
    }

    @AfterThrowing(pointcut = "applicationPointcut()", throwing = "ex")
    public void logAfterException(JoinPoint joinPoint, Throwable ex) {
        String coloredHeader = ANSIColorUtil.error("[ERROR]");
        String coloredMessage = ANSIColorUtil.error(
                PrettyJsonFormatter.format(new LoggingAspectEXCEPTIONJson(joinPoint.getSignature().getDeclaringTypeName(),
                        joinPoint.getSignature().getName(),
                        joinPoint.getArgs(),
                        ex.getMessage(),
                        ex.getClass().getName()))
        );
        log.error("\n{}\n{}\n", coloredHeader, coloredMessage);
    }
}