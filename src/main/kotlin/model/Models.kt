package model

import kotlinx.serialization.Serializable


// Clase de datos para la petición de login
@Serializable
data class LoginRequest(
    val user: String,
    val passwd: String
)

// Clase de datos para la respuesta del servidor
@Serializable
data class User(
    val id_empleado: Int,
    val id_gestor: Int,
    val nombre: String,
    val email: String
)
