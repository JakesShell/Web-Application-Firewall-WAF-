package com.waf;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();
        String queryString = httpRequest.getQueryString();

        // Check for SQL injection
        if (containsSqlInjection(queryString) || containsSqlInjection(requestURI)) {
            throw new ServletException("SQL Injection detected!");
        }

        // Check for XSS
        if (containsXss(queryString) || containsXss(requestURI)) {
            throw new ServletException("Cross-Site Scripting (XSS) detected!");
        }

        chain.doFilter(request, response); // Continue the request-response chain
    }

    private boolean containsSqlInjection(String input) {
        // Simple SQL injection detection logic
        return input != null && (input.contains("'") || input.toLowerCase().contains("select")
                || input.toLowerCase().contains("union") || input.toLowerCase().contains("drop"));
    }

    private boolean containsXss(String input) {
        // Simple XSS detection logic
        return input != null && (input.toLowerCase().contains("<script>") || input.toLowerCase().contains("javascript:"));
    }
}
