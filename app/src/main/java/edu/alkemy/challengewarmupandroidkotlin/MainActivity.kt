package edu.link.challengewarmupandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import edu.link.challengewarmupandroidkotlin.Entidades.Calle
import edu.link.challengewarmupandroidkotlin.Entidades.Direccion
import edu.link.challengewarmupandroidkotlin.Entidades.Entrecalle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val direcciones: ArrayList<Direccion> = ArrayList()

        val calle1: Calle = Calle("Maipú",2187)
        val entreCalle1: Entrecalle = Entrecalle("Delfin Gallo", "Pje Eliseo Canton");
        val direccion1: Direccion = Direccion("Argentina","Tucumán","Capital","San Miguel de Tucumán",4000,
            mapOf(Pair(calle1,entreCalle1)),"PB","C")

        val calle2: Calle = Calle("Maipú",2270)
        val entreCalle2: Entrecalle = Entrecalle("Isabel Católica", "Delfín Gallo");
        val direccion2: Direccion = Direccion("Argentina","Tucumán","Capital","San Miguel de Tucumán",4000,
            mapOf(Pair(calle2,entreCalle2)),null,null)

        val calle3: Calle = Calle("Emilio Castelar",550)
        val entreCalle3: Entrecalle = Entrecalle("Idelfonso De Las Muñecas", "25 De Mayo");
        val direccion3: Direccion = Direccion("Argentina","Tucumán","Capital","San Miguel de Tucumán",4000,
            mapOf(Pair(calle3,entreCalle3)),"Piso 3","3ºB")

        direcciones.add(direccion1)
        direcciones.add(direccion2)
        direcciones.add(direccion3)

        mostrarDireccion(direccion1)
        mostrarDireccion(direccion2)
        mostrarDireccion(direccion3)

        val pisoDepartamento:String = mostrarArrayDeDirecciones(direcciones)
        Log.i("mostrarDirecciones",pisoDepartamento)
    }

    private fun mostrarDireccion(direccion: Direccion)
    {
        if (direccion.piso == null || direccion.departamento == null)
        {
            Log.i("mostrarDireccion","Mi país es ${direccion.pais}, " +
                    "soy de la provincia de ${direccion.provincia}, " +
                    "vivo en la ciudad de ${direccion.ciudad} del partido ${direccion.partido}, " +
                    "el código postal es ${direccion.codigoPostal} " +
                    "y mi dirección es ${direccion.calle.keys.first().nombreDeCalle} ${direccion.calle.keys.first().numero} " +
                    "entre calles ${direccion.calle.values.first().entreCalle1} y ${direccion.calle.values.first().entreCalle2}")
        }
        else
        {
            Log.i("mostrarDireccion","Mi país es ${direccion.pais}, " +
                    "soy de la provincia de ${direccion.provincia}, " +
                    "vivo en la ciudad de ${direccion.ciudad} del partido ${direccion.partido}, " +
                    "el código postal es ${direccion.codigoPostal} " +
                    "y mi dirección es ${direccion.calle.keys.first().nombreDeCalle} ${direccion.calle.keys.first().numero} " +
                    "entre calles ${direccion.calle.values.first().entreCalle1} y ${direccion.calle.values.first().entreCalle2} " +
                    "${direccion.piso} departamento ${direccion.departamento}")
        }
    }

    private fun mostrarArrayDeDirecciones(direcciones: ArrayList<Direccion>) : String
    {
        var pisoDepartamento: String = ""
        direcciones.forEach {
            if (it.piso != null && it.departamento != null)
            {
                pisoDepartamento += "piso: ${it.piso} ; depto: ${it.departamento} "
            }
        }
        return pisoDepartamento
    }
}