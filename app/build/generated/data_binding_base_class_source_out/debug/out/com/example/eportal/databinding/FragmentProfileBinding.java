// Generated by view binder compiler. Do not edit!
package com.example.eportal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.dd.morphingbutton.MorphingButton;
import com.example.eportal.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentProfileBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MorphingButton buttonAdd;

  @NonNull
  public final EditText editTextCity;

  @NonNull
  public final EditText editTextName;

  @NonNull
  public final LinearLayout linearLayout;

  private FragmentProfileBinding(@NonNull ConstraintLayout rootView,
      @NonNull MorphingButton buttonAdd, @NonNull EditText editTextCity,
      @NonNull EditText editTextName, @NonNull LinearLayout linearLayout) {
    this.rootView = rootView;
    this.buttonAdd = buttonAdd;
    this.editTextCity = editTextCity;
    this.editTextName = editTextName;
    this.linearLayout = linearLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonAdd;
      MorphingButton buttonAdd = ViewBindings.findChildViewById(rootView, id);
      if (buttonAdd == null) {
        break missingId;
      }

      id = R.id.editTextCity;
      EditText editTextCity = ViewBindings.findChildViewById(rootView, id);
      if (editTextCity == null) {
        break missingId;
      }

      id = R.id.editTextName;
      EditText editTextName = ViewBindings.findChildViewById(rootView, id);
      if (editTextName == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      return new FragmentProfileBinding((ConstraintLayout) rootView, buttonAdd, editTextCity,
          editTextName, linearLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}