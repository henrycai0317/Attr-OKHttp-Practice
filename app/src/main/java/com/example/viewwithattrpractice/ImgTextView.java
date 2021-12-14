package com.example.viewwithattrpractice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ImgTextView extends LinearLayout {

    private ImageView mImg;
    private TextView mText;
    private int mImgSize;
    private Drawable mImgSrc;
    private int txtColor;
    private int mSpacing;
    private String mTxtString;
    private int mTxtSize;


    public ImgTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttr(attrs);
        initView();
    }

    public ImgTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(attrs);
        initView();
    }

    private void initView(){
        inflate(getContext(),R.layout.component_imgtextview,this);
        mImg = findViewById(R.id.img);
        mText = findViewById(R.id.txt);

    }
   private void initAttr(AttributeSet attrs){
        try {
            TypedArray attributes = getContext().obtainStyledAttributes(attrs,R.styleable.ImgTextView);
            getValue(attributes);
            mImg.setLayoutParams(new LayoutParams(mImgSize,mImgSize));
            mImg.setImageDrawable(mImgSrc);

            mText.setText(mTxtString);
            mText.setTextColor(txtColor);
            mText.setTextSize(TypedValue.COMPLEX_UNIT_PX,mTxtSize);
            LayoutParams txtLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            txtLayoutParams.setMargins(0,mSpacing,0,0);
            mText.setLayoutParams(txtLayoutParams);


        }catch (Exception e){
            e.printStackTrace();
        }

   }

    private void getValue(TypedArray attributes) {
        mImgSize = attributes.getDimensionPixelSize(R.styleable.ImgTextView_imgSize,getResources().getDimensionPixelSize(R.dimen.default_imgSize));
        mImgSrc = attributes.getDrawable(R.styleable.ImgTextView_imgSrc);
        txtColor = attributes.getColor(R.styleable.ImgTextView_txtColor, Color.BLACK);
        mSpacing = attributes.getDimensionPixelSize(R.styleable.ImgTextView_spacing,0);
        mTxtString = attributes.getString(R.styleable.ImgTextView_txtString);
        mTxtSize = (int) attributes.getDimension(R.styleable.ImgTextView_txtSize,getResources().getDimension(R.dimen.default_txtSize));
    }

}
