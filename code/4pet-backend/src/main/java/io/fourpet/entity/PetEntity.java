package io.fourpet.entity;

//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@DynamoDBTable(tableName = "pet")
public class PetEntity {

	private String id;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String tipoSanguineo;
	private String porte;
	private String raca;
	private boolean disponivelAdocao;
	private boolean disponivelCruzamento;
	private boolean disponivelMaeDeLeite;
	private Integer usuarioId;

}
