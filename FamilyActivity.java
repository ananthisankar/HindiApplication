package com.example.myhindi;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
private MediaPlayer mediaPlayer;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.word_list);
    final ArrayList<Word> words = new ArrayList<>();
    words.add(new Word("pita","father", R.drawable.family_father, R.raw.father));
    words.add(new Word("maa","mother", R.drawable.family_mother, R.raw.mother));
    words.add(new Word("beta","son", R.drawable.family_son, R.raw.son));
    words.add(new Word("betee","daughter", R.drawable.family_daughter, R.raw.daughter));
    words.add(new Word("bada bhaee","older brother", R.drawable.family_older_brother, R.raw.older_brother));
    words.add(new Word("chhota bhaee","younger brother", R.drawable.family_younger_brother, R.raw.younger_brother));
    words.add(new Word("badee bahan","older sister", R.drawable.family_older_sister, R.raw.older_sister));
    words.add(new Word("chhotee bahan","younger sister", R.drawable.family_younger_sister, R.raw.younger_sister));
    words.add(new Word("daadee ma","grandmother", R.drawable.family_grandmother, R.raw.grandmother));
    words.add(new Word("daada","grandfather", R.drawable.family_grandfather, R.raw.grandfather));

    WordAdapter adapter = new WordAdapter(this,  0, words, R.color.category_family);
    ListView list = findViewById(R.id.listView);
    list.setAdapter(adapter);

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Word word = words.get(position);
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
        mediaPlayer.start(); mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
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
