package com.message.fhl.config;

import com.message.fhl.config.ThreadContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(0)
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String customer = req.getHeader("customer");
        if (customer != null) {
            ThreadContext.setCustomer(req.getHeader("customer"));
        }

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }

}
