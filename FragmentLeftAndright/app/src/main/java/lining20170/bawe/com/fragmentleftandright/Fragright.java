package lining20170.bawe.com.fragmentleftandright;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Lenovo on 2017/3/29.
 * author ：李宁
 * 类注释：
 */

public class Fragright extends Fragment {

    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vv=View.inflate(getActivity(),R.layout.right,null);
        tv = (TextView) vv.findViewById(R.id.tv);

        return vv;

    }
      public void setTv(String dd){
          tv.setText(dd);
      }
}
