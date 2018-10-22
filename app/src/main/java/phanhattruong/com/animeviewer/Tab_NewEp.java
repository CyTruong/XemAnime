package phanhattruong.com.animeviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by admin on 19/10/2018.
 */

public class Tab_NewEp extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_newepisode, container, false);

        LoadNewEptAsyncTask loadNewEptAsyncTask = (LoadNewEptAsyncTask) new LoadNewEptAsyncTask(
                new LoadNewEptAsyncTask.AsyncReponse() {
                    @Override
                    public void processfinish(ArrayList<AnimeInfo> AniList) {

                    }
                }
        ).execute();

        return view;
    }

}





