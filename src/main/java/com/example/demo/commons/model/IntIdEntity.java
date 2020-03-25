package com.example.demo.commons.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class IntIdEntity extends BaseEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_sequence")
	@SequenceGenerator(name = "global_sequence", allocationSize = 10)
	private Integer id;

	@Version
	private Short version;

	public IntIdEntity(Integer id) {
		this.id = id;
	}
}
