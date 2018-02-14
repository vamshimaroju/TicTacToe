package com.vamshimaroju.tictactoe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    boolean player = true;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.one);
        btn2 = (Button) findViewById(R.id.two);
        btn3 = (Button) findViewById(R.id.three);
        btn4 = (Button) findViewById(R.id.four);
        btn5 = (Button) findViewById(R.id.five);
        btn6 = (Button) findViewById(R.id.six);
        btn7 = (Button) findViewById(R.id.seven);
        btn8 = (Button) findViewById(R.id.eight);
        btn9 = (Button) findViewById(R.id.nine);

    }

    @Override
    public void onClick(View view){

        Button c = (Button) findViewById(view.getId());
        String s = (String) c.getText();

            if(player == true && s == "" ){
                player = false;
                c.setText("X");
                track();
            }else if(s == ""){
                player = true;
                c.setText("O");
                track();
            }
    }

    public void resetGame(View view){
        player = true;
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
    }

    public void track(){

        String[] s = new String[9];
        s[0] = (String) btn1.getText();
        s[1] = (String) btn2.getText();
        s[2] = (String) btn3.getText();
        s[3] = (String) btn4.getText();
        s[4] = (String) btn5.getText();
        s[5] = (String) btn6.getText();
        s[6] = (String) btn7.getText();
        s[7] = (String) btn8.getText();
        s[8] = (String) btn9.getText();

        if    ( s[0]==s[1] && s[1]==s[2] ||
                s[0]==s[3] && s[3]==s[6] ||
                s[0]==s[4] && s[4]==s[8]

                ){
            if(s[0] == "X" ){
//                Toast.makeText(this,"x win the game",Toast.LENGTH_SHORT).show();
                showDialog(MainActivity.this, "X win the Game");
            }
            if(s[0] == "O") {
//                Toast.makeText(this,"o win the game",Toast.LENGTH_SHORT).show();
                showDialog(MainActivity.this, "O win the Game");
            }
        }else  if    ( s[8]==s[7] && s[7]==s[6] ||
                s[8]==s[5] && s[5]==s[2]

                ){
            if(s[8] == "X" ){
//                Toast.makeText(this,"x win the game",Toast.LENGTH_SHORT).show();
                showDialog(MainActivity.this, "X win the Game");

           }
            if(s[8] == "O") {
//                Toast.makeText(this,"o win the game",Toast.LENGTH_SHORT).show();
                showDialog(MainActivity.this, "O win the Game");

            }
        }else if ( s[3]==s[4] && s[4]==s[5] ||
                s[4]==s[1] && s[4]==s[7] ||
                s[2]==s[4] && s[4]==s[6]
              ){
            if(s[4] == "X" ){
//                Toast.makeText(this,"x win the game",Toast.LENGTH_SHORT).show();
                showDialog(MainActivity.this, "X win the Game");

            }
            if(s[4] == "O") {
//                Toast.makeText(this,"o win the game",Toast.LENGTH_SHORT).show();
                showDialog(MainActivity.this, "O win the Game");

            }
        }else if( s[0]!="" && s[1]!="" && ""!=s[2] &&
                 ""!=s[3] && ""!=s[4] && ""!=s[5] &&
                 ""!=s[6] && ""!=s[7] && ""!=s[8]){
            showDialog(MainActivity.this, "Game Tie");
        }


    }

    private void showDialog(MainActivity mainActivity, String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage(s);
        builder.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                player = true;
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");

            }
        }).setNegativeButton("Exit Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.create().show();
    }

}