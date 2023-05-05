package com.example.firebase_app

class Car {

    var car_make:String? = null
    var car_model:String? = null
    var car_id:String? = null
    var car_price:String? = null

    constructor(car_make:String, car_model:String, car_price:String, car_id:String) {

        this.car_make = car_make
        this.car_model = car_model
        this.car_id = car_id
        this.car_price = car_price

    }
}