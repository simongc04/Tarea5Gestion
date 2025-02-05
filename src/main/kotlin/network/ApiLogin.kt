package network
import kotlinx.coroutines.*
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.client.statement.*


suspend fun apiLogIn(usuario: String, password: String, onSuccessResponse: (User) -> Unit) {
    val url = "http://127.0.0.1:5000/gestor/login"
    CoroutineScope(Dispatchers.IO).launch {
        val response = httpClient.post(url){
            contentType(ContentType.Application.Json)
            setBody(LoginRequest(usuario, sha512(password)))
        }
        if (response.status == HttpStatusCode.OK){
            val user = response.body<user>()
            onSuccessResponse(user)
        } else {
            println("Error")
        }
    }
    }
