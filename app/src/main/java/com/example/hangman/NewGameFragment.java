package com.example.hangman;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Scanner;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.lang.String;
import java.net.URL;
import java.util.Random;


public class NewGameFragment extends Fragment {

    public NewGameFragment() {
        // Required empty public constructor
    }
    Button button1;
    Button button2;
    EditText editText1;
    TextView textView2;
    TextView textView3;
    ImageView imageView1;
    String letter;
    String word1="JAPAN";
    String word2="BELGIUM";
    String word3="SYRIA";
    String word4="SPAIN";
    String word5="ITALY";
    String word0="KOREA";
    int indexofletter;
    int imagecount;
    String imagename;
    int wordlength;
    String howmanyx="X";
    String xword;
int guessedcount;
int wordnumber;
    String newword;
    String savedword;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_game, container, false);

        button1 = v.findViewById(R.id.guess_new_word_btn);
        button2 = v.findViewById(R.id.try_btn);
        editText1 = v.findViewById(R.id.text_input);
        textView2 = v.findViewById(R.id.myWord);
        textView3 = v.findViewById(R.id.how_many_tries);
        imageView1 = v.findViewById(R.id.imageView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Random random = new Random();
                wordnumber = random.nextInt(5);
switch (wordnumber)
{
    case 1:
        newword =word2;
        wordnumber++;
        break;
    case 2:
        newword =word3;
        wordnumber++;
        break;
    case 3:
        newword =word4;
        wordnumber++;
        break;
    case 4:
        newword =word5;
        wordnumber++;
        break;
        default:
        newword =word0;
        wordnumber++;
        break;
}

                editText1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                wordlength=0;
                imagecount=0;
                guessedcount = 0;
                howmanyx="X";
                savedword = newword;
                textView2.setText("Guess The Country");
                xword = newword;
                imageView1.setImageResource(R.drawable.image);
                wordlength = newword.length();
                for (int i = 1 ; i< wordlength ;i++)
                {
                    howmanyx=howmanyx+"X";
                    xword = howmanyx;
                }
                textView3.setText(howmanyx);

            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                letter = editText1.getText().toString();


                if (imagecount < 7 && guessedcount < wordlength);
                {

                if (newword.contains(letter) == true)
{

    indexofletter = newword.indexOf(letter);
    xword = xword.substring(0, indexofletter) + letter + xword.substring(indexofletter + 1);
    newword = newword.substring(0, indexofletter) + "5" + newword.substring(indexofletter + 1);
    textView3.setText(xword);
    guessedcount++;
}
                else
                    {
                    imagecount++;
                    imageView1.setImageResource(R.drawable.image+imagecount);
                }


                }

                if (imagecount >= 7)
                {
                    imageView1.setImageResource(R.drawable.hangman);
                    textView2.setText("  Game Over ... The Word Was ");
                    textView3.setText(savedword);
                }
                if (guessedcount >= wordlength)
                {
                    imageView1.setImageResource(R.drawable.win);
                    textView2.setText(" ******** You Win ********");
                    textView3.setText(savedword);
                }

                if (wordnumber > 6)
                    wordnumber++;
                else wordnumber=0;

            }
        });

        return v;

    }




}













