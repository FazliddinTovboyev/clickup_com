package com.example.clickup_com.repository;

import com.example.clickup_com.entity.WorkSpaceRole;
import com.example.clickup_com.entity.Workspace;
import com.example.clickup_com.entity.WorkspaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WorkspaceUserRepository extends JpaRepository<WorkspaceUser, UUID> {
    Optional<WorkspaceUser> findByWorkspaceAndWorkSpaceRole(Workspace workspace, WorkSpaceRole workSpaceRole);
}
