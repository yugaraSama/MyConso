package yugs.myconso.presenter.interfaces;

import java.util.List;

import yugs.myconso.model.Refill;

public interface FuelRefill {
    interface View{
        void setFuelConsumptionList(List<Refill> RefillList);
    }

    interface Presenter{
        void refreshList();
    }
}
