package com.salma.layoutsdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.ViewHolder> {
    private List<Worldpopulation> _worldCountries;
    private Context context;

    CountriesAdapter(List<Worldpopulation> worldCountries) {
        _worldCountries = worldCountries;
       // _context=context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView countryName;
        TextView countryRank;
        TextView countryPopulation;
        CircleImageView countryFlag;


        ViewHolder(View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.Txt_countryName);
            countryRank = itemView.findViewById(R.id.Txt_Rank);
            countryPopulation = itemView.findViewById(R.id.txt_population);
            countryFlag = itemView.findViewById(R.id.img_flag);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View countryView = inflater.inflate(R.layout.singlerow, viewGroup, false);
        return new ViewHolder(countryView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Worldpopulation worldpopulation = _worldCountries.get(i);
        TextView countryName = viewHolder.countryName;
        TextView countryRank = viewHolder.countryRank;
        TextView countryPopulation = viewHolder.countryPopulation;
        ImageView countryFlag = viewHolder.countryFlag;
        countryName.setText(worldpopulation.getCountry());
        countryRank.setText(String.valueOf(worldpopulation.getRank()));
        countryPopulation.setText(worldpopulation.getPopulation());
        Glide.with(context).load(worldpopulation.getFlag()).diskCacheStrategy(DiskCacheStrategy.ALL).into(countryFlag);
    }

    @Override
    public int getItemCount() {
        return _worldCountries.size();
    }

}
