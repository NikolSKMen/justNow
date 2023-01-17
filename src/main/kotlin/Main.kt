fun main() {
    var lastOnLine = 17900;// vremya onlayn sec
    var howMatchTyme = when (lastOnLine) {
        in 0..60 -> "был(а) только что "
        in 61..60 * 60 -> {
            var time = lastOnLine / 60
            var ending = "минут назад"
            if (time % 10 == 1 || time % 100 == 11) {
                ending = "минуту назад"
            } else if (time % 10 >= 2 && time % 10 <= 4) {
                ending = "минуты назад"
            }

            println("был(а) в сети $time $ending")
        }

        in 60 * 60 + 1..24 * 60 * 60 -> {
            var hour = lastOnLine / 3600
            var endingDay = when (hour) {
                1, 21 -> "час назад"
                2, 3, 4, 22, 23, 24 -> "часа назад"
                else -> "часов назад"
            }
            println("был(а) в сети $hour $endingDay")
        }

        in 24 * 60 * 60..24 * 60 * 60 * 2 -> "был(а) в сети вчера "
        in 24 * 60 * 60 * 60 * 2..24 * 60 * 60 * 3 -> "был(а) в сети позавчера "
        else -> "был(а) в сети давно "
    }

    println(howMatchTyme)

}
