package com.example.caesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class DekripsiActivity extends AppCompatActivity {

    EditText edCipherText, edKeyDec;
    Button btHsDekripsi;
    TextView tvPlainText;

    StringBuilder plain = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dekripsi);

        edCipherText = findViewById(R.id.ed_cipherText);
        edKeyDec = findViewById(R.id.ed_keyDec);
        btHsDekripsi = findViewById(R.id.bt_hsDekripsi);
        tvPlainText = findViewById(R.id.tv_plainText);

        btHsDekripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String huruf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

                String text = edCipherText.getText().toString();
                int key = Integer.parseInt(edKeyDec.getText().toString());

                for (int i = 0; i < text.length(); i++) {
                    if (text.charAt(i) == ' ') {
                        plain.append(text.charAt(i));
                    } else {
                        int charPos = huruf.indexOf(text.charAt(i));
                        int indexValue = (charPos - key) % 26;
                        if (indexValue < 0) {
                            //
                            indexValue = huruf.length() + indexValue;
                        }

                        char charValue = huruf.charAt(indexValue);
                        plain.append(charValue);
                    }
                }
                tvPlainText.setText(plain.toString());
            }
        });
    }
}