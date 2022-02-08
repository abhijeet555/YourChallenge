package com.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
;
import com.example.assignment.R;
import com.model.PeopleDetailsBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

;import de.hdodenhof.circleimageview.CircleImageView;

public class ProductDetailsPagerAdapter extends PagerAdapter {

  private List<PeopleDetailsBean> peopleDetailsBeanList;
  private LayoutInflater layoutInflater;

  public ProductDetailsPagerAdapter(Context context, List<PeopleDetailsBean> imagesArray) {
    if (this.peopleDetailsBeanList == null) {
      this.peopleDetailsBeanList = new ArrayList<>();
    }
    this.peopleDetailsBeanList.addAll(imagesArray);
    layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() {
    return peopleDetailsBeanList.size();
  }

  @Override
  public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
    return view == ((LinearLayout) o);
  }

  @NonNull
  @Override
  public Object instantiateItem(@NonNull ViewGroup container, int position) {
    View itemView = layoutInflater.inflate(R.layout.people_details, container, false);

    CircleImageView imageView = itemView.findViewById(R.id.profile_image);
    Picasso.get().load(peopleDetailsBeanList.get(position).getPicture().getLarge()).into(imageView);

    TextView nameTextView = itemView.findViewById(R.id.people_details_name_text_view);
    if (peopleDetailsBeanList.get(position).getName() != null) {
      nameTextView.setText(peopleDetailsBeanList.get(position).getName().getTitle() + ". " + peopleDetailsBeanList.get(position).getName().getFirst() + " " + peopleDetailsBeanList.get(position).getName().getLast());
    } else {
      nameTextView.setText("");
    }

    TextView addressTextView = itemView.findViewById(R.id.people_details_address_text_view);
    if (peopleDetailsBeanList.get(position).getLocation() != null) {
      addressTextView.setText(Html.fromHtml( "<b>"+"<font color='#A44CD3'>" +peopleDetailsBeanList.get(position).getLocation().getStreet().getNumber() +"</font>" +"</b>" + ", " + peopleDetailsBeanList.get(position).getLocation().getStreet().getName() + " " + peopleDetailsBeanList.get(position).getLocation().getCity()
        + peopleDetailsBeanList.get(position).getLocation().getState() + ", " + "<b>" +peopleDetailsBeanList.get(position).getLocation().getCountry() + ", " + "</b>" + peopleDetailsBeanList.get(position).getLocation().getPostcode()));
    } else {
      nameTextView.setText("");
    }

    TextView timeTextView = itemView.findViewById(R.id.people_details_time_text_view);
    if (peopleDetailsBeanList.get(position).getLocation().getTimezone() != null) {
      timeTextView.setText(peopleDetailsBeanList.get(position).getLocation().getTimezone().getOffset() + ", " + peopleDetailsBeanList.get(position).getLocation().getTimezone().getDescription());
    } else {
      timeTextView.setText("");
    }

    TextView emailextView = itemView.findViewById(R.id.people_detailse_email_text_view);
    if (peopleDetailsBeanList.get(position).getGender() != null && peopleDetailsBeanList.get(position).getGender().equals("male")) {
      emailextView.setText("Male");
    } else if (peopleDetailsBeanList.get(position).getGender() != null && peopleDetailsBeanList.get(position).getGender().equals("female")) {
      emailextView.setText("Female");
    } else {
      emailextView.setText("");
    }

    container.addView(itemView);

    return itemView;
  }

  @Override
  public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    container.removeView((LinearLayout) object);
  }

}
