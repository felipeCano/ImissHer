package com.example.imissher

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

public class AnalyticsAdapter  @Inject constructor(
    @ActivityContext private val context: Context,
    private val service: AnalyticsService
) {  }