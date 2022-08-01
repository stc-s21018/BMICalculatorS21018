package jp.suntech.s21018.bmicalculators21018;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btClac=findViewById(R.id.btCalc);
        Listener listener = new Listener();
        btClac.setOnClickListener(listener);

        Button btClear=findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }
    private class Listener implements View.OnClickListener{
        public void onClick(View view){
            EditText age = findViewById(R.id.etAge);
            EditText height = findViewById(R.id.etHeight);
            EditText weight = findViewById(R.id.etWeight);
            TextView BMI = findViewById(R.id.tvBMI);
            TextView result = findViewById(R.id.tvResult);

            String agestr=age.getText().toString();
            String heightstr=age.getText().toString();
            String weightstr=age.getText().toString();

            double age2=Integer.parseInt(agestr);
            double height2=Float.parseFloat(heightstr);
            double weight2=Float.parseFloat(weightstr);

            int id = view.getId();

            height2/=100;
            switch (id){
                case R.id.btCalc:
                    if(age2<=15) {
                        OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                        dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
                        double BMIstr= weight2/height2*height2;
                        double BMIteki=height2*height2*22;
                        result.setText(String.valueOf(BMIteki));

                        if(BMIstr<=18.5)    BMI.setText("低体重");
                        else if(18.5<=BMIstr&&BMIstr<25) BMI.setText("普通体重");
                        else if(25<=BMIstr&&BMIstr<30) BMI.setText("肥満(1度)");
                        else if(30<=BMIstr&&BMIstr<35) BMI.setText("肥満(2度)");
                        else if(35<=BMIstr&&BMIstr<40) BMI.setText("肥満(3度)");
                        else if(40<=BMIstr) BMI.setText("肥満(4度)");
                        break;
                    }

                    double BMIstr= weight2/height2*height2;
                    double BMIteki=height2*height2*22;
                    result.setText(String.valueOf(BMIteki));

                    if(BMIstr<=18.5)    BMI.setText("低体重");
                    else if(18.5<=BMIstr&&BMIstr<25) BMI.setText("普通体重");
                    else if(25<=BMIstr&&BMIstr<30) BMI.setText("肥満(1度)");
                    else if(30<=BMIstr&&BMIstr<35) BMI.setText("肥満(2度)");
                    else if(35<=BMIstr&&BMIstr<40) BMI.setText("肥満(3度)");
                    else if(40<=BMIstr) BMI.setText("肥満(4度)");
                    break;

                case R.id.btClear:
                    age.setText("");
                    height.setText("");
                    weight.setText("");
                    BMI.setText("");
                    result.setText("");
                    break;
            }
        }
    }
}