package com.example.weblab2.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoCacheFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse r = (HttpServletResponse) res;
        r.setHeader("Cache-Control","no-store, no-cache, must-revalidate, max-age=0");
        r.setHeader("Pragma","no-cache");
        r.setDateHeader("Expires", 0);
        chain.doFilter(req, res);
    }
}
