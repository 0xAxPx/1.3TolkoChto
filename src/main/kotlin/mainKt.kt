import java.util.*

val LIST_2_3_4 = listOf<Int>(2,3,4)

fun main() {
    val scanner = Scanner(System.`in`)
    println("Введите количество секунд:")
    val userSeconds = scanner.nextInt()
    println("Пользователь был ${agoToText(userSeconds)}")
}

fun agoToText(userSeconds: Int): String {
    return when (userSeconds) {
        in 0..60 -> "только что"
        in 61..60 * 60 -> "${append2Minute(userSeconds)} назад"
        in 60 * 60 + 1..24 * 60 * 60 -> "${append2Hours(userSeconds)} назад"
        in 24 * 60 * 60 + 1..2 * (24 * 60 * 60) -> "сегодня"
        in 2 * (24 * 60 * 60)..3 * (24 * 60 * 60) -> "вчера"
        else -> "давно"
    }
}

fun append2Minute(seconds: Int): String {
    val minutes = seconds / 60 //получаем минуты
    println("$seconds это $minutes мин.")
    return when {
        minutes.toString().endsWith("1") && !minutes.toString().equals("11") -> "$minutes минуту"
        LIST_2_3_4.contains(minutes) -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun append2Hours(seconds: Int): String {
    val hours = seconds / 3600 //получаем часы
    println("$seconds это $hours ч.")
    return when {
        hours.toString().endsWith("1") && !hours.toString().equals("11") -> "$hours час"
        LIST_2_3_4.contains(hours) -> "$hours часа"
        else -> "$hours часов"
    }
}
