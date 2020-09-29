import Direction.*

// Battleship
// ==============
// Battleship Board:
//   - 10x10 alphanumeric matrix with letters denoting columns, numbers denoting rows
//   - Has many ships:
//     - `length`
//     - `position`
//     - `direction`
//     - `type`
//   - Ships can face in the 4 cardinal directions (N, S, E, W)
//   - 5 types of ships with different sizes:
//     - Carrier (5)
//     - Battleship (4)
//     - Submarine (3)
//     - Cruiser (2)
//     - Patrol (1)
//
//     A  B  C  D  E  F  G  H  I  J
//   1
//   2
//   3
//   4                                     N
//   5                                  W     E
//   6                                     S
//   7
//   8
//   9
//   10
//
// Requirements:
//  - Create a game with an array of ships
//  - Get status of game
//  - Return hit or miss for coordinates
//  - Return some indication of a ship being sunk
//  - Return some indication of the last ship being sunk


class Battleship(private val ships: Array<Ship>) {
    var hits = 0
    var shipHoles = 0

    // 10x10 array, initiated to false
    private val board: Array<Array<Cell>> = Array(10) {
        Array(10) { Cell(false, null) }
    }

    init {
        for (ship in ships) {
            val row = row(ship.position)
            val col = col(ship.position)
            shipHoles += ship.length
            when (ship.direction) {
                North -> {
                    for (i in 0 until ship.length) {
                        val cell = board[row - i][col]
                        cell.ship = ship
                        ship.cells.add(cell)
                    }
                }
                South -> {
                    for (i in 0 until ship.length) {
                        val cell = board[row + i][col]
                        cell.ship = ship
                        ship.cells.add(cell)
                    }
                }
                East -> {
                    for (i in 0 until ship.length) {
                        val cell = board[row][col + i]
                        cell.ship = ship
                        ship.cells.add(cell)
                    }
                }
                West -> {
                    for (i in 0 until ship.length) {
                        val cell = board[row][col - i]
                        cell.ship = ship
                        ship.cells.add(cell)
                    }
                }
            }
        }
        printStatus()
    }

    fun printStatus() {
        // shows your view of your board (not your view of opponents board):
        // empty space, ships, and hits only
        for (i in 0..9) {
            println(board[i].contentToString())
        }
        println("$hits hits")
    }

    fun fire(position: String): String {
        val cell = board[row(position)][col(position)]
        return if (cell.ship == null) {
            "miss"
        } else {
            hits++
            cell.hit = true
            val ship = cell.ship as Ship
            if (ship.isSunk()) {
                println("You sank my ${ship.type}")
                if (hits == shipHoles){
                    println("GAME OVER!")
                }
            }
            "hit"
        }
    }

    private fun col(position: String): Int {
        // A = 65
        return position[0].toInt() - 65
    }

    private fun row(position: String): Int {
        return position.substring(1).toInt() - 1
    }
}

class Ship(val type: ShipType, val position: String, val direction: Direction, val length: Int) {
    val cells = ArrayList<Cell>()

    fun isSunk(): Boolean {
        return cells.all { cell -> cell.hit }
    }
}

class Cell(var hit: Boolean, var ship: Ship?) {
    override fun toString(): String {
        return when {
            hit -> "H"
            ship != null -> "S"
            else -> "-"
        }
    }
}

enum class ShipType {
    Carrier, Battleship, Submarine, Cruiser, Patrol
}

enum class Direction {
    North, South, East, West
}

fun main() {
    val ships = arrayOf(
            Ship(ShipType.Carrier, "A6", South, 5),
            Ship(ShipType.Battleship, "D9", East, 4),
            Ship(ShipType.Submarine, "I7", South, 3)
    )
    val battleship = Battleship(ships)

    println(battleship.fire("A10"))
    println(battleship.fire("A9"))
    println(battleship.fire("A8"))
    println(battleship.fire("A7"))
    println(battleship.fire("A6"))

    println(battleship.fire("D9"))
    println(battleship.fire("E9"))
    println(battleship.fire("F9"))
    println(battleship.fire("G9"))

    println(battleship.fire("I7"))
    println(battleship.fire("I8"))
    println(battleship.fire("I9"))
    battleship.printStatus()
}