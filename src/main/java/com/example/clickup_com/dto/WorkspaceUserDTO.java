package com.example.clickup_com.dto;

import com.example.clickup_com.entity.Users;
import com.example.clickup_com.entity.WorkSpaceRole;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class WorkspaceUserDTO {
    private String users;
    private String role;
    private long workSpace;
}
