package com.example;

import android.graphics.Color;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.adapter.ProductDetailsPagerAdapter;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.assignment.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.PeopleBean;
import com.model.PeopleDetailsBean;

import com.utils.DataRequest;
import com.utils.NetworkAPI;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

  ViewPager productDetailsViewpager;

  ImageView leftImageView, rightImageView;

  LinearLayout peoplesLinearLayout;

  LinearLayout linearLayout;

  RequestQueue requestQueue;

  List<PeopleDetailsBean> peopleDetailsBeanList;
  List<PeopleBean> peopleBeanList;

  List<PeopleDetailsBean> imagesArrayList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scrolling);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ButterKnife.bind(this);

    peoplesLinearLayout = findViewById(R.id.people_details_linear_layout);
    linearLayout = findViewById(R.id.top_products_linear_layout);
    productDetailsViewpager = findViewById(R.id.people_details_viewpager);
    leftImageView = findViewById(R.id.left_image_view);
    rightImageView = findViewById(R.id.right_image_view);

    requestQueue = Volley.newRequestQueue(this);

    peopleDetailsBeanList = new ArrayList<>();
    peopleBeanList = new ArrayList<>();
    imagesArrayList = new ArrayList<>();


    peopleDetailsList();
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_scrolling, menu);
    return true;
  }

  private void peopleDetailsList() {
    DataRequest dataRequest = new DataRequest(Request.Method.GET, NetworkAPI.BASE_URL, null, response -> {

      Gson gson = new Gson();
      Type listType = new TypeToken<List<PeopleDetailsBean>>() {
      }.getType();

      try {
        peopleDetailsBeanList = gson.fromJson(response.getJSONArray("results").toString(), listType);

        showPeopleDetailsList(peopleDetailsBeanList);

      } catch (JSONException e) {
        e.printStackTrace();
      }

      System.out.println(response.toString());
    }, error -> {

    });

    requestQueue.add(dataRequest);
  }


 /* private void peopleList() {
    DataRequest dataRequest = new DataRequest(Request.Method.GET, NetworkAPI.BASE_URL, null, response -> {

      Gson gson = new Gson();
      Type listType = new TypeToken<List<PeopleBean>>() {
      }.getType();

      try {
        peopleBeanList = gson.fromJson(response.getJSONArray("results").toString(), listType);

        showPeopleList(peopleBeanList);

      } catch (JSONException e) {
        e.printStackTrace();
      }

      System.out.println(response.toString());
    }, error -> {

    });

    requestQueue.add(dataRequest);
  }*/

  private void showPeopleDetailsList(List<PeopleDetailsBean> peopleDetailsList) {

    showPeopleList(peopleDetailsList,0);

    ProductDetailsPagerAdapter productDetailsPagerAdapter = new ProductDetailsPagerAdapter(this, peopleDetailsList);
    productDetailsViewpager.setAdapter(productDetailsPagerAdapter);
    productDetailsViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int i, float v, int i1) {

      }

      @Override
      public void onPageSelected(int i) {
        // addBottomDots(i);

        showPeopleList(peopleDetailsList,i);
      }

      @Override
      public void onPageScrollStateChanged(int i) {

      }
    });

    leftImageView.setOnClickListener(v -> {
      int currentItem = productDetailsViewpager.getCurrentItem();

      if (currentItem >= 0) {
        productDetailsViewpager.setCurrentItem(currentItem - 1);
      }
    });

    rightImageView.setOnClickListener(v -> {
      int currentItem = productDetailsViewpager.getCurrentItem();

      if ((currentItem + 1) < imagesArrayList.size()) {
        productDetailsViewpager.setCurrentItem(currentItem + 1);
      }
    });

  }



  private void showPeopleList(List<PeopleDetailsBean> peopleList,int count) {


    linearLayout.removeAllViews();

    System.out.println(count+"ccccccccccccccccccccccccoooooooooooooooooooooooouuuuuuuuuuuuuuuuuuuuuuu");

    for (int i = 0; i < peopleList.size(); i++) {

      View productView = LayoutInflater.from(this).inflate(R.layout.people_list, null);

      TextView genderTextView = productView.findViewById(R.id.people_gender_text_view);

      if (peopleList.get(i).getGender() != null && peopleList.get(i).getGender().equals("male")) {
        genderTextView.setText("Male" + " . NL");
      } else if (peopleList.get(i).getGender() != null && peopleList.get(i).getGender().equals("female")) {
        genderTextView.setText("Female" + " . NL");
      } else {
        genderTextView.setText("");
      }

      TextView nameTextView =  productView.findViewById(R.id.people_name_text_view);
      if (peopleList.get(i).getName() != null) {
        nameTextView.setText(peopleList.get(i).getName().getTitle() + ". " + peopleList.get(i).getName().getFirst() + " " + peopleList.get(i).getName().getLast());
      } else {
        nameTextView.setText("");
      }

      TextView emailTextView = productView.findViewById(R.id.people_email_text_view);
      if (peopleList.get(i).getEmail() != null) {
        emailTextView.setText(peopleList.get(i).getEmail());
      } else {
        emailTextView.setText("");
      }

      LinearLayout layout = productView.findViewById(R.id.home_product_linear_layout);

      if(count == i) {
        layout.setBackgroundResource(R.color.purple_300);
        genderTextView.setTextColor(Color.WHITE);
        nameTextView.setTextColor(Color.WHITE);
        emailTextView.setTextColor(Color.WHITE);
      }else {
        layout.setBackgroundResource(R.color.white);
      }

      layout.setOnClickListener(v -> {
       // showPeopleDetailsList(peopleList,i);
      });

      linearLayout.addView(productView);
    }

  }

}
