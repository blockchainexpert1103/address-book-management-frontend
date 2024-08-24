package com.example.pms_client;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {


    private List<Contact> contactList;
    private boolean isFavoriteView; // Add a boolean flag to determine which layout to use

    public ContactAdapter(List<Contact> contactList, boolean isFavoriteView) {
        this.contactList = contactList;
        this.isFavoriteView = isFavoriteView;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        if (isFavoriteView) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.favorite, parent, false); // Inflate Favorite.xml
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.favorite_add, parent, false); // Inflate Favorite_Add.xml
        }
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contactList.get(position);
        holder.nameTextView.setText(contact.getName());

        // Set mobile and office phones if available
        if(contact.getMobilePhone().isEmpty()) {
            holder.mobileTextView.setText("勤務先 "+contact.getMobilePhone());
        }
        if(contact.getOfficePhone().isEmpty()) {
            holder.officeTextView.setText("携帯  "+contact.getOfficePhone());
        }
        holder.iconImageView.setImageResource(contact.getIconResourceId());

        // Set the click listener for contact_main_info
        holder.contactMainInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.contactDetails.getVisibility() == View.GONE) {
                    holder.contactDetails.setVisibility(View.VISIBLE);  // Show details
                } else {
                    holder.contactDetails.setVisibility(View.GONE);  // Hide details
                }
            }
        });
        //
        // Set click listener for SMS send action
        holder.sms_send.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), SMSSend.class);
            intent.putExtra("contact_name", contact.getName());
            intent.putExtra("mobile_phone", contact.getMobilePhone());
            v.getContext().startActivity(intent);
        });

        // Handle phone icon visibility (only if using Favorite.xml)
        if (isFavoriteView && holder.phoneIcon != null) {
            holder.phoneIcon.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView mobileTextView;
        TextView officeTextView;
        ImageView iconImageView;
        LinearLayout contactMainInfo;
        LinearLayout contactDetails;
        LinearLayout sms_send;
        ImageView phoneIcon; // Reference to the phone icon (for Favorite.xml)

        ContactViewHolder(View itemView) {
            super(itemView);
            nameTextView    = itemView.findViewById(R.id.contact_name);
            mobileTextView  = itemView.findViewById(R.id.mobile_phone);
            officeTextView  = itemView.findViewById(R.id.office_phone);
            iconImageView   = itemView.findViewById(R.id.contact_icon);
            contactMainInfo = itemView.findViewById(R.id.contact_main_info);
            contactDetails  = itemView.findViewById(R.id.contact_details);
            sms_send        = itemView.findViewById(R.id.sms_send);
            phoneIcon       = itemView.findViewById(R.id.favorite_ic_call); // Initialize phone icon
        }
    }
}
