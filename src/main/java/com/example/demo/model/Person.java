package com.example.demo.model;

import com.example.demo.commons.model.IntIdEntity;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "people")
@DynamicInsert
@DynamicUpdate
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Person extends IntIdEntity {

    @Column(nullable = false, length = 32)
    private String name;

    @NaturalId
    @Column(nullable = false, length = 32)
    private String email;

    @Type(type = "jsonb")
    @Column(nullable = false, columnDefinition = "jsonb")
    private Address address = new Address();
}
