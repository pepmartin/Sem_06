package pe.edu.jmb.pregunta_01;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterContact extends RecyclerView.Adapter<AdapterContact.ContactPrototype> {

    ArrayList<Contact> items;

    public AdapterContact(ArrayList<Contact> items)
    {
        this.items = items;
    }

    @NonNull
    @Override
    public ContactPrototype onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prototype_contact,
                viewGroup, false);
        ContactPrototype contactPrototype = new ContactPrototype(view);
        return contactPrototype;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactPrototype contactPrototype, int i) {
        contactPrototype.tvName.setText(items.get(i).getName());
        contactPrototype.tvCompany.setText(items.get(i).getCompany());
        contactPrototype.tvPhone.setText(items.get(i).getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ContactPrototype extends RecyclerView.ViewHolder {

        TextView tvName, tvCompany, tvPhone;

        public ContactPrototype(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvCompany = itemView.findViewById(R.id.tvCompany);
            tvPhone = itemView.findViewById(R.id.tvPhone);
        }
    }
}
