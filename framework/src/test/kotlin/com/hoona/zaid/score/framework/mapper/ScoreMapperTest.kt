package com.hoona.zaid.score.framework.mapper

import com.hoona.zaid.score.domian.Score
import com.hoona.zaid.score.framework.data.entity.ScoreEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import kotlin.properties.Delegates

class ScoreMapperTest {

    private var scoreMapper: ScoreMapper by Delegates.notNull()

    @Before
    fun setup() {
        scoreMapper = ScoreMapper()
    }

    @Test
    fun `should map list of entities to domain`() {
        val scoreEntityList = List(1) {
            ScoreEntity(it.toString(), "test student $it", 1, 2, 3, 4, 5, 6)
        }
        val scoreDomainList = scoreMapper.toDomain(scoreEntityList)

        assertThat(scoreDomainList).hasSize(1)
        val score = scoreDomainList[0]
        assertThat(score.id).isEqualTo("0")
        assertThat(score.studentId).isEqualTo("test student 0")
        assertThat(score.english).isEqualTo(1)
        assertThat(score.hindi).isEqualTo(2)
        assertThat(score.marathi).isEqualTo(3)
        assertThat(score.maths).isEqualTo(4)
        assertThat(score.science).isEqualTo(5)
        assertThat(score.socialScience).isEqualTo(6)
    }

    @Test
    fun `should map list of domain to entities`() {
        val scoreDomainList = List(1) {
            Score(it.toString(), "test student $it", 1, 2, 3, 4, 5, 6)
        }
        val scoreEntityList = scoreMapper.toEntity(scoreDomainList)

        assertThat(scoreEntityList).hasSize(1)
        val scoreEntity = scoreEntityList[0]
        assertThat(scoreEntity.id).isEqualTo("0")
        assertThat(scoreEntity.studentId).isEqualTo("test student 0")
        assertThat(scoreEntity.english).isEqualTo(1)
        assertThat(scoreEntity.hindi).isEqualTo(2)
        assertThat(scoreEntity.marathi).isEqualTo(3)
        assertThat(scoreEntity.maths).isEqualTo(4)
        assertThat(scoreEntity.science).isEqualTo(5)
        assertThat(scoreEntity.socialScience).isEqualTo(6)
    }
}

