package com.hoona.zaid.score.framework.data.jpa

import com.hoona.zaid.score.framework.data.entity.ScoreEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ScoreJpaRepository : JpaRepository<ScoreEntity, String> {
    fun findAllByStudentId(studentId: String): Optional<List<ScoreEntity>>
}
