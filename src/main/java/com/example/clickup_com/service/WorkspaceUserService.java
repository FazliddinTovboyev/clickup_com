package com.example.clickup_com.service;

import com.example.clickup_com.dto.APIResponse;
import com.example.clickup_com.dto.WorkspaceUserDTO;
import com.example.clickup_com.entity.Users;
import com.example.clickup_com.entity.WorkspaceUser;
import com.example.clickup_com.repository.WorkspaceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceUserService {
    @Autowired
    WorkspaceUserRepository workspaceUserRepository;

    public APIResponse add(WorkspaceUserDTO workspaceUserDTO) {
        return null;
    }

//    public APIResponse add(WorkspaceUserDTO workspaceUserDTO) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Users users = (Users) authentication.getPrincipal();
//        workspaceUserRepository.findByWorkspaceAndWorkSpaceRole(workspaceUserDTO.getWorkSpace(),workspaceUserDTO.getRole());
//        WorkspaceUser workspaceUser = new WorkspaceUser(
//                workspaceUserDTO.getUsers()
//        );
//    }
}
