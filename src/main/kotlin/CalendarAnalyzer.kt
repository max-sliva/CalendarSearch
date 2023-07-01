import java.io.File

class CalendarAnalyzer(var file: File) {
    /* обозначения в календ графике
    Э - сессия
    У - учеб. практика
    Н - науч-иссл работа
    П - произ практика
    Пд - преддипл практика
    ПА - повторная, вторая повторная аттестация
    Д - подготовка к процедуре зищиты и защита ВКР
    Г - подготовка к сдаче и сдача госов
    К - каникулы
    * - нерабочие праздн дни
    = - неделя отсутствует

     */
    lateinit var excelWork: ExcelWork

    init {
        println("file in CalendarAnalyzer = $file")
        excelWork = ExcelWork(file)
    }

    fun getInfoForDay(day: String): String {

        return ""
    }


}