package filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //容器启动时调用初始化方法，初始化一次
        System.out.println("初始化拦截器");
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //做一些处理
        //每次请求都会调用doFilter方法，通过FilterChain调用后续的方法
        System.out.println("doSomeThing");
        chain.doFilter(request,response);
    }
    @Override
    public void destroy() {
        //容器销毁时，执行
        System.out.println("销毁拦截器");
    }
}
