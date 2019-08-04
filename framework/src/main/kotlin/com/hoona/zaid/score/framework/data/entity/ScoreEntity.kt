package com.hoona.zaid.score.framework.data.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "score")
data class ScoreEntity(
        @Column
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id: String?,

        @Column
        val studentId: String,

        @Column
        val english: Int,

        @Column
        val hindi: Int,

        @Column
        val marathi: Int,

        @Column
        val maths: Int,

        @Column
        val science: Int,

        @Column
        val socialScience: Int
)
