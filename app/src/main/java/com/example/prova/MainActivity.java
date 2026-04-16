package com.example.prova;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etCode, etPrice, etQuantity;
    private Button btnSave, btnViewList;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getInstance(this);

        etName = findViewById(R.id.etName);
        etCode = findViewById(R.id.etCode);
        etPrice = findViewById(R.id.etPrice);
        etQuantity = findViewById(R.id.etQuantity);
        btnSave = findViewById(R.id.btnSave);
        btnViewList = findViewById(R.id.btnViewList);

        btnSave.setOnClickListener(v -> saveProduct());

        btnViewList.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
            startActivity(intent);
        });
    }

    private void saveProduct() {
        String name = etName.getText().toString().trim();
        String code = etCode.getText().toString().trim();
        String priceStr = etPrice.getText().toString().trim();
        String quantityStr = etQuantity.getText().toString().trim();

        if (name.isEmpty() || code.isEmpty() || priceStr.isEmpty() || quantityStr.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double price = Double.parseDouble(priceStr);
            if (price <= 0) {
                Toast.makeText(this, "O preço deve ser maior que zero", Toast.LENGTH_SHORT).show();
                return;
            }
            // Simple check for 2 decimal places - though numberDecimal handles it mostly
            if (priceStr.contains(".") && priceStr.substring(priceStr.indexOf(".") + 1).length() > 2) {
                Toast.makeText(this, "O preço deve ter no máximo duas casas decimais", Toast.LENGTH_SHORT).show();
                return;
            }

            int quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                Toast.makeText(this, "A quantidade deve ser um número inteiro positivo", Toast.LENGTH_SHORT).show();
                return;
            }

            Product product = new Product(name, code, price, quantity);
            db.productDao().insert(product);

            Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show();
            clearFields();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Dados inválidos", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        etName.setText("");
        etCode.setText("");
        etPrice.setText("");
        etQuantity.setText("");
        etName.requestFocus();
    }
}
