package com.cassiano.pontodevenda.dto.request;

import java.util.Set;
import java.util.UUID;

public class UserRequestDTO {

    private String name;
    private String barcode;
    private String password;
    private Boolean active;
    private UUID roleId;
    private Set<UUID> permissionIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public Set<UUID> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(Set<UUID> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
