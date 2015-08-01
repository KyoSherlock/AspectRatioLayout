# AspectRatioLayout

A simple fixed width height ratio layout.
A simple fixed widht height ratio imageview.

![](https://github.com/KyoSherlock/AspectRatioLayout/raw/master/screenshots/1.png)

# Usage

Below is an example of a AspectRatioLayout, you need to set a exact value to width/height and wrap_content to another, don't forget to add app:widthHeightRatio="xxx".

    <com.sherlock.aspectratio.AspectRatioLayout
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        app:widthHeightRatio="2" >

        <ImageView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@android:color/holo_blue_bright"
            android:contentDescription="@null"
            android:scaleType="centerCrop"
            android:src="@drawable/ic_launcher" />
    </com.sherlock.aspectratio.AspectRatioLayout>

# Changelog

### Version: 1.0

  * Initial Build

# License

Copyright 2015, KyoSherlock

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.