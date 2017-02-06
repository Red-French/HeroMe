package net.redfrench.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.redfrench.herome.Activities.MainActivity;
import net.redfrench.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChoosePowerFragment.ChoosePowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChoosePowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChoosePowerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button strengthBtn;
    private Button backstoryBtn;

    private ChoosePowerInteractionListener mListener;


//    ************************************************************************
//    ************************************************************************
//    ************************************************************************


    public ChoosePowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChoosePowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChoosePowerFragment newInstance(String param1, String param2) {
        ChoosePowerFragment fragment = new ChoosePowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_power, container, false);

        turtleBtn = (Button)view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button)view.findViewById(R.id.lightningBtn);
        flightBtn = (Button)view.findViewById(R.id.flightBtn);
        webBtn = (Button)view.findViewById(R.id.webBtn);
        laserBtn = (Button)view.findViewById(R.id.laserBtn);
        strengthBtn = (Button)view.findViewById(R.id.strengthBtn);
        backstoryBtn = (Button)view.findViewById(R.id.backstoryBtn);

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        laserBtn.setOnClickListener(this);
        strengthBtn.setOnClickListener(this);

        backstoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadBackstoryScreen();
            }
        });

        // disable and dim 'Choose' button
        backstoryBtn.setEnabled(false);
        backstoryBtn.getBackground().setAlpha(128);  // (255 would be 100% transparent)

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(255);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onChoosePowerFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ChoosePowerInteractionListener) {
            mListener = (ChoosePowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ChoosePowerInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface ChoosePowerInteractionListener {
        // TODO: Update argument type and name
        void onChoosePowerFragmentInteraction(Uri uri);

        void onBackstoryFragmentInteraction(Uri uri);
    }
}
