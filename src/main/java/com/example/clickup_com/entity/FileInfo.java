package com.example.clickup_com.entity;

import com.example.clickup_com.entity.template.AbstractUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class FileInfo extends AbstractUUIDEntity {
    private String nomi;
    private String orginalNomi;
    private Double hajmi;
    private String kengaytmasi;
}
