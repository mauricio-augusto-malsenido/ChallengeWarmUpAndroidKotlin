package edu.link.challengewarmupandroidkotlin.Entidades

data class Direccion (val pais:String,
                      val provincia:String,
                      val partido:String,
                      val ciudad:String,
                      val codigoPostal:Int,
                      val calle:Map<Calle,Entrecalle>,
                      val piso:String?,
                      val departamento:String?)