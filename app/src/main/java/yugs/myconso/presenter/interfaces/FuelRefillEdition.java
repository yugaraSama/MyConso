package yugs.myconso.presenter.interfaces;

public interface FuelRefillEdition {
    interface View{
        void setDateDisplay(String format);

        void enableConfirmButton();

        void setRefillList();
    }

    interface Presenter{
        void onDateSet(int yy, int mm, int dd);
        void onCancel();
        void onConfirm(String price, String liter);
    }
}
