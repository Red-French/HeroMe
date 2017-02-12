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

import static net.redfrench.herome.R.drawable.item_selected_btn;
import static net.redfrench.herome.R.drawable.lightning;


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
    int leftDrawable = 0;


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

        turtleBtn.setOnClickListener(this);  // finds the onClick listener that's part of this class (implemented in the class declaration above)
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
        MainActivity mainActivity = (MainActivity)getActivity();

        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(255);

        Button btn = (Button)view;  // cast the passed-in view into a button so methods can be performed on it

        if (btn == turtleBtn) {
            leftDrawable = R.drawable.turtlepower_icon;
            lightningBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lightning_icon,0,0,0);
            flightBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superman_crest,0,0,0);
            webBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
            laserBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.laservision_icon,0,0,0);
            strengthBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superstrength_icon,0,0,0);
            mainActivity.BACKSTORYHDR = "TURTLE POWER";
            mainActivity.BACKSTORY = "The secret of turtle power lies in slowness; it's actually patience.  Don't be fooled like the silly rabbit.  This guy is a hard shell to crack.";
            mainActivity.USERSPOWER = "Turtle Power";
            mainActivity.WEAKNESS = " A soft underbelly.  Gotta keep the sunny side up.";
        } else if (btn == lightningBtn) {
            turtleBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.turtlepower_icon,0,0,0);
            leftDrawable = R.drawable.lightning_icon;
            flightBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superman_crest,0,0,0);
            webBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
            laserBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.laservision_icon,0,0,0);
            strengthBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superstrength_icon,0,0,0);
            mainActivity.BACKSTORYHDR = "LIGHTNING ~~";
            mainActivity.BACKSTORY = "This is a story of lightning.  I was struck with this power one sunny day.";
            mainActivity.USERSPOWER = "Lightning";
            mainActivity.WEAKNESS = "Weakness? Come on, it's LIGHTNING.";
        } else if (btn == flightBtn) {
            turtleBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.turtlepower_icon,0,0,0);
            lightningBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lightning_icon,0,0,0);
            leftDrawable = R.drawable.superman_crest;
            webBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
            laserBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.laservision_icon,0,0,0);
            strengthBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superstrength_icon,0,0,0);
            mainActivity.BACKSTORYHDR = "FLIGHT";
            mainActivity.BACKSTORY = "Maybe it came from the wRight Bros., but I just as soon keep my boots in the dirt.";
            mainActivity.USERSPOWER = "Flight";
            mainActivity.WEAKNESS = "Crashing.  Crashing.  CRASHING. (no thanks)";
        } else if (btn == webBtn) {
            turtleBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.turtlepower_icon,0,0,0);
            lightningBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lightning_icon,0,0,0);
            flightBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superman_crest,0,0,0);
            leftDrawable = R.drawable.spider_web;
            laserBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.laservision_icon,0,0,0);
            strengthBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superstrength_icon,0,0,0);
            mainActivity.BACKSTORYHDR = "WEB SLINGING";
            mainActivity.BACKSTORY = "Well... what can I say?  Spinnin' tall tales is my special power.  'nuff said.";
            mainActivity.USERSPOWER = "Web Slinging";
            mainActivity.WEAKNESS = "Getting caught.  Quiet!";
        } else if (btn == laserBtn) {
            turtleBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.turtlepower_icon,0,0,0);
            lightningBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lightning_icon,0,0,0);
            flightBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superman_crest,0,0,0);
            webBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
            leftDrawable = R.drawable.laservision_icon;
            strengthBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superstrength_icon,0,0,0);
            mainActivity.BACKSTORYHDR = "LASER VISION";
            mainActivity.BACKSTORY = "Walking out of a dimly-lit cafe, I bumped into the 6-million dollar man.  Since then, well... you know.";
            mainActivity.USERSPOWER = "Laser Vision";
            mainActivity.WEAKNESS = "Sharp sticks to the orbital area of the skull.";
        } else if (btn == strengthBtn) {
            turtleBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.turtlepower_icon,0,0,0);
            lightningBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lightning_icon,0,0,0);
            flightBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superman_crest,0,0,0);
            webBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
            laserBtn.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.laservision_icon,0,0,0);
            leftDrawable = R.drawable.superstrength_icon;
            mainActivity.BACKSTORYHDR = "SUPER STRENGTH";
            mainActivity.BACKSTORY = "Watching The Hulk weekly was great education on becoming strong.  Just rip the shirt off.";
            mainActivity.USERSPOWER = "Super Strength";
            mainActivity.WEAKNESS = "Turning green.  That part sucks, strong or not.";
        }

        // set 'drawableRight' property on button that's clicked
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0, item_selected_btn,0);  // (left, top, right, bottom)
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
