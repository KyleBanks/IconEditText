package com.kylewbanks.android.iconedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * IconTextEdit
 *
 * An EditText with an Icon beside it.
 *
 * Created by kylewbanks on 15-09-05.
 */
public class IconEditText extends LinearLayout {

    private static final String TAG = IconEditText.class.getSimpleName();

    /**
     * UI Constants
     */
    private static final float ICON_WEIGHT = 0.15f;
    private static final float EDIT_TEXT_WEIGHT = 0.85f;

    private static final String HINT_PREFIX = " ";

    /**
     * Resource pointer for the Icon to display.
     */
    private Integer _iconResource;

    /**
     * The Hint text to display.
     */
    private String _hint;

    /**
     * Indicates if the EditText is for a password.
     */
    private boolean _isPassword = false;

    /**
     * UI Components
     */
    private ImageView _icon;
    private EditText _editText;

    /**
     * IconTextEdit Constructor
     * @param context
     */
    public IconEditText(Context context) {
        this(context, null);
    }

    /**
     * IconTextEdit Constructor
     * @param context
     * @param attrs
     */
    public IconEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * IconTextEdit Constructor
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public IconEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.parseAttributes(context, attrs);
        this.initialize();
    }

    /**
     * Parses out the custom attributes.
     *
     * @param context
     * @param attrs
     */
    private void parseAttributes(Context context, AttributeSet attrs) {
        Log.d(TAG, "parseAttributes()");
        if (attrs == null) {
            return;
        }

        TypedArray a = context.getTheme()
                .obtainStyledAttributes(attrs, R.styleable.IconEditText, 0, 0);

        try {
            _iconResource = a.getResourceId(R.styleable.IconEditText_iconSrc, 0);
            _hint = a.getString(R.styleable.IconEditText_hint);
            _isPassword = a.getBoolean(R.styleable.IconEditText_isPassword, false);

            Log.d(TAG, "{ _iconResource: " + _iconResource + ", _hint: " + _hint + ", _isPassword: " + _isPassword + "}");
        } catch (Exception ex) {
            Log.e(TAG, "Unable to parse attributes due to: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            a.recycle();
        }
    }

    /**
     * Initializes the Icon and TextEdit.
     */
    private void initialize() {
        Log.d(TAG, "initialize()");

        // Mandatory parameters
        this.setOrientation(LinearLayout.HORIZONTAL);

        // Create the Icon
        if (_icon == null) {
            _icon = new ImageView(this.getContext());
            _icon.setLayoutParams(
                    new LayoutParams(0, LayoutParams.MATCH_PARENT, ICON_WEIGHT)
            );
            _icon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

            if (_iconResource != null && _iconResource != 0) {
                _icon.setImageResource(_iconResource);
            }

            this.addView(_icon);
        }

        // Create the EditText
        if (_editText == null) {
            _editText = new EditText(this.getContext());
            _editText.setInputType(
                    _isPassword ? InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_TEXT_FLAG_AUTO_CORRECT
            );
            _editText.setLayoutParams(
                    new LayoutParams(0, LayoutParams.MATCH_PARENT, EDIT_TEXT_WEIGHT)
            );

            if (_hint != null) {
                _editText.setHint(String.format("%s%s", HINT_PREFIX, _hint.toLowerCase()));
            }

            this.addView(_editText);
        }
    }

    /**
     * Convenience Accessor to the underlying EditText's 'getText()' method.
     *
     * @return
     */
    public Editable getText() {
        return _editText.getText();
    }

}
