package com.example.clickup_com.entity;

import com.example.clickup_com.entity.enums.SystemRoleName;
import com.example.clickup_com.entity.template.AbstractUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "foydalanuvchilar")
@EntityListeners(AuditingEntityListener.class)
public class Users extends AbstractUUIDEntity implements UserDetails {
    private String fish;
    private String username;
    private String password;
    @Transient
    private char boshHarf;
    private String avatarRangi;
    private String platformaRangi;
    @ManyToOne
    private FileInfo fileInfo;
    @Enumerated(EnumType.ORDINAL)
    private SystemRoleName systemRoleName;
//    @ManyToOne
//    private WorkspaceUser workspaceUser;
    private String emailCode;

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled = false;

    public String getBoshHarf() {
        String[] s=fish.split(" ");
        String initL = "";
        initL = s[0].substring(0,1) + s[s.length - 1].substring(0,1).toUpperCase();
        return initL;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(systemRoleName.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    public Users(String fish, String username, String password, String avatarRangi, String platformaRangi, SystemRoleName systemRoleName, String emailCode) {
        this.fish = fish;
        this.username = username;
        this.password = password;
        this.avatarRangi = avatarRangi;
        this.platformaRangi = platformaRangi;
        this.systemRoleName = systemRoleName;
        this.emailCode = emailCode;
    }
}
