package network
import kotlinx.coroutines.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.client.statement.*
import model.LoginRequest
import model.User

suspend fun apiLogIn(usuario: String, password: String, onSuccessResponse: (User) -> Unit, onErrorResponse: (String) -> Unit) {
    val url = "http://127.0.0.1:5000/gestor/login"
    val networkUtils = NetworkUtils()

    CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = networkUtils.httpClient.post(url) {
                contentType(ContentType.Application.Json)
                setBody(LoginRequest(usuario, sha512(password)))
            }

            if (response.status == HttpStatusCode.OK) {
                val user = response.body<User>()
                onSuccessResponse(user)
            } else {
                val errorMessage = response.bodyAsText()
                onErrorResponse("Error: ${response.status}, $errorMessage")
            }
        } catch (e: Exception) {
            onErrorResponse("Error de red: ${e.localizedMessage}")
        }
    }
}
