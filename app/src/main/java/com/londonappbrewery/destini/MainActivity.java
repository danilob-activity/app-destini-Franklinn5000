package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
public class MainActivity extends AppCompatActivity {

    TextView mStoryTextView;
    Button mAnswerTop;
    Button mAnswerBottom;

    private Answer mT1_AnsTop= new Answer(R.string.T1_Ans1);
    private Answer mT1_AnsBot = new Answer(R.string.T1_Ans2);
    private Answer mT2_AnsTop= new Answer(R.string.T2_Ans1);
    private Answer mT2_AnsBot = new Answer(R.string.T2_Ans2);
    private Answer mT3_AnsTop= new Answer(R.string.T3_Ans1);
    private Answer mT3_AnsBot = new Answer(R.string.T3_Ans2);

    private Story mT1 = new Story(R.string.T1_Story);
    private Story mT2 = new Story(R.string.T2_Story);
    private Story mT3 = new Story(R.string.T3_Story);

    private Story mT4 = new Story(R.string.T4_End);
    private Story mT5 = new Story(R.string.T5_End);
    private Story mT6 = new Story(R.string.T6_End);

    private Story mStorySelected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //TODO: Faça o link do layout com a activity
        mStoryTextView = findViewById(R.id.storyTextView);
        mAnswerTop = findViewById(R.id.AnswerTop);
        mAnswerBottom = findViewById(R.id.AnswerBottom);

        //TODO:faça o mapeamento da história
        mT1.setAnswerTop(mT1_AnsTop);
        mT1.setAnswerBottom(mT1_AnsBot);
        mT2.setAnswerTop(mT2_AnsTop);
        mT2.setAnswerBottom(mT2_AnsBot);
        mT3.setAnswerTop(mT3_AnsTop);
        mT3.setAnswerBottom(mT3_AnsBot);

        mT1_AnsTop.setChildStory(mT3);
        mT1_AnsBot.setChildStory(mT2);
        mT2_AnsTop.setChildStory(mT3);
        mT2_AnsBot.setChildStory(mT4);
        mT3_AnsTop.setChildStory(mT6);
        mT3_AnsBot.setChildStory(mT5);

        if(savedInstanceState!=null){
            mStorySelected = (Story) savedInstanceState.getSerializable("StoryKey");
            mStoryTextView.setText(mStorySelected.getStoryID());
            if (mStorySelected.getAnswerTop() == null) {
                mAnswerTop.setVisibility(View.GONE);
                mAnswerBottom.setVisibility(View.GONE);

            }else{

                mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
                mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());


            }
        }else{
            mStorySelected = mT1;
            mStoryTextView.setText(mStorySelected.getStoryID());
            mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
            mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
        }


        mStorySelected = mT1;


        mStoryTextView.setText(mStorySelected.getStoryID());
        mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());
        mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());



        // TODO: Coloque o evento do click do botão, caso precise colocar a visibilidade no botão invisivel utilize a função
        // do botão setVisibility(View.GONE):
    }





    public void clickTop(View view) {
        mStorySelected = mStorySelected.getAnswerTop().getChildStory();
        mStoryTextView.setText(mStorySelected.getStoryID());


        if (mStorySelected.getAnswerTop() == null) {
            mAnswerTop.setVisibility(View.GONE);
            mAnswerBottom.setVisibility(View.GONE);

        }else{

            mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
            mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());


        }
    }

    public void clickBottom(View view) {

        mStorySelected = mStorySelected.getAnswerBottom().getChildStory();
        mStoryTextView.setText(mStorySelected.getStoryID());


        if (mStorySelected.getAnswerTop() == null) {
            mAnswerTop.setVisibility(View.GONE);
            mAnswerBottom.setVisibility(View.GONE);

        }else{

            mAnswerTop.setText(mStorySelected.getAnswerTop().getAnswerID());
            mAnswerBottom.setText(mStorySelected.getAnswerBottom().getAnswerID());


        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("StoryKey",mStorySelected);
    }


}
