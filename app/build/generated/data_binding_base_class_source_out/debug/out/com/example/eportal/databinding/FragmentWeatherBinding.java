// Generated by view binder compiler. Do not edit!
package com.example.eportal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.eportal.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentWeatherBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final TextView textViewCity;

  @NonNull
  public final TextView textViewCountry;

  @NonNull
  public final TextView textViewFeelsLike;

  @NonNull
  public final TextView textViewTemperature;

  private FragmentWeatherBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imageView,
      @NonNull LinearLayout linearLayout2, @NonNull ProgressBar progressBar,
      @NonNull TextView textViewCity, @NonNull TextView textViewCountry,
      @NonNull TextView textViewFeelsLike, @NonNull TextView textViewTemperature) {
    this.rootView = rootView;
    this.imageView = imageView;
    this.linearLayout2 = linearLayout2;
    this.progressBar = progressBar;
    this.textViewCity = textViewCity;
    this.textViewCountry = textViewCountry;
    this.textViewFeelsLike = textViewFeelsLike;
    this.textViewTemperature = textViewTemperature;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentWeatherBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentWeatherBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_weather, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentWeatherBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.textViewCity;
      TextView textViewCity = ViewBindings.findChildViewById(rootView, id);
      if (textViewCity == null) {
        break missingId;
      }

      id = R.id.textViewCountry;
      TextView textViewCountry = ViewBindings.findChildViewById(rootView, id);
      if (textViewCountry == null) {
        break missingId;
      }

      id = R.id.textViewFeelsLike;
      TextView textViewFeelsLike = ViewBindings.findChildViewById(rootView, id);
      if (textViewFeelsLike == null) {
        break missingId;
      }

      id = R.id.textViewTemperature;
      TextView textViewTemperature = ViewBindings.findChildViewById(rootView, id);
      if (textViewTemperature == null) {
        break missingId;
      }

      return new FragmentWeatherBinding((ConstraintLayout) rootView, imageView, linearLayout2,
          progressBar, textViewCity, textViewCountry, textViewFeelsLike, textViewTemperature);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
