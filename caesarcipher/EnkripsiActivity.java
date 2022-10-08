package com.example.caesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class EnkripsiActivity extends AppCompatActivity {

    EditText edPlainText, edKeyEn;
    Button btHsEnkripsi;
    ImageButton ibWhatsapp;
    TextView tvSend, tvCipherText;

    StringBuilder cipher = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enkripsi);

        edPlainText = findViewById(R.id.ed_plainText);
        edKeyEn = findViewById(R.id.ed_keyEn);
        btHsEnkripsi = findViewById(R.id.bt_hsEnkripsi);
        ibWhatsapp = findViewById(R.id.ib_whatsapp);
        tvSend = findViewById(R.id.tv_send);
        tvCipherText = findViewById(R.id.tv_cipherText);

        btHsEnkripsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String huruf = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

                String text = edPlainText.getText().toString();
                int key = Integer.parseInt(edKeyEn.getText().toString());


                    for (int i = 0; i < text.length(); i++) {
                        if (text.charAt(i) == ' ') {
                            cipher.append(text.charAt(i));
                        } else {
                            int charPos = huruf.indexOf(text.charAt(i));// dihitung per karakter
                            int indexValue = (charPos + key) % 26; // modulus dibawah 26 tetep bilangan itu sendiri
                            char charValue = huruf.charAt(indexValue);

                            cipher.append(charValue);
                        }
                    }

                    tvCipherText.setText(cipher.toString());


            }
        });

        ibWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirim = new Intent(Intent.ACTION_SEND);
                kirim.setType("text/plain");
                kirim.putExtra(Intent.EXTRA_TEXT, cipher.toString());
                kirim.putExtra("send", "" + "@s.whatsapp.net");
                kirim.setPackage("com.whatsapp");
                startActivity(kirim);
            }
        });
    }
}