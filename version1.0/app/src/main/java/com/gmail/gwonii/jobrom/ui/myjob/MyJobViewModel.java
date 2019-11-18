package com.gmail.gwonii.jobrom.ui.myjob;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyJobViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyJobViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
