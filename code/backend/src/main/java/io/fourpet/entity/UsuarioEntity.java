package io.fourpet.entity;

//import com.amazonaws.services.dynamodbv2.datamodeling.*;

import lombok.*;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@DynamoDBTable(tableName = "usuario")
//@EqualsAndHashCode(of = {"id", "email"})
public class UsuarioEntity {

	//@DynamoDBHashKey(attributeName = "id")
	//@DynamoDBAutoGeneratedKey
	private String id;

	//@DynamoDBAttribute
	private String nome;

	//@DynamoDBAttribute
	private String email;

	//@DynamoDBAttribute
	private String senha;

	//@DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
	private Boolean anunciante;

}
