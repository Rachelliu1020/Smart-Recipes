package com.example.rache.smartrecipes;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        initDB();
    }

    private void initDB(){
        RecipesOpenHelper helper = new RecipesOpenHelper(getApplicationContext());
        final SQLiteDatabase db = helper.getWritableDatabase();

        if(helper.getAllNumOfRecipes(db)==0){
            db.beginTransaction();
            try{
                String[] d_1 = getResources().getStringArray(R.array.dinner1);
                String[] d_2 = getResources().getStringArray(R.array.dinner2);
                String[] d_3 = getResources().getStringArray(R.array.dinner3);
                String[] d_4 = getResources().getStringArray(R.array.dinner4);
                String[] d_5 = getResources().getStringArray(R.array.dinner5);
                String[] d_6 = getResources().getStringArray(R.array.dinner6);

                helper.insertRecipe(db, d_1[0], d_1[1], d_1[2], d_1[3], d_1[4], Integer.parseInt(d_1[5]));
                helper.insertRecipe(db, d_2[0], d_2[1], d_2[2], d_2[3], d_2[4], Integer.parseInt(d_2[5]));
                helper.insertRecipe(db, d_3[0], d_3[1], d_3[2], d_3[3], d_3[4], Integer.parseInt(d_3[5]));
                helper.insertRecipe(db, d_4[0], d_4[1], d_4[2], d_4[3], d_4[4], Integer.parseInt(d_4[5]));
                helper.insertRecipe(db, d_5[0], d_5[1], d_5[2], d_5[3], d_5[4], Integer.parseInt(d_5[5]));
                helper.insertRecipe(db, d_6[0], d_6[1], d_6[2], d_6[3], d_6[4], Integer.parseInt(d_6[5]));
                db.setTransactionSuccessful();
            }finally {
                db.endTransaction();
            }
        }
        db.close();
    }

    public void customizeRecipe(final View v){
        final Intent intent_custom = new Intent(this, Customize_Activity.class);
        startActivity(intent_custom);
    }

    public void breakfastGallery(final View v){
        Intent intent_bfGallery= new Intent(this, RecipesGallery.class);
        intent_bfGallery.putExtra("type", "breakfast");
        startActivity(intent_bfGallery);
    }

    public void lunchGallery(final View v){
        final Intent intent_lunchGallery = new Intent(this, RecipesGallery.class);
        intent_lunchGallery.putExtra("type", "lunch");
        startActivity(intent_lunchGallery);
    }

    public void dinnerGallery(final View v){
        final Intent intent_dinnerGallery = new Intent(this, RecipesGallery.class);
        intent_dinnerGallery.putExtra("type", "dinner");
        startActivity(intent_dinnerGallery);
    }
}
