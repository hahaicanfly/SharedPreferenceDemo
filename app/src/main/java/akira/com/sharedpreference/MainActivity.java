package akira.com.sharedpreference;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

        private EditText name;
        private EditText password;
        private EditText phone;

        private Button btnCommit;
        private Button btnClear;
        private Button btnRead;

        MainActivity instance;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initAvtivity();
            readData();
            instance = this;
            setClickLIstener();

        }


    public void initAvtivity(){
        name = (EditText)findViewById(R.id.edName);
        password = (EditText)findViewById(R.id.edPasswd);
        phone = (EditText)findViewById(R.id.edPhone);

        btnCommit = (Button)findViewById(R.id.btnCommit);
        btnClear = (Button)findViewById(R.id.btnClear);
        btnRead = (Button)findViewById(R.id.btnRead);
    }



    public void readData(){
        name.setText(shareDAO.getInstance(this).getName());
        password.setText(shareDAO.getInstance(this).getPassword());
        phone.setText(shareDAO.getInstance(this).getPhone());
    }

    public void saveData(){

        shareDAO.getInstance(instance).setName(shareDAO.Name,name.getText().toString());
        shareDAO.getInstance(instance).setPassword(shareDAO.Password,password.getText().toString());
        shareDAO.getInstance(instance).setPhone(shareDAO.Phone,phone.getText().toString());
    }

    public void cleanData(){
        name.setText("");
        password.setText("");
        phone.setText("");
    }



    public void setClickLIstener(){

        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleanData();
            }
        });

    }

}
