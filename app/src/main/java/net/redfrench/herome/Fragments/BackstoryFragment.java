package net.redfrench.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import net.redfrench.herome.Activities.MainActivity;

import android.util.Log;
import net.redfrench.herome.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BackstoryFragment.BackstoryFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BackstoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackstoryFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button startOverBtn;

    private BackstoryFragmentInteractionListener mListener;


//    ************************************************************************
//    ************************************************************************
//    ************************************************************************


    public BackstoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackstoryFragment.
     */


    // TODO: Rename and change types and number of parameters
    public static BackstoryFragment newInstance(String param1, String param2) {
        BackstoryFragment fragment = new BackstoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_backstory, container, false);

        MainActivity mainActivity = (MainActivity)getActivity();
        String backStoryHdr = mainActivity.BACKSTORYHDR;
        String backStory = mainActivity.BACKSTORY;
        String usersPower = mainActivity.USERSPOWER;
        String gotHow = mainActivity.HOWOBTAINED;
        String weakness = mainActivity.WEAKNESS;

        startOverBtn = (Button)view.findViewById(R.id.startOverBtn);
        startOverBtn.setOnClickListener(this);


        TextView hdr = (TextView) view.findViewById(R.id.backStoryHdr);
        hdr.setText(backStoryHdr);

        TextView story = (TextView) view.findViewById(R.id.backstoryText);
        story.setText(backStory);

        TextView power = (TextView) view.findViewById(R.id.usersPower);
        power.setText(usersPower);

        TextView howGot = (TextView) view.findViewById(R.id.howObtained);
        howGot.setText(gotHow);

        TextView weakStuff = (TextView) view.findViewById(R.id.weakText);
        weakStuff.setText(weakness);

        switch( backStoryHdr) {
            case "TURTLE POWER":
                story.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.turtle_power3x,0,0,0);
                break;
            case "LIGHTNING ~~":
                story.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.lightning_icon,0,0,0);
                break;
            case "FLIGHT":
                story.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.big_superman_logo,0,0,0);
                break;
            case "WEB SLINGING":
                story.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.spiderweb3x,0,0,0);
                break;
            case "LASER VISION":
                story.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.laservision3x,0,0,0);
                break;
            case "SUPER STRENGTH":
                story.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.superstrength3x,0,0,0);
                break;
        };

        // Inflate the layout for this fragment
        return view;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onBackstoryFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BackstoryFragmentInteractionListener) {
            mListener = (BackstoryFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement BackstoryFragmentInteractionListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    private static final String TAG = "MyActivity";
    @Override
    public void onClick(View view) {
        Button btn = (Button)view;  // cast the passed-in view into a button so methods can be performed on it

        if (btn == startOverBtn) {
            android.util.Log.i(TAG, "Click!");
            MainActivity mainActivity = (MainActivity)getActivity();
            mainActivity.loadMainScreen();
        }
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
    public interface BackstoryFragmentInteractionListener {
        // TODO: Update argument type and name
        void onBackstoryFragmentInteraction(Uri uri);
    }
}
