package com.groweasy.newsservice.repository;

import com.groweasy.newsservice.model.New;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<New, Long> {

    Boolean existsByTitle(String title);
}
