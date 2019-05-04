package madhoma.test

import androidx.annotation.StringRes
import com.arellomobile.mvp.MvpView
import madhoma.test.models.State

interface MainView: MvpView {

    fun show(list: List<State>)

    fun showMessage(@StringRes res: Int)
}