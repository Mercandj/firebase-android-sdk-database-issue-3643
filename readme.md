# Firebase Android issue

### 1. What?

The minimal step to reproduce this issue https://github.com/firebase/firebase-android-sdk/issues/3643.

The `app/google-servies.json` has been git-ignored like [adviced](https://github.com/firebase/firebase-android-sdk/issues/3643#issuecomment-1106676413) for security reason I suppose.

This sample app will crash with the stacktrace bellow:

``` 
2022-04-21 23:08:38.743 E/AndroidRuntime: FATAL EXCEPTION: main
    Process: com.mercandalli.android.apps.sampler, PID: 11865
    java.lang.RuntimeException: Uncaught exception in Firebase Database runloop (20.0.4). If you are not already on the latest version of the Firebase SDKs, try updating your dependencies. Should this problem persist, please file a report at https://github.com/firebase/firebase-android-sdk
        at j4.n$a$a.run(:96)
        at android.os.Handler.handleCallback(Handler.java:938)
        at android.os.Handler.dispatchMessage(Handler.java:99)
        at android.os.Looper.loopOnce(Looper.java:201)
        at android.os.Looper.loop(Looper.java:288)
        at android.app.ActivityThread.main(ActivityThread.java:7870)
        at java.lang.reflect.Method.invoke(Native Method)
        at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:548)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:1003)
     Caused by: java.lang.NoSuchMethodError: No virtual method object()Lb9/g; in class Lb9/g; or its super classes (declaration of 'b9.g' appears in /data/app/~~MDSz81k4B6uCZgrZsQ9zyQ==/com.mercandalli.android.apps.sampler-66tdqwTq1qJ-KDvS2fRLdw==/base.apk)
```

### 2. Why the crash?

If I'm not mistaken, reason of the crash is having in the same time:
- `implementation("org.json:json:20220320")`
- minification enabled
- firebase database 20.0.4

*Why this supposition?*

- Because the mapping is telling me `'b9.g'` is `org.json.JSONStringer` and because removing the dependency "fix" the crash
- Because if you [remove this dependency line](https://github.com/Mercandj/firebase-android-sdk-database-issue-3643/blob/main/app/build.gradle.kts#L67), no more crash

----

Thks to [@argzdev](https://github.com/argzdev) and [RufenKhokhar](https://github.com/RufenKhokhar) for the help on that =).