package com.example.baecosmoclinic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class BaeProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bae_profile);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        final LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        final TextView tv1 = (TextView) findViewById(R.id.profileTextView1);
        final TextView tv2 = (TextView) findViewById(R.id.profileTextView2);
        final TextView tv3 = (TextView) findViewById(R.id.profileTextView3);
        final TextView tv4 = (TextView) findViewById(R.id.profileTextView4);


        tv1.setText("Education & Training\n");
        tv2.setText(
                "M.D. Saint Louis University - School of Medicine\n" +
                        "Residency, Plastic Surgery - UMKC/Truman Medical Center\n" +
                        "Fellowship, Hand Surgery - UMKC/KU\n" +
                        "\n" +
                        "Certified by The American Board of Plastic Surgery (ABPS)\n");
        tv3.setText("Asian Cosmetic Surgery Specialist\n");
        tv4.setText("\tThe creation of an aesthetically pleasing Asian face requires thorough knowledge of the anatomy of the Asian facial skeleton as well as an appreciation of the Asian ideals of beauty.\n\n" +
                "\tSymmetrical eyelid crease with smooth, firmly attached skin overlying the tarsus, and mobile, loosely attached skin above the level of the crease is aesthetically appealing in Asians.\n\n" +
                "\tAn appreciation of the Asian concept of beauty is required in order to practice Asian cosmetic surgery. In addition to the surgeon's aesthetic sense, imagination, and creativity, the surgeon's training and experience in plastic and reconstructive surgery are absolute requirements."
            );

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){

                    tv1.setText("Education & Training\n");
                    tv2.setText(
                            "M.D. Saint Louis University - School of Medicine\n" +
                            "Residency, Plastic Surgery - UMKC/Truman Medical Center\n" +
                            "Fellowship, Hand Surgery - UMKC/KU\n" +
                            "\n" +
                            "Certified by The American Board of Plastic Surgery (ABPS)\n");
                    tv3.setText("Asian Cosmetic Surgery Specialist\n");
                    tv4.setText("\tThe creation of an aesthetically pleasing Asian face requires thorough knowledge of the anatomy of the Asian facial skeleton as well as an appreciation of the Asian ideals of beauty.\n\n" +
                            "\tSymmetrical eyelid crease with smooth, firmly attached skin overlying the tarsus, and mobile, loosely attached skin above the level of the crease is aesthetically appealing in Asians.\n\n" +
                            "\tAn appreciation of the Asian concept of beauty is required in order to practice Asian cosmetic surgery. In addition to the surgeon's aesthetic sense, imagination, and creativity, the surgeon's training and experience in plastic and reconstructive surgery are absolute requirements."
                    );


                }
                else if(tab.getPosition()==1){

                    tv1.setText("Location\n");
                    tv2.setText("BAE Cosmetic Surgery\n" +
                            "Asia Aesthetica\n" +
                            "2727 W. Olympic Bl., Suite 304\n" +
                            "Los Angeles, CA  90006\n");

                    tv3.setText("");
                    tv4.setText("Tel. (213) 384-7555\n" +
                            "Fax. (213) 738-8798\n");

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
