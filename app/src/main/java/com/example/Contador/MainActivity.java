package com.example.Contador;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

public class MainActivity extends AppCompatActivity {
    //criando um obj pro nosso paint pra poder referenciar ele etc
        SimplePaint simplePaint;
        ImageView ivColorPicker;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //esse é o obj do paint da tela
            simplePaint = findViewById(R.id.simplePaint);
            ivColorPicker = findViewById(R.id.ivCPicker);
            ivColorPicker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    colorPickerSelectCor();
                }
            });
        }
        public void colorPickerSelectCor(){
            new ColorPickerDialog.Builder(this)
                    .setTitle("ColorPicker Dialog")
                    .setPreferenceName("MyColorPickerDialog")
                    .setPositiveButton(getString(R.string.confirm),
                            new ColorEnvelopeListener() {
                                @Override
                                public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                    setColor(envelope);
                                }
                            })
                    .setNegativeButton(getString(R.string.cancel),
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                    .attachAlphaSlideBar(true) // the default value is true.
                    .attachBrightnessSlideBar(true)  // the default value is true.
                    .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                    .show();
        }

    private void setColor(ColorEnvelope envelope) {
            //pra pegar a cor, e ent o valor alfan da cor do pick e dps passar pro paint
            simplePaint.setColor(Color.valueOf(envelope.getColor()));
            //pro imageview botao ficar com a cor selecionada, e usando mostrando que é o rgb alfanum:
        ivColorPicker.setColorFilter(Color.valueOf(envelope.getColor()).toArgb());
    }
}