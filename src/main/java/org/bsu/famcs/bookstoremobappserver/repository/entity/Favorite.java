package org.bsu.famcs.bookstoremobappserver.repository.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null)
            createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }

}
