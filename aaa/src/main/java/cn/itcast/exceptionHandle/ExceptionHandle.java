package cn.itcast.exceptionHandle;

import cn.itcast.exception.Ownexception;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandle implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        Ownexception on =null;
        //进行判断如果满足条件则输出对应的异常
        if (ex instanceof Ownexception){
            on=(Ownexception) ex;
        }else {
            on= new Ownexception("去你的");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("message",on.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
