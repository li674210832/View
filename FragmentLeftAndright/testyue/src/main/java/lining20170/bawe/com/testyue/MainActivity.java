package lining20170.bawe.com.testyue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Myview my= (Myview) findViewById(R.id.my);
        my.setonCricleClick(new Myview.ONCricleClick() {
            @Override
            public void onClickInnerCircle() {
                Toast.makeText(MainActivity.this, "内圆", Toast.LENGTH_SHORT).show();
                 startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }

            @Override
            public void onClickOutterCirle() {
                Toast.makeText(MainActivity.this, "外圆", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
