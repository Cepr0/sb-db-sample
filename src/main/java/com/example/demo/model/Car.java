package com.example.demo.model;

import com.example.demo.commons.model.IntIdEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cars")
@DynamicInsert
@DynamicUpdate
public class Car extends IntIdEntity {

    @Column(nullable = false, length = 16)
    private String brand;

    @Column(nullable = false, length = 16)
    private String model;

    @NaturalId
    @Column(nullable = false, length = 16)
    private String plateNum;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Person person;
}
