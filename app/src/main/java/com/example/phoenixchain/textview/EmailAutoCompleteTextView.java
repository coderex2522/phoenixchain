package com.example.phoenixchain.textview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phoenixchain.R;

/**
 * Created by Sanji on 2017/6/20.
 */

public class EmailAutoCompleteTextView extends android.support.v7.widget.AppCompatAutoCompleteTextView implements TextWatcher {

    private static final String TAG = "EmailAutoCompleteTextView";
    public  boolean hasFoucs;
    private Drawable mClearDrawable;
    private String[] emailSufixs = new String[] {"@163.com", "@126.com", "@sina.com", "@qq.com", "@sogou.com", "@sohu.com",
            "@yahoo.com.cn", "@56.com"};
    public EmailAutoCompleteTextView(Context context) {
        super(context);
        init(context);
    }

    public EmailAutoCompleteTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.editTextStyle);
    }

    public EmailAutoCompleteTextView(Context context, AttributeSet attrs,
                                     int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(final Context context) {
        // 获取EditText的DrawableRight，如果没有，则使用默认图片。
        mClearDrawable = getCompoundDrawables()[2];
        if (mClearDrawable == null) {
            mClearDrawable = getResources().getDrawable(
                    R.drawable.delete_selector);
        }
        mClearDrawable.setBounds(0, 0, mClearDrawable.getIntrinsicWidth(),
                mClearDrawable.getIntrinsicHeight());
        setClearIcoVisible(false);
        addTextChangedListener(this);

        // adapter中使用默认的emailSufixs中的数据，可以通过setAdapterString来更改
        this.setAdapter(new EmailAutoCompleteAdapter(context,
                R.layout.item_auto_complete, emailSufixs));

        // 使得在输入1个字符之后便开启自动完成
        this.setThreshold(1);

        // 为输入框设置焦点改变监听，如果输入框有焦点，我们判断输入框的值是否为空，为空就隐藏清除图标，否则就显示
        this.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                EmailAutoCompleteTextView.this.hasFoucs = hasFocus;
                if (hasFocus) {
                    setClearIcoVisible(getText().length() > 0);
                    String text = EmailAutoCompleteTextView.this.getText()
                            .toString();
                    // 当该文本域重新获得焦点后，重启自动完成
                    if (!"".equals(text))
                        performFiltering(text, 0);
                } else {
                    setClearIcoVisible(false);
                    // 当文本域丢失焦点后，检查输入email地址的格式
                    EmailAutoCompleteTextView ev = (EmailAutoCompleteTextView) v;
                    String text = ev.getText().toString();
                    // 正则判断邮箱格式是否正确
                    if (text != null
                            && text.matches("^[a-zA-Z0-9_]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+$")) {
                        Toast to = new Toast(context);
                        ImageView i = new ImageView(context);
                        i.setBackgroundResource(R.mipmap.ico_refund_success);
                        to.setView(i);
                        to.show();
                    } else {
                        Toast toast = Toast.makeText(context, "邮件地址格式不正确",
                                Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.TOP, 0, 50);
                        toast.show();
                    }
                }
            }
        });

    }

    public void setAdapterString(String[] es) {
        if(es != null && es.length > 0)
            this.emailSufixs = es;
    }


    @Override
    protected void replaceText(CharSequence text) {
        //当我们在下拉框中选择一项时，android会默认使用AutoCompleteTextView中Adapter里的文本来填充文本域
        //因为这里Adapter中只是存了常用email的后缀
        //因此要重新replace逻辑，将用户输入的部分与后缀合并
        //Log.i(TAG + " replaceText", text.toString());
        String t = this.getText().toString();
        int index = t.indexOf("@");
        if(index != -1)
            t = t.substring(0, index);
        super.replaceText(t + text);
    }

    @Override
    protected void performFiltering(CharSequence text, int keyCode) {
        //该方法会在用户输入文本之后调用，将已输入的文本与adapter中的数据对比，若它匹配
        //adapter中数据的前半部分，那么adapter中的这条数据将会在下拉框中出现
        //Log.i(TAG + " performFiltering", text.toString() + "   " + keyCode);
        String t = text.toString();

        //因为用户输入邮箱时，都是以字母，数字开始，而我们的adapter中只会提供以类似于"@163.com"
        //的邮箱后缀，因此在调用super.performFiltering时，传入的一定是以"@"开头的字符串
        int index = t.indexOf("@");
        if(index == -1) {
            if(t.matches("^[a-zA-Z0-9_]+$")) {
                super.performFiltering("@", keyCode);
            }
            else
                this.dismissDropDown();//当用户中途输入非法字符时，关闭下拉提示框
        } else {
            super.performFiltering(t.substring(index), keyCode);
        }
    }

    private class EmailAutoCompleteAdapter extends ArrayAdapter<String> {

        public EmailAutoCompleteAdapter(Context context, int textViewResourceId, String[] email_s) {
            super(context, textViewResourceId, email_s);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Log.i(TAG, "in GetView");
            View v = convertView;
            if (v == null)
                v = LayoutInflater.from(getContext()).inflate(
                        R.layout.item_auto_complete, null);
            TextView tv = (TextView) v.findViewById(R.id.tv);

            String t = EmailAutoCompleteTextView.this.getText().toString();
            int index = t.indexOf("@");
            if(index != -1)
                t = t.substring(0, index);
            //将用户输入的文本与adapter中的email后缀拼接后，在下拉框中显示
            tv.setText(t + getItem(position));
            //Log.i(TAG, tv.getText().toString());
            return v;
        }
    }

    /**
     * 设置图标的显示和隐藏，调用setCompoundDrawables为EditText绘制上去。
     *
     * @param visible
     */
    private void setClearIcoVisible(boolean visible) {
        Drawable rightDrawable = visible ? mClearDrawable : null;
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], rightDrawable, getCompoundDrawables()[3]);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    /**
     * 当手指抬起的位置在clean的图标的区域 我们将此视为进行清除操作 getWidth():得到控件的宽度
     * event.getX():抬起时的坐标(改坐标是相对于控件本身而言的)
     * getTotalPaddingRight():clean的图标左边缘至控件右边缘的距离
     * getPaddingRight():clean的图标右边缘至控件右边缘的距离 于是: getWidth() -
     * getTotalPaddingRight()表示: 控件左边到clean的图标左边缘的区域 getWidth() -
     * getPaddingRight()表示: 控件左边到clean的图标右边缘的区域 所以这两者之间的区域刚好是clean的图标的区域
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (getCompoundDrawables()[2] != null) {
            boolean touchable = (event.getX() > (getWidth() - getTotalPaddingRight())) && (event.getX() < (getWidth() - getPaddingRight()));
            if (touchable) {
                this.setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {

        if (hasFoucs) {
            setClearIcoVisible(length() > 0);
        }
        // TODO 自动生成的方法存根
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    /**
     * 设置晃动动画
     */
    public void setShakeAnimation() {

        this.startAnimation(shakeAnimation(5));
    }

    public void startAnimation(Animation animation) {
    }

    /**
     * 晃动动画
     *
     * @param counts
     *            1秒钟晃动多少下
     * @return
     */
    public static Animation shakeAnimation(int counts) {

        Animation translateAnimation = new TranslateAnimation(0, 10, 0, 0);
        translateAnimation.setInterpolator(new CycleInterpolator(counts));
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }
}


