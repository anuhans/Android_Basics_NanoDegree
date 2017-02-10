package com.example.rishabhgoyal.news;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<News>> {
    private static final String NEWS_URL = "http://content.guardianapis.com/search?q=debate|tag=economy/economy&show-fields=trailText&from-date=2017-01-01&api-key=test";;
    private static final int LOADER = 0;
    private static final String LOG = "MainActivity.LOG_TAG";
    private static final int DELAY = 30000;

    private Adapter Adatper;
    private ListView mListView;
    private ArrayList<News> mNews;
    private TextView mText;
    private SwipeRefreshLayout mSwipeLayout;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNews = new ArrayList<>();

        Adatper = new Adapter(this, mNews);
        mListView = (ListView) findViewById(R.id.list_view);
        mText = (TextView) findViewById(R.id.no_data);
        mText.setVisibility(View.GONE);
        mListView.setAdapter(Adatper);
        mSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);

        mSwipeLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.i(LOG, "onRefresh called from SwipeRefreshLayout");

                        // This method performs the refresh operation.
                        refresh();
                    }
                }
        );

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String url = mNews.get(position).getMlink();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        mHandler.post(runnableCode);
    }

    private void refresh() {
        if (isNetworkConnected()) {
            mSwipeLayout.post(new Runnable() {
                @Override
                public void run() {
                    mSwipeLayout.setRefreshing(true);
                }
            });

            mHandler.removeCallbacks(runnableCode);
            // Prepare the loader.  Either re-connect with an existing one,
            // or start a new one.
            getSupportLoaderManager().initLoader(LOADER, null, this).forceLoad();
        } else {
            mText.setText(R.string.device_not_connected);
            mText.setVisibility(View.VISIBLE);
        }
    }

    private boolean isNetworkConnected() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    private Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            // Do something here on the main thread
            Log.d("Handlers", "Called on main thread");
            refresh();
            mHandler.postDelayed(runnableCode, DELAY);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        refresh();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<ArrayList<News>> onCreateLoader(int id, Bundle args) {
        switch (id) {
            case LOADER:
                // Returns a new Loader
                Log.d(LOG, "onCreateLoader");
                return new ListLoader(this);
            default:
                // An invalid id was passed in
                return null;
        }
    }
    public static class ListLoader extends AsyncTaskLoader<ArrayList<News>> {
        public ListLoader(Context context) {
            super(context);
        }


        @Override
        public ArrayList<News> loadInBackground() {
            Log.d(LOG, "loadInBackground");
            return fetch.News(NEWS_URL);
        }
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<News>> loader, ArrayList<News> data) {

        mSwipeLayout.setRefreshing(false);
        mNews.clear();
        if (data != null) {
            mNews.addAll(data);
        }
        Adatper.notifyDataSetChanged();
        if (mNews.size() == 0) {
            mText.setText(R.string.no_data_available);
            mText.setVisibility(View.VISIBLE);
        } else {
            mText.setVisibility(View.GONE);
        }

        mHandler.postDelayed(runnableCode, DELAY);

    }

    @Override
    public void onLoaderReset(Loader<ArrayList<News>> loader) {
        Log.d(LOG,"Refresh");

    }


}
