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
//@DynamoDBTable(tableName = "raca")
public class RacaEntity {

    private String id;
    private String nome;

}
