package com.example.slstudiomini.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger =
    LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Object handleAllExceptions(Exception ex) {
        ModelAndView mav = new ModelAndView("error/custom-error");
        mav.addObject("errorMessage", "ニャニャ");
        return mav;
    }

    @ExceptionHandler(MyUniqueContstraintViolationException.class)
    public Object handleMyUniqueConstraintViolationException(Exception ex) {
        ModelAndView mav = new ModelAndView("error/custom-error");
        mav.addObject("errorMessage", ex.getMessage());
        return mav;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public Object handleDataIntegrityViolationException(Exception ex) {
        ModelAndView mav = new ModelAndView("error/custom-error");
        mav.addObject("errorMessage", "ユニーク性違反でエラーが出た可能性があります");
        return mav;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public Object handleNoSuchElementException(Exception ex){
        ModelAndView mav = new ModelAndView("error/custom-error");
        mav.addObject("errorMessage", "存在しないコースです!!");
        return mav;
    }
    @ExceptionHandler(NoResourceFoundException.class)
    public Object handleNoResourceFoundException(Exception ex){
        ModelAndView mav = new ModelAndView("error/custom-error");
        mav.addObject("errorMessage", "存在しないコースです!?");
        return mav;
    }

    @ExceptionHandler(MyLessonNotFoundException.class)
    public Object handleMyLessonNotFoundException(Exception ex){
        logger.error("不正なlessonへのアクセスが行われました。エラー詳細:"+ex.getMessage());
        ModelAndView mav = new ModelAndView("error/custom-error");
        mav.addObject("errorMessage","存在しないレッスンです Lesson id = "+((MyLessonNotFoundException)ex).getId() );
        return mav;
    }


}
