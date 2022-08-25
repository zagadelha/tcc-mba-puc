package io.fourpet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetEntity {

	private String id;
	private String nome;
	private String sexo;
	private String raca;

}
