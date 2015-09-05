# IconEditText for Android

`IconEditText` is an Android View that displays an `ImageView` and `EditText` together, compatible with `Android 4.0+`.

<p style="text-align: center">
  <img src="https://s3.amazonaws.com/kylewbanks/IconEditText/example.png"/>
</p>

## Usage

Using the `IconEditText` is easy enough, just clone the repo and <a href="https://www.google.ca/search?q=android+studio+add+library">add it to your project as a Library</a>.

After adding the library, you can add an `IconEditText` like so:

```xml
<!-- Note the declaration of the `widget` namespace. -->
<LinearLayout 
  ...
  xmlns:widget="http://schemas.android.com/apk/res-auto">

  <com.kylewbanks.android.iconedittext.IconEditText
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      widget:isPassword="false"
      widget:hint="@string/username"
      widget:iconSrc="@drawable/username_icon" />

</LinearLayout
```

### Options

The `IconEditText` currently supports the following properties:

- isPassword `{Boolean}`: If true, will mask the EditText's input.
- hint `{String}`: The hint text to display, if any.
- iconSrc `{Drawable}`: The source of the icon image to display.

## Author

### Kyle Banks
- http://kylewbanks.com
- https://github.com/KyleBanks
- https://twitter.com/kylewbanks

## License
```
The MIT License (MIT)

Copyright (c) 2015 Kyle Banks

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
