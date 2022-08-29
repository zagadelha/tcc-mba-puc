package io.fourpet.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;

import io.fourpet.entity.UsuarioEntity;

@Repository
public class UsuarioRepository {

	@Autowired
	private DynamoDBMapper dbMapper;

	public UsuarioEntity save(UsuarioEntity usuario) {
		dbMapper.save(usuario);
		return usuario;
	}

	public UsuarioEntity getUsuarioById(String usuarioId) {
		return dbMapper.load(UsuarioEntity.class, usuarioId);
	}

	public void delete(String usuarioId) {
		UsuarioEntity usuario = dbMapper.load(UsuarioEntity.class, usuarioId);
		dbMapper.delete(usuario);
	}

	public void update(String usuarioId, UsuarioEntity usuario) {
		dbMapper.save(usuario, new DynamoDBSaveExpression().withExpectedEntry("id",
				new ExpectedAttributeValue(new AttributeValue().withS(usuarioId))));
	}

}