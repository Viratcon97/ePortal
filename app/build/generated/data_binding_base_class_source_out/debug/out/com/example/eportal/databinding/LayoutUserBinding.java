// Generated by view binder compiler. Do not edit!
package com.example.eportal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
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

public final class LayoutUserBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnDelete;

  @NonNull
  public final Button btnEdit;

  @NonNull
  public final TextView userCity;

  @NonNull
  public final LinearLayout userLayout;

  @NonNull
  public final TextView userName;

  private LayoutUserBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnDelete,
      @NonNull Button btnEdit, @NonNull TextView userCity, @NonNull LinearLayout userLayout,
      @NonNull TextView userName) {
    this.rootView = rootView;
    this.btnDelete = btnDelete;
    this.btnEdit = btnEdit;
    this.userCity = userCity;
    this.userLayout = userLayout;
    this.userName = userName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnDelete;
      Button btnDelete = ViewBindings.findChildViewById(rootView, id);
      if (btnDelete == null) {
        break missingId;
      }

      id = R.id.btnEdit;
      Button btnEdit = ViewBindings.findChildViewById(rootView, id);
      if (btnEdit == null) {
        break missingId;
      }

      id = R.id.userCity;
      TextView userCity = ViewBindings.findChildViewById(rootView, id);
      if (userCity == null) {
        break missingId;
      }

      id = R.id.userLayout;
      LinearLayout userLayout = ViewBindings.findChildViewById(rootView, id);
      if (userLayout == null) {
        break missingId;
      }

      id = R.id.userName;
      TextView userName = ViewBindings.findChildViewById(rootView, id);
      if (userName == null) {
        break missingId;
      }

      return new LayoutUserBinding((ConstraintLayout) rootView, btnDelete, btnEdit, userCity,
          userLayout, userName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
