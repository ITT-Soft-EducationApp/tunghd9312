package itp.android.educationapp;

import itp.android.educationapp.model.News;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TinTuyenSinhDialog {
	Context context;
	News news;
	LinearLayout sdt_lay, email_lay, website_lay;
	
	
	public TinTuyenSinhDialog(Context context, News news) {
		this.context = context;
		this.news = news;
		showDialog();
	}
	
	public void doNothing(){
		// nothing to do here
	}

	private void showDialog() {
		Rect displayRectangle = new Rect();
		Window window = ((Activity) context).getWindow();
		window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

		LayoutInflater inflater = LayoutInflater.from(context);
		View layout = inflater.inflate(R.layout.tintuyensinh_dialog_layout, null);
		layout.setMinimumWidth((int) (displayRectangle.width() * 0.9f));
		layout.setMinimumHeight((int) (displayRectangle.height() * 0.9f));

		TextView title = (TextView) layout.findViewById(R.id.tintuyensinh_dialog_title);
		String s = context.getResources().getString(R.string.tintuyensinh);
		title.setText(s);
		TextView title_content = (TextView) layout.findViewById(R.id.tintuyensinh_dialog_title_1);
		title_content.setText(news.getName());
		TextView content = (TextView) layout.findViewById(R.id.tintuyensinh_dialog_content);
		content.setText(news.getContent());
		sdt_lay = (LinearLayout) layout.findViewById(R.id.tintuyensinh_dialog_content_layout);
		final ImageView image = (ImageView) layout.findViewById(R.id.tintuyensinh_dialog_image);
		final LinearLayout loadingImage = (LinearLayout) layout
				.findViewById(R.id.tintuyensinh_dialog_loadingImage);
		image.setImageResource(news.getUrl_image());

//		String imageUrl = news.getUrl_image();
//		if (!imageUrl.startsWith("http://") && !imageUrl.startsWith("https://"))
//			imageUrl = "http://" + imageUrl;
//		Picasso.with(context)
//		.load(imageUrl)
//		.placeholder(R.drawable.no_image)
//		.error(R.drawable.no_image)
//		.into(dImage, new Callback() {
//
//			@Override
//			public void onSuccess() {
//				loadingImage.setVisibility(View.INVISIBLE);
//				dImage.setVisibility(View.VISIBLE);
//
//			}
//
//			@Override
//			public void onError() {
//				loadingImage.setVisibility(View.INVISIBLE);
//				dImage.setVisibility(View.VISIBLE);
//			}
//		});
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setView(layout);
		builder.setCancelable(true);

		final AlertDialog alertDialog = builder.show();
		ImageView btnBack = (ImageView) layout.findViewById(R.id.tintuyensinh_dialog_back);
		btnBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				alertDialog.dismiss();
			}
		});
	}
}
