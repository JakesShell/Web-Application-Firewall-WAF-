package com.waf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<RequestFilter> requestFilter() {
        FilterRegistrationBean<RequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestFilter());
        registrationBean.addUrlPatterns("/*"); // Apply to all URLs
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<ResponseFilter> responseFilter() {
        FilterRegistrationBean<ResponseFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ResponseFilter());
        registrationBean.addUrlPatterns("/*"); // Apply to all URLs
        return registrationBean;
    }
}
