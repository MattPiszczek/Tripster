package tum.automotive.praktikum.master.ws2013.tripster.navi.menu;


import tum.automotive.praktikum.master.ws2013.tripster.R;
import tum.automotive.praktikum.master.ws2013.tripster.navi.far.NaviFarActivity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class NavigateWithMapsAPIDevActivity extends FragmentActivity {
	
	 public final static String EXTRA_BOOLEAN = "tum.automotive.praktikum.master.ws2013.tripster.BOOLEAN";
	 private boolean navigate;
	 private boolean naviWithoutAR;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigate_with_maps_apidev);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.navigate_with_maps_apidev, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(
					R.layout.fragment_navigate_with_maps_apidev, container,
					false);
			return rootView;
		}
	}
	
	public void onClickNaviWithoutAR(View v) {
		Toast.makeText(this, "NaviWithoutAR", Toast.LENGTH_SHORT).show();
		naviWithoutAR = true;
	}
	
	public void onClickHpbfAsTarget(View v) {
		Toast.makeText(this, "Go to Hpbf Munich", Toast.LENGTH_SHORT).show();
		Intent intentOpenGoogleNavi = new Intent(this, NaviFarActivity.class);
		navigate = true;
		intentOpenGoogleNavi.putExtra(EXTRA_BOOLEAN, navigate);
		startActivity(intentOpenGoogleNavi);
	}
	
	public void onClickLocationAsTarget(View v) {
		Intent intentNaviFarActivity = new Intent(this, NaviFarActivity.class);
		navigate = false;
		intentNaviFarActivity.putExtra(EXTRA_BOOLEAN, navigate);
		startActivity(intentNaviFarActivity);
	}

}
