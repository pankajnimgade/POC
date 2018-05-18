package poc.remote.android.hercules.com.presenter;

import poc.remote.android.hercules.com.model.IModel;
import poc.remote.android.hercules.com.model.Model;
import poc.remote.android.hercules.com.model.bluetooth.ErrorType;
import poc.remote.android.hercules.com.view.IMainActivity;

public class Presenter implements IPresenter {

    private IModel model;

    private IMainActivity view;

    public Presenter(IMainActivity view) {
        this.view = view;
        this.model = new Model(this);
    }

    @Override
    public void discoverBluetoothDevice() {
        model.discoverBluetoothDeviceModel();
    }

    @Override
    public void onError(ErrorType errorType) {
        view.onErrorUi(errorType);
    }
}
