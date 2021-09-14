package ci.valde

import org.bson.types.ObjectId

data class Car(var id: ObjectId?, var model: String, var year: Int)