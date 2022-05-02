package com.csw.common.vo;

import lombok.Data;

@Data
public class RoleQuery extends Page{
    private String username;
    private boolean enabled;
}
