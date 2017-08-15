package example.yunus.havadurumu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by yunus on 15.08.2017.
 */

public class Adapter extends BaseAdapter
{
    ArrayList<Weather>arrayList;
    LayoutInflater layoutInflater;
    Context context;
    public Adapter(Context context, ArrayList<Weather> arrayList)
    {
        this.context=context;
        this.arrayList=arrayList;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view=layoutInflater.inflate(R.layout.card_weather, parent, false);
        TextView sehir= (TextView) view.findViewById(R.id.cityName);
        TextView durum= (TextView) view.findViewById(R.id.situation);
        TextView aciklama= (TextView) view.findViewById(R.id.aciklama);
        TextView sicaklik= (TextView) view.findViewById(R.id.temp);

        sehir.setText(arrayList.get(position).getSehir());
        durum.setText(arrayList.get(position).getTanim());
        aciklama.setText(arrayList.get(position).getAciklama());
        double result= arrayList.get(position).getSicaklik();
        sicaklik.setText(String.format("%.2f °C",result));

        return view;
    }
}
