package com.example.myhindi;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
  private MediaPlayer mediaPlayer;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.word_list);
    final ArrayList<Word> words = new ArrayList<>();
    words.add(new Word("tum kahaan ja rahe ho?", "Where are you going?", R.raw.where_are_you_going));
    words.add(new Word("tumhaara naam kya he?", "What is your name?", R.raw.what_is_your_name));
    words.add(new Word("mera naam hai...", "My name is...", R.raw.my_name_is));
    words.add(new Word("aap kaisa mahasoos kar rahe hain?", "How are you feeling?", R.raw.how_are_you_feeling));
    words.add(new Word("main achchha mahasoos kar raha hoon.", "I’m feeling good.", R.raw.i_am_feeling_good));
    words.add(new Word("kya tum aa rahe ho?", "Are you coming?", R.raw.are_you_coming));
    words.add(new Word("haan, main aa raha hoon", "Yes, I’m coming.", R.raw.yes_i_am_coming));
    words.add(new Word("main aa raha hoon.", "I’m coming.", R.raw.i_am_coming));
    words.add(new Word("chalie chalate hain", "Let’s go.", R.raw.lets_go));
    words.add(new Word("yahaan aao.", "Come here.", R.raw.come_here));

    WordAdapter adapter = new WordAdapter(this,0,words, R.color.category_phrases);
    ListView list = findViewById(R.id.listView);
    list.setAdapter(adapter);

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Word word = words.get(position);
        releaseMediaPlayer();
        mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
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
