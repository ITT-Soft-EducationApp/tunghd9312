package itp.android.educationapp.fragment;

import itp.android.educationapp.R;
import itp.android.educationapp.adapter.TinTuyenSinhAdapter;
import itp.android.educationapp.model.News;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

public class TinTuyenSinhFragment extends Fragment {
    
	ListView top1View, listView;
	GridView top4View;
	ArrayList<News> top4, list;
	TinTuyenSinhAdapter top4_adapter, list_adapter;
	
    public TinTuyenSinhFragment(){
    	
    }
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_tintuyensinh, container, false);
        addedFixedData();
        
//        View top4_rootView = inflater.inflate(R.layout.tintuyensinh_item_header, container, false);
        View header = getActivity().getLayoutInflater().inflate(R.layout.tintuyensinh_header, null);
//        top4View = (GridView)header.findViewById(R.id.fragment_tintuyensinh_top4);
//        top4_adapter = new TinTuyenSinhAdapter(getActivity(), R.layout.tintuyensinh_top4, top4);
//        top4View.setAdapter(top4_adapter);
        
        listView = (ListView)rootView.findViewById(R.id.fragment_tintuyensinh_list);
      
        listView.addHeaderView(header);
        list_adapter = new TinTuyenSinhAdapter(getActivity(), R.layout.tintuyensinh_list, list);
        listView.setAdapter(list_adapter);
        
        return rootView;
    }
    
    void addedFixedData(){
    	top4 = new ArrayList<News>();
    	list = new ArrayList<News>();
    	News n1 = new News(0, "Hot Girl No1", " Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1", R.drawable.beutiful_girl_1, 1, "");
    	top4.add(n1);
    	News n2 = new News(0, "Hot Girl No2", " Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2",  R.drawable.beutiful_girl_2, 1,"");
    	top4.add(n2);
    	News n3 = new News(0, "Hot Girl No2", "Hot Girl No3",  R.drawable.beutiful_girl_3, 1,"");
    	top4.add(n3);
    	News n4 = new News(0, "Hot Girl No3", "Hot Girl No4",  R.drawable.beutiful_girl_4, 1,"");
    	top4.add(n4);
    	Log.d("ToanNM", "top4 size : " + top4.size());
    	
    	News l1 = new News(0, "Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1", "", R.drawable.beutiful_girl_1, 0, "02/06/2015 12:14");
    	list.add(l1);
    	News l2 = new News(0, "Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2", "",  R.drawable.beutiful_girl_2, 0, "01/06/2015 05:14");
    	list.add(l2);
    	News l3 = new News(0, "Hot Girl No6", "Hot Girl No3",  R.drawable.beutiful_girl_3, 0, "04/06/2015 22:24");
    	list.add(l3);
    	News l4 = new News(0, "Hot Girl No7", "Hot Girl No4",  R.drawable.beutiful_girl_4, 0, "05/06/2015 08:56");
    	list.add(l4);
    	News l9 = new News(0, "Hot Girl No8", "Hot Girl No4",  R.drawable.beutiful_girl_5, 0, "02/06/2015 12:14");
    	list.add(l9);
    	
    	News l5 = new News(0, "Hot Girl No9", "Hot Girl No1", R.drawable.beutiful_girl_1, 0,"02/06/2015 12:14");
    	list.add(l5);
    	News l6 = new News(0, "Hot Girl No10", "Hot Girl No2",  R.drawable.beutiful_girl_2, 0,"02/06/2015 12:14");
    	list.add(l6);
    	News l7 = new News(0, "Hot Girl No11", "Hot Girl No3",  R.drawable.beutiful_girl_3, 0,"02/06/2015 12:14");
    	list.add(l7);
    	News l8 = new News(0, "Hot Girl No12", "Hot Girl No4",  R.drawable.beutiful_girl_4, 0,"02/06/2015 12:14");
    	list.add(l8);
    	News l10 = new News(0, "Hot Girl No13", "Hot Girl No4",  R.drawable.beutiful_girl_5, 0,"02/06/2015 12:14");
    	list.add(l10);
    	
    	News l15 = new News(0, "Hot Girl No9", "Hot Girl No1", R.drawable.beutiful_girl_1, 0,"02/06/2015 12:14");
    	list.add(l15);
    	News l16 = new News(0, "Hot Girl No10", "Hot Girl No2",  R.drawable.beutiful_girl_2, 0,"02/06/2015 12:14");
    	list.add(l16);
    	News l17 = new News(0, "Hot Girl No11", "Hot Girl No3",  R.drawable.beutiful_girl_3, 0,"02/06/2015 12:14");
    	list.add(l17);
    	News l18 = new News(0, "Hot Girl No12", "Hot Girl No4",  R.drawable.beutiful_girl_4, 0,"02/06/2015 12:14");
    	list.add(l18);
    	News l19 = new News(0, "Hot Girl No13", "Hot Girl No4",  R.drawable.beutiful_girl_5, 0,"02/06/2015 12:14");
    	list.add(l19);
    	
    	
    }
}