package itp.android.educationapp.fragment;

import itp.android.educationapp.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NhungDieuCanBietFragment extends Fragment {
    
    public NhungDieuCanBietFragment(){}
     
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
  
        View rootView = inflater.inflate(R.layout.tuvan_tab2, container, false);
          
        return rootView;
    }
}