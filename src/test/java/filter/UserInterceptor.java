package filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserInterceptor implements HandlerInterceptor {
    //请求方法前置链接，这个方法会在Controller处理之前进行调用，Spring中可以有多个Interceptor，这些拦截器会按照设定的Order、顺序调用，当有一个拦截器在这个方法中返回false的时候，请求就终止
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if (userName == null || password == null) {
            response.setStatus(500);
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("参数缺失");
            return false;
        }
        //进行用户校验
        if (userName.equals("admin") && password.equals("admin")) {
            return true;
        } else {
            response.setStatus(500);
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("用户名或密码错误");
            return false;
        }
    }

    //prehandle返回结果为true时，在Controller方法执行之后，试图渲染之前被调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    //preHandle返回true，整个请求结束之后，执行这个方法
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }


































}
