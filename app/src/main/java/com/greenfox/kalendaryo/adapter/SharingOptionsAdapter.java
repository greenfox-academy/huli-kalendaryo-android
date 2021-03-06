package com.greenfox.kalendaryo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.greenfox.kalendaryo.R;
import com.greenfox.kalendaryo.models.GoogleCalendar;
import com.greenfox.kalendaryo.models.Kalendar;
import com.greenfox.kalendaryo.models.VisibilityOption;

import java.util.List;


public class SharingOptionsAdapter extends RecyclerView.Adapter<SharingOptionsAdapter.ViewHolder> {

    private List<GoogleCalendar> googleCalendars;
    private Context context;
    Kalendar kalendar;

    public SharingOptionsAdapter(Context context, Kalendar kalendar) {
        this.context = context;
        this.kalendar = kalendar;
        this.googleCalendars = kalendar.getInputGoogleCalendars();
    }

    @Override
    public SharingOptionsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sharing_options, parent, false);
        SharingOptionsAdapter.ViewHolder viewHolder = new SharingOptionsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SharingOptionsAdapter.ViewHolder holder, int position) {
        GoogleCalendar calendar = googleCalendars.get(position);
        holder.calendarName.setText(calendar.getSummary());
        calendar.setSharingOption(VisibilityOption.DEFAULT);

        Spinner spinner = holder.dropdown;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                calendar.setSharingOption((VisibilityOption)spinner.getSelectedItem());
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return googleCalendars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView calendarName;
        private Spinner dropdown;

        public ViewHolder(View itemView) {
            super(itemView);
            calendarName = itemView.findViewById(R.id.text_calendar_name);
            dropdown = (Spinner)itemView.findViewById(R.id.spinner_visibilities);
            ArrayAdapter<VisibilityOption> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, VisibilityOption.values());
            dropdown.setAdapter(adapter);
        }
    }
}
