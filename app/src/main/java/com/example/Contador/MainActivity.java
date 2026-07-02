package com.example.Contador;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

//aula de location manager, tela de solicitação de permissão pra acessar localização.
//Código faltava ser subido no git, na ordem certa das branchs.

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.textview);
        //checagem de permiss
        checkLocationPermission();
        //config do location manager
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Location localizacao = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (localizacao != null) {
            double latitude = localizacao.getLatitude();
            double longitude = localizacao.getLongitude();
            tv.setText("Latitude: " + latitude + "\nLongitude: " + longitude);
        } else {
            tv.setText("Localização não disponível");
        }
    }

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //PERM NÃO CONCEDIDA, SOLICITAR
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //PERMI CONCEDIDA
                recreate();  // Reinicia a Activity para obter a localização
            } else {
                // Permissão negada
                TextView tv = findViewById(R.id.textview);
                tv.setText("Permissão de localização negada");
            }
        }
    }
}