package com.example.clickup_com.entity;

import com.example.clickup_com.entity.enums.WorkspaceRoleName;
import com.example.clickup_com.entity.template.AbstractLongEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class WorkSpaceRole extends AbstractLongEntity {
    @Column(nullable = false)
    private String lavozimNomi;

    @ManyToOne
    private Workspace workspace;

    @Enumerated(EnumType.ORDINAL)
    private WorkspaceRoleName workspaceRoleNameList;
}