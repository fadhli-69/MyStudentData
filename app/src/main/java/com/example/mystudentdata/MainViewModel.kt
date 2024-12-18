package com.example.mystudentdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mystudentdata.database.Student
import com.example.mystudentdata.database.StudentAndUniversity
import com.example.mystudentdata.database.StudentWithCourse
import com.example.mystudentdata.database.UniversityAndStudent

class MainViewModel(private val studentRepository: StudentRepository) : ViewModel() {

//    init {
//        insertAllData()
//    }

    fun getAllStudent(): LiveData<List<Student>> = studentRepository.getAllStudent()
    fun getAllStudentAndUniversity(): LiveData<List<StudentAndUniversity>> = studentRepository.getAllStudentAndUniversity()
    fun getAllUniversityAndStudent(): LiveData<List<UniversityAndStudent>> = studentRepository.getAllUniversityAndStudent()
    fun getAllStudentWithCourse(): LiveData<List<StudentWithCourse>> = studentRepository.getAllStudentWithCourse()

//    private fun insertAllData() = viewModelScope.launch {
//        studentRepository.insertAllData()
//    }
}

class ViewModelFactory(private val repository: StudentRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}