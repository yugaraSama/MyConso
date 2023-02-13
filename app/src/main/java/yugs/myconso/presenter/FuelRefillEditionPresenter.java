package yugs.myconso.presenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import yugs.myconso.model.Refill;
import yugs.myconso.presenter.interfaces.FuelRefillEdition;

public class FuelRefillEditionPresenter implements FuelRefillEdition.Presenter {

    private final FuelRefillEdition.View view;
    private Refill refill;

    public FuelRefillEditionPresenter(FuelRefillEdition.View view) {
        this.view = view;
        this.refill = new Refill();
    }

    @Override
    public void onDateSet(int yy, int mm, int dd) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, yy);
        cal.set(Calendar.MONTH, mm);
        cal.set(Calendar.DAY_OF_MONTH, dd);

        refill.setDate(cal.getTime());
        view.setDateDisplay(SimpleDateFormat.getDateInstance().format(cal.getTime()));
        view.enableConfirmButton();

    }

    @Override
    public void onCancel() {
        view.setRefillList();
    }

    @Override
    public void onConfirm(String price, String liter) {
        refill.setPrice(price);
        refill.setLiter(liter);
    }

    //create second constructor for if the refill is modified

}
