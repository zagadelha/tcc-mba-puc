package io.fourpet.repository;

import io.fourpet.entity.UsuarioEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, String> {

    UsuarioEntity findByEmail(String email);

}
