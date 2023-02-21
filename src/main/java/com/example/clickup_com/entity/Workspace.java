package com.example.clickup_com.entity;

import com.example.clickup_com.entity.template.AbstractLongEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Workspace extends AbstractLongEntity {
    private String nomi;

    private char boshHarf;

    private String avatarRangi;

//    @OneToOne
//    private FileInfo fileInfo;

    @ManyToOne
    private Users users;
}
