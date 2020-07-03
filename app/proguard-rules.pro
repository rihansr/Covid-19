package com.rsr.covid_19.util;

import com.rsr.covid_19.model.topic.Slider;
import com.rsr.covid_19.model.topic.TopicDetails;
import com.rsr.covid_19.model.topic.TopicHost;

import java.util.ArrayList;
import java.util.Arrays;

public class SliderData {

    public static SliderHost beReadyFoCoronaVirus() {
        SliderHost topicHost = new SliderHost();
        topicHost.setId("SLH-1");
        topicHost.setTitle_En("Be Ready for coronavirus");
        topicHost.setTitle_Bn("করোনাভাইরাসের জন্য প্রস্তুত হন");

        Slider topic1 = new Slider();
        topic1.setId("SL-1");
        topic1.setTitle_En("Be KIND to address fear during coronavirus");
        topic1.setTitle_Bn