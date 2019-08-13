package com.alansolisflores.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private ListView nameListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nameListView = findViewById(R.id.nameListView);

        PersonModel person = new PersonModel();
        person.firstName = "Andrea";
        person.lastName = "Vega";

        Realm.init(this);

        //Instance
        Realm realm = Realm.getDefaultInstance();

        //Start transaction
        realm.beginTransaction();

        //Save
        realm.copyToRealm(person);

        //Close transaction
        realm.commitTransaction();

        //Query find all
        RealmResults<PersonModel> realmResults = realm.where(PersonModel.class).findAll();

        CustomAdapter customAdapter = new CustomAdapter(R.layout.item_layout,this,realmResults);

        this.nameListView.setAdapter(customAdapter);
    }
}
