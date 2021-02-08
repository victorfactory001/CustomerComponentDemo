package com.xiaoyue.customercomponentview.titlebar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaoyue.customercomponentview.R;


public class WhiteTitleBar extends LinearLayout {
    private ImageView ivBack;
    private ImageView ivMore;
    private ImageView ivShare;
    private TextView tvTitle;
    private Context context;
    private View viewLine;
    private LinearLayout llStatusBar;
    public WhiteTitleBar(final Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_white_title_bar, this, true);
        ivBack = findViewById(R.id.layout_iv_back);
        ivMore = findViewById(R.id.layout_iv_more);
        ivShare = findViewById(R.id.layout_iv_share);
        tvTitle = findViewById(R.id.layout_tv_title);
        viewLine = findViewById(R.id.layout_view_line);
        llStatusBar = findViewById(R.id.layout_status_bar);
        setOrientation(VERTICAL);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomWhiteTitleBar);
        if(null!=attributes){
            String title = attributes.getString(R.styleable.CustomWhiteTitleBar_title_text);
            tvTitle.setText(title);
            //
            boolean backButtonVisible = attributes.getBoolean(R.styleable.CustomWhiteTitleBar_back_visble, true);
            if(backButtonVisible){
                ivBack.setVisibility(VISIBLE);
            }else{
                ivBack.setVisibility(GONE);
            }

            boolean shareButtonVisible = attributes.getBoolean(R.styleable.CustomWhiteTitleBar_share_visible, false);
            if(shareButtonVisible){
                ivShare.setVisibility(VISIBLE);
            }else{
                ivShare.setVisibility(GONE);
            }

            boolean moreButtonVisible = attributes.getBoolean(R.styleable.CustomWhiteTitleBar_more_visble, true);
            if(moreButtonVisible){
                ivMore.setVisibility(VISIBLE);
            }else{
                ivMore.setVisibility(GONE);
            }

            boolean viewLineVisible = attributes.getBoolean(R.styleable.CustomWhiteTitleBar_view_line_visble, true);
            if(viewLineVisible){
                viewLine.setVisibility(VISIBLE);
            }else{
                viewLine.setVisibility(GONE);
            }
            attributes.recycle();
        }
        ivBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof Activity){
                    Activity activity= (Activity) context;
                    activity.finish();
                }
            }
        });
    }

    public void setBackOnclick(OnClickListener onClickListener){
        if(null != onClickListener){
            ivBack.setOnClickListener(onClickListener);
        }
    }

    public void setMoreClick(OnClickListener onClickListener){
        if(null!=onClickListener){
            ivMore.setOnClickListener(onClickListener);
        }
    }

    public void setShareClick(OnClickListener onClickListener){
        if(null!=onClickListener){
            ivShare.setOnClickListener(onClickListener);
        }
    }

    public LinearLayout getLlStatusBar(){
        return llStatusBar;
    }
}
