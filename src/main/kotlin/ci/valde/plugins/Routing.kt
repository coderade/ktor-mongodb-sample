package ci.valde.plugins

import ci.valde.handlers.MongoDataHandler
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {

    val mongoDataHandler = MongoDataHandler()
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/cars"){
            call.respond(mongoDataHandler.allCars())
        }
    }
}
