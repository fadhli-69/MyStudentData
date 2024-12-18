package com.example.mystudentdata

import androidx.lifecycle.LiveData
import com.example.mystudentdata.database.Student
import com.example.mystudentdata.database.StudentAndUniversity
import com.example.mystudentdata.database.StudentDao
import com.example.mystudentdata.database.StudentWithCourse
import com.example.mystudentdata.database.UniversityAndStudent
import com.example.mystudentdata.helper.SortType
import com.example.mystudentdata.helper.SortUtils

class StudentRepository(private val studentDao: StudentDao) {

    fun getAllStudent(sortType: SortType): LiveData<List<Student>> {
        val query = SortUtils.getSortedQuery(sortType)
        return studentDao.getAllStudent(query)
    }

    fun getAllStudentAndUniversity(): LiveData<List<StudentAndUniversity>> =
        studentDao.getAllStudentAndUniversity()

    fun getAllUniversityAndStudent(): LiveData<List<UniversityAndStudent>> =
        studentDao.getAllUniversityAndStudent()

    fun getAllStudentWithCourse(): LiveData<List<StudentWithCourse>> =
        studentDao.getAllStudentWithCourse()

//    suspend fun insertAllData() {
//        studentDao.insertStudent(InitialDataSource.getStudents())
//        studentDao.insertUniversity(InitialDataSource.getUniversities())
//        studentDao.insertCourse(InitialDataSource.getCourses())
//        studentDao.insertCourseStudentCrossRef(InitialDataSource.getCourseStudentRelation())
//    }
}