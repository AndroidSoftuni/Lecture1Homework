package homework.softuni.buttoncounter;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    int     counterImplicid;
    int     counterExplicid;
    boolean isClicked;

    Button   buttonExplicid;
    Button   buttonOne;
    Button   buttonTwo;
    Button   buttonThree;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterImplicid = 0;
        counterExplicid = 0;

        buttonOne      = (Button) findViewById(R.id.button_one);
        buttonTwo      = (Button) findViewById(R.id.button_two);
        buttonThree    = (Button) findViewById(R.id.button_three);
        buttonExplicid = (Button) findViewById(R.id.button_explicit);

        textView = (TextView) findViewById(R.id.textView);

        buttonExplicid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Button)view).setText(String.valueOf(++counterExplicid));
            }
        });

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonThree.setOnClickListener(this);

    }

    public void increment(View view) {
        ((Button)view).setText(String.valueOf(++counterImplicid));
    }

    @Override
    public void onClick(final View button) {
//        check if button is pressed already
        if (isClicked){
//            remove clickListener - click on textView is only permitted if button id is shown
            textView.setOnClickListener(null);
            textView.setText(String.valueOf(((Button)button).getText()));
            isClicked = false;
        }else {
            isClicked = true;
            textView.setText(String.valueOf(button.getId()));
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                    intent.putExtra("componentId",String.valueOf(button.getId()));
                    intent.putExtra("componentName",String.valueOf(((Button)button).getText()));
                    startActivity(intent);
                }
            });
        }
    }
}
