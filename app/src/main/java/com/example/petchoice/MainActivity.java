package com.example.petchoice;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkStart;
    TextView tvTitle;
    RadioGroup rGroup;
    RadioButton rdoDog, rdoCat, rdoRabbit;
    Button btnOk;
    ImageView imPet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar=getSupportActionBar();
        bar.setTitle("애완동물 사진보기");
        bar.setIcon(R.drawable.adicon);
        bar.setDisplayShowHomeEnabled(true);
        chkStart=findViewById(R.id.chkStart);
        tvTitle=findViewById(R.id.tvTitle);
        rGroup=findViewById(R.id.rdGroup);
        rdoCat=findViewById(R.id.rdCat);
        rdoDog=findViewById(R.id.rdDog);
        rdoRabbit=findViewById(R.id.rdRabbit);
        btnOk=findViewById(R.id.btnOk);
        imPet=findViewById(R.id.imPet);

        //체크박스를 통해 객체 보이거나 안 보이게 하는 설정 이벤트
        chkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    tvTitle.setVisibility(View.VISIBLE);
                    rGroup.setVisibility(View.VISIBLE);
                    btnOk.setVisibility(View.VISIBLE);
                    imPet.setVisibility(View.VISIBLE);
                } else{
                    tvTitle.setVisibility(View.INVISIBLE);
                    rGroup.setVisibility(View.INVISIBLE);
                    btnOk.setVisibility(View.INVISIBLE);
                    imPet.setVisibility(View.INVISIBLE);
                }
            }
        });
        //라디오 버튼에서 애완동물을 선택한 후 선택완료 버튼을 통해 이미지 보여주기.
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.rdDog:
                        imPet.setImageResource(R.drawable.dog);
                        break;
                    case R.id.rdCat:
                        imPet.setImageResource(R.drawable.cat);
                        break;
                    case R.id.rdRabbit:
                        imPet.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "체크해주세요.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}