package com.alansolisflores.realm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import io.realm.RealmResults;

public class CustomAdapter extends BaseAdapter {

    private int layout;

    private Context context;

    private RealmResults<PersonModel> realmResults;

    public CustomAdapter(int layout, Context context, RealmResults<PersonModel> realmResults) {
        this.layout = layout;
        this.context = context;
        this.realmResults = realmResults;
    }

    @Override
    public int getCount() {
        return this.realmResults.size();
    }

    @Override
    public Object getItem(int position) {
        return this.realmResults.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout,null);

            holder = new ViewHolder();

            holder.titleTextView = convertView.findViewById(R.id.titleTextView);
            holder.descriptionTextView = convertView.findViewById(R.id.descriptionTextView);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.descriptionTextView.setText(this.realmResults.get(position).firstName);
        holder.titleTextView.setText(this.realmResults.get(position).lastName);

        return convertView;
    }

    public static class ViewHolder{
        private TextView titleTextView;
        private TextView descriptionTextView;
    }
}
