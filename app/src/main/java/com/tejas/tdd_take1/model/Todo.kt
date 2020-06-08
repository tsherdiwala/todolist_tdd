package com.tejas.tdd_take1.model

import java.util.*

data class Todo(val id: UUID, val title: String) {
    constructor(title: String): this(UUID.randomUUID(), title)
}