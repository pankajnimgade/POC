package poc.remote.android.hercules.com.view.dailog;

import android.bluetooth.BluetoothDevice;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import poc.remote.android.hercules.com.R;
import poc.remote.android.hercules.com.view.dailog.BtDeviceFragment.OnListFragmentInteractionListener;
import poc.remote.android.hercules.com.view.dailog.dummy.DummyContent.DummyItem;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyBtDeviceRecyclerViewAdapter extends RecyclerView.Adapter<MyBtDeviceRecyclerViewAdapter.ViewHolder> {

    private final List<BluetoothDevice> bluetoothDevices;
    private final OnListFragmentInteractionListener mListener;

    public MyBtDeviceRecyclerViewAdapter(List<BluetoothDevice> bluetoothDevices, OnListFragmentInteractionListener listener) {
        this.bluetoothDevices = bluetoothDevices;
        this.mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_btdevice, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = bluetoothDevices.get(position);
        holder.mBluetoothDeviceTextView.setText("" + holder.mItem.getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return bluetoothDevices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mBluetoothDeviceTextView;
        public BluetoothDevice mItem;

        public ViewHolder(View view) {
            super(view);
            mView = (LinearLayout) view.findViewById(R.id.root_LinearLayout);
            mBluetoothDeviceTextView = (TextView) view.findViewById(R.id.fragment_btdevice_item_number_textView);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mItem.getName() + "'";
        }
    }
}
