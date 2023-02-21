package com.example.clickup_com.entity.template;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public abstract class AbstractEntity {
    @JoinColumn(updatable = false)
    @CreatedBy
    private Integer kimTomonidanYaratilgan;

    @LastModifiedBy
    private Integer kimTomonidanTahrirlangan;

    @CreationTimestamp
    @JoinColumn(updatable = false)
    private Timestamp yaratilganVaqti;

    @UpdateTimestamp
    private Timestamp tahrirlanganVaqti;
}
