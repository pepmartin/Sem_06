package pe.edu.jmb.pregunta_01;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvContact;
    ArrayList<Contact> items;

    AdapterContact adapterContact;

    final static int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContact = findViewById(R.id.rvContact);

        items = new ArrayList<>();
        
        loadItems();

        adapterContact =  new AdapterContact(items);
        rvContact.setAdapter(adapterContact);
        rvContact.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadItems() {
        Contact contactEntel = new Contact("Juan Valdez","ENTEL PERÚ","987675645");
        items.add(contactEntel);

        Contact contactClaro =  new Contact("Silvio Romero","CLARO PERÚ","989786545");
        items.add(contactClaro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this,ContactActivity.class);
        startActivityForResult(intent,REQUEST_CODE);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if  (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String name = data.getStringExtra("contact_name");
            String company = data.getStringExtra("contact_company");
            String phone = data.getStringExtra("contact_phone");

            Contact contact = new Contact(name,company,phone);
            items.add(contact);
            adapterContact.notifyDataSetChanged();
        }
    }

}
