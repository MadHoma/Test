package madhoma.test.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import madhoma.test.R
import madhoma.test.models.State

class DetailActivity : AppCompatActivity(){

    companion object {
        private const val STATE = "state"
        fun initIntent(context: Context, item: State): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(STATE, item)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val item = intent.getParcelableExtra<State>(STATE)
        tvTitle.text = "${item.name}, ${item.country}, ${item.abbr}"
        tvCapital.text = item.capital
        tvLargestCity.text = item.largest_city
        tvId.text = item.id.toString()
    }
}