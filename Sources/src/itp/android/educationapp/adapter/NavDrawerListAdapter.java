package itp.android.educationapp.adapter;

import itp.android.educationapp.R;
import itp.android.educationapp.model.NavDrawer;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class NavDrawerListAdapter extends BaseAdapter {
     
    private Context context;
    private ArrayList<NavDrawer> navDrawerItems;
     
    public NavDrawerListAdapter(Context context, ArrayList<NavDrawer> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }
 
    @Override
    public int getCount() {
        return navDrawerItems.size();
    }
 
    @Override
    public Object getItem(int position) {       
        return navDrawerItems.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }
          
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.drawer_icon);
        TextView text = (TextView) convertView.findViewById(R.id.drawer_text);
        TextView title = (TextView) convertView.findViewById(R.id.drawer_title);
        TextView version = (TextView) convertView.findViewById(R.id.drawer_version);
          
        imgIcon.setImageResource(navDrawerItems.get(position).getIcon());        
        text.setText(navDrawerItems.get(position).getText());
        
        View indicator = (View)convertView.findViewById(R.id.drawer_indicator);
        if(navDrawerItems.get(position).isTitle()){
        	indicator.setVisibility(View.VISIBLE);
        	title.setVisibility(View.VISIBLE);
        	title.setText(navDrawerItems.get(position).getTitle());
        }else{
        }
        //
        if(navDrawerItems.get(position).isFinal()){
//        	version.setVisibility(View.VISIBLE);
//        	String ver = context.getResources().getString(R.string.version);
//        	version.setText(ver);
        }else{
        }
        return convertView;
    }
 
}