package com.example.pms_client;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FavoriteAdapter extends BaseAdapter {

    private Context context;
    private int layoutId;
    private FavoriteListItem[] favoriteList;

    public FavoriteAdapter(Context context, int layoutId, FavoriteListItem[] favoriteList) {

        this.context = context;
        this.layoutId = layoutId;
        this.favoriteList = favoriteList;
    }

    @Override
    public int getCount() {
        return favoriteList.length;
    }

    @Override
    public Object getItem(int i) {
        return favoriteList[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {

            LayoutInflater layout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layout.inflate(layoutId, viewGroup, false);
        }

        ((TextView)view.findViewById(R.id.avatar_nickname)).setText(favoriteList[i].getName());
        ((TextView)view.findViewById(R.id.favorite_item_name)).setText(favoriteList[i].getName());
        ((TextView)view.findViewById(R.id.mobile_phone)).setText(favoriteList[i].getMobilePhone());
        ((TextView)view.findViewById(R.id.office_phone)).setText(favoriteList[i].getOfficePhone());

        return view;
    }
}
