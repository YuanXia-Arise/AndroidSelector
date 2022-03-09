

package com.github.yuanxia.calendarpicker.core;

import android.content.Context;
import android.widget.TextView;

/**
 * @author liyuj
 * @since 2022/1/5 16:03
 */
public interface ItemViewProvider {

    TextView provideTitleView(Context context);

    MonthView provideMonthView(Context context);

}
