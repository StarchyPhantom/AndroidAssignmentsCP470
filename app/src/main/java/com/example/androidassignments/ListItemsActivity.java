package com.example.androidassignments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListItemsActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ListItemsActivity", "onCreate() called");
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_items);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent,
                            10);}
            }
        });

        Switch switchButton = findViewById(R.id.switch1);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CharSequence text = getString(R.string.switch_off);
                int duration = Toast.LENGTH_LONG;

                if (isChecked) {
                    text = getString(R.string.switch_on);
                    duration = Toast.LENGTH_SHORT;
                }

                Toast toast = Toast.makeText(ListItemsActivity.this , text, duration); //this is the ListActivity
                toast.show(); //display your message box
            }
        });

        CheckBox checkboxButton = findViewById(R.id.checkBox);

        checkboxButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                    // 2. Chain together various setter methods to set the dialog characteristics
                    builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                            .setTitle(R.string.dialog_title)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User clicked OK button
                                    Intent resultIntent = new Intent();
                                    resultIntent.putExtra("Response", getString(R.string.ListItemsActivityReturned));
                                    setResult(Activity.RESULT_OK, resultIntent);
                                    finish();
                                }
                            })
                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User cancelled the dialog
                                    dialog.cancel();
                                }
                            })
                            .show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageButton btnImg = findViewById(R.id.imageButton);
            btnImg.setImageBitmap(imageBitmap);
//            try {
//                saveImage(imageBitmap);
//            }
//            catch (Exception e) {}
        }
    }

    public void print(String input) {
        Toast toast = Toast.makeText(this , input, Toast.LENGTH_SHORT); //this is the ListActivity
        toast.show(); //display your message box
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ListItemsActivity", "onResume() called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ListItemsActivity", "onStart() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ListItemsActivity", "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ListItemsActivity", "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ListItemsActivity", "onDestroy() called");
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i("ListItemsActivity", "onSaveInstanceState() called");

//        String nameValue = "Abdul-Rahman";
//        int accountNumber = 12345;
//        savedInstanceState.putString("name", nameValue);
//        savedInstanceState.putInt("accountNumber", accountNumber);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("ListItemsActivity", "onRestoreInstanceState() called");
    }

    public void goToMain(View view) {
        // go back to main page  in response to button
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}