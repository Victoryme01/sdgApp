package bbc.sdg.sdgapp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
//https://android-arsenal.com/details/1/7005

import com.baoyachi.stepview.VerticalStepView;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CalendarFragment extends Fragment {

    View mView;
    private VerticalStepView mSetpview0;
    public CalendarFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mView =  inflater.inflate(R.layout.fragment_calendar, container, false);
        return mView;

    }

    @Override
    public void onStart()
    {
        super.onStart();
        mSetpview0 = (VerticalStepView)mView.findViewById(R.id.step_view0);

        List<String> list0 = new ArrayList<>();
        list0.add("Inaguration of sdg app, 2020");
        list0.add("您的商品需要从外地调拨，我们会尽快处理，请耐心等待");
      list0.add(1,"inaguration");
        list0.add("您的订单预计6月23日送达您的手中，618期间促销火爆，可能影响送货时间，请您谅解，我们会第一时间送到您的手中");

        mSetpview0.setStepsViewIndicatorComplectingPosition(list0.size() - 2)//设置完成的步数
                .reverseDraw(false)//default is true
                .setTextSize(14)
                .setStepViewTexts(list0)//总步骤
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(getActivity(), android.R.color.black))//设置StepsViewIndicator完成线的颜色
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(getActivity(), R.color.uncompleted_text_color))//设置StepsViewIndicator未完成线的颜色
                .setStepViewComplectedTextColor(ContextCompat.getColor(getActivity(), android.R.color.black))//设置StepsView text完成线的颜色
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(getActivity(), R.color.red))//设置StepsView text未完成线的颜色
                .setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(getActivity(), R.drawable.calendar))//设置StepsViewIndicator CompleteIcon
                .setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(getActivity(), R.drawable.calendar))//设置StepsViewIndicator DefaultIcon
                .setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(getActivity(), R.drawable.attention));//设置StepsViewIndicator AttentionIcon

    }
}
