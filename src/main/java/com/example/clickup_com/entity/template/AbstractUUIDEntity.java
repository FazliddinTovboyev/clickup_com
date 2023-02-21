package com.example.clickup_com.entity.template;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class AbstractUUIDEntity extends AbstractEntity{
    @Id
    @GeneratedValue(generator = "uuid2")
//    @Type(type = "org.hibernate.UUIDType")
    @GenericGenerator(name = "uuid2",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
}
