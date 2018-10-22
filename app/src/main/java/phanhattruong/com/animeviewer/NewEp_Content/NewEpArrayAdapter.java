package phanhattruong.com.animeviewer.NewEp_Content;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import phanhattruong.com.animeviewer.AnimeInfo;
import phanhattruong.com.animeviewer.R;

/**
 * Created by admin on 21/10/2018.
 */

public class NewEpArrayAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    private ArrayList<AnimeInfo> arrAni;

    public NewEpArrayAdapter(Context context, int resource, ArrayList<AnimeInfo> objects) {
        super(context, resource, (List) objects);
        this.context = context;
        this.resource = resource;
        this.arrAni = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lv_item_new_ep, parent, false);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.lvitem_update_icon);
            viewHolder.tvChap = (TextView) convertView.findViewById(R.id.lvitem_update_chaper);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.lvitem_update_name);
            viewHolder.tvViews = (TextView) convertView.findViewById(R.id.lvitem_update_views);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        AnimeInfo info = arrAni.get(position);

        Bitmap icon = null;
        loadImageTask loadImageTasktask = new loadImageTask(icon);
        loadImageTasktask.execute(info.getImageSource());

        viewHolder.tvName.setText(info.getTitle());
        viewHolder.tvViews.setText(info.getViews());
        viewHolder.tvChap.setText(info.getChap());

        try {
            loadImageTasktask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        viewHolder.imageView.setImageBitmap(icon);


        return super.getView(position, convertView, parent);


    }

    class ViewHolder {
        ImageView imageView;
        TextView tvName, tvChap, tvViews;
    }


}

class loadImageTask extends AsyncTask<String, Void, Void> {

    Bitmap bm = null;

    public loadImageTask(Bitmap rootBm) {
        this.bm = rootBm;
    }


    @Override
    protected Void doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoInput(true);
            InputStream inputStream = con.getInputStream();
            bm = BitmapFactory.decodeStream(inputStream);
        } catch (Exception e) {

        }

        return null;
    }

}
