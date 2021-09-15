package ci.valde

import org.bson.types.ObjectId

data class Car(var id: ObjectId?, var model: String, var year: Int, var fuel:  Float){
    constructor(): this(null, "not_set", 1970, 0f)

    fun getIdAsHex(): String? {
        return this.id!!.toHexString()
    }
}