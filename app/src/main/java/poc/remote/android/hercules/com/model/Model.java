package poc.remote.android.hercules.com.model;

import android.bluetooth.BluetoothAdapter;

import poc.remote.android.hercules.com.presenter.IPresenter;

import static poc.remote.android.hercules.com.model.bluetooth.ErrorType.BLUETOOTH_NOT_SUPPORTED;
import static poc.remote.android.hercules.com.model.bluetooth.ErrorType.BLUETOOTH_OFF;

public class Model implements IModel {

    private IPresenter presenter;

    public Model(IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void discoverBluetoothDeviceModel() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            if (bluetoothAdapter.isEnabled()) {

            } else {
                presenter.onError(BLUETOOTH_OFF);
            }
        } else {
            presenter.onError(BLUETOOTH_NOT_SUPPORTED);
        }
    }
}
