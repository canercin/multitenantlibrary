package com.online.multitenantlib.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "publisher_id")
    private UUID publisherId;

    @Column(name = "publisher_name")
    private String publisherName;

    @ManyToMany(mappedBy = "publishers")
    private List<Book> books;
}
