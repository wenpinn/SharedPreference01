package tools.wpfang.sharedpreference01;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText userEditText;
    EditText passEditText;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userEditText=findViewById(R.id.usernametext);
        passEditText=findViewById(R.id.passtext);
        sp=getSharedPreferences("MyPrefGFile",MODE_PRIVATE);
        String userValue=sp.getString("user","");
        String passValue=sp.getString("pass","");
        userEditText.setText(userValue);
        passEditText.setText(passValue);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String s1=userEditText.getText().toString();
        String s2=passEditText.getText().toString();
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("user",s1);
        ed.putString("pass",s2);
        ed.apply();
    }
}
