package com.renzzle.backend.domain.puzzle.dao;

import com.renzzle.backend.domain.puzzle.domain.SolvedLessonPuzzle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SolvedLessonPuzzleRepository extends JpaRepository<SolvedLessonPuzzle, Long> {

    @Query(value = "SELECT * FROM solved_lesson_puzzle " +
            "WHERE user_id = :userId AND lesson_id = :lessonId",
            nativeQuery = true)
    Optional<SolvedLessonPuzzle> findByUserIdAndLessonId(@Param("userId") Long userId,
                                                         @Param("lessonId") Long lessonId);

    boolean existsByUserIdAndLessonId(Long userId, Long lessonId);

    @Query(value = "SELECT COUNT(*) " +
            "FROM solved_lesson_puzzle sl " +
            "JOIN lesson_puzzle l ON sl.lesson_id = l.id " +
            "WHERE sl.user_id = :userId AND l.chapter = :chapter",
            nativeQuery = true)
    int countSolvedLesson(@Param("userId") Long userId,
                          @Param("chapter") int chapter);

}
