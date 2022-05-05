package org.yc.crimeintent3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.yc.crimeintent3.databinding.ItemCrimeBinding;
import org.yc.crimeintent3.model.Crime;

import java.util.List;

public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.ViewHolder> {
    private final List<Crime> crimes;
    private int currentIndex = 0;
    private View.OnClickListener onClickListener;

    public CrimeAdapter(List<Crime> crimes) {
        this.crimes = crimes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCrimeBinding binding = ItemCrimeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Crime crime = crimes.get(position);
        holder.binding.tvTitle.setText(crime.getTitle());
        holder.binding.tvDate.setText(crime.getDate().toString());
        holder.binding.icon.setVisibility(crime.getSolved() ? View.INVISIBLE : View.VISIBLE);

        holder.itemView.setSelected(currentIndex == position);
    }

    @Override
    public int getItemCount() {
        return crimes.size();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setCurrentIndex(int position) {
        notifyItemChanged(currentIndex);
        notifyItemChanged(position);

        this.currentIndex = position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCrimeBinding binding;

        public ViewHolder(@NonNull ItemCrimeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.itemView.setTag(this);
            this.itemView.setOnClickListener(onClickListener);
        }
    }
}
