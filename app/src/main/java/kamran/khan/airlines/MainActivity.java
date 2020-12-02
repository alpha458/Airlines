package kamran.khan.airlines;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    Button b1, b2, b3, b4;
    ViewFlipper v_fliffer;
    View d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ImageView open_drawer_btn = findViewById(R.id.open_drawer_btn);
        open_drawer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent it = new Intent();
                switch (item.getItemId()) {
                    case R.id.nav_share_item:
                        it.setAction(Intent.ACTION_SEND);
                        it.putExtra(Intent.EXTRA_TEXT,
                                "https://play.google.com/store/apps/details?id=kamran.khan.airlines");
                        it.setType("text/plain");
                        startActivity(Intent.createChooser(it, "Choose one"));
                        break;
                    case R.id.nav_rate_item:
                        it.setAction(Intent.ACTION_VIEW);
                          it.setData(Uri.parse("https://play.google.com/store/apps/details?id=kamran.khan.airlines"));
                        startActivity(it);
                        break;
                    case R.id.nav_about_item:
                        startActivity(new Intent(MainActivity.this, about_us.class));
                        break;
                }
                return false;
            }
        });

        int image[] = {R.drawable.p1, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6};

        v_fliffer = findViewById(R.id.fliffer);

        for (int i = 0; i < image.length; i++) {
            flifferImages(image[i]);
        }


        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Airline.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, CurrencyCunverter.class);
                startActivity(it);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, hotel.class);
                startActivity(it);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, GoogleMap.class);
                startActivity(it);
            }
        });

    }

    public void flifferImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        v_fliffer.addView(imageView);
        v_fliffer.setFlipInterval(2000);
        v_fliffer.setAutoStart(true);

        v_fliffer.setPadding(0, 10, 0, 10);
        v_fliffer.setInAnimation(this, android.R.anim.slide_in_left);
        v_fliffer.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void onBackPressed() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure to exit ?");
        builder.setCancelable(true);
        builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                System.exit(0);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


}
