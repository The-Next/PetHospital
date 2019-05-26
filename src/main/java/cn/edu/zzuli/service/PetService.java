package cn.edu.zzuli.service;

import cn.edu.zzuli.domain.Pet;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author 程佩
 * @datatime 2019/5/14 20:45
 */
public interface PetService {
public Pet addPet(Pet pet);
public void deletePet(Integer id);
public Pet uptataPet(Pet pet);
public ArrayList<Pet>getPetList();
public Optional<Pet> getPetById(Integer id);
public ArrayList<Pet> getPetByType(Integer id);
public ArrayList<Pet> getPetByOwner(Integer id);
}