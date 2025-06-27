package com.example.semanaingenieria.data

object FakeData {
    fun getEventsForDay(day: Int): List<Event> {
        return when (day) {
            0 -> listOf(
                Event("Inauguración", "09:00 AM"),
                Event("Taller de Arduino", "10:30 AM")
            )
            1 -> listOf(
                Event("Conferencia IA", "09:00 AM"),
                Event("Hackathon", "11:00 AM")
            )
            2 -> listOf(
                Event("Cierre del evento", "02:00 PM")
            )
            else -> emptyList()
        }
    }
}