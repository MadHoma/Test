package madhoma.test

import android.annotation.SuppressLint
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.net.UnknownHostException
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    var disposable: CompositeDisposable = CompositeDisposable()

    init {
        App.appComponent.inject(this)
    }

    @Inject
    lateinit var api: StateApi

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }

    @SuppressLint("CheckResult")
    fun load() {
        api.getState()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { this.unSubscribeOnDestroy(it) }
            .subscribe(
                {
                    viewState.show(it.response.result)
                },
                {
                    if(it is UnknownHostException){
                        viewState.showMessage(R.string.network_error)
                    } else viewState.showMessage(R.string.unknown_error)
                    it.printStackTrace()
                })
    }

    private fun unSubscribeOnDestroy(disposable: Disposable) {
        this.disposable.add(disposable)
    }
}