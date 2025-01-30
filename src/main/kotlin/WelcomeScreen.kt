import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator

class WelcomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Bienvenido") },
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = Color.White
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
            ) {
                // Sección del rol del usuario (arriba a la izquierda)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Rol: Gestor",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primary
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Sección de saludo
                Text(
                    text = "Hola, Usuario",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Sección de proyectos activos
                Text(
                    text = "Proyectos Activos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Button(
                    onClick = {
                        // Navegar a la pantalla de proyectos activos
                        // navigator?.push(ActiveProjectsScreen())
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = "Ver Proyectos Activos")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Sección de historial de proyectos terminados
                Text(
                    text = "Historial de Proyectos",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Button(
                    onClick = {
                        // Navegar a la pantalla de historial de proyectos
                        // navigator?.push(ProjectHistoryScreen())
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = "Ver Historial de Proyectos Terminados")
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Botón para desconectar
                Button(
                    onClick = {
                        // Navegar a la pantalla de login o cerrar sesión
                        // navigator?.push(LoginScreen())
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
                ) {
                    Text(text = "Desconectar", color = Color.White)
                }
            }
        }
    }
}
