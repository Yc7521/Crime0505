package org.yc.crimeintent3.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.yc.crimeintent3.databinding.FragmentInfoBinding;
import org.yc.crimeintent3.model.Crime;

import java.util.Calendar;
import java.util.Date;

public class InfoFragment extends Fragment {

    private FragmentInfoBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentInfoBinding.inflate(inflater, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            Crime crime = (Crime) arguments.getSerializable("crime");
            Log.d("InfoFragment", "Has crime: " + crime);
            binding.title.setText(crime.getTitle());
            binding.detail.setText(crime.getDate().toString());
            binding.solved.setChecked(crime.getSolved());
        } else {
            Log.d("InfoFragment", "Bundle is null");
        }

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.detail.setOnClickListener(view1 -> {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());

            DatePickerDialog dialog = new DatePickerDialog(requireContext(),
                    (datePicker, year, month, date) -> {
                        Calendar now1 = Calendar.getInstance();

                        now1.set(year, month, date);
                        binding.detail.setText(now1.getTime().toString());
                    },
                    now.get(Calendar.YEAR),
                    now.get(Calendar.MONTH),
                    now.get(Calendar.DAY_OF_MONTH));
            dialog.show();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}