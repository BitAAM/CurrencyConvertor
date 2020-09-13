package rab.kac.currencyconvertor;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  EditText et1,et2;
  Button btn;
  float conversionRateToRupees= 75;
  float conversionRateToDollar=  0.75f;
  float converted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.dollarinput);
        et2=findViewById(R.id.ruppeesinput);
        btn=findViewById(R.id.convertbutton);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(Double.toString(dollar)) && TextUtils.isEmpty(Double.toString(rupees))){
                    Toast.makeText(MainActivity.this, "Enter amount in either Dollar or Rupees...", Toast.LENGTH_SHORT).show();
                }
                else if(Double.toString(dollar)!=""){
                    ConvertDollar();
                    et2.setText(Double.toString(converted));
                }
                else if(Double.toString(rupees)!=""){
                    ConvertRupees();
                    et1.setText(Double.toString(converted));
                }



            }
        });
    }

    float dollar = (float) Double.parseDouble(et1.getText().toString());
    float rupees = (float) Double.parseDouble(et2.getText().toString());



    public void ConvertDollar(){
        converted=dollar*conversionRateToRupees;
    }



    public void ConvertRupees(){
        converted=rupees*conversionRateToDollar;
    }

}
