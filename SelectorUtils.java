package com.aimer.shd.customview;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by shd on 2015/8/5.
 */
public class SelectorUtils {

    /**
     * 创建一个圆角矩形背景
     *
     * @param contentColor 内部填充颜色
     * @param strokeColor  描边颜色
     * @param radius       圆角
     */
    public static GradientDrawable createRoundDrawable(int contentColor, int strokeColor, int radius) {
        GradientDrawable drawable = new GradientDrawable(); // 生成Shape
        drawable.setGradientType(GradientDrawable.RECTANGLE); // 设置矩形
        drawable.setColor(contentColor);// 内容区域的颜色
        if (strokeColor!=-1) {
            drawable.setStroke(1, strokeColor); // 四周描边,描边后四角真正为圆角，不会出现黑色阴影。如果父窗体是可以滑动的，需要把父View设置setScrollCache(false)
        }
        drawable.setCornerRadius(radius); // 设置四角都为圆角
        return drawable;
    }

    /**
     * 创建一个图片选择器
     *
     * @param normalState  普通状态的图片
     * @param pressedState 按压状态的图片
     */
    public static StateListDrawable createSelector(Drawable normalState, Drawable focusState, Drawable pressedState) {
        StateListDrawable bg = new StateListDrawable();

        bg.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_focused}, focusState);
        bg.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, pressedState);
        bg.addState(new int[]{android.R.attr.state_focused}, focusState);
        bg.addState(new int[]{android.R.attr.state_pressed}, pressedState);
        bg.addState(new int[]{android.R.attr.state_enabled}, normalState);
        bg.addState(new int[]{}, normalState);
        return bg;
    }
}
