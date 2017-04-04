package lining20170.bawe.com.fragmentleftandright;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Lenovo on 2017/3/29.
 * author ：李宁
 * 类注释：
 */

public class Fragleft extends Fragment {
    private  String [] arr=new String[]{
            "监督5","监督4","监督3","监督2","监督1"
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View vv=View.inflate(getActivity(),R.layout.left,null);
        ListView  lv= (ListView) vv.findViewById(R.id.lvleft);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Fragright ff= (Fragright) manager.findFragmentByTag("right");
                ff.setTv(arr[position]);

            }
        });
        return vv;

    }
}
