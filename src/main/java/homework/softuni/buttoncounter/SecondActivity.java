package homework.softuni.buttoncounter;

import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textViewComponentId;
    TextView textViewComponentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewComponentId   = (TextView) findViewById(R.id.textView_component_id);
        textViewComponentName = (TextView) findViewById(R.id.textView_component_name);

        textViewComponentId.setText(getIntent().getStringExtra("componentId"));
        textViewComponentName.setText(getIntent().getStringExtra("componentName"));
    }
}
