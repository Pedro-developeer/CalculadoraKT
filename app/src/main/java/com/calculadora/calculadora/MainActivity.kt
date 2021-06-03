package com.calculadora.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        numero_zero.setOnClickListener{ AcrecentarUmaExpressao("0",true) } //evento de clicks
        numero_um.setOnClickListener{ AcrecentarUmaExpressao("1",true) } //evento de clicks
        numero_dois.setOnClickListener{ AcrecentarUmaExpressao("2",true) } //evento de clicks
        numero_tres.setOnClickListener{ AcrecentarUmaExpressao("3",true) } //evento de clicks
        numero_quatro.setOnClickListener{ AcrecentarUmaExpressao("4",true) } //evento de clicks
        numero_cinco.setOnClickListener{ AcrecentarUmaExpressao("5",true) } //evento de clicks
        numero_seis.setOnClickListener{ AcrecentarUmaExpressao("6",true) } //evento de clicks
        numero_sete.setOnClickListener{ AcrecentarUmaExpressao("7",true) } //evento de clicks
        numero_oito.setOnClickListener{ AcrecentarUmaExpressao("8",true) } //evento de clicks
        numero_nove.setOnClickListener{ AcrecentarUmaExpressao("9",true) } //evento de clicks
        ponto.setOnClickListener{ AcrecentarUmaExpressao(".",true) }

        //Operadores
        soma.setOnClickListener{ AcrecentarUmaExpressao("+",false) }
        subtracao.setOnClickListener{ AcrecentarUmaExpressao("-",false) }
        multiplicacao.setOnClickListener{ AcrecentarUmaExpressao("*",false) }
        divisao.setOnClickListener{ AcrecentarUmaExpressao("/",false) }

        limpar_dados.setOnClickListener{
            expressao.text = ""                    //limpar dados
            result.text = ""
        }

        backspace.setOnClickListener{
                                       //Backspace apagador um por um
            val string = expressao.text.toString()   //Vai capturar esse texto e coneverter para uma STRING
            if(string.isNotEmpty()){ //Se minha String não estiver vazia faça
                expressao.text = string .substring(0,string.length-1) // Verificar o comprimento dos nossos caracteres
            }
            result.text= ""
        }

        igual.setOnClickListener{ //Evento de click
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build() //biblioteca
                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if (resultado == longResult.toDouble())
                    result.text = longResult.toString()
                else
                    result.text = resultado.toString()


            }catch (e: Exception){
            }
        }
    }

    fun AcrecentarUmaExpressao(string: String, limpar_dados : Boolean){

        if (result.text.isNotEmpty()) { //Se o resultado da expressão não estiver vazia vamos limpar
            expressao.text = ""
        }

        if(limpar_dados){  //s limpar dados for verdadeiro vai ternoar como vazio
            result.text =""
            expressao.append(string)  //append e acrescentar
        }else{
            expressao.append(result.text) //ele vai apresentar o resultado e capturar como texto
            expressao.append(string)
            result.text = ""
        }
    }
}