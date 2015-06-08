package itp.android.educationapp;

import itp.android.educationapp.model.Education;
import itp.android.educationapp.utils.Utils;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DanhsachtruongDialog extends Activity {
	Education education;
	WebView webView;
	TextView title, contentTitle, address, callText, emailText, websiteText;
	LinearLayout callLayout, emailLayout, websiteLayout;
	ImageView back, call, email, website;

	long call_value = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.danhsachtruong_dialog_layout);
		education = Utils.getDanhSachTruongModel();

		initViews();

	}

	void initViews() {
		webView = (WebView) findViewById(R.id.danhsachtruong_dialog_webView);
		
		title = (TextView) findViewById(R.id.danhsachtruong_dialog_title);
		address = (TextView) findViewById(R.id.danhsachtruong_dialog_address);
		contentTitle = (TextView) findViewById(R.id.danhsachtruong_dialog_content_title);
		callText = (TextView) findViewById(R.id.danhsachtruong_dialog_callText);
		emailText = (TextView) findViewById(R.id.danhsachtruong_dialog_emailText);
		websiteText = (TextView) findViewById(R.id.danhsachtruong_dialog_websiteText);

		callLayout = (LinearLayout) findViewById(R.id.danhsachtruong_dialog_call);
		emailLayout = (LinearLayout) findViewById(R.id.danhsachtruong_dialog_email);
		websiteLayout = (LinearLayout) findViewById(R.id.danhsachtruong_dialog_website);
		
		back = (ImageView) findViewById(R.id.danhsachtruong_dialog_back);
		call = (ImageView) findViewById(R.id.danhsachtruong_dialog_call_image);
		email = (ImageView) findViewById(R.id.danhsachtruong_dialog_email_image);
		website = (ImageView) findViewById(R.id.danhsachtruong_dialog_website_image);
		
		String s = getResources().getString(R.string.danhsachtruong);
		title.setText(s);
		contentTitle.setText(education.getName());
		address.setText(education.getAddress());
		
		// web
		WebSettings setting = webView.getSettings();
		setting.setMinimumFontSize(25);
		setting.setUseWideViewPort(true);
		setting.setLoadWithOverviewMode(true);
		// setting.setDefaultZoom(ZoomDensity.FAR);
		setting.setBuiltInZoomControls(true);
		setting.setDisplayZoomControls(false);
		setting.setSupportZoom(true);
		setting.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

		String url = "file:///android_asset/AdmissionScore/"
				+ education.getAdmission() + ".htm";
		if (url != "") {
			webView.loadUrl(url);
		}

		// Check values
		String phone = education.getPhone();
		if (phone != "") {
			call_value = Integer.parseInt(phone);
		} else {
			call_value = 0;
		}

		final String email_value = education.getEmail();
		final String website_value = education.getWebsite();
		if (call_value != 0) {
			call.setImageResource(R.drawable.ic_call);
			callText.setTextColor(getResources().getColor(
					R.color.text_color));
		} else {
			call.setImageResource(R.drawable.ic_call_unselected);
			callText.setTextColor(getResources().getColor(
					R.color.text_color_disable));
		}
		if (email_value != "") {
			email.setImageResource(R.drawable.ic_email);
			emailText.setTextColor(getResources().getColor(
					R.color.text_color));
		} else {
			email.setImageResource(R.drawable.ic_email_unselected);
			emailText.setTextColor(getResources().getColor(
					R.color.text_color_disable));
		}
		if (website_value != "") {
			website.setImageResource(R.drawable.ic_website);
			websiteText.setTextColor(getResources().getColor(
					R.color.text_color));
		} else {
			website.setImageResource(R.drawable.ic_website_unselected);
			websiteText.setTextColor(getResources().getColor(
					R.color.text_color_disable));
		}

		// Action
		callLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (call_value != 0) {
					Intent callIntent = new Intent(Intent.ACTION_CALL);
					callIntent.setData(Uri.parse("tel:" + education.getPhone()));
					startActivity(callIntent);
				} else {
					String s = getResources().getString(R.string.error_call);
					Toast.makeText(getApplicationContext(), s,
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		emailLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (email_value != "") {
					Intent emailIntent = new Intent(
							android.content.Intent.ACTION_SEND);

					/* Fill it with Data */
					emailIntent.setType("plain/text");
					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
							new String[] { education.getEmail() });
					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
							"Subject");
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
							"Text");

					/* Send it off to the Activity-Chooser */
					startActivity(Intent.createChooser(emailIntent,
							"Send mail..."));
				} else {
					String s = getResources().getString(R.string.error_email);
					Toast.makeText(getApplicationContext(), s,
							Toast.LENGTH_SHORT).show();
				}

			}
		});
		websiteLayout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (website_value != "") {
					Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
							.parse(website_value));
					startActivity(browserIntent);
				} else {
					String s = getResources().getString(R.string.error_website);
					Toast.makeText(getApplicationContext(), s,
							Toast.LENGTH_SHORT).show();
				}

			}
		});
		
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
}