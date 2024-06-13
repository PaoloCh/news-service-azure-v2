package com.groweasy.newsservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "news")
public class New {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", length =150, nullable=false)
    private String title;

    @Column(name="description", length =200, nullable=false)
    private String description;

    @Column(name="link", length =200, nullable=false)
    private String link;

    @Column(name="image", length =200, nullable=false)
    private String image;
}
