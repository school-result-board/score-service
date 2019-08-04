package com.hoona.zaid.score.framework.mapper

import com.hoona.zaid.score.domian.Score
import com.hoona.zaid.score.framework.data.entity.ScoreEntity
import java.util.*

class ScoreMapper {

    fun toDomain(scoreEntity: ScoreEntity): Score {
        val (optionalId, studentId, english, hindi, marathi, maths, science, socialScience) = scoreEntity
        val id = Optional.ofNullable(optionalId).orElse("")
        return Score(id, studentId, english, hindi, marathi, maths, science, socialScience)
    }

    fun toDomain(scoreEntities: List<ScoreEntity>): List<Score> {
        return scoreEntities.map { toDomain(it) }
    }

    fun toEntity(score: Score): ScoreEntity {
        val (id, studentId, english, hindi, marathi, maths, science, socialScience) = score
        return ScoreEntity(id, studentId, english, hindi, marathi, maths, science, socialScience)
    }

    fun toEntity(scores: List<Score>): List<ScoreEntity> {
        return scores.map { toEntity(it) }
    }
}
