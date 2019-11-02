package com.example.fragment_profilebuilder;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;


public class DisplayFragment extends Fragment {
    ImageView iv_display;
    Button button_Edit;
    TextView d_name,dept, d_id;



    private OnFragmentInteractionListener mListener;

    public DisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iv_display = (ImageView) getActivity().findViewById(R.id.iv_display);
        button_Edit = (Button) getActivity().findViewById(R.id.button_Edit);
        d_name = (TextView) getActivity().findViewById(R.id.d_name);
        dept = (TextView) getActivity().findViewById(R.id.d_dept);
        d_id = (TextView) getActivity().findViewById(R.id.d_id);

        if (MainActivity.sharedPref.contains("profilebuild")) {
            String prof = MainActivity.sharedPref.getString("profilebuild", "");
            Gson gson = new Gson();
                Profile newprofile = gson.fromJson(prof, Profile.class);
            d_name.setText("Name: "+ newprofile.fname +" " + newprofile.lname);
            d_id.setText("Student ID: "+newprofile.studentid);
            dept.setText("Depatment: "+newprofile.rbvalue);
            int id = newprofile.imageid;
//            int id = MainActivity.sharedPref.getInt("imageid", 0);
            if (id == 1) {
                iv_display.setImageResource(R.drawable.avatar_f_1);
            } else if (id == 2) {
                iv_display.setImageResource(R.drawable.avatar_f_2);
            } else if (id == 3) {
                iv_display.setImageResource(R.drawable.avatar_f_3);
            } else if (id == 4) {
                iv_display.setImageResource(R.drawable.avatar_m_1);
            } else if (id == 5) {
                iv_display.setImageResource(R.drawable.avatar_m_2);
            } else if (id == 6) {
                iv_display.setImageResource(R.drawable.avatar_m_3);
            }else if (id ==0){
                iv_display.setImageResource(R.drawable.select_image);
            }

            button_Edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.editFunctioncall();
                }
            });

        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }



    public interface OnFragmentInteractionListener {
        void editFunctioncall();

    }
}
