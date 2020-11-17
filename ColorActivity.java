package com.example.myhindi;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
  private MediaPlayer mediaPlayer;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.word_list);

    final ArrayList<Word> words = new ArrayList<Word>();
    words.add(new Word("laal","red",R.drawable.color_red, R.raw.red));
    words.add(new Word("hara","green", R.drawable.color_green, R.raw.green));
    words.add(new Word("bhoora","brown", R.drawable.color_brown, R.raw.brown));
    words.add(new Word("dhoosar","gray", R.drawable.color_gray, R.raw.gray));
    words.add(new Word("kaalee","black", R.drawable.color_black, R.raw.black));
    words.add(new Word("saphed","white", R.drawable.color_white, R.raw.white));
    words.add(new Word("dhool bhara peela ","dusty yellow", R.drawable.color_dusty_yellow, R.raw.dusty_yellow));
    words.add(new Word("sarason ka peela","mustard_yellow", R.drawable.color_mustard_yellow, R.raw.mustard_yellow));

    WordAdapter adapter = new WordAdapter(this,0, words, R.color.category_colors);
    ListView list = findViewById(R.id.listView);
    list.setAdapter(adapter);

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Word word = words.get(position);
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
          @Override public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
          }
        });
      }
    });
  }
  @Override protected void onStop() {
    super.onStop();
    releaseMediaPlayer();
  }

  private void releaseMediaPlayer(){
    if(mediaPlayer != null){
      mediaPlayer.release();
      mediaPlayer = null;
    }
  }
}
