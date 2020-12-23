package org.bsu.famcs.bookstoremobappserver.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "publishing_year")
    private Integer publishingYear;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "delivery_date")
    private Timestamp deliveryDate;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "books")
    @EqualsAndHashCode.Exclude
    private Set<Genre> genres;

    @ManyToMany(mappedBy = "books")
    @EqualsAndHashCode.Exclude
    private Set<Author> authors;

    @OneToMany(mappedBy = "book")
    @EqualsAndHashCode.Exclude
    private Set<Favorite> favorites;

    @OneToMany(mappedBy = "book")
    @EqualsAndHashCode.Exclude
    private Set<Order> orders;

    @PrePersist
    public void prePersist() {
        if (createdAt == null)
            createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
