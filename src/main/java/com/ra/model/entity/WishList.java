package com.ra.model.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Todo: foreign Key: User Id(done)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //Todo: foreign Key: Product Id(done)
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
