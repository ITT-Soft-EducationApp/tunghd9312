package itp.android.educationapp.fragment;

import itp.android.educationapp.R;
import itp.android.educationapp.TuVanDialog;
import itp.android.educationapp.adapter.TuVanAdapter;
import itp.android.educationapp.model.Help;
import itp.android.educationapp.utils.Utils;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class TuVanFragment extends Fragment {

	ListView included_tab1;
	TextView tab1, tab2, tab3;
	LinearLayout included_tab2, included_tab3, tabLayout;
	TuVanAdapter adapter;
	ArrayList<Help> data;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		addFixedData();
		View rootView = inflater.inflate(R.layout.fragment_tuvan, container,
				false);
		initViews(inflater, rootView, container);
		return rootView;
	}

	void initViews(LayoutInflater inflater, View rootView, ViewGroup container) {

		tab1 = (TextView) rootView.findViewById(R.id.fragment_tuvan_tab1);
		tab2 = (TextView) rootView.findViewById(R.id.fragment_tuvan_tab2);
		tab3 = (TextView) rootView.findViewById(R.id.fragment_tuvan_tab3);
		included_tab1 = (ListView) rootView
				.findViewById(R.id.fragment_tuvan_included_tab1);
		included_tab2 = (LinearLayout) rootView
				.findViewById(R.id.fragment_tuvan_included_tab2);
		included_tab3 = (LinearLayout) rootView
				.findViewById(R.id.fragment_tuvan_included_tab3);
		tabLayout = (LinearLayout) rootView
				.findViewById(R.id.fragment_tuvan_tab_layout);

		adapter = new TuVanAdapter(getActivity(), R.layout.item_tuvan, data);
		included_tab1.setAdapter(adapter);
		included_tab1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				Utils.saveTuVanModel(data.get(pos));
				Intent intent = new Intent(getActivity(), TuVanDialog.class);
				startActivity(intent);
			}
		});

		tab1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				included_tab1.setVisibility(View.VISIBLE);
				included_tab2.setVisibility(View.GONE);
				included_tab3.setVisibility(View.GONE);
				tab1.setBackgroundColor(getResources().getColor(
						R.color.bg_white_50));
				tab2.setBackgroundColor(getResources()
						.getColor(R.color.bg_null));
				tab3.setBackgroundColor(getResources()
						.getColor(R.color.bg_null));
			}
		});
		tab2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				included_tab2.setVisibility(View.VISIBLE);
				included_tab1.setVisibility(View.GONE);
				included_tab3.setVisibility(View.GONE);

				tab2.setBackgroundColor(getResources().getColor(
						R.color.bg_white_50));
				tab1.setBackgroundColor(getResources()
						.getColor(R.color.bg_null));
				tab3.setBackgroundColor(getResources()
						.getColor(R.color.bg_null));
			}
		});
		tab3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				included_tab3.setVisibility(View.VISIBLE);
				included_tab1.setVisibility(View.GONE);
				included_tab2.setVisibility(View.GONE);

				tab3.setBackgroundColor(getResources().getColor(
						R.color.bg_white_50));
				tab2.setBackgroundColor(getResources()
						.getColor(R.color.bg_null));
				tab1.setBackgroundColor(getResources()
						.getColor(R.color.bg_null));
			}
		});
	}

	void addFixedData() {
		data = new ArrayList<Help>();
		String content = getActivity().getResources().getString(
				R.string.tuvan_content);
		String name = getActivity().getResources().getString(
				R.string.tuvan_name);
		for (int i = 1; i <= 50; i++) {
			Help help = new Help(i, name, content);
			data.add(help);
		}

	}

}