package itp.android.educationapp.adapter;

import itp.android.educationapp.R;
import itp.android.educationapp.model.News;

import java.util.ArrayList;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TinTuyenSinhAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<News> data;
	int resource;

	public TinTuyenSinhAdapter(Context context, int resource, ArrayList<News> data) {
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
		News news = data.get(pos);
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(resource, parent, false);
		}
		if(resource == R.layout.item_tintuyensinh_list){
			TextView time = (TextView)convertView.findViewById(R.id.tintuyensinh_item_time);
			time.setText(news.getCreated_at());
			
		}

		ImageView image = (ImageView) convertView
				.findViewById(R.id.tintuyensinh_item_image);
		TextView title = (TextView) convertView
				.findViewById(R.id.tintuyensinh_item_title);
		title.setText(news.getName());
		
		image.setImageResource(news.getUrl_image());

//		String imageUrl = news.getUrl_image();
//		if (!imageUrl.startsWith("http://") && !imageUrl.startsWith("https://"))
//			imageUrl = "http://" + imageUrl;
//		if (imageUrl != "http://") {
//			Picasso.with(context).load(imageUrl)
//					.placeholder(R.drawable.no_image)
//					.error(R.drawable.no_image).into(image, new Callback() {
//
//						@Override
//						public void onSuccess() {
//						}
//
//						@Override
//						public void onError() {
//						}
//					});
//		}
		
		

		return convertView;
	}
}
