/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.doitlikeitsyourjob.letscooklasagna;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.pollfish.constants.Position;
import com.pollfish.main.PollFish;


/**
 * A fragment representing a single step in a wizard. The fragment shows a dummy title indicating
 * the page number, along with some dummy text.
 * <p/>
 * <p>This class is used by the  {@link ScreenSlideActivity} sample.</p>
 */

public class ScreenSlidePageFragment extends Fragment {

    String[] RecipeArray;
    int[] ImageArray = new int[]
            {
                    R.drawable.wrecipeimg1, R.drawable.wrecipeimg2, R.drawable.wrecipeimg3,
                    R.drawable.wrecipeimg4, R.drawable.wrecipeimg5, R.drawable.wrecipeimg6,
                    R.drawable.wrecipeimg7, R.drawable.wrecipeimg8, R.drawable.wrecipeimg9,
                    R.drawable.wrecipeimg10, R.drawable.wrecipeimg11, R.drawable.wrecipeimg12,
                    R.drawable.wrecipeimg13, R.drawable.wrecipeimg14, R.drawable.wrecipeimg15,
                    R.drawable.wrecipeimg16, R.drawable.wrecipeimg17, R.drawable.wrecipeimg18,
                    R.drawable.wrecipeimg19, R.drawable.wrecipeimg20, R.drawable.wrecipeimg21,
                    R.drawable.wrecipeimg22, R.drawable.wrecipeimg23,R.drawable.wrecipeimg24,
                    R.drawable.wrecipeimg25,R.drawable.wrecipeimg26,R.drawable.wrecipeimg27,
                    R.drawable.wrecipeimg28,R.drawable.wrecipeimg29
            };

    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE**
     */
    private int mPageNumber;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ScreenSlidePageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout containing a title and body text and picture
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_screen_slide_page, container, false);

        // Set the title view to show the page number.
        ((TextView) rootView.findViewById(android.R.id.text1)).setText(
                getString(R.string.title_template_step, mPageNumber + 1));

        //Get Recipe Instructions via Array
        RecipeArray = getResources().getStringArray(R.array.recipe);

        //Assign TextView to Array
        TextView tv = (TextView) rootView.findViewById(R.id.tv_recipe_desc);
        tv.setText(RecipeArray[mPageNumber]);

        ImageView iv = (ImageView) rootView.findViewById(R.id.iv_recipe_image);
        iv.setImageResource(ImageArray[mPageNumber]);

        //Advert
        AdView adView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("4C67C373883EA1BA088AA0DD0B2D4BBE")  // My HTC One X test phone
                .build();
        adView.loadAd(adRequest);


        //if (mPageNumber == 10)  {
        //    handleAdColony();
        //}

        //if (mPageNumber == 20 ) {
        //    handleAdColony();
        //}

        //if (mPageNumber==6) {
        //    Button button = (Button) rootView.findViewById((R.id.btn_alarm));
        //    button.setVisibility(1);

        //    button.setOnClickListener(new View.OnClickListener() {
        //        @Override
        //        public void onClick(View view) {
        //Toast toast = Toast.makeText(getActivity(), "Test", Toast.LENGTH_SHORT);
        //toast.show();
        //handleButtonSetAlarmClick();

        //Intent intent = new Intent(ScreenSlidePageFragment.this.getActivity(), PingMain.class);
        //startActivity(intent);
        //        }
        //    });
        //}

        return rootView;
    }

   // private void handleAdColony() {
        //Intent intent = new Intent(getActivity(), AdColonyView.class);
        //startActivity(intent);
    //}


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }

/**@Override public void onClick(View view) {
Toast toast = Toast.makeText(getActivity(), "Test1", Toast.LENGTH_SHORT);
toast.show();
}
 */


}



