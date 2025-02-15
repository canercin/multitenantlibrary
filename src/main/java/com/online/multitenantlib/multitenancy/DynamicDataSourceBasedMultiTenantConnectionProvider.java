package com.online.multitenantlib.multitenancy;

import com.online.multitenantlib.repo.TenantRepository;
import jakarta.annotation.PostConstruct;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DynamicDataSourceBasedMultiTenantConnectionProvider extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl<String> {

    private final TenantRepository tenantRepository;
    private final Map<String, DataSource> dataSources = new HashMap<>();

    public DynamicDataSourceBasedMultiTenantConnectionProvider(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;

    }

    @PostConstruct
    public void load() {
        List<Tenant> tenants = tenantRepository.findAll();
        dataSources.putAll(tenants.stream().collect(Collectors.toMap(Tenant::getTenantId, tenant -> {
            return DataSourceBuilder.create()
                    .url(tenant.getUrl())
                    .username(tenant.getUsername())
                    .password(tenant.getPassword())
                    .build();
        })));
    }

    @Override
    protected DataSource selectAnyDataSource() {
        return dataSources.values().iterator().next();
    }

    @Override
    protected DataSource selectDataSource(String tenantIdentifier) {
        return dataSources.get(tenantIdentifier);
    }
}
