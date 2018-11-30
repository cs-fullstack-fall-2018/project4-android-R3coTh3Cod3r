package com.example.student.andriod_project_4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityAdapter extends ArrayAdapter<String> {

    String[] names;
    int[] menus;
    Context mContext;

    public ActivityAdapter(Context context, String[] menuNames, int[] menuOptions) {
        super(context, R.layout.listview_item);
        this.names = menuNames;
        this.menus = menuOptions;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return names.length;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mMenu = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        } else{
            mViewHolder = (ViewHolder)convertView.getTag();
        }
            mViewHolder.mMenu.setImageResource(menus[position]);
            mViewHolder.mName.setText((names[position]));


        return convertView;
    }

    static class ViewHolder{
        ImageView mMenu;
        TextView mName;
    }
}
