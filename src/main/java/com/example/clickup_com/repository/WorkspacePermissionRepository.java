package com.example.clickup_com.repository;

import com.example.clickup_com.entity.enums.WorkspacePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspacePermissionRepository extends JpaRepository<WorkspacePermission, Long> {
}
