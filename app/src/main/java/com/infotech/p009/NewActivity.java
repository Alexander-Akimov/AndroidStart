package com.infotech.p009;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

class NewActivity1 extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p009_click_handlers);

        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        // Первый метод обработки нажатия кнопки
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("Нажата кнопка 1");
            }
        });
        // Второй способ
        button2.setOnClickListener(this);

    }

    //третий способ
    public void clickButton3(View view) {
        textView.setText("Нажата кнопка 3");
    }

    @Override
    public void onClick(View view) {
        textView.setText("Нажата кнопка 2");
    }
}

class NewActivity9_10 extends AppCompatActivity {

    TextView textView;
    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p009_click_handlers);

        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.button1:
                        textView.setText("Нажата кнопка 1");
                        break;
                    case R.id.button2:
                        textView.setText("Нажата кнопка 2");
                        break;
                    case R.id.button3:
                        textView.setText("Нажата кнопка 3");
                        break;
                    case R.id.textView:
                        button3.setText("4");
                        break;
                }
            }
        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        textView.setOnClickListener(onClickListener);

    }


}

public class NewActivity extends AppCompatActivity {

    @Override
    @TargetApi(11)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p011_resources);

        Button btnChangeImg = (Button) findViewById(R.id.btnChangeImg);

        btnChangeImg.setOnClickListener(clickHandle());

    }

    protected View.OnClickListener clickHandle() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = (ImageView) findViewById(R.id.imageView);

                Drawable image = android.os.Build.VERSION.SDK_INT >= 21 ?
                        getResources().getDrawable(R.drawable.ic_camera_black_24dp, getTheme()) :
                        getResources().getDrawable(R.drawable.ic_camera_black_24dp);

                imageView.setImageDrawable(image);
            }
        };
    }
}
