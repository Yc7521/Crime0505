package org.yc.crimeintent3.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.yc.crimeintent3.R;
import org.yc.crimeintent3.adapter.CrimeAdapter;
import org.yc.crimeintent3.databinding.FragmentListBinding;
import org.yc.crimeintent3.model.Crime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListFragment extends Fragment {
    private FragmentListBinding binding;
    private List<Crime> crimes;
    private CrimeAdapter adapter;
    private int currentPos = 0;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentListBinding.inflate(inflater, container, false);

        initData();
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        adapter = new CrimeAdapter(crimes);
        adapter.setOnClickListener(view -> {
            CrimeAdapter.ViewHolder viewHolder = (CrimeAdapter.ViewHolder) view.getTag();
            currentPos = viewHolder.getAdapterPosition();
            adapter.setCurrentIndex(currentPos);
            final Bundle bundle = new Bundle();
            bundle.putSerializable("crime", crimes.get(currentPos));
            NavHostFragment.findNavController(ListFragment.this)
                    .navigate(R.id.action_ListFragment_to_InfoFragment, bundle);
        });
        binding.recyclerview.setAdapter(adapter);
        return binding.getRoot();
    }

    private void initData() {
        crimes = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            crimes.add(new Crime("" + i, "Crime #" + i, new Date(), i % 2 != 0));
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}