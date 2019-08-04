package com.hoona.zaid.score.application

import com.hoona.zaid.score.application.exception.InvalidScoreCreationException
import com.hoona.zaid.score.application.exception.InvalidScoreUpdateException
import com.hoona.zaid.score.application.exception.ScoreNotFoundException
import com.hoona.zaid.score.application.repo.ScoreRepository
import com.hoona.zaid.score.domian.Score
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.util.*
import kotlin.properties.Delegates

class ScoreServiceTest {

    private var scoreService: ScoreService by Delegates.notNull()
    private var scoreRepository: ScoreRepository by Delegates.notNull()
    private val studentId = "james may"

    @Before
    fun setUp() {
        scoreRepository = mock(ScoreRepository::class.java)
        scoreService = ScoreService(scoreRepository)
    }

    @Test
    fun should_call_score_repository_to_get_score_for_student() {
        val score = Score("1", "1", 1, 1, 1, 1, 1, 1)
        val scoreList = Collections.singletonList(score)
        doReturn(Optional.of(scoreList)).`when`(scoreRepository).getScoreForStudent(anyString())

        scoreService.getScoreForStudent(studentId)

        verify(scoreRepository).getScoreForStudent(studentId)
    }

    @Test
    fun should_call_score_repository_to_add_score() {
        val score = Score("", "testStudent", 1, 1, 1, 1, 1, 1)

        scoreService.addScore(score)

        verify(scoreRepository).addScore(score)
    }

    @Test(expected = InvalidScoreCreationException::class)
    fun should_throw_exception_when_adding_score_with_an_existing_id() {
        val score = Score("test", "testStudent", 1, 1, 1, 1, 1, 1)

        scoreService.addScore(score)
    }

    @Test
    fun should_call_score_repository_to_update_score() {
        val score = Score("test", "testStudent", 2, 2, 2, 2, 2, 2)

        scoreService.updateScore(score)

        verify(scoreRepository).updateScore(score)
    }

    @Test(expected = InvalidScoreUpdateException::class)
    fun should_throw_exception_when_updating_score_with_an_no_id() {
        val score = Score("", "testStudent", 1, 1, 1, 1, 1, 1)

        scoreService.updateScore(score)
    }

    @Test
    fun `should call score repository to find score using score id`() {
        val scoreId = "some score id"
        val score = Score("test", "testStudent", 1, 1, 1, 1, 1, 1)
        doReturn(Optional.of(score)).`when`(scoreRepository).getScoreById(scoreId)

        scoreService.findScoreById(scoreId)

        verify(scoreRepository).getScoreById(scoreId)
    }

    @Test(expected = ScoreNotFoundException::class)
    fun `should throw exception when score for the given id is not found`() {
        val scoreId = "some score id"

        scoreService.findScoreById(scoreId)
    }
}
