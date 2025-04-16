package br.fecapccp.checkboxsalrio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText salarioInput;
    private RadioGroup opcoesReajuste;
    private RadioButton opcao40, opcao45, opcao50;
    private Button btnCalcular;
    private TextView resultadoTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa os componentes
        salarioInput = findViewById(R.id.salarioInput);
        opcoesReajuste = findViewById(R.id.opcoesReajuste);
        opcao40 = findViewById(R.id.opcao40);
        opcao45 = findViewById(R.id.opcao45);
        opcao50 = findViewById(R.id.opcao50);
        btnCalcular = findViewById(R.id.btnCalcular);
        resultadoTexto = findViewById(R.id.resultadoTexto);

        btnCalcular.setOnClickListener(view -> {
            String salarioStr = salarioInput.getText().toString();

            if (salarioStr.isEmpty()) {
                Toast.makeText(MainActivity.this, "Digite o salário!", Toast.LENGTH_SHORT).show();
                return;
            }

            double salario = Double.parseDouble(salarioStr);
            double percentual;

            int selectedId = opcoesReajuste.getCheckedRadioButtonId();

            if (selectedId == R.id.opcao40) {
                percentual = 0.40;
            } else if (selectedId == R.id.opcao45) {
                percentual = 0.45;
            } else if (selectedId == R.id.opcao50) {
                percentual = 0.50;
            } else {
                Toast.makeText(MainActivity.this, "Selecione um percentual de aumento!", Toast.LENGTH_SHORT).show();
                return;
            }

            double novoSalario = salario + (salario * percentual);
            resultadoTexto.setText(String.format("Novo salário: R$ %.2f", novoSalario));
        });
    }
}