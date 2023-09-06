package com.example.cleanarchitecturetest.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cleanarchitecturetest.R;
import com.example.cleanarchitecturetest.data.UserRepositoryImpl;
import com.example.cleanarchitecturetest.domain.LoadUserUseCase;
import com.example.cleanarchitecturetest.domain.SaveUserUseCase;
import com.example.cleanarchitecturetest.domain.entety.User;

public class MainActivity extends AppCompatActivity {

    Button btnSave, btnLoad;
    EditText editFirst, editSecond;

    private LoadUserUseCase loadUserUseCase;
    private SaveUserUseCase saveUserUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        btnLoad = findViewById(R.id.btn_load);
        btnSave = findViewById(R.id.btn_save);
        editFirst = findViewById(R.id.firts_edit_text);
        editSecond = findViewById(R.id.second_edit_text);

        loadUserUseCase = new LoadUserUseCase(new UserRepositoryImpl(this));
        saveUserUseCase = new SaveUserUseCase(new UserRepositoryImpl(this));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editSecond.getText().toString();
                User user = new User(name);
                boolean success = saveUserUseCase.saveUser(user);
                if (success){
                    editFirst.setText("Данные успешно сохранены");
                    editSecond.setText("");
                }
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = loadUserUseCase.loadUser();
                editFirst.setText(name);
            }
        });
    }
}