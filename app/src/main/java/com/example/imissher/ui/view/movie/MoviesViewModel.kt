package com.example.imissher.ui.view.movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.imissher.core.BaseViewModel
import com.example.imissher.model.Movie
import com.example.imissher.repository.ApiRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviesViewModel @Inject constructor(private val apiRepository: ApiRepository) : BaseViewModel() {
    val liveData = MutableLiveData<List<Movie>>()
    fun getMovies(){
        val disposables1 : Disposable = apiRepository.getPopularMoviesList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{
            }
            .subscribe ({
                liveData.postValue(it)
                Log.d("PassValue",it.toString())
            },{
                Log.d("PassValue",it.toString())
            })
        disposables.add(disposables1)
    }
}