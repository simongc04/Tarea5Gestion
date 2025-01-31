import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class ProyectosScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        var showOnlyMine by remember { mutableStateOf(false) }

        val proyectos = listOf(
            Proyecto("Proyecto 1", "Descripción del Proyecto 1", true),
            Proyecto("Proyecto 2", "Descripción del Proyecto 2", false),
            Proyecto("Proyecto 3", "Descripción del Proyecto 3", true),
            Proyecto("Proyecto 4", "Descripción del Proyecto 4", false)
        )

        val filteredProyectos = if (showOnlyMine) proyectos.filter { it.esMio } else proyectos

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Proyectos Activos", color = Color.White) },
                    navigationIcon = {
                        IconButton(onClick = { navigator?.pop() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
                        }
                    },
                    backgroundColor = Color(0xFF1976D2)
                )
            },
            backgroundColor = Color(0xFFE3F2FD)
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Filtro de proyectos
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Mostrar solo mis proyectos",
                        fontSize = 16.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Switch(
                        checked = showOnlyMine,
                        onCheckedChange = { showOnlyMine = it },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color(0xFF1976D2),
                            checkedTrackColor = Color(0xFF64B5F6)
                        )
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Lista de proyectos
                LazyColumn {
                    items(filteredProyectos) { proyecto ->
                        ProyectoItem(proyecto, onClick = {
                            // Navegar a la pantalla de detalles del proyecto
                        })
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ProyectoItem(proyecto: Proyecto, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = proyecto.nombre,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1976D2)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = proyecto.descripcion,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

data class Proyecto(
    val nombre: String,
    val descripcion: String,
    val esMio: Boolean
)

@Composable
fun ProyectosScreenPreview() {
    ProyectosScreen().Content()
}

