package com.example.clickup_com.service;

import com.example.clickup_com.dto.APIResponse;
import com.example.clickup_com.entity.Users;
import com.example.clickup_com.entity.Workspace;
import com.example.clickup_com.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceService {
    @Autowired
    WorkspaceRepository workspaceRepository;

    public APIResponse addWorkspace(Workspace workspace) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users users = (Users) authentication.getPrincipal();
        Workspace workspace1 = new Workspace(
                workspace.getNomi(),
                workspace.getNomi().charAt(0),
                workspace.getAvatarRangi(),
                users
        );
        workspaceRepository.save(workspace1);
        return new APIResponse(true,"Yaratildi");
    }
}
