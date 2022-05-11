package com.example.stickyheaderrecyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    Context context;
    List<Person> personList;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == Common.VIEWTYPE_GROUP) {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.group_item, parent, false);
            return new ViewGroupHolder(group);
        } else if (viewType == Common.VIEWTYPE_PERSON) {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.person_layout, parent, false);
            return new PersonHolder(group);
        } else {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.group_item, parent, false);
            return new ViewGroupHolder(group);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return personList.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewGroupHolder) {
            ViewGroupHolder groupHolder = (ViewGroupHolder) holder;
            groupHolder.txt_group_title.setText(personList.get(position).getName());
            groupHolder.itemView.setOnClickListener(view -> {
                //start new activity
            });
        } else if (holder instanceof PersonHolder) {
            PersonHolder groupHolder = (PersonHolder) holder;
            groupHolder.txt_person_name.setText(personList.get(position).getName());
            groupHolder.txt_person_position.setText(personList.get(position).getPosition());
            groupHolder.itemView.setOnClickListener(view -> {
                //start new activity
            });
        }
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    private class ViewGroupHolder extends RecyclerView.ViewHolder {
        TextView txt_group_title;

        public ViewGroupHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txt_group_title = (TextView) itemView.findViewById(R.id.txt_group_view);
        }
    }

    private class PersonHolder extends RecyclerView.ViewHolder {
        TextView txt_person_name, txt_person_position;
        ImageView img_person_avatar;

        public PersonHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            txt_person_name = (TextView) itemView.findViewById(R.id.txt_person_name);
            txt_person_position = (TextView) itemView.findViewById(R.id.txt_person_position);
            img_person_avatar = (ImageView) itemView.findViewById(R.id.person_avatar);
        }
    }
}
