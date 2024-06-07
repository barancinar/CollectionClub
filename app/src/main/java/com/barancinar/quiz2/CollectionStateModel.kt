package com.barancinar.quiz2

import java.io.Serializable

data class CollectionStateModel(
    val id: Long,
    val image: Int,
    val state: Int
): Serializable
