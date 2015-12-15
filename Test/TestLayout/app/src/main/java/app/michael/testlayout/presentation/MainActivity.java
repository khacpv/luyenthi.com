package app.michael.testlayout.presentation;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridViewAdapter;
import com.wefika.flowlayout.FlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app.michael.testlayout.R;
import app.michael.testlayout.presentation.question.model.DemoItem;
import app.michael.testlayout.presentation.question.model.GridCell;
import app.michael.testlayout.presentation.question.model.GridObject;
import app.michael.testlayout.presentation.question.model.QuestionEntity;
import app.michael.testlayout.presentation.question.model.TestModel;
import app.michael.testlayout.presentation.question.view.adapter.DemoAdapter;
import app.michael.testlayout.presentation.question.view.component.PlaceSpan;
import io.github.kexanie.library.MathView;

public class MainActivity extends AppCompatActivity {
    private FlowLayout flowLayout;

    private Content content;

    private MathView webView;

    private TextView firstView,secondView;

    private List<Integer> places = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        places.add(3);
        places.add(13);
        places.add(24);

        flowLayout = (FlowLayout)findViewById(R.id.flowLayout);

        webView = (MathView)findViewById(R.id.webview);

        webView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                flowLayout.removeViewAt(13);
                View newView = makePlace(new Word(1,"$$x = {-b \\pm \\sqrt{b^2-4ac} \\over 2a}.$$"));

                flowLayout.addView(newView,13);

                newView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        flowLayout.removeViewAt(13);
                        View newView = makePlace(new Word(2,"..............."));

                        flowLayout.addView(newView,13);

                        webView.setVisibility(View.VISIBLE);

                        return  true;
                    }
                });

                v.setVisibility(View.GONE);

                return  true;
            }
        });

        firstView =  (TextView)findViewById(R.id.firstView);

        secondView =  (TextView)findViewById(R.id.secondView);

        content = new Content();

        // build flow layout
        buildFlowLayout();

    }

    private void buildFlowLayout() {
        for (Word word : content.getWords()) {

            View view = makePlace(word);

            flowLayout.addView(view);
        }
    }

    private View makePlace(Word word) {

        if(word.getType()==0) {

            TextView text = new TextView(getApplicationContext());
            text.setTextColor(Color.BLACK);

            text.setText(word.getValue());

            FlowLayout.LayoutParams layoutParams = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT, FlowLayout.LayoutParams.WRAP_CONTENT);
            text.setLayoutParams(layoutParams);

            return  text;

        } else if(word.getType()==1) {
            MathView mathView =new MathView(getApplicationContext(),null);

            mathView.setEngine(MathView.Engine.MATHJAX);

            mathView.setText(word.getValue());

            FlowLayout.LayoutParams layoutParams = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT, FlowLayout.LayoutParams.WRAP_CONTENT);

            mathView.setLayoutParams(layoutParams);

            return mathView;
        } else  {
            TextView text = new TextView(getApplicationContext());
            text.setTextColor(Color.BLUE);

            text.setText(word.getValue());

            FlowLayout.LayoutParams layoutParams = new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT, FlowLayout.LayoutParams.WRAP_CONTENT);
            text.setLayoutParams(layoutParams);

            return  text;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onLastClick(View view) {
        flowLayout.removeViewAt(24);
        View newView = makePlace(new Word(2,"Two"));

        flowLayout.addView(newView, 24);

        view.setVisibility(View.GONE);

        newView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowLayout.removeViewAt(24);
                View newView = makePlace(new Word(2,"............."));

                flowLayout.addView(newView,24);

                secondView.setVisibility(View.VISIBLE);
            }
        });
    }
    public void onFirstClick(View view) {
        flowLayout.removeViewAt(3);
        View newView = makePlace(new Word(2,"One"));

        flowLayout.addView(newView, 3);

        view.setVisibility(View.GONE);


        newView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flowLayout.removeViewAt(3);
                View newView = makePlace(new Word(2, "............."));

                flowLayout.addView(newView, 3);

                firstView.setVisibility(View.VISIBLE);
            }
        });
    }
}
