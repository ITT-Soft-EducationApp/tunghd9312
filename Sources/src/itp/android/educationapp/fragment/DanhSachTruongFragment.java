package itp.android.educationapp.fragment;

import itp.android.educationapp.DanhsachtruongDialog;
import itp.android.educationapp.R;
import itp.android.educationapp.adapter.DanhSachTruongAdapter;
import itp.android.educationapp.model.Education;
import itp.android.educationapp.utils.Utils;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class DanhSachTruongFragment extends Fragment {
	// 0 ten truong, 1 khu vuc, 2 ma truong
	boolean checked = true, checked_1 = false, checked_2 = false;
	LinearLayout checkLayout, checkLayout_1, checkLayout_2;
	ImageView checkImage, checkImage_1, checkImage_2, refresh;
	ListView listView;
	TextView result;
	EditText input;
	
	ArrayList<Education> data;
	DanhSachTruongAdapter adapter;

	public DanhSachTruongFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_danhsachtruong,
				container, false);
		data = new ArrayList<Education>();
		addedFixedData();

		listView = (ListView) rootView
				.findViewById(R.id.fragment_danhsachtruong_list);
		adapter = new DanhSachTruongAdapter(getActivity(),
				R.layout.item_danhsachtruong, data);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				Utils.saveDanhSachTruongModel(data.get(pos));
				Intent intent = new Intent(getActivity(),
						DanhsachtruongDialog.class);
				startActivity(intent);
			}
		});
		initViews(rootView);
		View v = getActivity().getCurrentFocus();
		if (v != null) {
			InputMethodManager inputManager = (InputMethodManager) getActivity()
					.getSystemService(Context.INPUT_METHOD_SERVICE);
			inputManager.hideSoftInputFromWindow(rootView.getWindowToken(),
					InputMethodManager.HIDE_NOT_ALWAYS);
		}
		return rootView;
	}

	void addedFixedData() {
		String website = "http://google.com.vn";
		String email = "gs.hbsky@gmail.com";
		String phone = "0123456789";

		Education edu = new Education(0, "Truong Dai hoc Cong nghe Ha Noi",
				"DHCN", "hanoi", "1", "So 199 Hoang Hoa Tham", "", email,
				website, 0);
		data.add(edu);
		Education edu1 = new Education(0,
				"Truong Dai hoc Cong nghe Ho Chi Minh", "CNHCM", "hcm", "2",
				"So 9 Cau Giay HaNoi", phone, "", website, 0);
		data.add(edu1);
		Education edu2 = new Education(0, "Truong Dai hoc Y duoc Ha Long",
				"YDHL", "halong", "3", "So 144 Xuan Thuy - Cau Giay HaNoi", "",
				email, website, 0);
		data.add(edu2);
		Education edu3 = new Education(0,
				"Truong Dai hoc giao thong van tai Gia Lai", "GTVT", "gialai",
				"4", "So 122 Xuan Thuy - Cau Giay HaNOi", phone, email, "", 0);
		data.add(edu3);
		Education edu4 = new Education(0,
				"Truong Dai hoc giao thong van tai Gia Lai", "GTVT", "gialai",
				"4", "So 122 Xuan Thuy - Cau Giay HaNOi", "", "", website, 0);
		data.add(edu4);
		Education edu5 = new Education(0, "Truong Dai hoc Cong nghe Ha Noi",
				"DHCN", "hanoi", "1", "So 199 Hoang Hoa Tham", "", "", "", 0);
		data.add(edu5);
		Education edu6 = new Education(0, "Truong Dai hoc Y duoc Ha Long",
				"YDHL", "halong", "3", "So 144 Xuan Thuy - Cau Giay HaNoi",
				phone, email, website, 0);
		data.add(edu6);
		Education edu7 = new Education(0,
				"Truong Dai hoc giao thong van tai Gia Lai", "GTVT", "gialai",
				"4", "So 122 Xuan Thuy - Cau Giay HaNOi", phone, "", "", 0);
		data.add(edu7);
		Education edu8 = new Education(0,
				"Truong Dai hoc Cong nghe Ho Chi Minh", "CNHCM", "hcm", "2",
				"So 9 Cau Giay HaNoi", "", "", website, 0);
		data.add(edu8);
		Education edu9 = new Education(0, "Truong Dai hoc Cong nghe Ha Noi",
				"DHCN", "hanoi", "1", "So 199 Hoang Hoa Tham", phone, "",
				website, 0);
		data.add(edu9);
		Education edu10 = new Education(0,
				"Truong Dai hoc giao thong van tai Gia Lai", "GTVT", "gialai",
				"4", "So 122 Xuan Thuy - Cau Giay HaNOi", "", email, "", 0);
		data.add(edu10);
		Education edu11 = new Education(0, "Truong Dai hoc Cong nghe Ha Noi",
				"DHCN", "hanoi", "1", "So 199 Hoang Hoa Tham", "", "", "", 0);
		data.add(edu11);
		Education edu12 = new Education(0,
				"Truong Dai hoc Cong nghe Ho Chi Minh", "CNHCM", "hcm", "2",
				"So 9 Cau Giay HaNoi", phone, email, website, 0);
		data.add(edu12);
		Education edu13 = new Education(0, "Truong Dai hoc Y duoc Ha Long",
				"YDHL", "halong", "3", "So 144 Xuan Thuy - Cau Giay HaNoi", "",
				email, "", 0);
		data.add(edu13);
		Education edu14 = new Education(0,
				"Truong Dai hoc giao thong van tai Gia Lai", "GTVT", "gialai",
				"4", "So 122 Xuan Thuy - Cau Giay HaNOi", "", "", website, 0);
		data.add(edu14);
		Education edu15 = new Education(0, "Truong Dai hoc Cong nghe Ha Noi",
				"DHCN", "hanoi", "1", "So 199 Hoang Hoa Tham", "", "", "", 0);
		data.add(edu15);
		Education edu16 = new Education(0, "Truong Dai hoc Cong nghe Ha Noi",
				"DHCN", "hanoi", "1", "So 199 Hoang Hoa Tham", phone, email,
				website, 0);
		data.add(edu16);
		Education edu17 = new Education(0,
				"Truong Dai hoc giao thong van tai Gia Lai", "GTVT", "gialai",
				"4", "So 122 Xuan Thuy - Cau Giay HaNOi", phone, "", "", 0);
		data.add(edu17);
		Education edu18 = new Education(0, "Truong Dai hoc Cong nghe Ha Noi",
				"DHCN", "hanoi", "1", "So 199 Hoang Hoa Tham", "", email, "", 0);
		data.add(edu18);
		Education edu19 = new Education(0, "Truong Dai hoc Y duoc Ha Long",
				"YDHL", "halong", "3", "So 144 Xuan Thuy - Cau Giay HaNoi",
				phone, email, website, 0);
		data.add(edu19);

	}

	void initViews(View rootView) {
		result = (TextView) rootView
				.findViewById(R.id.fragment_danhsachtruong_result);
		result.setText("" + data.size());
		checkLayout = (LinearLayout) rootView
				.findViewById(R.id.fragment_danhsachtruong_check_layout);
		refresh = (ImageView) rootView
				.findViewById(R.id.fragment_danhsachtruong_refresh);
		
		refresh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addedFixedData();
				adapter.notifyDataSetChanged();
				result.setText("" + data.size());
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
					checkImage.setBackgroundColor(getResources().getColor(R.color.list_background));
					checkImage.setImageResource(R.drawable.ic_check_onselected);
					checked = true;
					checked_1 = false;
					checked_2 = false;

					checkLayout_2.setBackgroundResource(R.xml.checkbox_bg);
					checkImage_2.setBackgroundColor(getResources().getColor(R.color.list_background_pressed));
					checkImage_2.setImageResource(R.drawable.ic_check);

					checkLayout_1.setBackgroundResource(R.xml.checkbox_bg);
					checkImage_1.setBackgroundColor(getResources().getColor(R.color.list_background_pressed));
					checkImage_1.setImageResource(R.drawable.ic_check);

					String s = getActivity().getResources().getString(
							R.string.tentruong);
					input.setHint(s);
					filter();
				}
			}
		});
		checkLayout_1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (!checked_1) {
					checkLayout_1
							.setBackgroundResource(R.xml.checkbox_bg_onselected);
					checkImage_1.setBackgroundColor(getResources().getColor(R.color.list_background));
					checkImage_1
							.setImageResource(R.drawable.ic_check_onselected);
					checked_1 = true;
					checked_2 = false;
					checked = false;

					checkLayout.setBackgroundResource(R.xml.checkbox_bg);
					checkImage.setBackgroundColor(getResources().getColor(R.color.list_background_pressed));
					checkImage.setImageResource(R.drawable.ic_check);

					checkLayout_2.setBackgroundResource(R.xml.checkbox_bg);
					checkImage_2.setBackgroundColor(getResources().getColor(R.color.list_background_pressed));
					checkImage_2.setImageResource(R.drawable.ic_check);

					String s = getActivity().getResources().getString(
							R.string.khuvuc);
					input.setHint(s);
					filter();
				}
			}
		});
		checkLayout_2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (!checked_2) {
					checkLayout_2
							.setBackgroundResource(R.xml.checkbox_bg_onselected);
					checkImage_2.setBackgroundColor(getResources().getColor(R.color.list_background));
					checkImage_2
							.setImageResource(R.drawable.ic_check_onselected);

					checked_1 = false;
					checked_2 = true;
					checked = false;

					checkLayout.setBackgroundResource(R.xml.checkbox_bg);
					checkImage.setBackgroundColor(getResources().getColor(R.color.list_background_pressed));
					checkImage.setImageResource(R.drawable.ic_check);

					checkLayout_1.setBackgroundResource(R.xml.checkbox_bg);
					checkImage_1.setBackgroundColor(getResources().getColor(R.color.list_background_pressed));
					checkImage_1.setImageResource(R.drawable.ic_check);

					String s = getActivity().getResources().getString(
							R.string.matruong);
					input.setHint(s);
					filter();
				}
			}
		});

		input.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {

			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {

			}

			@Override
			public void afterTextChanged(Editable arg0) {
				filter();
			}
		});

	}

	void filter() {
		String filter = input.getText().toString();
		filter.replaceAll(" ", "");
		filter.trim();
		ArrayList<Education> newData = new ArrayList<Education>();
		if (checked) {
			newData = filterByName(filter, data);
		} else if (checked_1) {
			newData = filterByArea(filter, data);
		} else if (checked_2) {
			newData = filterByCode(filter, data);
		} else if (filter == "") {
			newData = data;
		}
		adapter = new DanhSachTruongAdapter(getActivity(),
				R.layout.item_danhsachtruong, newData);
		adapter.notifyDataSetChanged();
		listView.setAdapter(adapter);
		result.setText("" + newData.size());
		Log.d("ToanNM", "new data size : " + newData.size() + " , filter : " + filter);
	}

	private ArrayList<Education> filterByName(String filter,
			ArrayList<Education> parentData) {
		ArrayList<Education> newData = new ArrayList<Education>();
		if (!parentData.isEmpty()) {
			int max = parentData.size();
			for (int i = 0; i < max; i++) {
				String s = parentData.get(i).getName().toLowerCase();
				s.replace(" ", "");
				if (s.contains(filter.toLowerCase())) {
					newData.add(parentData.get(i));
				}
			}
		}
		return newData;

	}

	private ArrayList<Education> filterByArea(String filter,
			ArrayList<Education> parentData) {
		ArrayList<Education> newData = new ArrayList<Education>();
		if (!parentData.isEmpty()) {
			for (int i = 0; i < parentData.size(); i++) {
				String s = parentData.get(i).getArea().toLowerCase();
				s.replace(" ", "");
				if (s.contains(filter.toLowerCase())) {
					newData.add(parentData.get(i));
				}
			}
		}
		return newData;

	}

	private ArrayList<Education> filterByCode(String filter,
			ArrayList<Education> parentData) {
		ArrayList<Education> newData = new ArrayList<Education>();
		if (!parentData.isEmpty()) {
			for (int i = 0; i < parentData.size(); i++) {
				String s = parentData.get(i).getCode().toLowerCase();
				s.replace(" ", "");
				if (s.contains(filter.toLowerCase())) {
					newData.add(parentData.get(i));
				}
			}
		}
		return newData;

	}
	
	private String getString(String filter) {
        return filter.replaceAll(
                  String.format("%s|%s|%s",
                     "(?<=[A-Z])(?=[a-z])",
                     "(?<=[^A-Z])(?=[A-Z])",
                     "(?<=[A-Za-z])(?=[^A-Za-z])"
                  ),
                  " "
               ).toLowerCase();
            }
}