package com.example.clickup_com.entity;

import com.example.clickup_com.entity.template.AbstractUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class WorkspaceUser extends AbstractUUIDEntity {
    @ManyToOne
    private Users users;
    @ManyToOne
    private WorkSpaceRole workSpaceRole;
    private Timestamp lastActice;
    @CreationTimestamp
    private Timestamp taklifYuborilganVaqt;
    @ManyToOne
    private Workspace workspace;
//    @UpdateTimestamp
//    private Timestamp taklifQabulQilingan;
}
