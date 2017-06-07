package com.example.phoenixchain.home;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.phoenixchain.R;

/**
 * Created by coderex2522 on 6/7/2017.
 */

public class MessageReminderActionProvider extends ActionProvider {
    /**
     * Creates a new instance.
     *
     * @param context Context for accessing resources.
     */
    private ImageView messageReminderImgView;
    private TextView tipsTextView;

    public MessageReminderActionProvider(Context context) {
        super(context);
    }

    @Override
    public View onCreateActionView() {
        int size;
        size = getContext().getResources().getDimensionPixelSize(
                android.support.design.R.dimen.abc_action_bar_default_height_material);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(size,size);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.icon_message_reminder,null,false);

        view.setLayoutParams(layoutParams);
        messageReminderImgView = (ImageView) view.findViewById(R.id.messageImgView);
        tipsTextView = (TextView) view.findViewById(R.id.badgeTextView);
        //view.setOnClickListener(onClickListener);
        return view;
    }

    //private View.OnClickListener onClickListener
}
