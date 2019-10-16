package com.example.studentskamenza.domen

class Food (var dorucak: Int,
            var rucak: Int,
            var vecera: Int){


    fun add(food: Food){
        this.dorucak+=food.dorucak
        this.rucak+=food.rucak
        this.vecera+=food.vecera
    }
}