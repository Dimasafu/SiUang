package com.dimasafu.mobile.siuang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A login screen that offers login via email/password.
 */
    public class Welcome extends AppCompatActivity {
        Button btnFB;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);

        Button btnFB = (Button)findViewById(R.id.btnfb);
        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.facebook.com/login.php"));
                startActivity(intent);
            }
        });
    }
        public void save(View v) {
            TextView namaText = (TextView) findViewById(R.id.personal_name);
            String nama = namaText.getText().toString();
            User dataUser = new User(this);
            dataUser.name = nama;
            dataUser.amount = 0;
            if (nama.equals("")) {
                Toast.makeText(this, "Nama Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
            }
            else {
                dataUser.insertUser(dataUser);
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
            }
        }


}