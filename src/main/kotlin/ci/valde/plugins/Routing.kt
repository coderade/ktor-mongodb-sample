package ci.valde.plugins

import ci.valde.Car
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
            call.respondText("Ktor with Mongo sample")
        }

        get("/cars"){
            call.respond(mongoDataHandler.allCars())
        }

        post("/fuel-up/{carId}"){
            val carId = call.parameters["carId"]!!
            log.info("car id $carId")
            mongoDataHandler.fuelUpCar(carId)
            call.respond(mongoDataHandler.allCars())
        }

        post("/replace"){
            val car = call.receive(Car::class)
            log.info("car $car")
            mongoDataHandler.replaceCar(car)
            call.respond(mongoDataHandler.findOneCar(car.getIdAsHex()!!)!!)
        }

        post("/cars/{carId}"){
            val carId = call.parameters["carId"]!!
            log.info("car $carId")
            val car = mongoDataHandler.findOneCar(carId)!!
            call.respond(car)
        }
    }
}
