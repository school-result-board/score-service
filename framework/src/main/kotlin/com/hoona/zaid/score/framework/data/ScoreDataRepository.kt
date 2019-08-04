package com.hoona.zaid.score.framework.data

import com.hoona.zaid.score.application.repo.ScoreRepository
import com.hoona.zaid.score.domian.Score
import com.hoona.zaid.score.framework.data.jpa.ScoreJpaRepository
import com.hoona.zaid.score.framework.mapper.ScoreMapper
import org.springframework.beans.BeanUtils
import java.util.*

class ScoreDataRepository(private val scoreJpaRepository: ScoreJpaRepository, private val scoreMapper: ScoreMapper) : ScoreRepository {

    override fun getScoreById(scoreId: String): Optional<Score> {
        val scoreEntity = scoreJpaRepository.findById(scoreId)
        return scoreEntity.map { scoreMapper.toDomain(it) }
    }

    override fun updateScore(score: Score): Score {
        val savedScore = scoreJpaRepository.findById(score.id)
        val updatedScore = scoreMapper.toEntity(score)
        savedScore.ifPresent { BeanUtils.copyProperties(updatedScore, savedScore) }
        val newScore = scoreJpaRepository.save(savedScore.get())
        return scoreMapper.toDomain(newScore)
    }

    override fun addScore(score: Score): Score {
        val scoreEntity = scoreMapper.toEntity(score)
        val savedEntity = scoreJpaRepository.save(scoreEntity)
        return scoreMapper.toDomain(savedEntity)
    }

    override fun getScoreForStudent(studentId: String): Optional<List<Score>> {
        val scoreForStudent = scoreJpaRepository.findAllByStudentId(studentId)
        return scoreForStudent.map { scoreMapper.toDomain(it) }
    }
}
