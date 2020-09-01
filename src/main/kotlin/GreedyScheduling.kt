class GreedyScheduling {
    companion object {
        // Greedy scheduling algorithm applied to problem that has list of arrival times
        // and corresponding durations
        // Assume arrival size == duration size
        // Assume duration size is sorted for a given arrival time.
        // Problem:  maximize number of events. Does not matter when last event ends.
        // Smartsheet coding test
        fun maxEvents(arrival: Array<Int>, duration: Array<Int>): Int {
            var numEvents = 0
            var lastEndTime: Int? = null
            for (i in arrival.indices) {
                if (lastEndTime != null && lastEndTime > arrival[i]) {
                    continue
                }

                if (noConflictWithNextEvent(arrival, duration, i)) {
                    lastEndTime = arrival[i] + duration[i]
                    numEvents++
                }
            }
            return numEvents
        }

        private fun noConflictWithNextEvent(arrival: Array<Int>, duration: Array<Int>, i: Int): Boolean {
            if (i == arrival.lastIndex) return true
            return (arrival[i] + duration[i]) <= arrival[i + 1]
        }
    }
}
