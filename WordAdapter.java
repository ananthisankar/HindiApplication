import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hephzibah.list.R;
import com.example.hephzibah.list.Word;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

  private int mColorResourceId;

  public WordAdapter(Context context, int resource, ArrayList<Word> words) {
    super(context, resource, words);
  }

  public WordAdapter(Context context, int resource, ArrayList<Word> words, int mColorResourceId) {
    super(context, resource, words);
    this.mColorResourceId = mColorResourceId;
  }

  public int getmColorResourceId() {
    return mColorResourceId;
  }

  @Override
  public View getView(int position,  View convertView, ViewGroup parent) {

    if(convertView == null){
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
    }

    Word currentWord = getItem(position);

    TextView hindi = convertView.findViewById(R.id.hindi);
    TextView english = convertView.findViewById(R.id.english);
    ImageView imageIcon = convertView.findViewById(R.id.imageIcon);

    hindi.setText(currentWord.getmHindiTranslation());
    english.setText(currentWord.getmEnglishTranslation());

    if(currentWord.hasImage()) {
      imageIcon.setImageResource(currentWord.getmImageResourceId());
      imageIcon.setVisibility(View.VISIBLE);
    }
    else
    {
      imageIcon.setVisibility(View.GONE);
    }

    View textHolder = convertView.findViewById(R.id.ll_textHolder);
    int color = ContextCompat.getColor(getContext(), getmColorResourceId());
    textHolder.setBackgroundColor(color);

    return convertView;


  }
}
