package com.example.Contador;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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

    public SimplePaint(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaintList = new ArrayList<Paint>();
        mPathList = new ArrayList<Path>();

//config do paint
        currentPaint.setColor(Color.RED);

    }
//metodo de inicialização pra evitar aquela questao de estilo mudar por conta da config do path e paint ser nova, e garantir inicialização coerente:
    public void inicializaCamadaDesenho(){
        currentPaint = new Paint();
        currentPath = new Path();
        //config do paint
        currentPaint.setStyle(Paint.Style.STROKE);
        currentPaint.setStrokeWidth(20);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0 ; i < mPaintList.size(); i++){
            //renderizar o canvas, desenhar na tela
            canvas.drawPath(mPathList.get(i), mPaintList.get(i));
        }
        //se nn usar esse aqui que tem os elementos usados, fica td errado e estranho:
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
                //reinicializar as variaveis:
                currentPaint = new Paint();
                currentPath = new Path();

                break;
            default:
                break;
        }
        invalidate();
        return true;
    }

    public void setColor(Color color) {
        currentPaint.setColor(color.toArgb());
    }
}
