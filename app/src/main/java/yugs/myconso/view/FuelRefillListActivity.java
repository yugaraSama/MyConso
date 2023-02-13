package yugs.myconso.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import yugs.myconso.R;
import yugs.myconso.model.Refill;
import yugs.myconso.presenter.interfaces.FuelRefill;
import yugs.myconso.presenter.FuelRefillPresenter;


public class FuelRefillListActivity extends AppCompatActivity implements FuelRefill.View {

    private final FuelRefill.Presenter presenter = new FuelRefillPresenter(this);
    private RecyclerView fuelRefillList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton editRefillButton = findViewById(R.id.addFuelRefill);
        fuelRefillList = findViewById(R.id.FuelRefillList);

        editRefillButton.setOnClickListener(view -> {
            Intent intentAddRefill = new Intent(this, FuelRefillEditionActivity.class);
            startActivity(intentAddRefill);
        });
    }

    @Override
    public void setFuelConsumptionList(List<Refill> RefillList) {

    }
}
