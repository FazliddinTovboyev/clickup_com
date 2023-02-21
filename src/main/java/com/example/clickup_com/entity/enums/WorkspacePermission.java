package com.example.clickup_com.entity.enums;

import com.example.clickup_com.entity.WorkSpaceRole;
import com.example.clickup_com.entity.template.AbstractLongEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class WorkspacePermission extends AbstractLongEntity {
    @Enumerated
    private WorkspacePermissionName workspacePermissionName;

    @ManyToOne
    private WorkSpaceRole workSpaceRole;
}
