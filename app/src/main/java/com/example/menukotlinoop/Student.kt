package com.example.menukotlinoop

import java.util.Vector

class Student(name: String, grades: Vector<Double>) {
    var name = name
    var grades = grades
    var average: Double = grades.sum() / grades.count()

}