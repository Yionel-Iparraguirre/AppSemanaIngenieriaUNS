package com.example.semanaingenieria.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.semanaingenieria.R

// --- Data classes para estructurar la información ---
data class Seminario(
    val hora: String,
    val titulo: String,
    val ponente: String
)

data class EscuelaSeminarios(
    val nombreEscuela: String,
    val lugar: String,
    val fecha: String,
    val seminarios: List<Seminario>
)

class SeminariosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_seminarios, container, false)
        val containerLayout = rootView.findViewById<LinearLayout>(R.id.seminariosContainer)

        val seminariosPorEscuela = getSeminariosData()

        for (escuela in seminariosPorEscuela) {
            // Inflar el card de la escuela
            val card = inflater.inflate(R.layout.item_escuela_card, containerLayout, false) as CardView

            // Asignar título y detalles
            card.findViewById<TextView>(R.id.tituloEscuela).text = escuela.nombreEscuela
            card.findViewById<TextView>(R.id.detalleLugarFecha).text = "${escuela.fecha} | ${escuela.lugar}"

            // Añadir seminarios al contenedor interno
            val seminariosLayout = card.findViewById<LinearLayout>(R.id.contenedorSeminarios)
            for (seminario in escuela.seminarios) {
                val seminarioView = TextView(requireContext()).apply {
                    text = "🕒 ${seminario.hora}\n📌 ${seminario.titulo}\n👤 ${seminario.ponente}"
                    textSize = 14f
                    setPadding(0, 6, 0, 12)
                    setTextColor(resources.getColor(android.R.color.black))
                }
                seminariosLayout.addView(seminarioView)
            }

            containerLayout.addView(card)
        }

        return rootView
    }

    private fun getSeminariosData(): List<EscuelaSeminarios> {
        return listOf(
            EscuelaSeminarios(
                "Ingeniería Agroindustrial",
                "Auditorio EPIE",
                "Martes 03-06-25",
                listOf(
                    Seminario("08:00 a. m.", "Hidrólisis marinos – vía enzimática", "Ing. Gabriel Silvestre Peñaloza"),
                    Seminario("08:45 a. m.", "Nutrición agroindustrial con propósito", "Ing. Miriam Vásquez Chihuán"),
                    Seminario("09:30 a. m.", "Innovación, emprendimiento y gestión agroindustrial", "Ing. Nadia Esther Gamarra Abanto"),
                    Seminario("10:15 a. m.", "Gestión de calidad en producción de aceite de pescado", "Ing. Carmen Pajuelo Carbajal")
                )
            ),
            EscuelaSeminarios(
                "Ingeniería Agrónoma",
                "Auditorio Ing. Agrónoma – Campus II",
                "Martes 03-06-25",
                listOf(
                    Seminario("03:00 p. m.", "Manejo agronómico del cultivo de palto var. Hass", "Ing. Paco Chicoma Rivera"),
                    Seminario("03:45 p. m.", "Estrés biológicos en cultivos", "Ing. Daleida Longobardi Méndez"),
                    Seminario("04:30 p. m.", "Agroexportación de frutales", "Ing. Jesús Jaque Chauca")
                )
            ),
            EscuelaSeminarios(
                "Ingeniería en Energía",
                "Auditorio EPIE",
                "Miércoles 04-06-25",
                listOf(
                    Seminario("09:00 a. m.", "Agrovoltaica: alternativa para transición energética", "Dr. Denis Arangurí Cayetano"),
                    Seminario("10:00 a. m.", "Técnicas nucleares para detección de gas Radón", "Ing. Carlos Montañez Montenegro"),
                    Seminario("11:00 a. m.", "Energía eólica residencial: comparación Perú-Europa", "M.Sc. Ricardo Cedrón Magallanes")
                )
            ),
            EscuelaSeminarios(
                "Ingeniería Mecánica",
                "Auditorio EPIE",
                "Miércoles 04-06-25",
                listOf(
                    Seminario("03:00 p. m.", "TPM en procesamiento de harina de pescado", "M.Sc. Arquímedes Iparraguirre Lozano"),
                    Seminario("03:45 p. m.", "Bloqueo de energía residual en industria", "M.Sc. Luis Carlos Calderón Rodríguez"),
                    Seminario("04:15 p. m.", "Sistemas ATS", "Ms. Fredesvindo Fidel Ríos Noriega")
                )
            ),
            EscuelaSeminarios(
                "Ingeniería Civil",
                "Auditorio Biblioteca Central",
                "Jueves 05-06-25",
                listOf(
                    Seminario("10:00 a. m.", "El ingeniero como agente de cambio", "Ing. Jorge Castañeda Centurión"),
                    Seminario("10:45 a. m.", "Desempeño sísmico en edificios esenciales", "Ing. Iván León Mulo"),
                    Seminario("11:30 a. m.", "Cimentaciones en Chimbote según E.050", "Ing. Jorge Morillo Trujillo")
                )
            )
        )
    }
}
