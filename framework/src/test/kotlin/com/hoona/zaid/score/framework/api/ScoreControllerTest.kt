package com.hoona.zaid.score.framework.api

import com.hoona.zaid.score.application.ScoreService
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import kotlin.properties.Delegates

class ScoreControllerTest {

    private var scoreController: ScoreController by Delegates.notNull()
    private var scoreService: ScoreService by Delegates.notNull()
    private val studentId = "james may"

    @Before
    fun setUp() {
        scoreService = mock(ScoreService::class.java)
        scoreController = ScoreController(scoreService)
    }

    @Test
    fun should_call_student_service_to_get_score_for_student() {
        scoreController.getScoreForStudent(studentId)

        verify(scoreService).getScoreForStudent(studentId)
    }
}
