package android.example.resep;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dataadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<datamodel> datamodelArrayList;
    private Activity activity;
    public dataadapter(Activity activity, ArrayList<datamodel> datamodelArrayList){
        this.activity = activity;
        this.datamodelArrayList = datamodelArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case 1 : {
                View v = inflater.inflate(R.layout.list_item, parent, false);
                viewHolder = new ItemHolder(v);
                break;
            }
            case 2 : {
                View v = inflater.inflate(R.layout.list_header, parent, false);
                viewHolder = new ItemHolder(v);
                break;
            }
            case 3 : {
                View v = inflater.inflate(R.layout.list_footer, parent, false);
                viewHolder = new ItemHolder(v);
                break;
            }
        }
        return viewHolder;
}
    private class ItemHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ItemHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.txtjudul);
        }
    }

    public static class HeaderHolder extends RecyclerView.ViewHolder {
        public HeaderHolder(View view) {
            super(view);
        }
    }

    public static class FooterHolder extends RecyclerView.ViewHolder {
        public FooterHolder(View view) {
            super(view);
        }
    }
    @Override
    public void onBindViewHolder( final RecyclerView.ViewHolder viewholder, final int position) {
        switch (getItem(position).getViewType()){
            case 1:{
                ItemHolder holder = (ItemHolder) viewholder;
                holder.textView.setText(getItem(position).getJudul());

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Intent intent = new Intent(activity, DetailActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("dataModel", getItem(position));
                        intent.putExtras(bundle);
                        activity.startActivity(intent);
                    }
                });

                break;
            }
        }

    }

    @Override
    public int getItemViewType(int position) {
        return datamodelArrayList.get(position).getViewType();
    }

    public datamodel getItem(int position) {
        return datamodelArrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return datamodelArrayList.size();
    }


}
