package de.mvo.playground;

import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "PLAYGROUND.EXTRA.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something
        final Intent intent = new Intent(this, DisplayMessageActivity.class);
        final EditText editText = findViewById(R.id.editText);
        final String message = editText.getText().toString();
        // Test Lambdas
        intent.putExtra(EXTRA_MESSAGE, message.isEmpty() ? "Keine Eingabe" : message);
        startActivity(intent);
    }

    public void showUiActivity(View view) {
        startActivity(new Intent(this, UiElementsActivity.class));
    }

    public void showPicturesActivity(View view) {
        startActivity(new Intent(this, PicturesActivity.class));
    }
}
