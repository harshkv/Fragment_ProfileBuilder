package com.example.fragment_profilebuilder;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;


public class AvatarFragment extends Fragment {
    GridLayout gridLayout;
    ImageView imageView,imageView6,imageView2,imageView3,imageView4,imageView5;
    final static int[] id = new int[1];


    private returnImage mListener1;

    public AvatarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_avatar, container, false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imageView = (ImageView) getActivity().findViewById(R.id.imageView);
        imageView2 = (ImageView) getActivity().findViewById(R.id.imageView2);
        imageView3 = (ImageView) getActivity().findViewById(R.id.imageView3);
        imageView4 = (ImageView) getActivity().findViewById(R.id.imageView4);
        imageView5 = (ImageView) getActivity().findViewById(R.id.imageView5);
        imageView6 = (ImageView) getActivity().findViewById(R.id.imageView6);
        id[0] =0;


        final androidx.gridlayout.widget.GridLayout gridLayout = (androidx.gridlayout.widget.GridLayout) getActivity().findViewById(R.id.gridLayout);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id[0] = 1;
                mListener1.getImage(id[0]);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id[0] = 2;
                mListener1.getImage(id[0]);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id[0] = 3;
                mListener1.getImage(id[0]);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id[0] = 4;
                mListener1.getImage(id[0]);
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id[0] = 5;
                mListener1.getImage(id[0]);
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id[0] = 6;
                mListener1.getImage(id[0]);
            }
        });
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof returnImage) {
            mListener1 = (returnImage) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener1 = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface returnImage {
      public void getImage(int tagid);
}




}
