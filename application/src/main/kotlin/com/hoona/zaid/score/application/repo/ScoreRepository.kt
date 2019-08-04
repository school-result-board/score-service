package com.hoona.zaid.score.application.repo

import com.hoona.zaid.score.domian.Score
import java.util.*

interface ScoreRepository {
    fun getScoreForStudent(studentId: String): Optional<List<Score>>
    fun addScore(score: Score): Score
    fun updateScore(score: Score): Score
    fun getScoreById(scoreId: String): Optional<Score>
}
