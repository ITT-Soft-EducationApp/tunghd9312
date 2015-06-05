package itp.android.educationapp.fragment;

import itp.android.educationapp.R;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class TuVanFragment extends Fragment {
	TabHost mTabHost;
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        mTabHost = (TabHost)rootView.findViewById(android.R.id.tabhost);
        setupTab(new TextView(getActivity()), "Q&A");
        setupTab(new TextView(getActivity()), "Tu van nghe nghiep");
        setupTab(new TextView(getActivity()), "TU van tuyen sinh");
          
        return rootView;
    }
    private void setupTab(final View view, final String tag) {
        View tabview = createTabView(mTabHost.getContext(), tag);
            TabSpec setContent = mTabHost.newTabSpec(tag).setIndicator(tabview).setContent(new TabContentFactory() {
            public View createTabContent(String tag) {return view;}
        });
        mTabHost.addTab(setContent);
    }
    private static View createTabView(final Context context, final String text) {
        View view = LayoutInflater.from(context).inflate(R.layout.tuvan_tab_bg, null);
        TextView tv = (TextView) view.findViewById(R.id.tabsText);
        tv.setText(text);
        return view;
    }

}