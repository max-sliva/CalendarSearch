import javafx.application.Application
import javafx.application.Platform
import javafx.fxml.FXMLLoader
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.stage.Stage
import java.net.URLDecoder
import kotlin.system.exitProcess

class CalendarSearch: Application() {
    override fun start(primaryStage: Stage) {
        val fxmlLoader = getLoader("mainWindow.fxml")
        primaryStage.title = "CalendarSearch 0.1!"
        val scene = Scene(fxmlLoader.load(), 800.0, 600.0)
        primaryStage.scene = scene

        primaryStage.show()
        primaryStage.onCloseRequest = EventHandler {
            Platform.exit()
            exitProcess(0)
        }
    }

    companion object { //специальный объект для запуска проекта в рамках фреймворка JavaFX
        @JvmStatic // его всегда оставляем одинаковым для всех проектов
        fun main(args: Array<String>) {
            launch(CalendarSearch::class.java) // CalendarSearch – имя запускного класса
        }
    }
}

fun getCurrentPath(): String {
    val path: String = CalendarSearch::class.java.protectionDomain.codeSource.location.path
    val decodedPath = URLDecoder.decode(path, "UTF-8")
    val last = decodedPath.lastIndexOf("/")
    val newPath = decodedPath.subSequence(0, last)

    return newPath.toString()
}

fun getLoader(fxmlName: String): FXMLLoader {
    val fxmlPath = "${getCurrentPath()}/$fxmlName"
//    val fxmlLoader = FXMLLoader(URL("file:$fxmlPath")) //для jar-файла
    val fxmlLoader = FXMLLoader(CalendarSearch::class.java.getResource(fxmlName)) //для запуска из IDE
    return fxmlLoader
}