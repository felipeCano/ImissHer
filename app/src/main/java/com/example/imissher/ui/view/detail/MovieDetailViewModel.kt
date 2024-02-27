package com.example.imissher.ui.view.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.imissher.core.BaseViewModel
import com.example.imissher.model.MovieDetailsResponse
import com.example.imissher.repository.ApiRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
class MovieDetailViewModel @Inject constructor(private val apiRepository: ApiRepository) : BaseViewModel() {
    val liveDataDetail = MutableLiveData<MovieDetailsResponse>()
    fun getMovies(movieId: Int){
        val disposables1 : Disposable = apiRepository.getMovieDetails(movieId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe{
            }
            .subscribe ({
                liveDataDetail.postValue(it)
                Log.d("PassValueDetail", it.toString())
            },{
                Log.d("PassValueDetail",it.toString())
            })
        disposables.add(disposables1)
    }
}