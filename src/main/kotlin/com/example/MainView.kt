package com.example

import javafx.collections.FXCollections
import tornadofx.*
import java.time.LocalDate

class MainView : View("TornadoFX") {
    private val persons = FXCollections.observableArrayList(
            Person(1, "Samantha Stuart", LocalDate.of(1981,12,4)),
            Person(2, "Tom Marks", LocalDate.of(2001,1,23)),
            Person(3, "Stuart Gills", LocalDate.of(1989,5,23)),
            Person(3, "Nicole Williams", LocalDate.of(1998,8,11))
    )

    data class Person(val id: Int, val name: String, val birthday: LocalDate)

    override val root = vbox {

        label("hello")

        button("say hello") {
            setOnAction { println("hello") }
        }

        webview {
            engine.load("http://google.jp")
        }

        tableview(persons) {
            column("ID", Person::id)
            column("Name", Person::name)
            column("Birthday", Person::birthday)
        }
    }
}