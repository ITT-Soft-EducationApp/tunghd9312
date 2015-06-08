package itp.android.educationapp.adapter;

import itp.android.educationapp.R;
import itp.android.educationapp.model.Education;
import itp.android.educationapp.model.Help;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TuVanAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<Help> data;
	int resource;

	public TuVanAdapter(Context context, int resource,
			ArrayList<Help> data) {
		this.context = context;
		this.resource = resource;
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int pos) {
		data.get(pos);
		return null;
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		Help help = data.get(pos);
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(resource, parent, false);
		}

		ImageView image = (ImageView) convertView
				.findViewById(R.id.tuvan_item_image);
		TextView title = (TextView) convertView
				.findViewById(R.id.tuvan_item_title);
		title.setText(help.getName());
		int url_image = context.getResources().getIdentifier(
				"drawable/" + "ic_" + help.getId(), null,
				context.getPackageName());

		image.setImageResource(url_image);

		return convertView;
	}

	void setImageIcon(Education data) {
		String area = data.getArea();
		if (area.contains("HaNoi")) {

		}
	}
}
