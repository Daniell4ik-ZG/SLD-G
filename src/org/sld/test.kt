package org.sld

import java.io.File

fun main() {
    var a: List<String> = File("src/org/sld/language.sld").useLines { it.toList() }

    var i = 0
    while (true) {
        var prompt = readln()
        while (i < 1040) {
            var comprompt = "ввод=$prompt".replace(' ', '@')
                //println(comprompt)
            if (comprompt == a[i]) {
                var answ = a[i+1].replace("ответ=", "").replace("@", " ")
                println(answ)
                i = 0
                break
            }
            else {
                //println(i)
                i += 1
                continue
            }

        }


    }
    i = 0
}