

package com.github.yuanxia.colorpicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;


class SavedState extends View.BaseSavedState {
    int color;
    boolean isBrightnessGradient;

    SavedState(Parcelable superState) {
        super(superState);
    }

    private SavedState(Parcel in) {
        super(in);
        color = in.readInt();
        isBrightnessGradient = in.readInt() == 1;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeInt(color);
        out.writeInt(isBrightnessGradient ? 1 : 0);
    }

    public static final Creator<SavedState> CREATOR =
            new Creator<SavedState>() {
                public SavedState createFromParcel(Parcel in) {
                    return new SavedState(in);
                }

                public SavedState[] newArray(int size) {
                    return new SavedState[size];
                }
            };

}
