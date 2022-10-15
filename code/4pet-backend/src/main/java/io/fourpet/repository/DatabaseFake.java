package io.fourpet.repository;

import io.fourpet.entity.PetEntity;
import io.fourpet.entity.RacaEntity;
import io.fourpet.entity.UsuarioEntity;

import java.util.*;
import java.util.stream.Collectors;

public class DatabaseFake {

    private static List<UsuarioEntity> usuarios = new ArrayList<>();
    private static List<PetEntity> pets = new ArrayList<>();
    private static List<RacaEntity> racas = new ArrayList<>();


    static{
        feedStaticLists();
    }

    private static void feedStaticLists() {

        // Populate static users
        UsuarioEntity u1 = UsuarioEntity.builder().id("0").nome("Ana").email("ana@mail.com").senha("123").build();
        UsuarioEntity u2 = UsuarioEntity.builder().id("1").nome("Bia").email("bia@mail.com").senha("123").build();
        UsuarioEntity u3 = UsuarioEntity.builder().id("2").nome("Cris").email("cris@mail.com").senha("123").build();
        Collections.addAll(usuarios, u1, u2, u3);

    }

    private static String getNextUsuarioID(){
        return usuarios.size() + "";
    }

    private static String getNextPetID(){
        return (pets.size()-1) + "";
    }

    public static UsuarioEntity save(UsuarioEntity usuario) {
        usuarios.add(usuario);
        usuario.setId(getNextUsuarioID());
        return usuario;
    }


    public static UsuarioEntity findById(String usuarioId) {

        Optional<UsuarioEntity> opUsuario = usuarios.stream().
                filter(u -> u.getId().equals(usuarioId)).findFirst();

        if (opUsuario.isPresent())
            return opUsuario.get();
        else
            return new UsuarioEntity();
    }

    public static UsuarioEntity findByEmail(String email) {

        Optional<UsuarioEntity> opUsuario = usuarios.stream().
                filter(u -> u.getEmail().equals(email)).findFirst();

        if (opUsuario.isPresent())
            return opUsuario.get();
         else
            return new UsuarioEntity();
    }

    public static PetEntity savePet(PetEntity pet) {
        pets.add(pet);
        pet.setId(getNextPetID());
        return pet;
    }

    public static List<PetEntity> findPetsByUser(String userId) {

        if (pets == null || pets.size() == 0) {
            return new ArrayList<PetEntity>();
        }else{
            Integer user = Integer.parseInt(userId);
            List<PetEntity> filteredPets = pets.stream().filter( p -> p.getUsuarioId().equals(user)).collect(Collectors.toList());
            return filteredPets;
        }
    }
}
