package yugs.myconso.presenter;

import yugs.myconso.presenter.interfaces.FuelRefill;

public class FuelRefillPresenter implements FuelRefill.Presenter{
    private final FuelRefill.View view;

    public FuelRefillPresenter(FuelRefill.View view){
        this.view = view;
    }

    @Override
    public void refreshList() {

    }
}
