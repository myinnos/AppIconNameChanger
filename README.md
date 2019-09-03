# AppIconNameChanger
Change Android App launcher Icon and App Name programmatically !

 ![AppIconNameChanger - Example1](https://i.postimg.cc/bvWNzSQg/App-Icon-Name-Changer-example-01.png)
 `` `` `` `` `` `` `` ``
 ![AppIconNameChanger - Example2](https://i.postimg.cc/7Ld7p6b8/App-Icon-Name-Changer-example-02.png)
 `` `` `` `` `` `` `` ``
 ![AppIconNameChanger - Example3](https://i.postimg.cc/pd4GqPHy/App-Icon-Name-Changer-example-03.png)

#### Download Demo APK from [HERE](https://github.com/myinnos/AppIconNameChanger/raw/master/apk/appIconNameChanger.apk "APK")
  
#### Kindly use the following links to use this library:

In build.gradle (Project)
```java
allprojects {
	repositories {
	...
	maven { url "https://jitpack.io" }
	}
}
```
And then in the other gradle file(may be your app gradle or your own module library gradle, but never add in both of them to avoid conflict.)
```java	
dependencies {
	compile 'com.github.myinnos:AppIconNameChanger:1.0.7'
}
```
How to use
-----
**Step 1:** set activity alias in manifest file : [#Example](https://github.com/myinnos/AppIconNameChanger/blob/master/app/src/main/AndroidManifest.xml "Example")
```xml
<application
         .........
        
       <!-- main activity-->
       <activity android:name=".MainActivity" />

        <!-- setting activity-alias names-->
        <activity-alias
            android:name="in.myinnos.changeappiconandname.MainActivitySettings"
            android:enabled="true"  //enabled by default launcher
            android:icon="@drawable/ic_settings"  //app icon
            android:label="@string/app_settings"  //app label/name
            android:targetActivity=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity-alias>

        <activity-alias
            android:name="in.myinnos.changeappiconandname.MainActivityCamera"
            android:enabled="false"
            android:icon="@drawable/ic_camera"  //app icon
            android:label="@string/app_camera" //app label/name
            android:targetActivity=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity-alias>

        .........

</application>
```
**Step 2:** implement App Icon Name Changer method : [#Example](https://github.com/myinnos/AppIconNameChanger/blob/master/app/src/main/java/in/myinnos/changeappiconandname/MainActivity.java "Example")
```java
// Active alias name
String activeName = "in.myinnos.changeappiconandname.MainActivitySettings";

// Disable alias names
List<String> disableNames = new ArrayList<String>();
disableNames.add("in.myinnos.changeappiconandname.MainActivityCamera");
disableNames.add("in.myinnos.changeappiconandname.MainActivityMessage");

// Initiate App Icon Name Changer
new AppIconNameChanger.Builder(MainActivity.this)
                .activeName(activeName) // String
                .disableNames(disableNames) // List<String>
                .packageName(BuildConfig.APPLICATION_ID)
                .build()
                .setNow();
```
**IMP Note:** To change application launcher icon and the application name should wait for 10 Seconds(MAX) to refresh the launcher.
##### Any Queries? or Feedback, please let me know by opening a [new issue](https://github.com/myinnos/AppIconNameChanger/issues/new)!

## Contact
#### Prabhakar Thota
* :globe_with_meridians: Website: [myinnos.in](http://www.myinnos.in "Prabhakar Thota")
* :email: e-mail: contact@myinnos.in
* :mag_right: LinkedIn: [PrabhakarThota](https://www.linkedin.com/in/prabhakarthota "Prabhakar Thota on LinkedIn")
* :thumbsup: Twitter: [@myinnos](https://twitter.com/myinnos "Prabhakar Thota on Twitter")   
* :camera: Instagram: [@prabhakar_t_](https://www.instagram.com/prabhakar_t_/ "Prabhakar Thota on Instagram")   

> If you appreciate my work, consider buying me a cup of :coffee: to keep me recharged :metal: by [PayPal](https://www.paypal.me/fansfolio)

License
-------

    Copyright 2019 MyInnos

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
