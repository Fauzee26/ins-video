package fauzi.hilmy.app20;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    final String[] nama = new String[]{
            "Animation short film  ' A love story '", "2D Animated Short Film 'GRAVITY'- BEAUTIFUL Love Story. Family Animation by Ailin Liu", "CGI  Animated Short HD- Multiple Award-Winning 'HEART' by  Erick Oh", "Changing Batteries - The Saddest Story 3D Animation", "Destiny - Animation Short", "Emotional Award Winning Animated Short", "Father- World's Best inspirational Video Ever", "Oktapodi (2007) - Oscar 2009 Animated Short Film"
    };
    Context context;

    final int[] video = {R.raw.love, R.raw.gravity, R.raw.heart, R.raw.chang, R.raw.destiny, R.raw.emotional, R.raw.father, R.raw.oktapodi};
    ListView listView;
//    VideoView videoView;
//    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Video.class);
                intent.putExtra(Video.EXTRA_VIDEO, video[position]);
                startActivity(intent);
            }
        });
    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return nama.length;
        }

        @Override
        public Object getItem(int position) {
            return nama[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.adapter, null);
            final TextView textView = view.findViewById(R.id.namaVideo);
            textView.setText(nama[position]);

            return view;
        }
    }
}