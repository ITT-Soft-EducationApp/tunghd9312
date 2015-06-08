package itp.android.educationapp.fragment;

import itp.android.educationapp.R;
import itp.android.educationapp.TinTuyenSinhDialog;
import itp.android.educationapp.adapter.TinTuyenSinhAdapter;
import itp.android.educationapp.model.News;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TinTuyenSinhFragment extends Fragment {
    
	ListView top1View, listView;
	GridView top4View;
	ArrayList<News> top4, list, top1;
	TinTuyenSinhAdapter top4_adapter, list_adapter;
	//
	ImageView top1_image, top4_image_1, top4_image_2, top4_image_3, top4_image_4;
	TextView top1_content, top4_content, top4_content_2, top4_content_3, top4_content_4;
	
    public TinTuyenSinhFragment(){
    	
    }
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_tintuyensinh, container, false);
        addedFixedData();
        
        View header = getActivity().getLayoutInflater().inflate(R.layout.tintuyensinh_header, null);
        
        listView = (ListView)rootView.findViewById(R.id.fragment_tintuyensinh_list);
      
        listView.addHeaderView(header);
        list_adapter = new TinTuyenSinhAdapter(getActivity(), R.layout.item_tintuyensinh_list, list);
        listView.setAdapter(list_adapter);
        
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				int position = pos -1;
				TinTuyenSinhDialog dialog = new TinTuyenSinhDialog(getActivity(), list.get(position));
				dialog.doNothing();
			}
		});
        initHeaderViews(rootView);
        return rootView;
    }
    
    void initHeaderViews(View header){
//    	View header = getActivity().getLayoutInflater().inflate(R.layout.tintuyensinh_header, null);
    	top1_image = (ImageView)header.findViewById(R.id.tintuyensinh_top1_image);
    	top4_image_1 = (ImageView)header.findViewById(R.id.tintuyensinh_top4_image1);
    	top4_image_2 = (ImageView)header.findViewById(R.id.tintuyensinh_top4_image2);
    	top4_image_3 = (ImageView)header.findViewById(R.id.tintuyensinh_top4_image3);
    	top4_image_4 = (ImageView)header.findViewById(R.id.tintuyensinh_top4_image4);
    	
    	top1_content = (TextView)header.findViewById(R.id.tintuyensinh_top1_title1);
    	top4_content = (TextView)header.findViewById(R.id.tintuyensinh_top4_title1);
    	top4_content_2 = (TextView)header.findViewById(R.id.tintuyensinh_top4_title2);
    	top4_content_3 = (TextView)header.findViewById(R.id.tintuyensinh_top4_title3);
    	top4_content_4 = (TextView)header.findViewById(R.id.tintuyensinh_top4_title4);
    	
    	top1_image.setImageResource(top1.get(0).getUrl_image());
    	top1_content.setText(top1.get(0).getName());
    	top1_image.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				TinTuyenSinhDialog dialog = new TinTuyenSinhDialog(getActivity(), top1.get(0));
				dialog.doNothing();
			}
		});
    	top4_image_1.setImageResource(top4.get(0).getUrl_image());
    	top4_content.setText(top4.get(0).getName());
    	top4_image_1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				TinTuyenSinhDialog dialog = new TinTuyenSinhDialog(getActivity(), top4.get(0));
				dialog.doNothing();
			}
		});
    	top4_image_2.setImageResource(top4.get(1).getUrl_image());
    	top4_content_2.setText(top4.get(1).getName());
    	top4_image_2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				TinTuyenSinhDialog dialog = new TinTuyenSinhDialog(getActivity(), top4.get(1));
				dialog.doNothing();
			}
		});
    	top4_image_3.setImageResource(top4.get(2).getUrl_image());
    	top4_content_3.setText(top4.get(2).getName());
    	top4_image_3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				TinTuyenSinhDialog dialog = new TinTuyenSinhDialog(getActivity(), top4.get(2));
				dialog.doNothing();
			}
		});
    	top4_image_4.setImageResource(top4.get(3).getUrl_image());
    	top4_content_4.setText(top4.get(3).getName());
    	top4_image_4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				TinTuyenSinhDialog dialog = new TinTuyenSinhDialog(getActivity(), top4.get(3));
				dialog.doNothing();
			}
		});
    }
    
    void addedFixedData(){
    	top1 = new ArrayList<News>();
    	top4 = new ArrayList<News>();
    	list = new ArrayList<News>();
    	String content = getActivity().getResources().getString(R.string.content);
    	String content1 = getActivity().getResources().getString(R.string.content1);
    	String content2 = content + content1;
    	News n1 = new News(0, "Color in material design is inspired by bold hues juxtaposed with muted environments, deep shadows", content, R.drawable.beutiful_girl_1, 1, "02/06/2015 12:14");
    	top4.add(n1);
    	News n2 = new News(0, "Material takes cues from contemporary architecture, road signs, pavement marking tape, and athletic courts", content1,  R.drawable.beutiful_girl_2, 1,"02/06/2015 12:14");
    	top4.add(n2);
    	News n3 = new News(0, "Color should be unexpected and vibrant.", content2,  R.drawable.beutiful_girl_3, 1,"02/06/2015 12:14");
    	top4.add(n3);
    	News n4 = new News(0, "This color palette comprises primary and accent colors that can be used for illustration or to develop your brand colors.", content1,  R.drawable.beutiful_girl_4, 1,"02/06/2015 12:14");
    	top4.add(n4);
    	News n41 = new News(0, "This color palette comprises primary and accent colors that can be used for illustration or to develop your brand colors.", content1,  R.drawable.beutiful_girl_5, 1,"02/06/2015 12:14");
    	top1.add(n41);
    	
    	
    	News l1 = new News(0, "Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1 Hot Girl No1", content, R.drawable.beutiful_girl_1, 0, "02/06/2015 12:14");
    	list.add(l1);
    	News l2 = new News(0, "Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2 Hot Girl No2", content,  R.drawable.beutiful_girl_2, 0, "01/06/2015 05:14");
    	list.add(l2);
    	News l3 = new News(0, "Hot Girl No6", content,  R.drawable.beutiful_girl_3, 0, "04/06/2015 22:24");
    	list.add(l3);
    	News l4 = new News(0, "Hot Girl No7", content2,  R.drawable.beutiful_girl_4, 0, "05/06/2015 08:56");
    	list.add(l4);
    	News l9 = new News(0, "Hot Girl No8", content1,  R.drawable.beutiful_girl_5, 0, "02/06/2015 12:14");
    	list.add(l9);
    	list.add(n1);
    	list.add(n2);
    	list.add(n3);
    	list.add(n4);
    	
    	News l5 = new News(0, "Hot Girl No9", content2, R.drawable.beutiful_girl_1, 0,"02/06/2015 12:14");
    	list.add(l5);
    	News l6 = new News(0, "Hot Girl No10", content1,  R.drawable.beutiful_girl_2, 0,"02/06/2015 12:14");
    	list.add(l6);
    	News l7 = new News(0, "Hot Girl No11", content2,  R.drawable.beutiful_girl_3, 0,"02/06/2015 12:14");
    	list.add(l7);
    	News l8 = new News(0, "Hot Girl No12", content,  R.drawable.beutiful_girl_4, 0,"02/06/2015 12:14");
    	list.add(l8);
    	News l10 = new News(0, "Hot Girl No13", content1,  R.drawable.beutiful_girl_5, 0,"02/06/2015 12:14");
    	list.add(l10);
    	
    	News l15 = new News(0, "Hot Girl No9", content1, R.drawable.beutiful_girl_1, 0,"02/06/2015 12:14");
    	list.add(l15);
    	News l16 = new News(0, "Hot Girl No10", content,  R.drawable.beutiful_girl_2, 0,"02/06/2015 12:14");
    	list.add(l16);
    	News l17 = new News(0, "Hot Girl No11", content2,  R.drawable.beutiful_girl_3, 0,"02/06/2015 12:14");
    	list.add(l17);
    	News l18 = new News(0, "Hot Girl No12", content,  R.drawable.beutiful_girl_4, 0,"02/06/2015 12:14");
    	list.add(l18);
    	News l19 = new News(0, "Hot Girl No13", content2,  R.drawable.beutiful_girl_5, 0,"02/06/2015 12:14");
    	list.add(l19);
    	
    	
    }
}