package com.example.semanaingenieria.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.semanaingenieria.R

class CompetenciasFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_competencias, container, false)
        val containerLayout = rootView.findViewById<LinearLayout>(R.id.competenciasContainer)

        val competenciasPorDia = mapOf(
            "Jueves 05-06-25" to listOf(
                Triple(
                    "Corso Interescuelas",
                    "15:00 horas | Inicia en Puerta 1, finaliza en Complejo Deportivo UNS",
                    "otros"
                ),
                Triple(
                    "Fútbol - Partido Inaugural",
                    "16:00 horas | Complejo Deportivo UNS\nEscuela Campeón 2024 vs Club UNS",
                    "futbol"
                ),
                Triple(
                    "Fútbol - Egresados",
                    "16:45 horas | Complejo Deportivo UNS\nMaster 1 vs Master 2",
                    "futbol"
                )
            ),
            "Viernes 06-06-25" to listOf(
                Triple(
                    "Fútbol - Eliminatorias",
                    "09:00 horas | Complejo Deportivo UNS\nAgronomía vs Sistemas\nMecánica vs Agroindustrial\nEnergía vs Civil",
                    "futbol"
                ),
                Triple(
                    "Básquet - Eliminatorias",
                    "09:00 horas | Complejo Deportivo UNS\nEnergía vs Civil\nMecánica vs Agroindustrial\nAgronomía vs Sistemas",
                    "basquet"
                ),
                Triple(
                    "Vóley - Eliminatorias",
                    "Tarde | Complejo Deportivo UNS\nAgronomía vs Sistemas\nMecánica vs Agroindustrial\nEnergía vs Civil",
                    "voley"
                ),
                Triple(
                    "Final del Campeonato Interescuelas",
                    "15:00 horas | Complejo Deportivo UNS\nDisciplinas: Fútbol, Vóley y Básquet",
                    "otros"
                ),
                Triple("Premiación de Equipos", "18:00 horas | Complejo Deportivo UNS", "otros")
            )
        )

        for ((dia, competencias) in competenciasPorDia) {
            // Título del día
            val diaTitle = TextView(requireContext()).apply {
                text = dia
                textSize = 20f
                setTextColor(resources.getColor(android.R.color.black))
                setPadding(0, 16, 0, 8)
            }
            containerLayout.addView(diaTitle)

            for ((titulo, detalle, tipo) in competencias) {
                val card =
                    inflater.inflate(R.layout.item_competencia_card, container, false) as CardView
                card.findViewById<TextView>(R.id.tituloCompetencia).text = titulo
                card.findViewById<TextView>(R.id.detalleCompetencia).text = detalle


                val imageView = card.findViewById<ImageView>(R.id.iconoDeporte)

                when (tipo) {
                    "futbol" -> {
                        card.setCardBackgroundColor(resources.getColor(R.color.futbolCard))
                        imageView.setImageResource(R.drawable.ic_futbol)
                    }
                    "voley" -> {
                        card.setCardBackgroundColor(resources.getColor(R.color.voleyCard))
                        imageView.setImageResource(R.drawable.ic_voley)
                    }
                    "basquet" -> {
                        card.setCardBackgroundColor(resources.getColor(R.color.basquetCard))
                        imageView.setImageResource(R.drawable.ic_basquet)
                    }
                    else -> {
                        card.setCardBackgroundColor(resources.getColor(R.color.otrosCard))
                        imageView.setImageResource(R.drawable.ic_otros)
                    }
                }

                containerLayout.addView(card)
            }
        }
        return rootView
    }
}