package com.example.clickup_com.dto;

import com.example.clickup_com.entity.Workspace;
import com.example.clickup_com.entity.enums.WorkspaceRoleName;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class WorkspaceRoleDTO {
//    @NotNull
    private String lavozimNomi;
//    @NotNull
    private Workspace workspace;
//    @NotNull
    private WorkspaceRoleName workspaceRoleNameList;
}
