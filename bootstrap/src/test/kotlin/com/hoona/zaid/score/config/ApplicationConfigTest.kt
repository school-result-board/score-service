package com.hoona.zaid.score.config

import com.hoona.zaid.score.application.ScoreService
import com.hoona.zaid.score.application.repo.ScoreRepository
import com.hoona.zaid.score.framework.mapper.ScoreMapper
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner::class)
class ApplicationConfigTest {

    @Autowired
    lateinit var scoreService: ScoreService

    @Autowired
    lateinit var scoreRepository: ScoreRepository

    @Autowired
    lateinit var scoreMapper: ScoreMapper

    @Test
    fun `should create score service`() {
        Assertions.assertThat(scoreService).isNotNull
    }

    @Test
    fun `should create score repository`() {
        Assertions.assertThat(scoreRepository).isNotNull
    }

    @Test
    fun `should create score mapper`() {
        Assertions.assertThat(scoreMapper).isNotNull
    }
}
