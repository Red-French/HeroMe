package net.redfrench.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;  // support library for older devices to use fragments
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.redfrench.herome.Activities.MainActivity;
import net.redfrench.herome.R;

import static net.redfrench.herome.R.drawable.item_selected_btn;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.MainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener {  // implement View interface

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Button accidentBtn;
    private Button mutationBtn;
    private Button bornBtn;
    private Button chooseBtn;
    int leftDrawable = 0;

    private MainFragmentInteractionListener mListener;


//    ************************************************************************
//    ************************************************************************
//    ************************************************************************


    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    // ONCREATE
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    // ONCREATEVIEW
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);  // store the view in 'view'

        // grab all buttons
        accidentBtn = (Button)view.findViewById(R.id.accidentBtn);  // calling findViewById on the view which was stored above
        mutationBtn = (Button)view.findViewById(R.id.mutationBtn);  // cast what's found into a button so methods can be used on it
        bornBtn = (Button)view.findViewById(R.id.bornBtn);
        chooseBtn = (Button)view.findViewById(R.id.chooseBtn);

        accidentBtn.setOnClickListener(this);  // finds the onClick listener that's part of this 'MainFragment' class
        mutationBtn.setOnClickListener(this);
        bornBtn.setOnClickListener(this);

        chooseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                MainActivity mainActivity = (MainActivity)getActivity();  // getActivity() in a fragment gets the activity hosting the fragment
                                                                          // A fragment doesn't have its own instance of a Context object.
                                                                          // However, once the fragment is added to the parent activity, it can
                                                                          // call getActivity() to access the parent activity and use the context
                                                                          // of the parent activity
                mainActivity.loadChoosePowerScreen();  // load fragment
            }
        });

        // disable and dim 'Choose' button
        chooseBtn.setEnabled(false);
        chooseBtn.getBackground().setAlpha(128);  // (255 would be 100% transparent)

        // Inflate the layout for this fragment
        return view;
    }

    // generic onclick function
    @Override
    public void onClick(View view) {  // a button is a view, so the clicked button gets passed in as a view
        MainActivity mainActivity = (MainActivity)getActivity();

        chooseBtn.setEnabled(true);
        chooseBtn.getBackground().setAlpha(255);  // fully opaque

        Button btn = (Button)view;  // cast the passed-in view into a button so methods can be performed on it

        if (btn == accidentBtn) {
            leftDrawable = R.drawable.lightning;
            mutationBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.atomic,0,0,0);
            bornBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.rocket,0,0,0);
            mainActivity.HOWOBTAINED = "  Pure Accident";
        } else if (btn == mutationBtn) {
            leftDrawable = R.drawable.atomic;
            accidentBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lightning,0,0,0);
            bornBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.rocket,0,0,0);
            mainActivity.HOWOBTAINED = "  Mean Mutation";
        } else if (btn == bornBtn) {
            leftDrawable = R.drawable.rocket;
            accidentBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lightning,0,0,0);
            mutationBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.atomic,0,0,0);
            mainActivity.HOWOBTAINED = "  Born Bad to the Bone... bbbaaad";
        }

        // set 'drawableRight' property on button that's clicked
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0, item_selected_btn,0);  // (left, top, right, bottom)

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMainFragmentInteraction(uri);
        }
    }


    // ONATTACH
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    // ONDETACH
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
    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction(Uri uri);  // this function gets called when something needs to interact
    }
}
