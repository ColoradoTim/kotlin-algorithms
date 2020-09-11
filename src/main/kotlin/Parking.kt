import kotlin.random.Random

// Mint.com interview
// Design a system that manages a rectangular parking lot.
// Requirements:
// •  The parking lot is rectangular and has a series of rows of spaces with each row having the same number of parking
//    spaces.  The lot has M rows with N cars per row for M*N spaces total.
// •  When a car/user comes to the entrance of the parking lot we want to indicate whether or not the parking lot is full.
// •  If it is not full we want to assign a spot to the user and give them a ticket.
// •  When the user leaves the parking lot they give back the ticket which marks the space they were using as free.

class Parking(rows: Int, cols: Int) {
    // to optimize performance, store parking spaces in Map with space id as the key for faster lookups.
    // if we want to send vehicles to the closest spot, can insert parking spaces into list
    // based on ascending distance from entrance.
    private var parkingSpaces = ArrayList<ParkingSpace>()

    init {
        for (i in 0..(rows * cols)) {
            // 2% of spaces for RV, 10% for motorcycles, rest are car
            val vehicleType = getRandVehicleType()
            parkingSpaces.add(ParkingSpace(i, vehicleType))
        }
    }

    // returns id of the parking space, or -1 if none available
    fun parkVehicle(vehicleType: VehicleType): Int {
        print("parking a $vehicleType ")
        val emptySpace = parkingSpaces.firstOrNull { space -> !space.occupied && space.vehicleType == vehicleType }
        if (emptySpace == null) {
            throw IllegalStateException("no $vehicleType spaces")
        }

        emptySpace.occupied = true
        println("in space ${emptySpace.id}")
        return emptySpace.id
    }

    fun removeVehicle(spaceId: Int) {
        println("removing car in space $spaceId")
        // first() throws exception if not found
        val parkingSpace = parkingSpaces.first { space -> space.id == spaceId }
        parkingSpace.occupied = false
    }
}

// randomly park and remove cars until we run out of space
fun main() {
    val parking = Parking(5, 6)
    val parkedCars = ArrayList<Int>(50)
    while (true) {
        if (Random.nextBoolean()) {
            val spaceId = parking.parkVehicle(getRandVehicleType())
            parkedCars += spaceId
        } else {
            if (parkedCars.isNotEmpty()) {
                val spaceId = parkedCars.removeAt(0)
                parking.removeVehicle(spaceId)
            }
        }
    }
}

enum class VehicleType {
    Motorcycle, RV, Car
}

private class ParkingSpace(val id: Int, type: VehicleType) {
    // could store GPS coords of center of space, to pre-calculate distance from entrance, and could then store distance too.
    var occupied = false
    val vehicleType = type
}

fun getRandVehicleType(): VehicleType {
    return when (Random.nextInt(0, 100)) {
        in 0..1 -> VehicleType.RV
        in 2..11 -> VehicleType.Motorcycle
        else -> VehicleType.Car
    }
}

