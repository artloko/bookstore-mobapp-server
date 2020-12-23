package org.bsu.famcs.bookstoremobappserver.repository.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@EqualsAndHashCode
@Entity
@Data
@RequiredArgsConstructor
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntity {

    public enum Role {USER, ADMIN, USER_MANAGER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "encrypted_password")
    private String passwordEncrypted;

    @Column(name = "reset_password_token")
    private String passwordResetToken;

    @Column(name = "reset_password_sent_at")
    private Timestamp passwordResetSentAt;

    @Column(name = "remember_created_at")
    private Timestamp rememberCreatedAt;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "userEntity")
    private Set<Favorite> favorites;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "userEntity")
    private Set<Order> orders;

    @Transient
    private Role role = Role.USER;

    @PrePersist
    public void prePersist() {
        if (createdAt == null)
            createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
