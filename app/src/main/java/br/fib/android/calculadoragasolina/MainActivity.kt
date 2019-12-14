package br.fib.android.calculadoragasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("AULA", "On Create")

        texto1.addTextChangedListener(MoneyTextWatcher(texto1));
        texto2.addTextChangedListener(MoneyTextWatcher(texto2));

        botao.setOnClickListener {
            var valorGasolina = texto1.text.toString();
            var valorAlcool = texto2.text.toString();

            if (valorGasolina == "") {
                Toast.makeText(this, "Favor preencher o valor da gasolina", Toast.LENGTH_LONG).show()
            }

            if (valorAlcool == ""){
                Toast.makeText(this, "Favor preencher o valor da alcool", Toast.LENGTH_LONG).show()
            }

            System.out.println(valorGasolina)
            System.out.println(valorAlcool)

            if (valorGasolina != "" && valorAlcool != "") {
                var valorGasolinaFloat = valorGasolina.replace(",", "").toFloat()
                var valorAlcoolFloat = valorAlcool.replace(",", "").toFloat()

                Log.i("AULA", "Cálculo de combustível. Gasolina: ${valorGasolinaFloat}. Alcool: ${valorAlcoolFloat}.")

                if (valorGasolinaFloat * 0.7 > valorAlcoolFloat) {
                    resultado.setText("Comprar Alcool")
                    Log.i("AULA", "Resultado: Comprar Alcool")
                }
                else {
                    resultado.setText("Comprar Gasolina")
                    Log.i("AULA", "Resultado: Comprar Gasolina")
                }
            }


        }

    }
}
