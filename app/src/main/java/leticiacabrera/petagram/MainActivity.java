package leticiacabrera.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout srlMyIndicatorRefresh;
    ListView lvMyList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAB();

        srlMyIndicatorRefresh = (SwipeRefreshLayout) findViewById(R.id.srlMyIndicatorRefresh);
        lvMyList = (ListView) findViewById(R.id.lvMyList);


        String[] planets = getResources().getStringArray(R.array.planets);
        lvMyList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets));

        srlMyIndicatorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            }
        });
    }

    public void refreshingContent() {
        String[] planets = getResources().getStringArray(R.array.planets);
        lvMyList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets));
        srlMyIndicatorRefresh.setRefreshing(false);
    }

    public void agregarFAB(){
        FloatingActionButton miFAB = (FloatingActionButton) findViewById(R.id.buttonFloating);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getResources().getString(R.string.message), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.text_action), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR", "Click in Snackbar");
                            }
                        })
                        .show();

            }
        });
    }
}