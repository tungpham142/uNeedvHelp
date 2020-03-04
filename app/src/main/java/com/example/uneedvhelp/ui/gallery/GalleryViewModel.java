package com.example.uneedvhelp.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

  //  private MutableLiveData<String> mText, mText2;

    public GalleryViewModel() {
       /* mText = new MutableLiveData<>();
        mText2 = new MutableLiveData<>();
        mText.setValue("Receive Notifications");
        mText2.setValue("Notifications Sound");*/
    }

    public LiveData<String> getText() {
        // return mText,mText2;
        return null;
    }
}