package com.online.multitenantlib.config;

import com.online.multitenantlib.interceptors.TenantIdResolverInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfigurer implements WebMvcConfigurer {

    private final TenantIdResolverInterceptor tenantIdResolverInterceptor;

    public InterceptorConfigurer(TenantIdResolverInterceptor tenantIdResolverInterceptor) {
        this.tenantIdResolverInterceptor = tenantIdResolverInterceptor;
    }

    @Override
    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
        registry.addInterceptor(tenantIdResolverInterceptor);
    }
}
