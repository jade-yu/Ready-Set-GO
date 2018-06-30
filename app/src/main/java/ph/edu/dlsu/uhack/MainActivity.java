package ph.edu.dlsu.uhack;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.pbready);
        Drawable drawable2 = res.getDrawable(R.drawable.pbset);
        Drawable drawable3 = res.getDrawable(R.drawable.pbgo);

        final ProgressBar pbReady = findViewById(R.id.pbready);
        final ProgressBar pbSet = findViewById(R.id.pbset);
        final ProgressBar pbGo = findViewById(R.id.pbgo);

        pbReady.setProgress(0);
        pbReady.setSecondaryProgress(100);
        pbReady.setMax(100);
        pbReady.setProgressDrawable(drawable);

        pbSet.setProgress(0);
        pbSet.setSecondaryProgress(100);
        pbSet.setMax(100);
        pbSet.setProgressDrawable(drawable2);

        pbGo.setProgress(0);
        pbGo.setSecondaryProgress(100);
        pbGo.setMax(100);
        pbGo.setProgressDrawable(drawable3);

        btnTest = findViewById(R.id.btntest);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // placeholder only
                // TODO actual implementation
                pbReady.incrementProgressBy(5);
                pbSet.incrementProgressBy(10);
                pbGo.incrementProgressBy(15);
            }
        });
    }

}
