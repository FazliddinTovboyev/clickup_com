package com.example.clickup_com.controller;

import com.example.clickup_com.dto.APIResponse;
import com.example.clickup_com.dto.UserDTO;
import com.example.clickup_com.entity.Workspace;
import com.example.clickup_com.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {
    @Autowired
    WorkspaceService workspaceService;

    @PostMapping("/create")
    public HttpEntity<?> create(@RequestBody Workspace workspace){
        APIResponse apiResponse = workspaceService.addWorkspace(workspace);
        return ResponseEntity.status(apiResponse.isHolat()?200:208).body(apiResponse.getXabar());
    }
}
