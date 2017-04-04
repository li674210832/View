package lining20170.bawe.com.testyue;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.ScrollView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.io.IOException;
import java.util.List;

import lining20170.bawe.com.testyue.adapter.Rwcyadapter;
import lining20170.bawe.com.testyue.bb.ReBean;
import lining20170.bawe.com.testyue.bb.bean;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recy;
    private List<bean.ResultBean.RowsBean> rows;
    private PullToRefreshScrollView pull;
    private Rwcyadapter rwcyadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recy = (RecyclerView) findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(this));
        pull = (PullToRefreshScrollView) findViewById(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);

        new Gooddate().execute();
        plist();
    }

    private void plist() {
         pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
             @Override
             public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                //得到当前刷新的时间
                 String label = DateUtils.formatDateTime(Main2Activity.this.getApplicationContext(), System.currentTimeMillis(),
                         DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                 // Update the LastUpdatedLabel
                 //设置更新时间
                 refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

                 new Gooddate().execute();
                 rwcyadapter.notifyDataSetChanged();

             }

             @Override
             public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                 //得到当前刷新的时间
                 String label = DateUtils.formatDateTime(Main2Activity.this.getApplicationContext(), System.currentTimeMillis(),
                         DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

                 // Update the LastUpdatedLabel
                 //设置更新时间
                 refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
                 new Gooddate().execute();
                 rwcyadapter.notifyDataSetChanged();
             }
         });

    }

    class Gooddate extends AsyncTask<Void,Void,String>{
         @Override
         protected String doInBackground(Void... params) {
             try {
                 Thread.sleep(2000);
             } catch (InterruptedException e) {
             }

             String url="http://api.fang.anjuke.com/m/android/1.3/shouye/recInfosV3/?city_id=14&lat=40.04652&lng=116.306033&api_key=androidkey&sig=9317e9634b5fbc16078ab07abb6661c5&macid=45cd2478331b184ff0e15f29aaa89e3e&app=a-ajk&_pid=11738&o=PE-TL10-user+4.4.2+HuaweiPE-TL10+CHNC00B260+ota-rel-keys%2Crelease-keys&from=mobile&m=Android-PE-TL10&cv=9.5.1&cid=14&i=864601026706713&v=4.4.2&pm=b61&uuid=1848c59c-185d-48d9-b0e9-782016041109&_chat_id=0&qtime=20160411091603"+10;
             try {

                 String httpok = Okhttp.httpok(url);
                 //Log.d("zzz","httpok"+httpok.toString());
                 Gson gson = new Gson();
                 bean beann = gson.fromJson(httpok, bean.class);
                 Log.d("zzz","beann"+beann.toString());
                 bean.ResultBean result = beann.getResult();
                 rows = result.getRows();


             } catch (IOException e) {
                 e.printStackTrace();
             }


             return null;
         }

         @Override
         protected void onPostExecute(String s) {
             rwcyadapter = new Rwcyadapter(Main2Activity.this, rows);
             recy.setAdapter(rwcyadapter);

             //在更新UI后，无需其它Refresh操作，系统会自己加载新的
             pull.onRefreshComplete();
             super.onPostExecute(s);

         }
     }
}
