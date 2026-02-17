# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Keep data classes used for serialization
-keep class com.scode.ai.httpcat.HttpCatStatus { *; }

# Keep Ktor classes
-keep class io.ktor.** { *; }

# Keep Coil classes
-keep class coil3.** { *; }
