class Greeter() {
    companion object {
        fun sayHello(name: String): String {
            return if (name.isEmpty()) {
                "Hello there!"
            } else {
                "Hello, $name!"
            }
        }
    }
}