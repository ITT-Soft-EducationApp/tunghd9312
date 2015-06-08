package itp.android.educationapp;

import itp.android.educationapp.model.Help;
import itp.android.educationapp.utils.Utils;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class TuVanDialog extends Activity {
	Help help;
	TextView content;
	ImageView back;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tuvan_dialog_layout_1);
		help = Utils.getTuVanModel();

		initViews();

	}

	void initViews() {
		content = (TextView) findViewById(R.id.tuvan_dialog_content);
		content.setText(help.getContent());
		
		back = (ImageView) findViewById(R.id.tuvan_dialog_back);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}
}