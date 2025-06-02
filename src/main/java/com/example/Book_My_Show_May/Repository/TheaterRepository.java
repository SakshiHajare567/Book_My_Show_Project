package com.example.Book_My_Show_May.Repository;

import com.example.Book_My_Show_May.Entities.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity , Integer> {
}
