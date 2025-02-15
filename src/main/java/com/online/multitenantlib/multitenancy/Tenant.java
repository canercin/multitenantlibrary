package com.online.multitenantlib.multitenancy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Tenant {
    @Id
    private String tenantId;
    private String url;
    private String username;
    private String password;
}
