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

class UbicacionesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_ubicaciones, container, false)
        val containerLayout = rootView.findViewById<LinearLayout>(R.id.ubicacionesContainer)

        val ubicaciones = listOf(
            Triple(
                "Universidad Nacional del Santa",
                "Lugar donde se realizarán los seminarios, ceremonias y conferencias.\nEdificios: EPIE, Aulas de Energía, Sala de Cómputo, Auditorio UNS, etc.",
                R.drawable.uns_universidad
            ),
            Triple(
                "Complejo Deportivo UNS",
                "Ubicación de los campeonatos deportivos y la jornada recreativa del Viernes 06-06-25.",
                R.drawable.uns_deportivo
            )
        )

        for ((titulo, descripcion, imagenRes) in ubicaciones) {
            val card = inflater.inflate(R.layout.item_ubicacion_card, container, false) as CardView
            card.findViewById<TextView>(R.id.ubicacionTitulo).text = titulo
            card.findViewById<TextView>(R.id.ubicacionDescripcion).text = descripcion
            card.findViewById<ImageView>(R.id.ubicacionImagen).setImageResource(imagenRes)
            containerLayout.addView(card)
        }

        return rootView
    }
}
