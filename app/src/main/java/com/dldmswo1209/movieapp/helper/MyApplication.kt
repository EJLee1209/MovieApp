package com.dldmswo1209.movieapp.helper

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// 의존성 주입 라이브러리인 Hilt 를 사용하기 위해서 @HiltAndroidApp 어노테이션을 붙인 Application 클래스를 만들어야 한다.
// Application 클래스를 만들고, manifest 에 application name 으로 등록 해야 한다.

// Hilt 를 사용하기 위한 준비 작업이라고 생각하면 됨.
@HiltAndroidApp
class MyApplication : Application()