package phanhattruong.com.animeviewer.NewEp_Content;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import phanhattruong.com.animeviewer.AnimeInfo;
import phanhattruong.com.animeviewer.AnimeViewActivity;
import phanhattruong.com.animeviewer.NewEp_Content.LoadNewEptAsyncTask;
import phanhattruong.com.animeviewer.R;

/**
 * Created by admin on 19/10/2018.
 */

public class Tab_NewEp extends Fragment {

    ListView listView;
    Activity context;

    public Tab_NewEp(Activity context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tab_newepisode, container, false);

        listView = (ListView) view.findViewById(R.id.lvnewep);

        LoadNewEptAsyncTask loadNewEptAsyncTask = (LoadNewEptAsyncTask) new LoadNewEptAsyncTask(
                new LoadNewEptAsyncTask.AsyncReponse() {
                    @Override
                    public void processfinish(ArrayList<AnimeInfo> AniList) {
                        Log.d("Tab_new","Recive Anilist "+ AniList.size()+" element" );
                        NewEpArrayAdapter adapter = new NewEpArrayAdapter(context,R.layout.lv_item_new_ep,AniList);
                        listView.setAdapter(adapter);
                    }
                }
        ).execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AnimeInfo item = (AnimeInfo) listView.getItemAtPosition(i);
                Toast.makeText(context,item.getTitle(),Toast.LENGTH_SHORT).show();
                Intent itent = new Intent(getContext(),AnimeViewActivity.class);
                getContext().startActivity(itent);
            }
        });

        return view;
    }



}





