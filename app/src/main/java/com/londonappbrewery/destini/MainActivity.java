package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView mStoryTextView;
    Button mAnswerTop;
    Button mAnswerBottom;
    // TODO: Declare as variaveis aqui:

    //indice corrente da historia
    private Story mStorySelected;
    private int mStoryIndex;
    private android.os.Bundle outState;

    Answer mT1_Ans1 = new Answer(R.string.T1_Ans1);
    Answer mT2_Ans2 = new Answer(R.string.T1_Ans2);


    Story mt1 = new Story(R.string.T1_Story);
    Story mt2 = new Story(R.string.T2_Story);
    Story mt3 = new Story(R.string.T3_Story);

    Story mt4 = new Story(R.string.T4_End);
    Story mt5 = new Story(R.string.T5_End);
    Story mt6 = new Story(R.string.T6_End);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        {
            super.onSaveInstanceState(outState);
            putInt("StoryKey",mStoryIndex);
        }


            //TODO: Faça o link do layout com a activity
        mStoryTextView = findViewById(R.id.storyTextView);
        mAnswerTop = findViewById(R.id.AnswerTop);
        mAnswerBottom = findViewById(R.id.AnswerBottom);

            //TODO:faça o mapeamento da história

            // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
            // do botão setVisibility(View.GONE):


        }

    private void putInt(String storyKey, int storyIndex) {
    }

}
