package lining20170.bawe.com.fragmentleftandright;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          init();
    }

    private void init() {
        FragmentTransaction ff = getSupportFragmentManager().beginTransaction();
        ff.replace(R.id.left,new Fragleft(),"left");
        ff.replace(R.id.right,new Fragright(),"right");
        ff.commit();

    }
}
