package myalarm.example.alarmapptest2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText plianText;
    TextView textView;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plianText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        mediaPlayer = MediaPlayer.create(this, R.raw.wryyy);

    }

    public void select(View view){
        try{

            int time = Integer.parseInt(plianText.getText().toString());

            Log.i("time", String.valueOf(time));
            int timeMilliSeconds = time * 1000;
            new CountDownTimer(timeMilliSeconds, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    textView.setText("0.00"+String.valueOf(millisUntilFinished/1000));
                }

                @Override
                public void onFinish() {
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                }
            }.start();
        }catch (NumberFormatException e)
        {
            Toast.makeText(this, "Enter Integear value only", Toast.LENGTH_SHORT).show();
        }
    }

    public void stopAlarm(View view){
        mediaPlayer.stop();
    }
}
