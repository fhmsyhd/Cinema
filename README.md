# Cinema
Cinema App - Fahmi Imam Syuhada

Cinema App adalah sebuah aplikasi mobile berbasis android yang menyediakan list film yang sedang tayang secara real time, dan juga dapat melihat detail film tersebut seperti rating, overview, release date, popularity, film serupa, dll.

How to Use :
- Download project from github
- Open in Android Studio
- Run in your device
- And app showing the list of movies

Dependecies :

Untuk unit testing
- testImplementation "androidx.arch.core:core-testing:$androidCoreTestVersion"
    testImplementation "com.nhaarman.mockitokotlin2:mockito-kotlin:$mockitoKotlinVersion"
    testImplementation "org.mockito:mockito-core:$mockitoVersion"
    testImplementation "org.mockito:mockito-inline:$mockitoVersion"

Untuk keperluan desain :
- implementation "androidx.cardview:cardview:$cardview_version"
    implementation "androidx.recyclerview:recyclerview:$recyclerview_version"
    implementation "com.google.android.material:material:$material_version"
    implementation "com.github.bumptech.glide:glide:$glide_version"
    implementation "com.airbnb.android:lottie:$lottie_version"

Untuk database lokal menggunakan room :
- implementation "androidx.room:room-runtime:$room_version"
    kapt "androidx.room:room-compiler:$room_version"
    androidTestImplementation "androidx.room:room-testing:$room_version"
    implementation "androidx.room:room-ktx:$room_version"
    
Untuk get api :
- implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    implementation "com.squareup.okhttp3:logging-interceptor:$logging_interceptor_version"
    
Untuk reactive programming menggunakan:
- implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlin_coroutines_version"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlin_coroutines_version"
    
Untuk dependency injection menggukana koin :
- implementation "io.insert-koin:koin-core:$koin_version"
    implementation "io.insert-koin:koin-android:$koin_version"
