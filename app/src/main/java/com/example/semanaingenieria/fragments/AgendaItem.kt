package com.example.semanaingenieria.fragments

data class AgendaItem(
    val dia: String,
    val escuela: String,
    val eventos: List<Evento>
)

data class Evento(
    val hora: String,
    val titulo: String,
    val lugar: String,
    val ponente: String? = null,
    val escuela: String? = null
)