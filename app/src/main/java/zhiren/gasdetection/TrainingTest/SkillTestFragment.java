package zhiren.gasdetection.TrainingTest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zhiren.gasdetection.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SkillTestFragment extends Fragment {


    public SkillTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_test, container, false);
    }

}
