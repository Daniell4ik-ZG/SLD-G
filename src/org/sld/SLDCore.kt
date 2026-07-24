package org.sld

import java.io.File
import java.nio.charset.Charset
import kotlin.system.exitProcess

fun main() {
    val language: List<String> = File("language.sld").absoluteFile.bufferedReader(Charset.forName("UTF-8")).use { it.readLines() }
    var token = 0
    createTerminal()

    while (true) {
        var prompt = a.text.substringAfterLast('#')
        if(prompt.endsWith("\n")) {
            a.text = a.text + "#"
            a.caretPosition = a.text.length
            while(token<1040) {
                var comprompt = "ввод=$prompt".replace(' ', '@').replace("?", "").replace("Terminal:@3.1@||@SLDCore:@1.7\n", "").replace("#", "").replace("\n", "")
                if (comprompt == language[token]) {
                    var answ = language[token+1].replace("ответ=", "").replace("@", " ")
                    a.text = a.text + "$answ\n#"
                    a.caretPosition = a.text.length
                    token = 0
                    break
                } else if (comprompt == "ввод=пока" || comprompt == "ввод=ладно,@пока" || comprompt == "ввод=до@свидания"|| comprompt == "ввод=ну,@пока" || comprompt == "ввод=ну@ладно,@пока") {
                    exitProcess(0)
                } else if (token == 1039) {
                    token = 0
                    break
                }
                else {
                    token += 1
                    continue
                }
            }
        }
    }
}