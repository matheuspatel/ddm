package com.example.Contador;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SimplePaint extends View {
    //pras camadas:
    List<Paint> mPaintList;
    List<Path> mPathList;
    Paint currentPaint;
    Path currentPath;
    ColorDrawable currentColor;

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaintList = new ArrayList<Paint>();
        mPathList = new ArrayList<Path>();

// inicializar a variavel
        currentColor = new ColorDrawable();
        currentColor.setColor(Color.BLACK);

        // pra chamar o metodo/função
        inicializaCamadaDesenho();

    }
//definindo o metodo de inicialização pra evitar aquela questao de estilo mudar por conta da config do path e paint ser nova, e garantir inicialização coerente:
    public void inicializaCamadaDesenho(){
        currentPaint = new Paint();
        currentPath = new Path();
        //config do paint
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeWidth(20);
        //config pra pegar o inteiro do currentcolor e colocar no paint
        currentPaint.setColor(currentColor.getColor());
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0 ; i < mPaintList.size(); i++){
            //renderizar a lista do canvas, desenhar na tela:
            canvas.drawPath(mPathList.get(i), mPaintList.get(i));
        }
        //se nn usar esse aqui que tem os elementos usados, fica td errado e estranho. Usando ele mosra a camada atual
        canvas.drawPath(currentPath, currentPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float lx, ly;
        lx = event.getX();
        ly = event.getY();
        switch (event.getAction()){
            case (MotionEvent.ACTION_DOWN):
                currentPath.moveTo(lx, ly);
                currentPath.lineTo(lx, ly);
                break;

            case (MotionEvent.ACTION_MOVE):
                currentPath.lineTo(lx, ly);
                break;
            case (MotionEvent.ACTION_UP):
                currentPath.lineTo(lx, ly);
                mPaintList.add(currentPaint);
                mPathList.add(currentPath);
                //usando no lugar de reinicializar as variaveis:
                inicializaCamadaDesenho();

                break;
            default:
                break;
        }
        invalidate();
        return true;
    }

    public void setColor(Color color) {
        currentColor.setColor(color.toArgb());
        currentPaint.setColor(color.toArgb());
    }
}
