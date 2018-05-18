package poc.remote.android.hercules.com.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import poc.remote.android.hercules.com.R
import poc.remote.android.hercules.com.model.bluetooth.ErrorType
import poc.remote.android.hercules.com.presenter.IPresenter
import poc.remote.android.hercules.com.presenter.Presenter
import poc.remote.android.hercules.com.view.dailog.AlertFragment

class MainActivity : AppCompatActivity(), IMainActivity {


    private val TAG = "MainActivity"
    private lateinit var presenter: IPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        presenter = Presenter(this)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    fun onClickButton(view: View) {
        Log.d(TAG, "onClickButton: ")
        val alertFragment = AlertFragment.newInstance("text1", "text2")
        alertFragment.show(fragmentManager, "alertFragment")

        presenter.discoverBluetoothDevice()
    }

    override fun onErrorUi(errorType: ErrorType?) {
        Log.d(TAG, "onErrorUi: $errorType")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}