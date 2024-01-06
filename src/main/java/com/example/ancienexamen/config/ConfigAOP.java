package com.example.ancienexamen.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Slf4j
public class ConfigAOP {


     @After("execution(* com.example.ancienexamen.service.ExamenServiceImpl.ajouter*(..))")
    public void logMethodExit3(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Execution Réussie !"+name);
    }

    @Before("execution(* com.example.ancienexamen.service.ExamenServiceImpl.ajouter*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Début Exécution :"+name);
    }








    @AfterReturning(value = "execution(* com.example.ancienexamen.service.*.*(String))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("La méthode {} a utilisé un string comme paramètre", name);
    }


    @AfterReturning("execution(* com.example.ancienexamen.service.ExamenServiceImpl.MontantApayerParClient*(..))")
    public void logMethodExit1(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();

        log.info("******* Montant facture calculée *************" + name);
    }


    /*@Around("execution(* com.example.ancienexamen.service.*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        log.info("Methodexecutiontime AOP: " + elapsedTime + " milliseconds.");
        return obj;
    }*/
}
