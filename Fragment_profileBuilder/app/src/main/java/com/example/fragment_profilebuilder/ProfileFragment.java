package com.example.fragment_profilebuilder;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import static com.example.fragment_profilebuilder.MainActivity.sharedPref;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class ProfileFragment extends Fragment {
    ImageView image;
    EditText et_fname,et_lname,et_id;
    Button button_save;
    RadioGroup radioGroup;
    RadioButton rb_cs,rb_sis,rb_bio,rb_Other;
    TextView tv_avatar;
    String rbvalue ="";
    Profile studentProfile = new Profile();
    int id =0;
    String flag="";
    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
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


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        image = getActivity().findViewById(R.id.image);
        et_fname = (EditText) getActivity().findViewById(R.id.et_fname);
        et_lname = (EditText) getActivity().findViewById(R.id.et_lname);
        et_id = (EditText) getActivity().findViewById(R.id.et_id);
        button_save = (Button) getActivity().findViewById(R.id.button_save);
        radioGroup = (RadioGroup) getActivity().findViewById(R.id.radioGroup);
        rb_cs = (RadioButton) getActivity().findViewById(R.id.rb_cs);
        rb_sis = (RadioButton) getActivity().findViewById(R.id.rb_sis);
        rb_bio = (RadioButton) getActivity().findViewById(R.id.rb_bio);
        rb_Other = (RadioButton) getActivity().findViewById(R.id.rb_Other);
        tv_avatar = (TextView) getActivity().findViewById(R.id.tv_avatar);
        studentProfile = new Profile();
        rb_cs.setChecked(true);
        studentProfile.setRbvalue("CS");


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_cs) {
                    studentProfile.setRbvalue("CS");
                } else if (checkedId == R.id.rb_sis) {
                    studentProfile.setRbvalue("SIS");
                } else if (checkedId == R.id.rb_bio) {
                    studentProfile.setRbvalue("BIO");
                } else if (checkedId == R.id.rb_Other) {
                    studentProfile.setRbvalue("Other");
                }
            }
        });


        if (sharedPref.contains("profilebuild")) {

            getActivity().setTitle("My Profile");
            String prof = MainActivity.sharedPref.getString("profilebuild", "");
            Gson gson = new Gson();
            Profile profileobj = gson.fromJson(prof, Profile.class);
            et_fname.setText(profileobj.getFname());
            et_lname.setText(profileobj.getLname());
            et_id.setText(profileobj.getStudentid());

            switch (profileobj.getRbvalue()) {
                case "CS":
                    rb_cs.setChecked(true);
                    studentProfile.setRbvalue("CS");
                    break;

                case "SIS":
                    rb_sis.setChecked(true);
                    studentProfile.setRbvalue("SIS");
                    break;

                case "BIO":
                    rb_bio.setChecked(true);
                    studentProfile.setRbvalue("BIO");
                    break;

                case "other":
                    rb_Other.setChecked(true);
                    studentProfile.setRbvalue("other");
                    break;

            }


            switch (profileobj.getImageid()) {

                case 1:
                    image.setImageResource(R.drawable.avatar_f_1);
                    studentProfile.setImageid(1);
                    break;

                case 2:
                    image.setImageResource(R.drawable.avatar_f_2);
                    studentProfile.setImageid(2);
                    break;

                case 3:
                    image.setImageResource(R.drawable.avatar_f_3);
                    studentProfile.setImageid(3);
                    break;

                case 4:
                    image.setImageResource(R.drawable.avatar_m_1);
                    studentProfile.setImageid(4);
                    break;

                case 5:
                    image.setImageResource(R.drawable.avatar_m_2);
                    studentProfile.setImageid(5);
                    break;

                case 6:
                    image.setImageResource(R.drawable.avatar_m_3);
                    studentProfile.setImageid(6);
                    break;

                default:
                    image.setImageResource(R.drawable.select_image);
                    studentProfile.setImageid(0);
                    break;
            }

        }


        if(sharedPref.contains("tagid")){
//

            int images1 = sharedPref.getInt("tagid",0);

            switch (images1){

                case 1:
                    image.setImageResource(R.drawable.avatar_f_1);
                    studentProfile.setImageid(1);
                    break;

                case 2:
                    image.setImageResource(R.drawable.avatar_f_2);
                    studentProfile.setImageid(2);
                    break;

                case 3:
                    image.setImageResource(R.drawable.avatar_f_3);
                    studentProfile.setImageid(3);
                    break;

                case 4:
                    image.setImageResource(R.drawable.avatar_m_1);
                    studentProfile.setImageid(4);
                    break;

                case 5:
                    image.setImageResource(R.drawable.avatar_m_2);
                    studentProfile.setImageid(5);
                    break;

                case 6:
                    image.setImageResource(R.drawable.avatar_m_3);
                    studentProfile.setImageid(6);
                    break;
                default:
                    image.setImageResource(R.drawable.select_image);
                studentProfile.setImageid(0);
                break;
            }

        }


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.gotoNext();
            }

        });


        button_save.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {


                if (image.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.select_image).getConstantState())
                {
                    studentProfile.setImageid(0);
                    tv_avatar.setError("please select an avatar");
                }
                 else if(et_fname.getText().toString().length() == 0) {
                    et_fname.setError("provide values");
                } else if (et_lname.getText().toString().length() == 0) {
                    et_lname.setError("provide values");

                } else if (et_id.getText().toString().length() != 9) {
                    et_id.setError("provide values of 9 digits");

                } else if (studentProfile.rbvalue.length() == 0) {
                    rb_Other.setError("select a value");

                } else {

                    studentProfile.setFname(et_fname.getText().toString());
                    studentProfile.setLname(et_lname.getText().toString());
                    studentProfile.setStudentid(et_id.getText().toString());
                    mListener.addProfile(studentProfile);

                }
            }
        });







    }



    public interface OnFragmentInteractionListener {
        public void gotoNext();
        public void addProfile(Profile profile);
}




}
