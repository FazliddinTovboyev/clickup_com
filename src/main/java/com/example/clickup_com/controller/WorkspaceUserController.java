package com.example.clickup_com.controller;

import com.example.clickup_com.dto.APIResponse;
import com.example.clickup_com.dto.WorkspaceUserDTO;
import com.example.clickup_com.service.WorkspaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workspace-user")
public class WorkspaceUserController {
    @Autowired
    WorkspaceUserService workspaceUserService;

    @PostMapping("/add")
    public HttpEntity<?> add(@RequestBody WorkspaceUserDTO workspaceUserDTO){
        APIResponse apiResponse = workspaceUserService.add(workspaceUserDTO);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
}
