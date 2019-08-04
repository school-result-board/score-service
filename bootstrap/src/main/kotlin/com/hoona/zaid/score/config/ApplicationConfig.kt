package com.hoona.zaid.score.config

import com.hoona.zaid.score.application.ScoreService
import com.hoona.zaid.score.application.repo.ScoreRepository
import com.hoona.zaid.score.framework.data.ScoreDataRepository
import com.hoona.zaid.score.framework.data.jpa.ScoreJpaRepository
import com.hoona.zaid.score.framework.mapper.ScoreMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfig {

    @Bean
    fun scoreService(scoreRepository: ScoreRepository): ScoreService {
        return ScoreService(scoreRepository)
    }

    @Bean
    fun scoreRepository(scoreJpaRepository: ScoreJpaRepository, scoreMapper: ScoreMapper): ScoreRepository {
        return ScoreDataRepository(scoreJpaRepository, scoreMapper)
    }

    @Bean
    fun scoreMapper(): ScoreMapper {
        return ScoreMapper()
    }
}
