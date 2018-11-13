package fauzi.hilmy.app20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    public static String EXTRA_VIDEO = "extraVideo";
    VideoView videoView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        int video = getIntent().getIntExtra(EXTRA_VIDEO, 0);
        mediaController = new MediaController(this);
        videoView = findViewById(R.id.videoo);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + video);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

    }
}
