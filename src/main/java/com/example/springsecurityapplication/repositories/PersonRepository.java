package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    // Получаем запись из БД по логину
    Optional<Person> findByLogin(String login);


    Optional<Person> findByPassword(String password);

    //запрос для обновления пароля при смене
    @Modifying
    @Query(value = "UPDATE person set password = ?2 where id=?1", nativeQuery = true)
    void updatePersonById(int id, String password);

}
