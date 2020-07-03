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
        topic1.setTitle_Bn("করোনা ভাইরাসের সময়ে আতঙ্ক কাটাতে সহায় হোন");
        topic1.setDetails(new ArrayList<>(Arrays.asList(
                new SliderDetails("D-1", "null", "Show empathy with those affected", "আক্রান্ত মানুষদের প্রতি সহানুভূতিশীল হোন", false, false),
                new SliderDetails("D-2", "null", "Learn about the disease to assess the risk", "ঝুঁকি নিরুপনে এই রোগ সম্পর্কে জানুন", false, true),
                new SliderDetails("D-3", "null", "Adopt practical measures to stay safe", "নিরাপদ থাকতে কার্যকর বিধি মেনে চলুন", false, false)
        )));

        Slider topic2 = new Slider();
        topic2.setId("SL-2");
        topic2.setTitle_En("Be KIND to address stigma during coronavirus");
        topic2.setTitle_Bn("করোনা ভাইরাসের সময়ে কুসংস্কার এড়াতে সদয় হোন");
        topic2.setDetails(new ArrayList<>(Arrays.asList(
                new SliderDetails("D-1", "null", "Share the latest facts", "সর্বশেষ তথ্যাদি প্রচার করুন এবং অতিরঞ্জিত তথ্য বা গুজব এড়িয়ে চলুন", false, false),
              