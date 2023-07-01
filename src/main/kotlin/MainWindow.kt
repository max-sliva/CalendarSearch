import javafx.event.ActionEvent
import javafx.scene.layout.BorderPane
import javafx.stage.FileChooser
import java.io.File
import java.nio.file.Paths

class MainWindow {
    var fileChooser = FileChooser()
    private var dataIsReady: Boolean = false
    lateinit var mainPane: BorderPane

    fun openPlanXlsx(actionEvent: ActionEvent) {
        dataIsReady = false
        println("open file")
        fileChooser = FileChooser().apply {
            title = "Open Excel File"
            val currentPath: String = Paths.get(".").toAbsolutePath().normalize().toString()
            initialDirectory = File(currentPath)
            extensionFilters.addAll(
                FileChooser.ExtensionFilter("Excel Files", "*.xlsx", "*.xls"),
                FileChooser.ExtensionFilter("All Files", "*.*")
            )
        }
        val file = fileChooser.showOpenDialog(mainPane.scene.window)
        println("file name = $file")
        if (file!=null) {
            val analyzer = CalendarAnalyzer(file)
        }
//        val task = createTask { (::fileWork)(file) }
//        Thread(task).start()
    }



}
