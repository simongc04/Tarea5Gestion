package model


// Clase de datos para la petición de login
data class LoginRequest(val usuario: String, val password: String)

// Clase de datos para la respuesta del servidor
data class User(val id: Int, val name: String, val token: String)
