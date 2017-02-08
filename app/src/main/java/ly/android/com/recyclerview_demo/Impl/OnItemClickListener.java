package ly.android.com.recyclerview_demo.Impl;

import android.view.View;

/**
 * Created by 409165 on 2017/2/8.
 */
public interface OnItemClickListener {
    void onItemClick(View view, int position);
    void onItemLongClick(View view , int position);
  }
