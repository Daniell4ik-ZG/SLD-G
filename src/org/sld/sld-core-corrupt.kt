package org.sld

import java.io.File
import java.nio.charset.Charset
import java.util.*
import kotlin.system.exitProcess

//
//class SLD_CORE {
//    var max = 1496
//    var prompt = ""
//
//
//    @Throws(FileNotFoundException::class)
//    fun assembly() {
//        val com = File("src/org/sld/commands.sld")
//
//        val com1 = File(com.getAbsolutePath())
//
//        val comm = Scanner(com1)
//        val tokens = comm.nextLine()
//        val tkns: Array<String?> = tokens.split("    ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
//
//        var i = 0
//        val a = 1
//        var word = ""
//        var next = ""
//        var prompt = ""
//
//        if (prompt.equals("пока") || prompt.equals("ладно, пока") || prompt.equals("досвидания") || prompt.equals(
//                "ну, пока"
//            ) || prompt.equals("ну ладно, пока")
//        ) {
//            System.exit(0)
//        }
//        if (prompt.equals("как тебя зовут?")) {
//            println("меня зовут Serial Language Designation-F (SLD-F)")
//        }
//        while (i != max) {
//            word = tkns[i]!!.replace("ввод=", "")
//            next = tkns[i + 1]!!.replace("ответ=", "")
//
//            if (prompt.equals(word)) {
//                println(next)
//            }
//
//            i = i + 2
//        }
//        i = 0
//    }
//}
fun main() {
    val language: List<String> = File("language.sld").absoluteFile.bufferedReader(Charset.forName("UTF-8")).use { it.readLines() }
    val sc = Scanner(System.`in`, "UTF-8")
    var token = 0
    while (true) {
        var prompt = sc.nextLine()
        while (token < 1040) {
            var comprompt = "ввод=$prompt".replace(' ', '@').replace("?", "")
            if (comprompt == language[token]) {
                var answ = language[token+1].replace("ответ=", "").replace("@", " ")
                println(answ)
                token = 0
                break
            } else if (comprompt == "ввод=пока" || comprompt == "ввод=ладно,@пока" || comprompt == "ввод=до@свидания"|| comprompt == "ввод=ну,@пока" || comprompt == "ввод=ну@ладно,@пока") {
                println("до скорых встреч!")
                exitProcess(0)
            }
            else {
                token += 1
                continue
            }

        }


    }
}