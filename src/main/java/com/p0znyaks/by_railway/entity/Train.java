package com.p0znyaks.by_railway.entity;

import com.p0znyaks.by_railway.entity.enums.TrainType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "trains")
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TrainType type;

    public Train(String number, TrainType type) {
        this.number = number;
        this.type = type;
    }
}
