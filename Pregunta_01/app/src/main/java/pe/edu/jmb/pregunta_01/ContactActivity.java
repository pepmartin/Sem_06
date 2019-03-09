package pe.edu.jmb.pregunta_01;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ContactActivity extends AppCompatActivity {

    TextInputEditText etName, etCompany, etPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        etName = findViewById(R.id.etName);
        etCompany = findViewById(R.id.etCompany);
        etPhone = findViewById(R.id.etPhone);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contact_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String name = etName.getText().toString();
        String company = etCompany.getText().toString();
        String phone = etPhone.getText().toString();

        Contact contact = new Contact(name,company,phone);

        Intent intent = getIntent();

        intent.putExtra("contact_name",name);
        intent.putExtra("contact_company",company);
        intent.putExtra("contact_phone",phone);

        setResult(RESULT_OK, intent);

        finish();
        return true;
    }
}
