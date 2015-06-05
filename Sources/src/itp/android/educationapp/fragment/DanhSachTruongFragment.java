package itp.android.educationapp.fragment;

import itp.android.educationapp.R;
import itp.android.educationapp.adapter.DanhSachTruongAdapter;
import itp.android.educationapp.model.Education;

import java.util.ArrayList;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class DanhSachTruongFragment extends Fragment {
	// 0 ten truong, 1 khu vuc, 2 ma truong
	boolean checked = true, checked_1 = false, checked_2 = false;
	LinearLayout checkLayout, checkLayout_1, checkLayout_2;
	ImageView checkImage, checkImage_1, checkImage_2;
	Button refresh;
	EditText input;
	
	ArrayList<Education> data;

	public DanhSachTruongFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_danhsachtruong,
				container, false);
		addedFixedData();
		
		ListView listView = (ListView)rootView.findViewById(R.id.fragment_danhsachtruong_list);
		listView.setAdapter(new DanhSachTruongAdapter(getActivity(), R.layout.danhsachtruong_item, data));
		
		initViews(rootView);
		return rootView;
	}
	
	void addedFixedData(){
		data = new ArrayList<Education>();
		Education edu = new Education(0, "Truong Dai hoc Cong nghe Ha Noi", "DHCN", "hanoi", "", "", 0, 0);
		data.add(edu);
		Education edu1 = new Education(0, "Truong Dai hoc Cong nghe Ho Chi Minh", "CNHCM", "hcm", "", "", 0, 0);
		data.add(edu1);
		Education edu2 = new Education(0, "Truong Dai hoc Y duoc Ha Long", "YDHL", "halong", "", "", 0, 0);
		data.add(edu2);
		Education edu3 = new Education(0, "Truong Dai hoc giao thong van tai Gia Lai", "GTVT", "gialai", "", "", 0, 0);
		data.add(edu3);
		Education edu4 = new Education(0, "Truong Cao dang San khau va dien anh Lang Son", "SKVDA", "langson", "", "", 0, 0);
		data.add(edu4);
		Education edu5 = new Education(0, "Truong Dai hoc Cong nghe Ha Noi", "DHCN", "hanoi", "", "", 0, 0);
		data.add(edu5);
		Education edu6 = new Education(0, "Truong Dai hoc Cong nghe Ho Chi Minh", "CNHCM", "hcm", "", "", 0, 0);
		data.add(edu6);
		Education edu7 = new Education(0, "Truong Dai hoc Y duoc Ha Long", "YDHL", "halong", "", "", 0, 0);
		data.add(edu7);
		Education edu8 = new Education(0, "Truong Dai hoc giao thong van tai Gia Lai", "GTVT", "gialai", "", "", 0, 0);
		data.add(edu8);
		Education edu9 = new Education(0, "Truong Cao dang San khau va dien anh Lang Son", "SKVDA", "langson", "", "", 0, 0);
		data.add(edu9);
		Education edu10 = new Education(0, "Truong Dai hoc Cong nghe Ha Noi", "DHCN", "hanoi", "", "", 0, 0);
		data.add(edu10);
		Education edu11 = new Education(0, "Truong Dai hoc Cong nghe Ho Chi Minh", "CNHCM", "hcm", "", "", 0, 0);
		data.add(edu11);
		Education edu12 = new Education(0, "Truong Dai hoc Y duoc Ha Long", "YDHL", "halong", "", "", 0, 0);
		data.add(edu12);
		Education edu13 = new Education(0, "Truong Dai hoc giao thong van tai Gia Lai", "GTVT", "gialai", "", "", 0, 0);
		data.add(edu13);
		Education edu14 = new Education(0, "Truong Cao dang San khau va dien anh Lang Son", "SKVDA", "langson", "", "", 0, 0);
		data.add(edu14);
		Education edu15 = new Education(0, "Truong Dai hoc Cong nghe Ha Noi", "DHCN", "hanoi", "", "", 0, 0);
		data.add(edu15);
		Education edu16 = new Education(0, "Truong Dai hoc Cong nghe Ho Chi Minh", "CNHCM", "hcm", "", "", 0, 0);
		data.add(edu16);
		Education edu17 = new Education(0, "Truong Dai hoc Y duoc Ha Long", "YDHL", "halong", "", "", 0, 0);
		data.add(edu17);
		Education edu18 = new Education(0, "Truong Dai hoc giao thong van tai Gia Lai", "GTVT", "gialai", "", "", 0, 0);
		data.add(edu18);
		Education edu19 = new Education(0, "Truong Cao dang San khau va dien anh Lang Son", "SKVDA", "langson", "", "", 0, 0);
		data.add(edu19);
		
    }

	void initViews(View rootView) {
		checkLayout = (LinearLayout) rootView
				.findViewById(R.id.fragment_danhsachtruong_check_layout);
		refresh = (Button)rootView.findViewById(R.id.fragment_danhsachtruong_refresh);
		refresh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getActivity(), "Refreshed ", 200).show();
			}
		});
		checkImage = (ImageView) rootView
				.findViewById(R.id.fragment_danhsachtruong_check_image);

		checkLayout_1 = (LinearLayout) rootView
				.findViewById(R.id.fragment_danhsachtruong_check_layout_1);
		checkImage_1 = (ImageView) rootView
				.findViewById(R.id.fragment_danhsachtruong_check_image_1);

		checkLayout_2 = (LinearLayout) rootView
				.findViewById(R.id.fragment_danhsachtruong_check_layout_2);
		checkImage_2 = (ImageView) rootView
				.findViewById(R.id.fragment_danhsachtruong_check_image_2);

		input = (EditText) rootView
				.findViewById(R.id.fragment_danhsachtruong_input);
		checkLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (!checked) {
					checkLayout
							.setBackgroundResource(R.xml.checkbox_bg_onselected);
					checkImage.setBackgroundColor(Color.parseColor("#F44336"));
					checkImage.setImageResource(R.drawable.ic_check_onselected);
					checked = true;
					checked_1 = false;
					checked_2 = false;
					
					checkLayout_2.setBackgroundResource(R.xml.checkbox_bg);
					checkImage_2.setBackgroundColor(Color.parseColor("#E0E0E0"));
					checkImage_2.setImageResource(R.drawable.ic_check);
					
					checkLayout_1.setBackgroundResource(R.xml.checkbox_bg);
					checkImage_1.setBackgroundColor(Color.parseColor("#E0E0E0"));
					checkImage_1.setImageResource(R.drawable.ic_check);
					
					String s = getActivity().getResources().getString(
							R.string.tentruong);
					input.setHint(s);
				}
			}
		});
		checkLayout_1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (!checked_1) {
					checkLayout_1
							.setBackgroundResource(R.xml.checkbox_bg_onselected);
					checkImage_1.setBackgroundColor(Color.parseColor("#F44336"));
					checkImage_1
							.setImageResource(R.drawable.ic_check_onselected);
					checked_1 = true;
					checked_2 = false;
					checked = false;
					
					checkLayout.setBackgroundResource(R.xml.checkbox_bg);
					checkImage.setBackgroundColor(Color.parseColor("#E0E0E0"));
					checkImage.setImageResource(R.drawable.ic_check);
					
					checkLayout_2.setBackgroundResource(R.xml.checkbox_bg);
					checkImage_2.setBackgroundColor(Color.parseColor("#E0E0E0"));
					checkImage_2.setImageResource(R.drawable.ic_check);
					
					String s = getActivity().getResources().getString(
							R.string.khuvuc);
					input.setHint(s);
					
				}
			}
		});
		checkLayout_2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (!checked_2) {
					checkLayout_2
							.setBackgroundResource(R.xml.checkbox_bg_onselected);
					checkImage_2.setBackgroundColor(Color.parseColor("#F44336"));
					checkImage_2
							.setImageResource(R.drawable.ic_check_onselected);
					
					checked_1 = false;
					checked_2 = true;
					checked = false;
					
					checkLayout.setBackgroundResource(R.xml.checkbox_bg);
					checkImage.setBackgroundColor(Color.parseColor("#E0E0E0"));
					checkImage.setImageResource(R.drawable.ic_check);
					
					checkLayout_1.setBackgroundResource(R.xml.checkbox_bg);
					checkImage_1.setBackgroundColor(Color.parseColor("#E0E0E0"));
					checkImage_1.setImageResource(R.drawable.ic_check);
					
					String s = getActivity().getResources().getString(
							R.string.matruong);
					input.setHint(s);
				}
			}
		});

	}
}