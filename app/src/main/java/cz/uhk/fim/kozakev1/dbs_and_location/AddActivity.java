package cz.uhk.fim.kozakev1.dbs_and_location;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import cz.uhk.fim.kozakev1.dbs_and_location.database.DatabaseHelper;
import cz.uhk.fim.kozakev1.dbs_and_location.model.Pub;

public class AddActivity extends AppCompatActivity {

    @BindView(R.id.editName)
    EditText editName;

    @BindView(R.id.editLat)
    EditText editLat;

    @BindView(R.id.editLng)
    EditText editLng;

    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        databaseHelper = new DatabaseHelper(this);

        ButterKnife.bind(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuItemAdd) {
            String name = editName.getText().toString();
            double lat = Double.parseDouble(editLat.getText().toString());
            double lng = Double.parseDouble(editLng.getText().toString());

            Pub pub = new Pub(name, lat, lng);


           if(databaseHelper.savePub(pub))  {
               finish(); // vypnu aktivitu a vratim se na seznam
           } else {
               Toast.makeText(this, "OOPS", Toast.LENGTH_SHORT).show();
           }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
