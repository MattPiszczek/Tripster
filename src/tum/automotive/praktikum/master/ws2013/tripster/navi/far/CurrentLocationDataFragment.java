package tum.automotive.praktikum.master.ws2013.tripster.navi.far;


import tum.automotive.praktikum.master.ws2013.tripster.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CurrentLocationDataFragment extends Fragment{
	
	public CurrentLocationDataFragment() {}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_current_location_data,
				container, false);
		return rootView;
	}

}
