package phanhattruong.com.animeviewer;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class AnimeViewActivity extends Activity {

    VideoView videoView;
    String url = "https://scontent.xx.fbcdn.net/v/t42.9040-2/10000000_166552990954108_806433135490236416_n.mp4?_nc_cat=100&efg=eyJybHIiOjE1MDAsInJsYSI6NDA5NiwidmVuY29kZV90YWciOiJzdmVfaGQifQ%3D%3D&rl=1500&vabr=537&_nc_ht=video.fsgn2-4.fna&oh=02b72e2855f288db998700298f06a143&oe=5BD6107F&expire=1540742529";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_view);
        Init();
        LoadVideo();
    }

    private void Init(){
        videoView = (VideoView) findViewById(R.id.videoView);
    }

    private void LoadVideo(){
        String isFullScreen = getIntent().getStringExtra("fullScreenInd");
        if("y".equals(isFullScreen)){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }


        MediaController mediaController = new VideoControler(this);
        
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(url));
        videoView.start();
    }



    private boolean isLandScape(){
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE))
                .getDefaultDisplay();
        int rotation = display.getRotation();

        if (rotation == Surface.ROTATION_90
                || rotation == Surface.ROTATION_270) {
            return true;
        }
        return false;
    }


}
