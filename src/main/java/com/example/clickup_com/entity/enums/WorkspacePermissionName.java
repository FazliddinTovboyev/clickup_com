package com.example.clickup_com.entity.enums;

import java.util.Arrays;
import java.util.List;

public enum WorkspacePermissionName {
    ADDMEMBERS("A'zolarni qo'shish yoki o'chirish","Foydalanuvchiga ish maydoniga a'zolar qo'shish", Arrays.asList(WorkspaceRoleName.MEMBERS,WorkspaceRoleName.ADMIN)),
    ADDSTATUS("","",Arrays.asList(WorkspaceRoleName.MEMBERS));
    private String nomi;
    private String izoh;
    private List<WorkspaceRoleName> workspaceRoleNameList;

    public List<WorkspaceRoleName> getWorkspaceRoleNameList() {
        return workspaceRoleNameList;
    }

    public String getIzoh() {
        return izoh;
    }

    public String getNomi() {
        return nomi;
    }

    WorkspacePermissionName(String nomi, String izoh, List<WorkspaceRoleName> workspaceRoleNameList) {
        this.nomi = nomi;
        this.izoh = izoh;
        this.workspaceRoleNameList = workspaceRoleNameList;
    }
}
