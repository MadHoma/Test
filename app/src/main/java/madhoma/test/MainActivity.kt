package madhoma.test

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import madhoma.test.models.State

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    private lateinit var adapter: StateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = StateAdapter {
            startActivity(DetailActivity.initIntent(this, it))
        }
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = adapter
        presenter.load()
    }

    override fun show(list: List<State>) {
        adapter.list = list
        adapter.notifyDataSetChanged()
    }

    override fun showMessage(res: Int) {
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show()
    }
}
