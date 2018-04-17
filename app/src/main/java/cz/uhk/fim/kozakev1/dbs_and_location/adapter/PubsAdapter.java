package cz.uhk.fim.kozakev1.dbs_and_location.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.uhk.fim.kozakev1.dbs_and_location.R;
import cz.uhk.fim.kozakev1.dbs_and_location.model.Pub;


/**
 * Created by kozakev1 on 19.03.2018.
 */


public class PubsAdapter extends RecyclerView.Adapter<PubsAdapter.PubViewHolder> {

    public PubsAdapter(List<Pub> pubs) {
        this.pubs = pubs;

    }


    List<Pub> pubs = new ArrayList<>();

    @Override
    public PubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pub, null);
      return new PubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PubViewHolder holder, int position) {
        Pub pub = pubs.get(position);
        holder.textName.setText(pub.getName());
        holder.textPosition.setText(pub.getLat() + ":" + pub.getLng());

    }

    @Override
    public int getItemCount() {
        return pubs.size();
    }


    public class PubViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtName)
        TextView textName;

        @BindView(R.id.txtPosition)
        TextView textPosition;

        public PubViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


    }

}
