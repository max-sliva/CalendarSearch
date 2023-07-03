class MonthWithRanges (name: String){
//мап (номер курса , мап(диапазон дат, значение для этого диапазона)
    private var courseRangeMap = HashMap<Int, HashMap<IntRange, String>>()

    fun addMapForCourse(course: Int, map: HashMap<IntRange, String>){
        courseRangeMap[course] = map
    }

    fun getDateInfo(course: Int, date: Int): String{
        var dateString = ""
        val rangeMap = courseRangeMap[course]
        rangeMap?.keys?.forEach {
            if (it.contains(date)) dateString = rangeMap[it]!!
        }
        return dateString
    }
}