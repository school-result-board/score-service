package com.hoona.zaid.score.domian

data class Score(
        val id: String,
        val studentId: String,
        val english: Int,
        val hindi: Int,
        val marathi: Int,
        val maths: Int,
        val science: Int,
        val socialScience: Int
)
