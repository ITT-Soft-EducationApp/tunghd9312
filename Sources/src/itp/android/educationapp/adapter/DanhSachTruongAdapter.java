package itp.android.educationapp.adapter;

import itp.android.educationapp.R;
import itp.android.educationapp.model.Education;
import itp.android.educationapp.model.News;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DanhSachTruongAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<Education> data;
	int resource;

	public DanhSachTruongAdapter(Context context, int resource,
			ArrayList<Education> data) {
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
		Education edu = data.get(pos);
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(resource, parent, false);
		}

		ImageView image = (ImageView) convertView
				.findViewById(R.id.danhsachtruong_item_image);
		TextView title = (TextView) convertView
				.findViewById(R.id.danhsachtruong_item_title);
		TextView code = (TextView) convertView
				.findViewById(R.id.danhsachtruong_item_code);
		code.setText(edu.getCode());
		title.setText(edu.getName());
		int url_image = context.getResources().getIdentifier(
				"drawable/" + "area_" + edu.getArea(), null,
				context.getPackageName());

		// int image_url = R.drawable.area_" + edu.getArea();"
		image.setImageResource(url_image);

		// String imageUrl = news.getUrl_image();
		// if (!imageUrl.startsWith("http://") &&
		// !imageUrl.startsWith("https://"))
		// imageUrl = "http://" + imageUrl;
		// if (imageUrl != "http://") {
		// Picasso.with(context).load(imageUrl)
		// .placeholder(R.drawable.no_image)
		// .error(R.drawable.no_image).into(image, new Callback() {
		//
		// @Override
		// public void onSuccess() {
		// }
		//
		// @Override
		// public void onError() {
		// }
		// });
		// }

		return convertView;
	}

	void setImageIcon(Education data) {
		String area = data.getArea();
		if (area.contains("HaNoi")) {

		}
	}
}
