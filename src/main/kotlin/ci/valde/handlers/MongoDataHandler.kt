package ci.valde.handlers

import ci.valde.Car
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.codecs.configuration.CodecRegistries.fromProviders
import org.bson.codecs.configuration.CodecRegistries.fromRegistries
import org.bson.codecs.configuration.CodecRegistry
import org.bson.codecs.pojo.PojoCodecProvider

class MongoDataHandler {
    private val database: MongoDatabase
    private val carsCollection: MongoCollection<Car>

    init {
        val pojoCodecRegistry: CodecRegistry = fromProviders(
            PojoCodecProvider.builder()
                .automatic(true)
                .build()
        )

        val codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry)
        val settings: MongoClientSettings = MongoClientSettings.builder()
//            .applyConnectionString("localhost") => add the connection string if not using localhost
            .codecRegistry(codecRegistry)
            .build()

        val mongoClient = MongoClients.create(settings)
        database = mongoClient.getDatabase("dev")
        carsCollection = database.getCollection(Car::class.java.name, Car::class.java)

        initCars()
    }

    private fun initCars() {
        carsCollection.insertOne(Car(null, "BMW X5 M", 2010))
        carsCollection.insertOne(Car(null, "2009 Cadillac CTS-V", 2009))
        carsCollection.insertOne(Car(null, "Bugatti Veyron 16.4 Grand Sport Vitesse", 2012))
        carsCollection.insertOne(Car(null, "McLaren P1", 2003))
    }

    fun allCars(): List<Car> {
        val mongoResult = carsCollection.find()
        mongoResult.forEach {
            println("car: $it")
        }
        return mongoResult.toList()
    }
}