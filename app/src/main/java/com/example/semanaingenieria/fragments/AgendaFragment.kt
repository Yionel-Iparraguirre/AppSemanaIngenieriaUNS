package com.example.semanaingenieria.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import android.widget.ImageView
import com.example.semanaingenieria.R

class AgendaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = inflater.inflate(R.layout.fragment_agenda, container, false)
        val containerLayout = rootView.findViewById<LinearLayout>(R.id.agendaContainer)

        val agendaData = obtenerAgenda() 

        for (agendaItem in agendaData) {
            val dayCard = inflater.inflate(R.layout.item_agenda_day_card, container, false) as CardView
            val diaText = dayCard.findViewById<TextView>(R.id.diaText)
            val expandCollapseIcon = dayCard.findViewById<ImageView>(R.id.expandCollapseIcon)
            val escuelasContainer = dayCard.findViewById<LinearLayout>(R.id.escuelasContainer)

            diaText.text = agendaItem.dia
            escuelasContainer.visibility = View.GONE

            // Agrupar eventos por escuela
            val eventosPorEscuela = agendaItem.eventos.groupBy { it.escuela ?: "General" }

            for ((escuela, eventos) in eventosPorEscuela) {
                val escuelaCard = inflater.inflate(R.layout.item_escuela_eventos_card, container, false) as CardView
                val escuelaText = escuelaCard.findViewById<TextView>(R.id.escuelaText)
                val eventosContainer = escuelaCard.findViewById<LinearLayout>(R.id.eventosContainer)

                escuelaText.text = escuela

                for (evento in eventos) {
                    val eventoView = inflater.inflate(R.layout.item_evento, container, false)
                    eventoView.findViewById<TextView>(R.id.horaText).text = evento.hora
                    eventoView.findViewById<TextView>(R.id.tituloText).text = evento.titulo
                    eventoView.findViewById<TextView>(R.id.lugarText).text = evento.lugar
                    eventoView.findViewById<TextView>(R.id.ponenteText).text =
                        evento.ponente ?: "Sin ponente"

                    eventosContainer.addView(eventoView)
                }

                escuelasContainer.addView(escuelaCard)
            }

            var isExpanded = false
            dayCard.setOnClickListener {
                isExpanded = !isExpanded
                escuelasContainer.visibility = if (isExpanded) View.VISIBLE else View.GONE
                expandCollapseIcon.setImageResource(
                    if (isExpanded) R.drawable.ic_expand_less else R.drawable.ic_expand_more
                )
            }

            containerLayout.addView(dayCard)
        }

        return rootView
    }

    private fun obtenerAgenda(): List<AgendaItem> {
        return listOf(
            AgendaItem(
                dia = "Lunes 02-06-25",
                escuela = "General",
                eventos = listOf(
                    Evento(
                        hora = "09:00 a.m.",
                        titulo = "Ceremonia de Inauguración",
                        lugar = "Plazuela de la UNS",
                        ponente = null,
                        escuela = null
                    )
                )
            ),
            AgendaItem(
                dia = "Martes 03-06-25",
                escuela = "",
                eventos = listOf(
                    // Ingeniería Agroindustrial
                    Evento(
                        "08:00 - 08:45",
                        "Hornos más eficientes - visión energética",
                        "Auditorio EPIE",
                        "Mg. Gabriel Sínemes Peusgo",
                        "Ingeniería Agroindustrial"
                    ),
                    Evento(
                        "08:45 - 09:30",
                        "Agroindustria con propósito: Innovar, emprender y transformar desde la agricultura familiar",
                        "Auditorio EPIE",
                        "Ing. Mirian Vásquez Chiquituta",
                        "Ingeniería Agroindustrial"
                    ),
                    Evento(
                        "09:30 - 10:15",
                        "Innovación, emprendimiento y gestión agroindustrial",
                        "Auditorio EPIE",
                        "Ing. Nadia Ethier Gamarra Abanto",
                        "Ingeniería Agroindustrial"
                    ),
                    Evento(
                        "10:15 - 11:00",
                        "Gestión de calidad en la producción de aceite de pescado para consumo humano",
                        "Auditorio EPIE",
                        "Ing. Carmen Pajuelo Carbajal",
                        "Ingeniería Agroindustrial"
                    ),

                    // Ingeniería Agronómica
                    Evento(
                        "15:00 - 15:45",
                        "Manejo agronómico del cultivo de palto var. Hass",
                        "Auditorio Ing. Agrónoma - Campus II",
                        "Ing. Paco Chicoma Rivera",
                        "Ingeniería Agronómica"
                    ),
                    Evento(
                        "15:45 - 16:30",
                        "Estrés fisiológicos en cultivos",
                        "Auditorio Ing. Agrónoma - Campus II",
                        "Ing. Daleida Longobardi Méndez",
                        "Ingeniería Agronómica"
                    ),
                    Evento(
                        "16:30 - 17:15",
                        "Agroexportación de frutales",
                        "Auditorio Ing. Agrónoma - Campus II",
                        "Ing. Jesús Jueve Chauca",
                        "Ingeniería Agronómica"
                    ),
                    Evento(
                        "17:15 - 18:00",
                        "Experiencias fitosanitarias en el cultivo de palto (Agro Chimú)",
                        "Auditorio Ing. Agrónoma - Campus II",
                        "Ms. Teófilo Arias Miranda",
                        "Ingeniería Agronómica"
                    ),
                    Evento(
                        "18:00 - 18:45",
                        "Nuevas alternativas de nutrición en el cultivo de palta (Yara Perú)",
                        "Auditorio Ing. Agrónoma - Campus II",
                        "Ing. Shiny Zapata Gutiérrez",
                        "Ingeniería Agronómica"
                    ),

                    // Ingeniería de Sistemas e Informática
                    Evento(
                        "15:00 - 15:45",
                        "Inteligencia artificial y su influencia en la programación",
                        "Auditorio EPIE",
                        "Dr. Carlos Eugenio Vega Moreno",
                        "Ingeniería de Sistemas e Informática"
                    ),
                    Evento(
                        "15:45 - 16:30",
                        "Estrategias competitivas en negocios empresariales",
                        "Auditorio EPIE",
                        "Dra. Lisbeth Briones Pereyra",
                        "Ingeniería de Sistemas e Informática"
                    ),
                    Evento(
                        "16:30 - 17:15",
                        "Del dato a la decisión: Fundamentos de Power BI",
                        "Auditorio EPIE",
                        "Ms. Johan López Heredia",
                        "Ingeniería de Sistemas e Informática"
                    ),
                    Evento(
                        "17:15 - 18:00",
                        "Stacking ensemble approach for diabetes diagnosis",
                        "Auditorio EPIE",
                        "Dr. Alfredo Daza Vergaray",
                        "Ingeniería de Sistemas e Informática"
                    ),
                    Evento(
                        "18:00 - 18:45",
                        "Modelo multiclasificador para predicción de carga térmica en edificios",
                        "Auditorio EPIE",
                        "Mg. Luis Ramírez Milla",
                        "Ingeniería de Sistemas e Informática"
                    )
                )
            ),
            AgendaItem(
                dia = "Miércoles 04-06-25",
                escuela = "",
                eventos = listOf(
                    // Ingeniería en Energía
                    Evento(
                        "09:00 - 10:00",
                        "Agrovoltaica: Alternativa sostenible para transición energética",
                        "Auditorio EPIE",
                        "Dr. Denis Aranguri Cayetano",
                        "Ingeniería en Energía"
                    ),
                    Evento(
                        "10:00 - 11:00",
                        "Técnicas nucleares para medición de gas Radón",
                        "Auditorio EPIE",
                        "MSc. Carlos Montañez Montenegro",
                        "Ingeniería en Energía"
                    ),
                    Evento(
                        "11:00 - 12:00",
                        "Energía eólica residencial: Comparativo regulatorio Europa-Perú",
                        "Auditorio EPIE",
                        "MSc. Ricardo Cedrón Maguña",
                        "Ingeniería en Energía"
                    ),

                    // Ingeniería Mecánica
                    Evento(
                        "15:00 - 15:45",
                        "Aplicación de TPM en equipos de harina de pescado",
                        "Auditorio EPIE",
                        "MSc. Arquimales Iparraguirre",
                        "Ingeniería Mecánica"
                    ),
                    Evento(
                        "15:45 - 16:30",
                        "Bloqueo y etiquetado de energía residual industrial",
                        "Auditorio EPIE",
                        "MSc. Luis Calderón Rodríguez",
                        "Ingeniería Mecánica"
                    ),
                    Evento(
                        "16:30 - 17:15",
                        "Sistemas automáticos de transferencia de energía (ATS)",
                        "Auditorio EPIE",
                        "Ms. Fredeshildo Ríos Noriega",
                        "Ingeniería Mecánica"
                    ),
                    Evento(
                        "17:15 - 18:00",
                        "Hidrocinética aplicada a la ingeniería",
                        "Auditorio EPIE",
                        "MSc. Neiver Escalante Espinoza",
                        "Ingeniería Mecánica"
                    ),
                    Evento(
                        "18:00 - 18:45",
                        "Fabricación de puentes metálicos con metodología BIM",
                        "Auditorio EPIE",
                        "Ing. Diego Blondet Beluando",
                        "Ingeniería Mecánica"
                    )
                )
            ),
            AgendaItem(
                dia = "Jueves 05-06-25",
                escuela = "General",
                eventos = listOf(
                    Evento(
                        hora = "09:00 a.m.",
                        titulo = "Misa de Celebración por la Semana de Ingeniería",
                        lugar = "Capilla de la UNS",
                        ponente = "Delegaciones de las E.P. de la Facultad, administrativos, docentes, centros de producción.",
                        escuela = null
                    ),
                    Evento(
                        hora = "10:00 a.m.",
                        titulo = "Ceremonia Central por la Celebración de la Semana de Ingeniería",
                        lugar = "Auditorio de Ingeniería en Energía",
                        ponente = "Himno Nacional\nPalabras de Bienvenida (Presidente de la Comisión Central)\nPalabras del Decano de la Facultad de Ingeniería\nReconocimiento a Estudiantes (Primeros Puestos de cada Escuela)\nReconocimiento a Docentes por Escuela\nPalabras de la Rectora de la UNS\nBrindis de Honor (Mejor Ingeniero Docente de la Facultad)",
                        escuela = null
                    ),
                    Evento(
                        hora = "15:00",
                        titulo = "Corso Interescuelas",
                        lugar = "Complejo Deportivo UNS",
                        ponente = "Inicio en Puerta 1 del Campus Universitario, final en Complejo Deportivo UNS.",
                        escuela = null
                    ),
                    Evento(
                        hora = "16:00",
                        titulo = "Partidos de Fútbol de Confraternidad",
                        lugar = "Complejo Deportivo UNS",
                        ponente = "Escuela Campeón 2024 vs Club UNS\nEgresados Ingenieros Master 1 vs Egresados Ingenieros Master 2",
                        escuela = null
                    )
                )
            ),
            AgendaItem(
                dia = "Viernes 06-06-25",
                escuela = "General",
                eventos = listOf(
                    Evento(
                        hora = "09:00 a.m.",
                        titulo = "Campeonato Interescuelas - Eliminatorias",
                        lugar = "Complejo Deportivo UNS",
                        ponente = "Fútbol:\nIng. Agronomía vs Ing. Sistemas\nIng. Pesquera vs Ing. Agroindustrial\nIng. Energía vs Ing. Civil\n\nBásquet (Mañana):\nIng. Energía vs Ing. Civil\nIng. Pesquera vs Ing. Agroindustrial\nIng. Agronomía vs Ing. Sistemas",
                        escuela = null
                    ),
                    Evento(
                        hora = "Tarde",
                        titulo = "Campeonato Interescuelas - Vóley",
                        lugar = "Complejo Deportivo UNS",
                        ponente = "Ing. Agronomía vs Ing. Sistemas\nIng. Pesquera vs Ing. Agroindustrial\nIng. Energía vs Ing. Civil",
                        escuela = null
                    ),
                    Evento(
                        hora = "13:00",
                        titulo = "Almuerzo de Confraternidad",
                        lugar = "Complejo Deportivo UNS",
                        ponente = null,
                        escuela = null
                    ),
                    Evento(
                        hora = "14:00",
                        titulo = "Campeonato Fútbol Interescuelas - Docentes",
                        lugar = "Complejo Deportivo UNS",
                        ponente = null,
                        escuela = null
                    ),
                    Evento(
                        hora = "15:00",
                        titulo = "Final del Campeonato Interescuelas - Estudiantes",
                        lugar = "Complejo Deportivo UNS",
                        ponente = "Disciplinas: Fútbol, Vóley y Básquet",
                        escuela = null
                    ),
                    Evento(
                        hora = "18:00",
                        titulo = "Premiación de Equipos Ganadores",
                        lugar = "Complejo Deportivo UNS",
                        ponente = null,
                        escuela = null
                    ),
                    Evento(
                        hora = "18:15",
                        titulo = "Clausura",
                        lugar = "Complejo Deportivo UNS",
                        ponente = null,
                        escuela = null
                    )
                )
            )
        )
    }
}
