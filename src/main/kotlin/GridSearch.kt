class GridSearch {
    companion object {
        // each cell is either land or water (false = water, true = land)
        // count islands, only consider edges that touch, not corners
        // Smartsheet coding test
        fun countIslands(grid: Array<BooleanArray>): Int {
            val rows = grid.size
            val cols = grid[0].size
            val visited = Array(rows) { BooleanArray(cols) }

            var numIslands = 0

            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (isLand(grid, i, j) && !visited[i][j]) {
                        dfs(grid, i, j, visited)
                        ++numIslands
                    }
                }
            }
            return numIslands
        }

        // Depth First Search
        private fun dfs(grid: Array<BooleanArray>, row: Int, col: Int, visited: Array<BooleanArray>) {
            if (existsAndUnvisited(grid, row, col, visited) && isWater(grid, row, col)) {
                // is water, or visited, or non-existent
                return
            }

            // each cell can have 4 neighboring cells. Add these values to row and col to get neighboring cell coordinates
            val rowNbr: IntArray = intArrayOf(-1, 0, 0, 1)
            val colNbr: IntArray = intArrayOf(0, -1, 1, 0)

            visited[row][col] = true

            for (k in rowNbr.indices) {
                if (existsAndUnvisited(grid, row + rowNbr[k], col + colNbr[k], visited)) {
                    dfs(grid, row + rowNbr[k], col + colNbr[k], visited)
                }
            }
        }

        // returns false if non-existent cell or visited, else true
        private fun existsAndUnvisited(
            grid: Array<BooleanArray>,
            row: Int,
            col: Int,
            visited: Array<BooleanArray>
        ): Boolean {
            return exists(grid, row, col) && !visited[row][col]
        }

        private fun isWater(grid: Array<BooleanArray>, row: Int, col: Int) = !grid[row][col]

        private fun isLand(grid: Array<BooleanArray>, row: Int, col: Int) = grid[row][col]

        private fun exists(grid: Array<BooleanArray>, row: Int, col: Int): Boolean {
            return row >= 0 && col >= 0 && row < grid.size && col < grid[0].size
        }
    }
}

/* original solution
//  var grid = Array<IntArray>()
// zero = water, one = land
// TODO change int to boolean everywhere
fun countIslands(grid: Array<IntArray>()) {
  // grid nxm
  // each cell land or water
  // count of groups of land
  // only consider edges that touch

  var i = 0
  var j = 0
  var cells : Array<Array<Cell>>
  // populate 2D cells array
  while(true){
    // neighbors are i+1, j; i-1, j; i, j-1; i,j+1.  ignore if i or j < 0 or > array bounds
    if(grid[i][j] == 0){
      // skip
    } else {
      // water
      val cell = Cell(i, j)
      // delegate to safeGridValue for each call
      cell.up = (grid[i][j-1] == 1)
      cell.down = (grid[i][j+1] == 1)
      cell.left = (grid[i-1][j] == 1)
      cell.right = (grid[i+1][j] == 1)

      // recurstion:  check if cell object exists, if so for each land cell next to it check all its cells. Recursion ends when cell surrounded by water.
    }
  }

  // sum cells 2D array
  // iterate over true up/down/left/right cells, mark visited
  var numLandMasses = 0
  // increment numLandMasses when moving new position in array and finding unvisited cell
}

LLW
WWW
WWL

fun safeGridValue(grid: Array<IntArray>, i : Int, j: Int) : Boolean{
  // false if non-existant cell  (i < 0 or i> length of array grid.length; for j grid[i].length
  // true if exists and is 1
}

class Cell(val i: Int, val j: Int){
  // does cell in that direction have land
  var up = false
  var down = false
  var left = false
  var right = false
  var visited = false
}
 */