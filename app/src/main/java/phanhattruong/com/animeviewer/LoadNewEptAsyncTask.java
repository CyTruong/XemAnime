package phanhattruong.com.animeviewer;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import java.util.ArrayList;

public class LoadNewEptAsyncTask extends AsyncTask<Void, String, Void> {

    private ArrayList<AnimeInfo> anilist;

    public AsyncReponse delegate = null;

    public LoadNewEptAsyncTask(AsyncReponse asyncReponse) {
        this.delegate = asyncReponse;
    }

    public interface AsyncReponse {
        void processfinish(ArrayList<AnimeInfo> AniList);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://vuighe.net").get();
            Element element = doc.body();
            Node AniNode = element.childNodes().get(3).childNodes().get(7).childNodes().get(3);
            anilist = GetAniInfoInList(AniNode);
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        anilist = new ArrayList<>();
        delegate.processfinish(anilist);
    }

    private ArrayList<AnimeInfo> GetAniInfoInList(Node AnilistNode) {

        ArrayList<AnimeInfo> AniList = new ArrayList<AnimeInfo>();
        for (int i = 0; i < AnilistNode.childNodeSize() / 2; i++) {
            int index = 2 * i + 1;
            Node Ani = AnilistNode.childNode(index);
            Node AniInfo = Ani.childNodes().get(1);
            Node ImgaeSourceNode = AniInfo.childNode(1);
            String ImageSource = ImgaeSourceNode.attributes().get("data-src");
            Node NameChapViews = AniInfo.childNode(3);
            String Chap = NameChapViews.childNode(1).childNode(0).toString();
            String Name = NameChapViews.childNode(3).childNode(1).childNode(0).toString();
            String Views = NameChapViews.childNode(3).childNode(3).childNode(0).toString();
            String Source = AniInfo.attributes().get("href");
            AnimeInfo animeInfo = new AnimeInfo(Name,Chap,"",ImageSource,Views,"null");
            AniList.add(animeInfo);
        }
        return AniList;
    }



}
