package org.sld

import java.awt.Color
import java.awt.Font
import javax.swing.*
import javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER


var a = JTextArea("Terminal: 3.1 || SLDCore: 1.7\n" +
        "#")
var f = JFrame("Serial Language Designation G");

fun createTerminal() {
    f.setSize(800, 500)
    f.setLocationRelativeTo(null)
    f.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    f.background = Color.BLACK
    val font = Font("LUCIDA CONSOLE",Font.PLAIN,13)

    val p = JScrollPane(a)
    p.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    f.add(p)
    p.isVisible = true
    a.background = Color.BLACK
    a.foreground = Color.GREEN
    a.font = font
    a.caretColor = Color.WHITE
    a.caretPosition = a.text.length

    f.setVisible(true)
}