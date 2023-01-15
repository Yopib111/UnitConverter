package converter

import java.lang.Exception

fun main() {
    do {
        print("Enter what you want to convert (or exit): ")
        val inputString = readln().split(' ')
        var number: Double = 0.0
        var measureInput = ""
        var targetInput = ""
        val distanceUnits = listOf<String>(
            "m", "meter", "meters",
            "km", "kilometer", "kilometers",
            "cm", "centimeter", "centimeters",
            "mm", "millimeter", "millimeters",
            "mi", "mile", "miles",
            "yd", "yard", "yards",
            "ft", "foot", "feet",
            "in", "inch", "inches"
        )
        val weightUnits = listOf<String>(
            "g", "gram", "grams",
            "kg", "kilogram", "kilograms",
            "mg", "milligram", "milligrams",
            "lb", "pound", "pounds",
            "oz", "ounce", "ounces"
        )
        val temperatureUnits = listOf<String>(
            "degree celsius", "degrees celsius", "celsius", "dc", "c",
            "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f",
            "kelvin", "kelvins", "k")


        if (inputString[0] != "exit") {
            try {
                inputString[0].toDouble()
            } catch (e: Exception) {
                println("Parse error")
                println()
                continue
            }
        }

        if (inputString.size > 1) {
            number = inputString[0].toDouble()
            if (inputString[1].lowercase() == "degree" || inputString[1].lowercase() == "degrees") measureInput = inputString[2].lowercase() else measureInput = inputString[1].lowercase()
            targetInput = inputString.last().lowercase()
        }

        if (number < 0 && (measureInput in weightUnits || targetInput in weightUnits)) {
            println("Weight shouldn't be negative")
            println()
            continue
        }
        if (number < 0 && (measureInput in distanceUnits || targetInput in distanceUnits)) {
            println("Length shouldn't be negative")
            println()
            continue
        }

        if (inputString.size > 1 && (
                    measureInput in distanceUnits && targetInput in weightUnits ||
                            measureInput in distanceUnits && targetInput in temperatureUnits ||
                            measureInput in weightUnits && targetInput in temperatureUnits ||
                            measureInput in weightUnits && targetInput in distanceUnits ||
                            measureInput in temperatureUnits && targetInput in weightUnits ||
                            measureInput in temperatureUnits && targetInput in distanceUnits
                    )
        ) {
            println("Conversion from ${writeCorrectEnds(measureInput)} to ${writeCorrectEnds(targetInput)} is impossible")
    } else if (inputString.size > 1 &&
            (measureInput !in distanceUnits && targetInput !in distanceUnits) &&
            (measureInput !in weightUnits && targetInput !in weightUnits) &&
            (measureInput !in temperatureUnits && targetInput !in temperatureUnits))
        {
        println("Conversion from ??? to ??? is impossible")
        } else if (inputString.size > 1 && (measureInput !in distanceUnits && measureInput !in weightUnits && measureInput !in temperatureUnits)) {
            println("Conversion from ??? to ${writeCorrectEnds(targetInput)} is impossible")
        } else if (inputString.size > 1 && (targetInput !in distanceUnits && targetInput !in weightUnits && targetInput !in temperatureUnits)) {
            println("Conversion from ${writeCorrectEnds(measureInput)} to ??? is impossible")
        } else {

            when (measureInput) {
                "m", "meter", "meters" -> {
                    when (targetInput) {
                        "m", "meter", "meters" -> println(convertMetersToMeters(number))
                        "km", "kilometer", "kilometers" -> println(convertMetersToKilometers(number))
                        "cm", "centimeter", "centimeters" -> println(convertMetersToCentimeters(number))
                        "mm", "millimeter", "millimeters" -> println(convertMetersToMillimeters(number))
                        "mi", "mile", "miles" -> println(convertMetersToMiles(number))
                        "yd", "yard", "yards" -> println(convertMetersToYards(number))
                        "ft", "foot", "feet" -> println(convertMetersToFoot(number))
                        "in", "inch", "inches" -> println(convertMetersToInch(number))
                    }
                }
                "km", "kilometer", "kilometers" -> {
                    when (targetInput) {
                        "m", "meter", "meters" -> println(convertKmToMeters(number))
                        "km", "kilometer", "kilometers" -> println(convertKilometersToKilometers(number))
                        "cm", "centimeter", "centimeters" -> println(convertKilometersToCentimeters(number))
                        "mm", "millimeter", "millimeters" -> println(convertKilometersToMillimeters(number))
                        "mi", "mile", "miles" -> println(convertKilometersToMiles(number))
                        "yd", "yard", "yards" -> println(convertKilometersToYards(number))
                        "ft", "foot", "feet" -> println(convertKilometersToFoot(number))
                        "in", "inch", "inches" -> println(convertKilometersToInch(number))
                    }
                }
                "cm", "centimeter", "centimeters" -> {
                    when (targetInput) {
                        "m", "meter", "meters" -> println(convertCentiToMeters(number))
                        "km", "kilometer", "kilometers" -> println(convertCentimeterToKilometers(number))
                        "cm", "centimeter", "centimeters" -> println(convertCentimeterToCentimeters(number))
                        "mm", "millimeter", "millimeters" -> println(convertCentimeterToMillimeters(number))
                        "mi", "mile", "miles" -> println(convertCentimeterToMiles(number))
                        "yd", "yard", "yards" -> println(convertCentimeterToYards(number))
                        "ft", "foot", "feet" -> println(convertCentimeterToFoot(number))
                        "in", "inch", "inches" -> println(convertCentimeterToInch(number))
                    }
                }
                "mm", "millimeter", "millimeters" -> {
                    when (targetInput) {
                        "m", "meter", "meters" -> println(convertMillimetersToMeters(number))
                        "km", "kilometer", "kilometers" -> println(convertMillimeterToKilometers(number))
                        "cm", "centimeter", "centimeters" -> println(convertMillimeterToCentimeters(number))
                        "mm", "millimeter", "millimeters" -> println(convertMillimeterToMillimeters(number))
                        "mi", "mile", "miles" -> println(convertMillimeterToMiles(number))
                        "yd", "yard", "yards" -> println(convertMillimeterToYards(number))
                        "ft", "foot", "feet" -> println(convertMillimeterToFoot(number))
                        "in", "inch", "inches" -> println(convertMillimeterToInch(number))
                    }
                }
                "mi", "mile", "miles" -> {
                    when (targetInput) {
                        "m", "meter", "meters" -> println(convertMilesToMeters(number))
                        "km", "kilometer", "kilometers" -> println(convertMilesToKilometers(number))
                        "cm", "centimeter", "centimeters" -> println(convertMilesToCentimeters(number))
                        "mm", "millimeter", "millimeters" -> println(convertMilesToMillimeters(number))
                        "mi", "mile", "miles" -> println(convertMilesToMiles(number))
                        "yd", "yard", "yards" -> println(convertMilesToYards(number))
                        "ft", "foot", "feet" -> println(convertMilesToFoot(number))
                        "in", "inch", "inches" -> println(convertMilesToInch(number))
                    }
                }
                "yd", "yard", "yards" -> {
                    when (targetInput) {
                        "m", "meter", "meters" -> println(convertYardsToMeters(number))
                        "km", "kilometer", "kilometers" -> println(convertYardsToKilometers(number))
                        "cm", "centimeter", "centimeters" -> println(convertYardsToCentimeters(number))
                        "mm", "millimeter", "millimeters" -> println(convertYardsToMillimeters(number))
                        "mi", "mile", "miles" -> println(convertYardsToMiles(number))
                        "yd", "yard", "yards" -> println(convertYardsToYards(number))
                        "ft", "foot", "feet" -> println(convertYardsToFoot(number))
                        "in", "inch", "inches" -> println(convertYardsToInch(number))
                    }
                }
                "ft", "foot", "feet" -> {
                    when (targetInput) {
                        "m", "meter", "meters" -> println(convertFootToMeters(number))
                        "km", "kilometer", "kilometers" -> println(convertFootToKilometers(number))
                        "cm", "centimeter", "centimeters" -> println(convertFootToCentimeters(number))
                        "mm", "millimeter", "millimeters" -> println(convertFootToMillimeters(number))
                        "mi", "mile", "miles" -> println(convertFootToMiles(number))
                        "yd", "yard", "yards" -> println(convertFootToYards(number))
                        "ft", "foot", "feet" -> println(convertFootToFoot(number))
                        "in", "inch", "inches" -> println(convertFootToInch(number))
                    }
                }
                "in", "inch", "inches" -> {
                    when (targetInput) {
                        "m", "meter", "meters" -> println(convertInchesToMeters(number))
                        "km", "kilometer", "kilometers" -> println(convertInchToKilometers(number))
                        "cm", "centimeter", "centimeters" -> println(convertInchToCentimeters(number))
                        "mm", "millimeter", "millimeters" -> println(convertInchToMillimeters(number))
                        "mi", "mile", "miles" -> println(convertInchToMiles(number))
                        "yd", "yard", "yards" -> println(convertInchToYards(number))
                        "ft", "foot", "feet" -> println(convertInchToFoot(number))
                        "in", "inch", "inches" -> println(convertInchToInch(number))

                    }
                }

//        далее идут меры веса --------------------------------------------------------
                "g", "gram", "grams" -> {
                    when (targetInput) {
                        "g", "gram", "grams" -> println(convertGramsToGrams(number))
                        "kg", "kilogram", "kilograms" -> println(convertGramsToKilograms(number))
                        "mg", "milligram", "milligrams" -> println(convertGramsToMilligram(number))
                        "lb", "pound", "pounds" -> println(convertGramsToPounds(number))
                        "oz", "ounce", "ounces" -> println(convertGramsToOunces(number))
                    }
                }
                "kg", "kilogram", "kilograms" -> {
                    when (targetInput) {
                        "g", "gram", "grams" -> println(convertKilogramsToGrams(number))
                        "kg", "kilogram", "kilograms" -> println(convertKilogramsToKilograms(number))
                        "mg", "milligram", "milligrams" -> println(convertKilogramsToMilligram(number))
                        "lb", "pound", "pounds" -> println(convertKilogramsToPounds(number))
                        "oz", "ounce", "ounces" -> println(convertKilogramsToOunces(number))
                    }
                }
                "mg", "milligram", "milligrams" -> {
                    when (targetInput) {
                        "g", "gram", "grams" -> println(convertMilligramsToGrams(number))
                        "kg", "kilogram", "kilograms" -> println(convertMilligramsToKilograms(number))
                        "mg", "milligram", "milligrams" -> println(convertMilligramsToMilligram(number))
                        "lb", "pound", "pounds" -> println(convertMilligramsToPounds(number))
                        "oz", "ounce", "ounces" -> println(convertMilligramsToOunces(number))
                    }
                }
                "lb", "pound", "pounds" -> {
                    when (targetInput) {
                        "g", "gram", "grams" -> println(convertPoundsToGrams(number))
                        "kg", "kilogram", "kilograms" -> println(convertPoundsToKilograms(number))
                        "mg", "milligram", "milligrams" -> println(convertPoundsToMilligram(number))
                        "lb", "pound", "pounds" -> println(convertPoundsToPounds(number))
                        "oz", "ounce", "ounces" -> println(convertPoundsToOunces(number))
                    }
                }
                "oz", "ounce", "ounces" -> {
                    when (targetInput) {
                        "g", "gram", "grams" -> println(convertOuncesToGrams(number))
                        "kg", "kilogram", "kilograms" -> println(convertOuncesToKilograms(number))
                        "mg", "milligram", "milligrams" -> println(convertOuncesToMilligram(number))
                        "lb", "pound", "pounds" -> println(convertOuncesToPounds(number))
                        "oz", "ounce", "ounces" -> println(convertOuncesToOunces(number))
                    }
                }

//          далее идут температуры
                "degree celsius", "degrees celsius", "celsius", "dc", "c" -> {
                    when(targetInput) {
                        "degree celsius", "degrees celsius", "celsius", "dc", "c" -> println(convertCelsiusToCelsius(number))
                        "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f" -> println(convertCelsiusToFahrenheit(number))
                        "kelvin", "kelvins", "k" -> println(convertCelsiusToKelvins(number))
                    }
                }
                "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f" -> {
                    when(targetInput) {
                        "degree celsius", "degrees celsius", "celsius", "dc", "c" -> println(convertFahrenheitToCelsius(number))
                        "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f" -> println(
                            convertFahrenheitToFahrenheit(number)
                        )
                        "kelvin", "kelvins", "k" -> println(convertFahrenheitToKelvins(number))
                    }
                }
                "kelvin", "kelvins", "k" -> {
                    when(targetInput) {
                        "degree celsius", "degrees celsius", "celsius", "dc", "c" -> println(convertKelvinsToCelsius(number))
                        "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f" -> println(
                            convertKelvinsToFahrenheit(number)
                        )
                        "kelvin", "kelvins", "k" -> println(convertKelvinsToKelvins(number))

                    }
                }
            }
        }
        println()
    } while (inputString[0] != "exit")
}

fun convertKmToMeters (number: Double): String {
    val result = number * 1000
    when {
        (number == 1.0) -> {
            return "$number kilometer is 1000 meters"
        }
        (result == 1.0) -> {
            return "$number kilometers is $result meter"
        }
        else -> {
            return "$number kilometers is $result meters"
        }
    }
}
fun convertMetersToMeters (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 meter is 1.0 meter"
        }
        else -> {
            "$number meters is $number meters"
        }
    }
}
fun convertCentiToMeters (number: Double): String {
    val result = number * 0.01
    return when {
        (number == 1.0) -> {
            "$number centimeter is $result meters"
        }
        (result == 1.0) -> {
            "$number centimeters is $result meter"
        }
        else -> {
            "$number centimeters is $result meters"
        }
    }

}
fun convertMillimetersToMeters (number: Double): String {
    val result = number * 0.001
    return when {
        (number == 1.0) -> {
            "$number millimeter is $result meters"
        }
        (result == 1.0) -> {
            "$number millimeters is $result meter"
        }
        else -> {
            "$number millimeters is $result meters"
        }
    }
}
fun convertMilesToMeters (number: Double): String {
    val result = number * 1609.35
    return when {
        (number == 1.0) -> {
            "$number mile is $result meters"
        }
        (result == 1.0) -> {
            "$number miles is $result meter"
        }
        else -> {
            "$number miles is $result meters"
        }
    }
}
fun convertYardsToMeters (number: Double): String {
    val result = number * 0.9144
    return when {
        (number == 1.0) -> {
            "$number yard is $result meters"
        }
        (result == 1.0) -> {
            "$number yards is $result meter"
        }
        else -> {
            "$number yards is $result meters"
        }
    }
}
fun convertFootToMeters (number: Double): String {
    val result = number * 0.3048
    return when {
        (number == 1.0) -> {
            "$number foot is $result meters"
        }
        (result == 1.0) -> {
            "$number feet is $result meter"
        }
        else -> {
            "$number feet is $result meters"
        }
    }
}
fun convertInchesToMeters (number: Double): String {
    val result = number * 0.0254
    return when {
        (number == 1.0) -> {
            "$number inch is $result meters"
        }
        (result == 1.0) -> {
            "$number inches is $result meter"
        }
        else -> {
            "$number inches is $result meters"
        }
    }
}

fun convertMetersToKilometers (number: Double): String {
    val result = number / 1000
    return when {
        (number == 1.0) -> {
            "$number meter is $result kilometers"
        }
        (result == 1.0) -> {
            "$number meters is $result kilometer"
        }
        else -> {
            "$number meters is $result kilometers"
        }
    }
}
fun convertKilometersToKilometers (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 kilometer is 1.0 kilometer"
        }
        else -> {
            "$number kilometers is $number kilometers"
        }
    }
}
fun convertCentimeterToKilometers (number: Double): String {
    val result = number / 100000
    return when {
        (number == 1.0) -> {
            "$number centimeter is $result kilometers"
        }
        (result == 1.0) -> {
            "$number centimeters is $result kilometer"
        }
        else -> {
            "$number centimeters is $result kilometers"
        }
    }
}
fun convertMillimeterToKilometers (number: Double): String {
    val result = number / 100000000
    return when {
        (number == 1.0) -> {
            "$number millimeter is $result kilometers"
        }
        (result == 1.0) -> {
            "$number millimeters is $result kilometer"
        }
        else -> {
            "$number millimeters is $result kilometers"
        }
    }
}
fun convertMilesToKilometers (number: Double): String {
    val result = number * 1.60935
    return when {
        (number == 1.0) -> {
            "$number mile is $result kilometers"
        }
        (result == 1.0) -> {
            "$number miles is $result kilometer"
        }
        else -> {
            "$number miles is $result kilometers"
        }
    }
}
fun convertYardsToKilometers (number: Double): String {
    val result = number * 0.0009144
    return when {
        (number == 1.0) -> {
            "$number yard is $result kilometers"
        }
        (result == 1.0) -> {
            "$number yards is $result kilometer"
        }
        else -> {
            "$number yards is $result kilometers"
        }
    }
}
fun convertFootToKilometers (number: Double): String {
    val result = number * 0.0003048
    return when {
        (number == 1.0) -> {
            "$number foot is $result kilometers"
        }
        (result == 1.0) -> {
            "$number feet is $result kilometer"
        }
        else -> {
            "$number feet is $result kilometers"
        }
    }
}
fun convertInchToKilometers (number: Double): String {
    val result = number * 0.0000254
    return when {
        (number == 1.0) -> {
            "$number inch is $result kilometers"
        }
        (result == 1.0) -> {
            "$number inches is $result kilometer"
        }
        else -> {
            "$number inches is $result kilometers"
        }
    }
}

fun convertMetersToCentimeters (number: Double): String {
    val result = number * 100
    return when {
        (number == 1.0) -> {
            "$number meter is $result centimeters"
        }
        (result == 1.0) -> {
            "$number meters is $result centimeter"
        }
        else -> {
            "$number meters is $result centimeters"
        }
    }
}
fun convertKilometersToCentimeters (number: Double): String {
    val result = number * 10000
    return when {
        (number == 1.0) -> {
            "$number kilometer is $result centimeters"
        }
        (result == 1.0) -> {
            "$number kilometers is $result centimeter"
        }
        else -> {
            "$number kilometers is $result centimeters"
        }
    }
}
fun convertCentimeterToCentimeters (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 centimeter is 1.0 centimeter"
        }
        else -> {
            "$number centimeters is $number centimeters"
        }
    }
}
fun convertMillimeterToCentimeters (number: Double): String {
    val result = number * 0.1
    return when {
        (number == 1.0) -> {
            "$number millimeter is $result centimeters"
        }
        (result == 1.0) -> {
            "$number millimeters is $result centimeter"
        }
        else -> {
            "$number millimeters is $result centimeters"
        }
    }
}
fun convertMilesToCentimeters (number: Double): String {
    val result = number * 160935
    return when {
        (number == 1.0) -> {
            "$number mile is $result centimeters"
        }
        (result == 1.0) -> {
            "$number miles is $result centimeter"
        }
        else -> {
            "$number miles is $result centimeters"
        }
    }
}
fun convertYardsToCentimeters (number: Double): String {
    val result = number * 91.44
    return when {
        (number == 1.0) -> {
            "$number yard is $result centimeters"
        }
        (result == 1.0) -> {
            "$number yards is $result centimeter"
        }
        else -> {
            "$number yards is $result centimeters"
        }
    }
}
fun convertFootToCentimeters (number: Double): String {
    val result = number * 30.48
    return when {
        (number == 1.0) -> {
            "$number foot is $result centimeters"
        }
        (result == 1.0) -> {
            "$number feet is $result centimeter"
        }
        else -> {
            "$number feet is $result centimeters"
        }
    }
}
fun convertInchToCentimeters (number: Double): String {
    val result = number * 2.54
    return when {
        (number == 1.0) -> {
            "$number inch is $result centimeters"
        }
        (result == 1.0) -> {
            "$number inches is $result centimeter"
        }
        else -> {
            "$number inches is $result centimeters"
        }
    }
}

fun convertMetersToMillimeters (number: Double): String {
    val result = number * 1000
    return when {
        (number == 1.0) -> {
            "$number meter is $result millimeters"
        }
        (result == 1.0) -> {
            "$number meters is $result millimeter"
        }
        else -> {
            "$number meters is $result millimeters"
        }
    }
}
fun convertKilometersToMillimeters (number: Double): String {
    val result = number * 1000000
    return when {
        (number == 1.0) -> {
            "$number kilometer is $result centimeters"
        }
        (result == 1.0) -> {
            "$number kilometers is $result centimeter"
        }
        else -> {
            "$number kilometers is $result centimeters"
        }
    }
}
fun convertCentimeterToMillimeters (number: Double): String {
    val result = number * 10
    return when {
        (number == 1.0) -> {
            "$number centimeter is $result millimeters"
        }

        (result == 1.0) -> {
            "$number centimeters is $result millimeter"
        }

        else -> {
            "$number centimeters is $result millimeters"
        }
    }
}
fun convertMillimeterToMillimeters (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 millimeter is 1.0 millimeter"
        }
        else -> {
            "$number millimeters is $number millimeters"
        }
    }
}
fun convertMilesToMillimeters (number: Double): String {
    val result = number * 1609350
    return when {
        (number == 1.0) -> {
            "$number mile is $result millimeters"
        }
        (result == 1.0) -> {
            "$number miles is $result millimeter"
        }
        else -> {
            "$number miles is $result millimeters"
        }
    }
}
fun convertYardsToMillimeters (number: Double): String {
    val result = number * 914.4
    return when {
        (number == 1.0) -> {
            "$number yard is $result millimeters"
        }
        (result == 1.0) -> {
            "$number yards is $result millimeter"
        }
        else -> {
            "$number yards is $result millimeters"
        }
    }
}
fun convertFootToMillimeters (number: Double): String {
    val result = number * 304.8
    return when {
        (number == 1.0) -> {
            "$number foot is $result millimeters"
        }
        (result == 1.0) -> {
            "$number feet is $result millimeter"
        }
        else -> {
            "$number feet is $result millimeters"
        }
    }
}
fun convertInchToMillimeters (number: Double): String {
    val result = number * 25.4
    return when {
        (number == 1.0) -> {
            "$number inch is $result millimeters"
        }
        (result == 1.0) -> {
            "$number inches is $result millimeter"
        }
        else -> {
            "$number inches is $result millimeters"
        }
    }
}

fun convertMetersToMiles (number: Double): String {
    val result = number / 1609.35
    return when {
        (number == 1.0) -> {
            "$number meter is $result miles"
        }
        (result == 1.0) -> {
            "$number meters is $result mile"
        }
        else -> {
            "$number meters is $result miles"
        }
    }
}
fun convertKilometersToMiles (number: Double): String {
    val result = number / 1.60935
    return when {
        (number == 1.0) -> {
            "$number kilometer is $result miles"
        }
        (result == 1.0) -> {
            "$number kilometers is $result mile"
        }
        else -> {
            "$number kilometers is $result miles"
        }
    }
}
fun convertCentimeterToMiles (number: Double): String {
    val result = number / 160935
    return when {
        (number == 1.0) -> {
            "$number centimeter is $result miles"
        }
        (result == 1.0) -> {
            "$number centimeters is $result mile"
        }
        else -> {
            "$number centimeters is $result miles"
        }
    }
}
fun convertMillimeterToMiles (number: Double): String {
    val result = number / 1609350
    return when {
        (number == 1.0) -> {
            "$number millimeter is $result miles"
        }
        (result == 1.0) -> {
            "$number millimeters is $result mile"
        }
        else -> {
            "$number millimeters is $result miles"
        }
    }
}
fun convertMilesToMiles (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 mile is 1.0 mille"
        }
        else -> {
            "$number miles is $number miles"
        }
    }
}
fun convertYardsToMiles (number: Double): String {
    val result = number * 0.00057
    return when {
        (number == 1.0) -> {
            "$number yard is $result miles"
        }
        (result == 1.0) -> {
            "$number yards is $result mile"
        }
        else -> {
            "$number yards is $result miles"
        }
    }
}
fun convertFootToMiles (number: Double): String {
    val result = number / 0.000189
    return when {
        (number == 1.0) -> {
            "$number foot is $result miles"
        }
        (result == 1.0) -> {
            "$number feet is $result mile"
        }
        else -> {
            "$number feet is $result miles"
        }
    }
}
fun convertInchToMiles (number: Double): String {
    val result = number * 0.000016
    return when {
        (number == 1.0) -> {
            "$number inch is $result miles"
        }
        (result == 1.0) -> {
            "$number inches is $result mile"
        }
        else -> {
            "$number inches is $result miles"
        }
    }
}

fun convertMetersToYards (number: Double): String {
    val result = number / 0.9144
    return when {
        (number == 1.0) -> {
            "$number meter is $result yards"
        }
        (result == 1.0) -> {
            "$number meters is $result yard"
        }
        else -> {
            "$number meters is $result yards"
        }
    }
}
fun convertKilometersToYards (number: Double): String {
    val result = number / 0.0009144
    return when {
        (number == 1.0) -> {
            "$number kilometer is $result yards"
        }
        (result == 1.0) -> {
            "$number kilometers is $result yard"
        }
        else -> {
            "$number kilometers is $result yards"
        }
    }
}
fun convertCentimeterToYards (number: Double): String {
    val result = number / 91.44
    return when {
        (number == 1.0) -> {
            "$number centimeter is $result yards"
        }
        (result == 1.0) -> {
            "$number centimeters is $result yard"
        }
        else -> {
            "$number centimeters is $result yards"
        }
    }
}
fun convertMillimeterToYards (number: Double): String {
    val result = number / 914.4
    return when {
        (number == 1.0) -> {
            "$number millimeter is $result yards"
        }
        (result == 1.0) -> {
            "$number millimeters is $result yard"
        }
        else -> {
            "$number millimeters is $result yards"
        }
    }
}
fun convertMilesToYards (number: Double): String {
    val result = number * 1760
    return when {
        (number == 1.0) -> {
            "$number mile is $result yards"
        }
        (result == 1.0) -> {
            "$number miles is $result yard"
        }
        else -> {
            "$number miles is $result yards"
        }
    }
}
fun convertYardsToYards (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 yard is 1.0 yard"
        }
        else -> {
            "$number yards is $number yards"
        }
    }
}
fun convertFootToYards (number: Double): String {
    val result = number / 3
    return when {
        (number == 1.0) -> {
            "$number foot is $result yards"
        }
        (result == 1.0) -> {
            "$number feet is $result yard"
        }
        else -> {
            "$number feet is $result yards"
        }
    }
}
fun convertInchToYards (number: Double): String {
    val result = number / 36
    return when {
        (number == 1.0) -> {
            "$number inch is $result yards"
        }
        (result == 1.0) -> {
            "$number inches is $result yard"
        }
        else -> {
            "$number inches is $result yards"
        }
    }
}

fun convertMetersToFoot (number: Double): String {
    val result = number / 0.3048
    return when {
        (number == 1.0) -> {
            "$number meter is $result feet"
        }
        (result == 1.0) -> {
            "$number meters is $result foot"
        }
        else -> {
            "$number meters is $result feet"
        }
    }
}
fun convertKilometersToFoot (number: Double): String {
    val result = number / 0.0003048
    return when {
        (number == 1.0) -> {
            "$number kilometer is $result feet"
        }
        (result == 1.0) -> {
            "$number kilometers is $result foot"
        }
        else -> {
            "$number kilometers is $result feet"
        }
    }
}
fun convertCentimeterToFoot (number: Double): String {
    val result = number / 30.48
    return when {
        (number == 1.0) -> {
            "$number centimeter is $result feet"
        }
        (result == 1.0) -> {
            "$number centimeters is $result foot"
        }
        else -> {
            "$number centimeters is $result feet"
        }
    }
}
fun convertMillimeterToFoot (number: Double): String {
    val result = number / 304.8
    return when {
        (number == 1.0) -> {
            "$number millimeter is $result feet"
        }
        (result == 1.0) -> {
            "$number millimeters is $result foot"
        }
        else -> {
            "$number millimeters is $result feet"
        }
    }
}
fun convertMilesToFoot (number: Double): String {
    val result = number  * 5280.02
    return when {
        (number == 1.0) -> {
            "$number mile is $result feet"
        }
        (result == 1.0) -> {
            "$number miles is $result foot"
        }
        else -> {
            "$number miles is $result feet"
        }
    }
}
fun convertYardsToFoot (number: Double): String {
    val result = number * 3
    return when {
        (number == 1.0) -> {
            "$number yard is $result feet"
        }
        (result == 1.0) -> {
            "$number yards is $result foot"
        }
        else -> {
            "$number yards is $result feet"
        }
    }
}
fun convertFootToFoot (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 foot is 1.0 foot"
        }
        else -> {
            "$number feet is $number feet"
        }
    }
}
fun convertInchToFoot (number: Double): String {
    val result = number / 12
    return when {
        (number == 1.0) -> {
            "$number inch is $result feet"
        }
        (result == 1.0) -> {
            "$number inches is $result foot"
        }
        else -> {
            "$number inches is $result feet"
        }
    }
}

fun convertMetersToInch (number: Double): String {
    val result = number / 0.0254
    return when {
        (number == 1.0) -> {
            "$number meter is $result inches"
        }
        (result == 1.0) -> {
            "$number meters is $result inch"
        }
        else -> {
            "$number meters is $result inches"
        }
    }
}
fun convertKilometersToInch (number: Double): String {
    val result = number / 0.0000254
    return when {
        (number == 1.0) -> {
            "$number kilometer is $result inches"
        }
        (result == 1.0) -> {
            "$number kilometers is $result inch"
        }
        else -> {
            "$number kilometers is $result inches"
        }
    }
}
fun convertCentimeterToInch (number: Double): String {
    val result = number / 2.54
    return when {
        (number == 1.0) -> {
            "$number centimeter is $result inches"
        }
        (result == 1.0) -> {
            "$number centimeters is $result inch"
        }
        else -> {
            "$number centimeters is $result inches"
        }
    }
}
fun convertMillimeterToInch (number: Double): String {
    val result = number / 25.4
    return when {
        (number == 1.0) -> {
            "$number millimeter is $result inches"
        }
        (result == 1.0) -> {
            "$number millimeters is $result inch"
        }
        else -> {
            "$number millimeters is $result inches"
        }
    }
}
fun convertMilesToInch (number: Double): String {
    val result = number * 63360
    return when {
        (number == 1.0) -> {
            "$number mile is $result inches"
        }
        (result == 1.0) -> {
            "$number miles is $result inch"
        }
        else -> {
            "$number miles is $result inches"
        }
    }
}
fun convertYardsToInch (number: Double): String {
    val result = number * 36
    return when {
        (number == 1.0) -> {
            "$number yard is $result inches"
        }
        (result == 1.0) -> {
            "$number yards is $result inch"
        }
        else -> {
            "$number yards is $result inches"
        }
    }
}
fun convertFootToInch (number: Double): String {
    val result = number * 12
    return when {
        (number == 1.0) -> {
            "$number foot is $result inches"
        }
        (result == 1.0) -> {
            "$number feet is $result inch"
        }
        else -> {
            "$number feet is $result inches"
        }
    }
}
fun convertInchToInch (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 inch is 1.0 inch"
        }
        else -> {
            "$number inches is $number inches"
        }
    }
}

// ДАЛЕЕ ИДУЮ ФУНКЦИИ ПО МЕРАМ ВЕСА ---------------------------------------------------------------------
fun convertGramsToGrams (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 gram is 1.0 gram"
        }
        else -> {
            "$number grams is $number grams"
        }
    }
}
fun convertGramsToKilograms (number: Double): String {
    val result = number / 1000
    return when {
        (number == 1.0) -> {
            "$number gram is $result kilograms"
        }
        (result == 1.0) -> {
            "$number grams is $result kilogram"
        }
        else -> {
            "$number grams is $result kilograms"
        }
    }
}
fun convertGramsToMilligram (number: Double): String {
    val result = number * 1000
    return when {
        (number == 1.0) -> {
            "$number gram is $result milligrams"
        }
        (result == 1.0) -> {
            "$number grams is $result milligram"
        }
        else -> {
            "$number grams is $result milligrams"
        }
    }
}
fun convertGramsToPounds (number: Double): String {
    val result = number / 453.592
    return when {
        (number == 1.0) -> {
            "$number gram is $result pounds"
        }
        (result == 1.0) -> {
            "$number grams is $result pound"
        }
        else -> {
            "$number grams is $result pounds"
        }
    }
}
fun convertGramsToOunces (number: Double): String {
    val result = number / 28.3495
    return when {
        (number == 1.0) -> {
            "$number gram is $result ounces"
        }
        (result == 1.0) -> {
            "$number grams is $result ounce"
        }
        else -> {
            "$number grams is $result ounces"
        }
    }
}

fun convertKilogramsToGrams (number: Double): String {
    val result = number * 1000
    return when {
        (number == 1.0) -> {
            "$number kilogram is $result grams"
        }
        (result == 1.0) -> {
            "$number kilograms is $result gram"
        }
        else -> {
            "$number kilograms is $result grams"
        }
    }
}
fun convertKilogramsToKilograms (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 kilogram is 1.0 kilogram"
        }
        else -> {
            "$number kilograms is $number kilograms"
        }
    }

}
fun convertKilogramsToMilligram (number: Double): String {
    val result = number * 1000000
    return when {
        (number == 1.0) -> {
            "$number kilogram is $result milligrams"
        }
        (result == 1.0) -> {
            "$number kilograms is $result milligram"
        }
        else -> {
            "$number kilograms is $result milligrams"
        }
    }
}
fun convertKilogramsToPounds (number: Double): String {
    val result = number / 0.453592
    return when {
        (number == 1.0) -> {
            "$number kilogram is $result pounds"
        }
        (result == 1.0) -> {
            "$number kilograms is $result pound"
        }
        else -> {
            "$number kilograms is $result pounds"
        }
    }
}
fun convertKilogramsToOunces (number: Double): String {
    val result = number / 0.0283495
    return when {
        (number == 1.0) -> {
            "$number kilogram is $result ounces"
        }
        (result == 1.0) -> {
            "$number kilograms is $result ounce"
        }
        else -> {
            "$number kilograms is $result ounces"
        }
    }
}

fun convertMilligramsToGrams (number: Double): String {
    val result = number / 1000
    return when {
        (number == 1.0) -> {
            "$number milligram is $result grams"
        }
        (result == 1.0) -> {
            "$number milligrams is $result gram"
        }
        else -> {
            "$number milligrams is $result grams"
        }
    }
}
fun convertMilligramsToKilograms (number: Double): String {
    val result = number / 1000000
    return when {
        (number == 1.0) -> {
            "$number milligram is $result kilograms"
        }
        (result == 1.0) -> {
            "$number milligrams is $result kilogram"
        }
        else -> {
            "$number milligrams is $result kilograms"
        }
    }
}
fun convertMilligramsToMilligram (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 milligram is 1.0 milligram"
        }
        else -> {
            "$number milligrams is $number milligrams"
        }
    }

}
fun convertMilligramsToPounds (number: Double): String {
    val result = number / 453592.292
    return when {
        (number == 1.0) -> {
            "$number milligram is $result pounds"
        }
        (result == 1.0) -> {
            "$number milligrams is $result pound"
        }
        else -> {
            "$number milligrams is $result pounds"
        }
    }
}
fun convertMilligramsToOunces (number: Double): String {
    val result = number * 0.0000352739
    return when {
        (number == 1.0) -> {
            "$number milligram is $result ounces"
        }
        (result == 1.0) -> {
            "$number milligrams is $result ounce"
        }
        else -> {
            "$number milligrams is $result ounces"
        }
    }
}

fun convertPoundsToGrams (number: Double): String {
    val result = number * 453.592
    return when {
        (number == 1.0) -> {
            "$number pound is $result grams"
        }
        (result == 1.0) -> {
            "$number pounds is $result gram"
        }
        else -> {
            "$number pounds is $result grams"
        }
    }
}
fun convertPoundsToKilograms (number: Double): String {
    val result = number * 0.453592
    return when {
        (number == 1.0) -> {
            "$number pound is $result kilograms"
        }
        (result == 1.0) -> {
            "$number pounds is $result kilogram"
        }
        else -> {
            "$number pounds is $result kilograms"
        }
    }
}
fun convertPoundsToMilligram (number: Double): String {
    val result = number * 453592
    return when {
        (number == 1.0) -> {
            "$number pound is $result milligram"
        }
        (result == 1.0) -> {
            "$number pounds is $result milligrams"
        }
        else -> {
            "$number pounds is $result milligrams"
        }
    }
}
fun convertPoundsToPounds (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 pound is 1.0 pound"
        }
        else -> {
            "$number pounds is $number pounds"
        }
    }
}
fun convertPoundsToOunces (number: Double): String {
    val result = number * 16
    return when {
        (number == 1.0) -> {
            "$number pound is $result ounces"
        }
        (result == 1.0) -> {
            "$number pounds is $result ounce"
        }
        else -> {
            "$number pounds is $result ounces"
        }
    }
}

fun convertOuncesToGrams (number: Double): String {
    val result = number * 28.3495
    return when {
        (number == 1.0) -> {
            "$number ounce is $result grams"
        }
        (result == 1.0) -> {
            "$number ounces is $result gram"
        }
        else -> {
            "$number ounces is $result grams"
        }
    }
}
fun convertOuncesToKilograms (number: Double): String {
    val result = number * 0.0283495
    return when {
        (number == 1.0) -> {
            "$number ounce is $result kilograms"
        }
        (result == 1.0) -> {
            "$number ounces is $result kilogram"
        }
        else -> {
            "$number ounces is $result kilograms"
        }
    }
}
fun convertOuncesToMilligram (number: Double): String {
    val result = number * 28349.5
    return when {
        (number == 1.0) -> {
            "$number ounce is $result milligram"
        }
        (result == 1.0) -> {
            "$number ounces is $result milligrams"
        }
        else -> {
            "$number ounces is $result milligrams"
        }
    }
}
fun convertOuncesToPounds (number: Double): String {
    val result = number / 16
    return when {
        (number == 1.0) -> {
            "$number ounce is $result pounds"
        }
        (result == 1.0) -> {
            "$number ounces is $result pound"
        }
        else -> {
            "$number ounces is $result pounds"
        }
    }
}
fun convertOuncesToOunces (number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 ounce is 1.0 ounce"
        }
        else -> {
            "$number ounces is $number ounces"
        }
    }
}

fun convertCelsiusToFahrenheit(number: Double): String {
    val result = number * 1.8 + 32
    return when {
        (number == 1.0) -> {
            "$number degree Celsius is $result degrees Fahrenheit"
        }
        (result == 1.0) -> {
            "$number degrees Celsius is $result degree Fahrenheit"
        }
        else -> {
            "$number degrees Celsius is $result degrees Fahrenheit"
        }
    }
}
fun convertCelsiusToKelvins(number: Double): String {
    val result = number + 273.15
    return when {
        (number == 1.0) -> {
            "$number degree Celsius is $result kelvins"
        }
        (result == 1.0) -> {
            "$number degrees Celsius is $result kelvin"
        }
        else -> {
            "$number degrees Celsius is $result kelvins"
        }
    }
}
fun convertCelsiusToCelsius(number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 degree Celsius is 1.0 degree Celsius"
        }
        else -> {
            "$number degrees Celsius is $number degrees Celsius"
        }
    }
}

fun convertKelvinsToFahrenheit(number: Double): String {
    val result = (number * 1.8) - 459.67
    return when {
        (number == 1.0) -> {
            "$number kelvin is $result degrees Fahrenheit"
        }
        (result == 1.0) -> {
            "$number kelvins is $result degree Fahrenheit"
        }
        else -> {
            "$number kelvins is $result degrees Fahrenheit"
        }
    }
}
fun convertKelvinsToKelvins(number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 kelvin is 1.0 kelvin"
        }
        else -> {
            "$number kelvins is $number kelvins"
        }
    }
}
fun convertKelvinsToCelsius(number: Double): String {
    val result = number - 273.15
    return when {
        (number == 1.0) -> {
            "$number kelvin is $result degrees Celsius"
        }
        (result == 1.0) -> {
            "$number kelvins is $result degree Celsius"
        }
        else -> {
            "$number kelvins is $result degrees Celsius"
        }
    }
}

fun convertFahrenheitToFahrenheit(number: Double): String {
    return when {
        (number == 1.0) -> {
            "1.0 degree Fahrenheit is 1.0 degree Fahrenheit"
        }
        else -> {
            "$number degrees Fahrenheit is $number degrees Fahrenheit"
        }
    }
}
fun convertFahrenheitToKelvins(number: Double): String {
    val result = (number + 459.67) * 0.5555555555555556
    return when {
        (number == 1.0) -> {
            "$number degree Fahrenheit is $result kelvins"
        }
        (result == 1.0) -> {
            "$number degrees Fahrenheit is $result kelvin"
        }
        else -> {
            "$number degrees Fahrenheit is $result kelvins"
        }
    }
}
fun convertFahrenheitToCelsius(number: Double): String {
    val result = (number - 32) * 0.5555555555555556
    return when {
        (number == 1.0) -> {
            "$number degree Fahrenheit is $result degrees Celsius"
        }
        (result == 1.0) -> {
            "$number degrees Fahrenheit is $result degree Celsius"
        }
        else -> {
            "$number degrees Fahrenheit is $result degrees Celsius"
        }
    }
}



fun writeCorrectEnds (inputString: String): String {
    when (inputString) {
        "m", "meter", "meters" -> return "meters"
        "km", "kilometer", "kilometers" -> return "kilometers"
        "cm", "centimeter", "centimeters" -> return "centimeters"
        "mm", "millimeter", "millimeters" -> return "millimeters"
        "mi", "mile", "miles" -> return "miles"
        "yd", "yard", "yards" -> return "yards"
        "ft", "foot", "feet" -> return "feet"
        "in", "inch", "inches" -> return "inches"
        "g", "gram", "grams" -> return "grams"
        "kg", "kilogram", "kilograms" -> return "kilograms"
        "mg", "milligram", "milligrams" -> return "milligrams"
        "lb", "pound", "pounds" -> return "pounds"
        "oz", "ounce", "ounces" -> return "ounces"
        "degree celsius", "degrees celsius", "celsius", "dc", "c" -> return "degrees Celsius"
        "degree fahrenheit", "degrees fahrenheit", "fahrenheit", "df", "f" -> return "degrees Fahrenheit"
        "kelvin", "kelvins", "k" -> return "kelvins"
    }
    return ""
}
