package com.hoona.zaid.score.application.exception

class ScoreNotFoundException(scoreId: String) : Exception("Cannot find score for id $scoreId")
