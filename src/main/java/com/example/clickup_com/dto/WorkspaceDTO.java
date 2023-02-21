package com.example.clickup_com.dto;

import com.example.clickup_com.entity.FileInfo;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class WorkspaceDTO {
//    @NotNull
    private String nomi;
//    @NotNull
    private char boshHarf;
//    @NotNull
    private String avatarRangi;
//    @NotNull
    private FileInfo fileInfo;
//    @NotNull
    private String users;
}
