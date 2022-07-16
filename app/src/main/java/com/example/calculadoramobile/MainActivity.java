package com.example.calculadoramobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero,
            numeroUm,
            numeroDois,
            numeroTres,
            numeroQuatro,
            numeroCinco,
            numeroSeis,
            numeroSete,
            numeroOito,
            numeroNove,
            ponto,
            soma,
            sub,
            mult,
            divisao,
            equal,
            porcento,
            abreParenteses,
            fechaParenteses
    ;

    private TextView txtExpressao, txtResultado;
    private ImageView apagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        SetarListener();
        getSupportActionBar().hide();

    }

    private void SetarListener(){
        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        soma.setOnClickListener(this);
        sub.setOnClickListener(this);
        divisao.setOnClickListener(this);
        mult.setOnClickListener(this);
        ponto.setOnClickListener(this);
        abreParenteses.setOnClickListener(this);
        fechaParenteses.setOnClickListener(this);
        porcento.setOnClickListener(this);

        apagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView expressao = findViewById(R.id.txt_expressao);
                String texto = expressao.getText().toString();

                if(!texto.isEmpty()){
                    byte var0 = 0;
                    int var1 = texto.length()-1;
                    String txtExpressao = texto.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        equal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long lResultado = (long) resultado;

                    if (resultado == (double)lResultado){
                        txtResultado.setText((CharSequence)String.valueOf(lResultado));
                    }else{
                        txtResultado.setText((CharSequence)String.valueOf(resultado));
                    }
                }catch (Exception e){ }

            }
        });

    }

    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.btn_zero);
        numeroUm = findViewById(R.id.btn_um);
        numeroDois = findViewById(R.id.btn_dois);
        numeroTres = findViewById(R.id.btn_tres);
        numeroQuatro = findViewById(R.id.btn_quatro);
        numeroCinco = findViewById(R.id.btn_cinco);
        numeroSeis = findViewById(R.id.btn_seis);
        numeroSete = findViewById(R.id.btn_sete);
        numeroOito = findViewById(R.id.btn_oito);
        numeroNove = findViewById(R.id.btn_nove);
        ponto = findViewById(R.id.btn_ponto);
        soma = findViewById(R.id.btn_soma);
        sub = findViewById(R.id.btn_sub);
        mult = findViewById(R.id.btn_mult);
        divisao = findViewById(R.id.btn_divisao);
        porcento = findViewById(R.id.btn_porcento);
        abreParenteses = findViewById(R.id.btn_fecha_parenteses);
        fechaParenteses = findViewById(R.id.btn_abre_parenteses);
        equal = findViewById(R.id.btn_equal);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        apagar = findViewById(R.id.btn_apagar);

    }

    public void AcrescentarExpressao(String pTexto, boolean limpar_dados){
        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(pTexto);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(pTexto);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_zero:
                AcrescentarExpressao("0",true);
                break;
            case R.id.btn_um:
                AcrescentarExpressao("1",true);
                break;
            case R.id.btn_dois:
                AcrescentarExpressao("2",true);
                break;
            case R.id.btn_tres:
                AcrescentarExpressao("3",true);
                break;
            case R.id.btn_quatro:
                AcrescentarExpressao("4",true);
                break;
            case R.id.btn_cinco:
                AcrescentarExpressao("5",true);
                break;
            case R.id.btn_seis:
                AcrescentarExpressao("6",true);
                break;
            case R.id.btn_sete:
                AcrescentarExpressao("7",true);
                break;
            case R.id.btn_oito:
                AcrescentarExpressao("8",true);
                break;
            case R.id.btn_nove:
                AcrescentarExpressao("9",true);
                break;
            case R.id.btn_ponto:
                AcrescentarExpressao(".",true);
                break;
            case R.id.btn_soma:
                AcrescentarExpressao("+",false);
                break;
            case R.id.btn_sub:
                AcrescentarExpressao("-",false);
                break;
            case R.id.btn_divisao:
                AcrescentarExpressao("/",false);
                break;
            case R.id.btn_mult:
                AcrescentarExpressao("*",false);
                break;
            case R.id.btn_abre_parenteses:
                AcrescentarExpressao("(",false);
                break;
            case R.id.btn_fecha_parenteses:
                AcrescentarExpressao(")",false);
                break;
            case R.id.btn_porcento:
                AcrescentarExpressao("%",false);
                break;
        }
    }
}