package com.cafeiq.repository;

import com.cafeiq.entity.CafeOperatingDay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CafeOperatingDayRepository
        extends JpaRepository<CafeOperatingDay, LocalDate> {

    // Closed dates in the last 7 completed calendar days
    @Query(value = """
        SELECT operating_date
        FROM cafe_operating_day
        WHERE operating_date BETWEEN CURRENT_DATE - INTERVAL '7 days'
                                 AND CURRENT_DATE - INTERVAL '1 day'
          AND status = 'CLOSED'
        ORDER BY operating_date
        """, nativeQuery = true)
    List<java.sql.Date> getClosedDatesLast7Days();


    // Number of closed days in the last 7 completed calendar days
    @Query(value = """
        SELECT COUNT(*)
        FROM cafe_operating_day
        WHERE operating_date BETWEEN CURRENT_DATE - INTERVAL '7 days'
                                 AND CURRENT_DATE - INTERVAL '1 day'
          AND status = 'CLOSED'
        """, nativeQuery = true)
    Long getClosedDaysCountLast7Days();


    // Number of closed days in the previous 7 completed calendar days
    @Query(value = """
        SELECT COUNT(*)
        FROM cafe_operating_day
        WHERE operating_date BETWEEN CURRENT_DATE - INTERVAL '14 days'
                                 AND CURRENT_DATE - INTERVAL '8 days'
          AND status = 'CLOSED'
        """, nativeQuery = true)
    Long getClosedDaysCountPrevious7Days();
}