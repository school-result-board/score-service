package com.hoona.zaid.score.application

import com.hoona.zaid.score.application.exception.InvalidScoreCreationException
import com.hoona.zaid.score.application.exception.InvalidScoreUpdateException
import com.hoona.zaid.score.application.exception.ScoreNotFoundException
import com.hoona.zaid.score.application.repo.ScoreRepository
import com.hoona.zaid.score.domian.Score
import java.util.*

class ScoreService(private val scoreRepository: ScoreRepository) {

    fun getScoreForStudent(studentId: String): List<Score> {
        val scoreForStudent = scoreRepository.getScoreForStudent(studentId)
        return scoreForStudent.orElse(Collections.emptyList())
    }

    fun findScoreById(scoreId: String): Score {
        val score = scoreRepository.getScoreById(scoreId)
        return score.orElseThrow { ScoreNotFoundException(scoreId) }
    }

    fun addScore(score: Score): Score {
        if (score.id != "") {
            throw InvalidScoreCreationException()
        }
        return scoreRepository.addScore(score)
    }

    fun updateScore(score: Score): Score {
        if (score.id == "") {
            throw InvalidScoreUpdateException()
        }
        return scoreRepository.updateScore(score)
    }
}
