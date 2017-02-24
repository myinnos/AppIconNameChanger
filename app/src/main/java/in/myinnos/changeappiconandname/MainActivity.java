package in.myinnos.changeappiconandname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import in.myinnos.library.AppIconNameChanger;

public class MainActivity extends AppCompatActivity {

    Button btSettings, btMessage, btCamera;
    String activeName;
    List<String> disableNames = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btSettings = (Button) findViewById(R.id.btSettings);
        btMessage = (Button) findViewById(R.id.btMessage);
        btCamera = (Button) findViewById(R.id.btCamera);

        btSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activeName = "in.myinnos.changeappiconandname.MainActivity-settings";
                disableNames.add("in.myinnos.changeappiconandname.MainActivity-message");
                disableNames.add("in.myinnos.changeappiconandname.MainActivity-camera");
                setAppIcon(activeName, disableNames);
            }
        });

        btMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeName = "in.myinnos.changeappiconandname.MainActivity-message";
                disableNames.add("in.myinnos.changeappiconandname.MainActivity-camera");
                disableNames.add("in.myinnos.changeappiconandname.MainActivity-settings");
                setAppIcon(activeName, disableNames);
            }
        });

        btCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activeName = "in.myinnos.changeappiconandname.MainActivity-camera";
                disableNames.add("in.myinnos.changeappiconandname.MainActivity-message");
                disableNames.add("in.myinnos.changeappiconandname.MainActivity-settings");
                setAppIcon(activeName, disableNames);
            }
        });

    }

    public void setAppIcon(String activeName, List<String> disableNames) {

        new AppIconNameChanger.Builder(MainActivity.this)
                .activeName(activeName) // String
                .disableNames(disableNames) // List<String>
                .packageName(BuildConfig.APPLICATION_ID)
                .build()
                .setNow();
    }
}
