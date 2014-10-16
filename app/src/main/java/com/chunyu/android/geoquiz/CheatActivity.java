package com.chunyu.android.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by wangchenlong on 14-10-14.
 */
public class CheatActivity extends Activity {

    private static final String TAG_IS_SHOW_ANSWER = "isShowAnswer";

    public static final String EXTRA_ANSWER_IS_TRUE =
            "com.chunyu.android.qeoquiz.answer_is_true";

    public static final String EXTRA_ANSWER_SHOWN =
            "com.chunyu.android.qeoquiz.answer_show";

    private boolean mAnswerIsTrue;
    private boolean mIsShowAnswer = false;

    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private TextView mApiView;

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setAnswerShownResult(false);

        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);

        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }
                mIsShowAnswer = true;
                setAnswerShownResult(mIsShowAnswer);
            }
        });

        if (savedInstanceState != null) {
            mIsShowAnswer = savedInstanceState.getBoolean(TAG_IS_SHOW_ANSWER, false);
        }

        if (mIsShowAnswer) {
            if (mAnswerIsTrue) {
                mAnswerTextView.setText(R.string.true_button);
            } else {
                mAnswerTextView.setText(R.string.false_button);
            }
            setAnswerShownResult(mIsShowAnswer);
        }

        mApiView = (TextView)findViewById(R.id.showApiLevel);
        mApiView.setText("API level"+Build.VERSION.SDK_INT);

    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(TAG_IS_SHOW_ANSWER, mIsShowAnswer);
    }
}
