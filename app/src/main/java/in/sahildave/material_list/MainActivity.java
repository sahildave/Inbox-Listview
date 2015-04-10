package in.sahildave.material_list;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import in.sahildave.material_list.dummy.DummyContent;

public class MainActivity extends ActionBarActivity implements MaterialListFragment.OnFragmentInteractionListener {

    private MaterialListFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            fragment = new MaterialListFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(DummyContent.DummyItem item) {
    }

    @Override
    public void onBackPressed() {
        if(DummyContent.isAnyItemSelected) {
            DummyContent.isAnyItemSelected = false;
            fragment.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }
}
