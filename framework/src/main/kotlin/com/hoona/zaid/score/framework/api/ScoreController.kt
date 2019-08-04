package com.hoona.zaid.score.framework.api

import com.hoona.zaid.score.application.ScoreService
import com.hoona.zaid.score.domian.Score
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/v1/score")
class ScoreController(private val scoreService: ScoreService) {

    @GetMapping("/{scoreId}")
    fun getScoreById(@PathVariable scoreId: String): ResponseEntity<List<Score>> {
        val scoreForStudent = scoreService.getScoreForStudent(scoreId)
        return ResponseEntity.ok(scoreForStudent)
    }

    @GetMapping("/student/{studentId}")
    fun getScoreForStudent(@PathVariable studentId: String): ResponseEntity<List<Score>> {
        val scoreForStudent = scoreService.getScoreForStudent(studentId)
        return ResponseEntity.ok(scoreForStudent)
    }

    @PostMapping
    fun addScore(@RequestBody score: Score): ResponseEntity<Score> {
        val savedScore = scoreService.addScore(score)
        return ResponseEntity.created(URI.create("/v1/score/${savedScore.id}")).body(score)
    }

    @PutMapping
    fun updateScore(@RequestBody score: Score): ResponseEntity<Score> {
        val updatedScore = scoreService.updateScore(score)
        return ResponseEntity.ok(updatedScore)
    }
}
