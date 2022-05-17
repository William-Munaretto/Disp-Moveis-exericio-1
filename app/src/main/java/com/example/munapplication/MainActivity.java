package com.example.munapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText edtNome;
    private EditText edtMail;
    private EditText edtTel;
    private RadioGroup radioSexo;
    private RadioButton radioMasc;
    private RadioButton radioFem;
    private CheckBox cboxMusica;
    private CheckBox cboxCinema;
    private CheckBox cboxEsporte;
    private CheckBox cboxGastronomia;
    private Button btnLimpar;
    private Button btnExibir;
    private Switch notify;
    private LinearLayout lblDados;
    private TextView txtNome;
    private TextView txtSexo;
    private TextView txtEmail;
    private TextView txtTelefone;
    private TextView txtPref;
    private TextView txtNotify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNome = findViewById(R.id.edtNome);
        radioSexo = findViewById(R.id.groupRadioButton);
        radioMasc = findViewById(R.id.radioButtonMasc);
        radioFem = findViewById(R.id.radioButtonFem);
        edtMail = findViewById(R.id.edtEmail);
        edtTel = findViewById(R.id.edtTelefone);
        cboxMusica = findViewById(R.id.musica);
        cboxCinema = findViewById(R.id.cinema);
        cboxEsporte = findViewById(R.id.esporte);
        cboxGastronomia = findViewById(R.id.gastronomia);
        notify = findViewById(R.id.notify);
        btnLimpar = findViewById(R.id.limparButton);
        btnExibir = findViewById(R.id.exibirButton);

        btnLimpar.setOnClickListener(this);
        btnExibir.setOnClickListener(this);

        lblDados = findViewById(R.id.lblDados);
        txtNome = findViewById(R.id.txtNome);
        txtSexo = findViewById(R.id.txtSexo);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefone = findViewById(R.id.txtTelefone);
        txtPref = findViewById(R.id.txtPref);
        txtNotify = findViewById(R.id.txtNotify);


    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.exibirButton) {
            lblDados.setVisibility(View.VISIBLE);
            txtNome.setText("Nome: " + edtNome.getText().toString());
            txtEmail.setText(edtMail.getText().toString());
            txtTelefone.setText(edtTel.getText().toString());

            int idrdbSelecionado = radioSexo.getCheckedRadioButtonId();
            if (idrdbSelecionado > 0) {
                RadioButton rdbSelecionado = findViewById(idrdbSelecionado);
                txtSexo.setText("Sexo: " + rdbSelecionado.getText().toString());
            }

            String pref="";
            if (cboxMusica.isChecked()) {
                pref = cboxMusica.getText().toString();
            }
            if (cboxCinema.isChecked()) {
                pref += " ";
                pref += cboxCinema.getText().toString();
            }
            if(cboxEsporte.isChecked()){
                pref += " ";
                pref += cboxEsporte.getText().toString();
            }
            if(cboxGastronomia.isChecked()){
                pref += " ";
                pref += cboxGastronomia.getText().toString();
            }
            txtPref.setText("Preferências: " + pref);

            if(notify.isChecked()){
                txtNotify.setText("Notificação: " + notify.getTextOn());
            }else{
                txtNotify.setText("Notificação: " + notify.getTextOff());
            }

        } else if (view.getId() == R.id.limparButton){
            edtNome.setText("");
            edtMail.setText("");
            edtTel.setText("");
            radioSexo.clearCheck();
            cboxMusica.setChecked(false);
            cboxCinema.setChecked(false);
            cboxEsporte.setChecked(false);
            cboxGastronomia.setChecked(false);
            notify.setChecked(false);
            lblDados.setVisibility(View.INVISIBLE);

        }



    }
}