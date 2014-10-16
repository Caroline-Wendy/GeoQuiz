package com.chunyu.android.geoquiz;

/**
 * Created by wangchenlong on 14-10-13.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(final int question) {
        mQuestion = question;
    }

    public void setTrueQuestion(final boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

    public TrueFalse (int question, boolean trueQuestion) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }
}
