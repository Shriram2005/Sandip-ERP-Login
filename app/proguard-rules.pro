# Preserve the line number information for debugging stack traces.
-keepattributes SourceFile,LineNumberTable

# Hide the original source file name.
-renamesourcefileattribute SourceFile

# Keep WebView JavaScript interfaces
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# Keep all annotations
-keepattributes *Annotation*

# Keep all classes extending AppCompatActivity
-keep class androidx.appcompat.app.AppCompatActivity { *; }

# Keep all classes extending WebViewClient
-keep class android.webkit.WebViewClient { *; }

# Keep all classes extending WebView
-keep class android.webkit.WebView { *; }

# Keep all classes in the com.shriram.sandipuniversity package
-keep class com.shriram.sandipuniversity.** { *; }

# Keep all classes in the androidx package
-keep class androidx.** { *; }

# Keep all classes in the android package
-keep class android.** { *; }

# Keep all classes in the com.google.android.material package
-keep class com.google.android.material.** { *; }

# Keep all classes in the androidx.constraintlayout package
-keep class androidx.constraintlayout.** { *; }

# Keep all classes in the androidx.core package
-keep class androidx.core.** { *; }

# Keep all classes in the androidx.appcompat package
-keep class androidx.appcompat.** { *; }

# Keep all classes in the androidx.test package
-keep class androidx.test.** { *; }

# Keep all classes in the junit package
-keep class junit.** { *; }

# Keep all classes in the espresso package
-keep class androidx.test.espresso.** { *; }