package com.example.clickup_com.repository;

import com.example.clickup_com.entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {
//    Optional<Workspace> findByNomi(String nomi);
}
