package yugs.myconso.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import yugs.myconso.R;
import yugs.myconso.presenter.FuelRefillEditionPresenter;
import yugs.myconso.presenter.interfaces.FuelRefillEdition;

public class FuelRefillEditionActivity extends AppCompatActivity implements FuelRefillEdition.View {
    private FuelRefillEdition.Presenter presenter;
    private FloatingActionButton confirmAddingRefill, cancelRefill;
    private TextView refillPriceByLiter, refillLiters;
    private Button datePickerButton;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_refill);

        this.presenter = new FuelRefillEditionPresenter(this);

        datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.setOnDateSetListener((view, yy, mm, dd) -> presenter.onDateSet(yy, mm, dd));

        confirmAddingRefill = findViewById(R.id.addRefillButton);
        cancelRefill = findViewById(R.id.cancelCreatingRefillButton);

        refillPriceByLiter = findViewById(R.id.price);
        refillLiters = findViewById(R.id.liters);
        datePickerButton = findViewById(R.id.refillDate);

        datePickerButton.setOnClickListener(view -> datePickerDialog.show());
        cancelRefill.setOnClickListener((view -> presenter.onCancel()));
        confirmAddingRefill.setEnabled(false);

        refillLiters.addTextChangedListener(watcher);
        refillPriceByLiter.addTextChangedListener(watcher);
    }

    @Override
    public void setDateDisplay(String format) {
        datePickerButton.setText(format);
    }

    @Override
    public void enableConfirmButton() {
        confirmAddingRefill.setEnabled(true);
    }

    @Override
    public void setRefillList() {
        setContentView(R.layout.activity_main);
    }

    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            confirmAddingRefill.setEnabled(!refillPriceByLiter.getText().toString().isEmpty() && !refillLiters.getText().toString().isEmpty());
        }
    };

}
