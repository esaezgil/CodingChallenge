package com.example.enrique.cabifychallenge.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.enrique.cabifychallenge.R;

public class ResultsAdapter extends ArrayAdapter<String[]> {

    private Context context;
    private String[][] journeyList;

    public ResultsAdapter(Context context, int layout,
                          int layoutText, String[][] data) {
        super(context, layout, layoutText, data);
        this.context = context;
        this.journeyList = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup padre){
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_journey, null);

            holder = new ViewHolder();

            holder.setIdView(convertView);
            holder.setRegionView(convertView);
            holder.setUserIdView(convertView);
            holder.setCreatedAtView(convertView);
            holder.setStartLatView(convertView);
            holder.setStartLongView(convertView);
            holder.setEndLongView(convertView);
            holder.setEndLatView(convertView);

            holder.setDistanceView(convertView);
            holder.setDurationView(convertView);
            holder.setCurrencyView(convertView);
            holder.setPriceView(convertView);
            holder.setDiscountView(convertView);
            holder.setTotalPriceView(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.setId(journeyList[position][0]);
        holder.setRegion(journeyList[position][1]);
        holder.setUserId(journeyList[position][2]);
        holder.setStartLat(journeyList[position][3]);
        holder.setStartLong(journeyList[position][4]);
        holder.setEndLat(journeyList[position][5]);
        holder.setEndLong(journeyList[position][6]);
        holder.setCreatedAt(journeyList[position][7]);

        holder.setDistance(journeyList[position][8] + " meters");
        holder.setDuration(journeyList[position][9] + " seconds");
        holder.setCurrency(journeyList[position][10]);
        holder.setPrice(journeyList[position][11]);
        holder.setDiscount(journeyList[position][12]);
        holder.setTotalPrice(journeyList[position][13]);
        return convertView;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return journeyList.length;
    }
}
