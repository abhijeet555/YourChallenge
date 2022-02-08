package com.adapter;

import android.content.Context;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.R;
import com.model.PeopleBean;

import java.util.ArrayList;

public class PeopleListAdapter extends RecyclerView.Adapter<PeopleListAdapter.PeopleListViewHolder> {

  Context context;
  ArrayList<PeopleBean> peopleBeanArrayList;


  public PeopleListAdapter(Context context, ArrayList<PeopleBean> peopleBeanArrayList) {
    this.context = context;
    this.peopleBeanArrayList = peopleBeanArrayList;

  }

  @NonNull
  @Override
  public PeopleListAdapter.PeopleListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

    View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.people_list, viewGroup, false);

    return new PeopleListAdapter.PeopleListViewHolder(itemView);
  }

  @RequiresApi(api = Build.VERSION_CODES.O)
  @Override
  public void onBindViewHolder(@NonNull final PeopleListAdapter.PeopleListViewHolder peopleListViewHolder, final int position) {

    final PeopleBean peopleBean = peopleBeanArrayList.get(position);

    peopleListViewHolder.genderTextView.setText(peopleBean.getGender() + " . NL");

    peopleListViewHolder.nameTextView.setText(peopleBean.getName().getTitle() + ". " + peopleBean.getName().getFirst() +" " + peopleBean.getName().getLast());

    peopleListViewHolder.emailTextView.setText(peopleBean.getEmail());

  /*  peopleListViewHolder.emailTextView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        peopleListViewHolder.linearLayout.setBackgroundResource(R.color.purple_700);
      }
    });*/

  }


  @Override
  public int getItemCount() {
    return peopleBeanArrayList.size();
  }


  public static class PeopleListViewHolder extends RecyclerView.ViewHolder {


    TextView genderTextView, nameTextView, emailTextView;

    LinearLayout linearLayout;

    public PeopleListViewHolder(@NonNull View itemView) {
      super(itemView);

      linearLayout = itemView.findViewById(R.id.home_product_linear_layout);
      genderTextView = itemView.findViewById(R.id.people_gender_text_view);
      nameTextView = itemView.findViewById(R.id.people_name_text_view);
      emailTextView = itemView.findViewById(R.id.people_email_text_view);

    }
  }
}
