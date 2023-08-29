package com.example.smilekarina.check.infrastructure;

import com.example.smilekarina.check.domain.CheckPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CheckRepository extends JpaRepository<CheckPoint, Long> {
//    @Query("SELECT cp FROM CheckPoint cp WHERE cp.userId = ?1 ORDER BY cp.ckeckDate DESC")
//    Optional<CheckPoint> findLatestByUserId(Long userId);
    List<CheckPoint> findByUserIdAndCkeckDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}
