package org.bsu.famcs.bookstoremobappserver.repository.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
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

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "user")
    private Set<Favorite> favorites;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
}
