package com.rsr.covid_19.util;

import com.rsr.covid_19.model.topic.Topic;
import com.rsr.covid_19.model.topic.TopicDetails;
import com.rsr.covid_19.model.topic.TopicHost;

import java.util.ArrayList;
import java.util.Arrays;

public class SliderData {

    public static TopicHost beReadyFoCoronaVirus() {
        TopicHost topicHost = new TopicHost();
        topicHost.setId("SLH-1");
        topicHost.setTitle_En("Be Ready for coronavirus");
        topicHost.setTitle_Bn("করোনাভাইরাসের জন্য প্রস্তুত হন");

        Topic topic1 = new Topic();
        topic1.setId("SL-1");
        topic1.setTitle_En("Be KIND to address fear during coronavirus");
        topic1.setTitle_Bn("করোনা ভাইরাসের সময়ে আতঙ্ক কাটাতে সহায় হোন");
        topic1.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1", "null", "Show empathy with those affected", "আক্রান্ত মানুষদের প্রতি সহানুভূতিশীল হোন", false, false),
                new TopicDetails("D-2", "null", "Learn about the disease to assess the risk", "ঝুঁকি নিরুপনে এই রোগ সম্পর্কে জানুন", false, true),
                new TopicDetails("D-3", "null", "Adopt practical measures to stay safe", "নিরাপদ থাকতে কার্যকর বিধি মেনে চলুন", false, false)
        )));

        Topic topic2 = new Topic();
        topic2.setId("SL-2");
        topic2.setTitle_En("Be KIND to address stigma during coronavirus");
        topic2.setTitle_Bn("করোনা ভাইরাসের সময়ে কুসংস্কার এড়াতে সদয় হোন");
        topic2.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1", "null", "Share the latest facts", "সর্বশেষ তথ্যাদি প্রচার করুন এবং অতিরঞ্জিত তথ্য বা গুজব এড়িয়ে চলুন", false, false),
                new TopicDetails("D-2", "null", "Show solidarity with affected people", "আক্রান্ত মানুষদের সাথে সংহতি প্রকাশ করুন", false, true),
                new TopicDetails("D-3", "null", "Tell the stories of people who have experienced the virus", "যারা এই ভাইরাস দ্বারা আক্রান্ত হয়েছে তাদের অভিজ্ঞতার কথা জানান", false, false)
        )));

        Topic topic3 = new Topic();
        topic3.setId("SL-3");
        topic3.setTitle_En("Be KIND to support loved ones during coronavirus");
        topic3.setTitle_Bn("করোনা ভাইরাসের সময়ে প্রিয়জনদেরকে সহায়তা দিতে সদয় হোন");
        topic3.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1", "null", "Check in regularly especially with those affected", "নিয়মিতভাবে প্রিয়জনদের বিশেষত আক্রান্তদের খোঁজখবর নিন", false, false),
                new TopicDetails("D-2", "null", "Encourage them to keep doing what they enjoy", "তারা আনন্দ পান এমন কাজ গুলো তাদের করতে উৎসাহ দিন", false, true),
                new TopicDetails("D-3", "null", "Provide calm and correct advice for your children", "আপনার শিশুদেরকে সঠিক ও সুস্থ থাকার পরামর্শ দিন", false, false)
        )));

        Topic topic4 = new Topic();
        topic4.setId("SL-4");
        topic4.setTitle_En("Be SAFE from coronavirus");
        topic4.setTitle_Bn("করোনা ভাইরাস থেকে নিরাপদ থাকুন");
        topic4.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1", "If you are 60+ or if you have an underlying condition like:", "আপনার বয়স যদি ৬০ এর অধিক হয় বা আগে থেকে নিচের রোগগুলো থাকেঃ"),
                new TopicDetails("D-2", "null", "Cardiovascular disease", "হূদরোগ ও রক্তনালির রোগ", true, false),
                new TopicDetails("D-3", "null", "Respiratory condition", "শ্বাসনালী ও ফুসফুসের সমস্যা", true, false),
                new TopicDetails("D-4", "null", "Diabetes", "ডায়াবেটিস", true, false),
                new TopicDetails("D-5", "by avoiding crowded areas or places where you might interact with people who are sick", "তাহলে আপনি মানুষের ভিড় হয় এমন জায়গা বা স্থান গুলো এড়িয়ে চলুন কারণ সেখানে আপনি অসুস্থ মানুষের সংস্পর্শে আসতে পারেন")
        )));

        Topic topic5 = new Topic();
        topic5.setId("SL-5");
        topic5.setTitle_En("Be SMART & inform yourself about coronavirus");
        topic5.setTitle_Bn("নিজেকে করোনভাইরাস সম্পর্কে অবহিত করুন");
        topic5.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1", "null", "Follow accurate public health advice from your local health authority", "আপনার স্থানীয় স্বাস্থ্য কর্তৃপক্ষ থেকে সঠিক জনস্বাস্থ্য বিষয়ক পরামর্শ নিন", false, false),
                new TopicDetails("D-2", "null", "Follow the news on latest coronavirus updates", "করোনা ভাইরাসের সর্বশেষ খবর অনুসরণ করুন", false, true),
                new TopicDetails("D-3", "null", "To avoid spreading rumors, always check the source you are getting information from", "গুজব এড়াতে, সর্বদা যে উত্স থেকে আপনি তথ্য নিচ্ছেন তা পরীক্ষা করুন", false, false),
                new TopicDetails("D-4", "null", "Don’t spread rumors", "গুজব ছড়ানো থেকে বিরত থাকুন", false, true)
        )));

        ArrayList<Topic> topics = new ArrayList<>(Arrays.asList(topic1, topic2, topic3, topic4, topic5));

        topicHost.setTopics(topics);

        return topicHost;
    }

    public static TopicHost mentalHealth() {
        TopicHost topicHost = new TopicHost();
        topicHost.setId("SLH-2");
        topicHost.setTitle_En("Protect your Mental Health");
        topicHost.setTitle_Bn("কোভিড-১৯ এবং মানসিক স্বাস্থ্য");

        Topic topic1 = new Topic();
        topic1.setId("SL-2");
        topic1.setTitle_En("Coping with stress during the COVID-19 outbreak");
        topic1.setTitle_Bn("মানিসক চাপ মুক্ত থাকেত কী করেবন");
        topic1.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "It is normal to feel sad, stressed, confused, scared or angry during a crisis.\n\nTalking to people you trust can help. Contact your friends and family",
                        "করোনা ভাইরাস সংক্রমণের ভীতি থেকে অবসাদে ভোগা, মনের ওপর বাড়তি চাপ তৈরি হওয়া, হতবিহবল হয়ে পড়া, আতঙ্কিত হওয়া বা রেগে যাওয়া স্বাভাবিক।\n\nএই সময় আপনি যাদের উপর আস্থা রাখতে পারেন তাদের সাথে কথা বলুন, পরামর্শ নিন। স্বজন আর বন্ধুদের সাথে যোগাযোগ রাখুন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "If you must stay at home, maintain a healthy lifestyle - including proper diet, sleep, exercise and social contacts with loved ones at home and by email and phone with other family and friends.",
                        "আপনি যদি বাড়িতে থাকতে বাধ্য হোন, তাহলে স্বাস্থ্যকর জীবনযাপন করুন। সুষম খাদ্য গ্রহণ করুন, পর্যাপ্ত পরিমাণ ঘুমান, হাল্কা ব্যায়াম করুন এবং বাসায় পরিবারের সদস্যদের সাথে ভালো সময় কাটান আর বাইরের বন্ধু বা স্বজনদের সাথে ইমেইল, টেলিফোন বা সামাজিক যোগাযোগ মাধ্যমের সাহায্যে যোগাযোগ রক্ষা করুন।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Don’t use smoking, alcohol or other drugs to deal with your emotions.\n\nIf you feel overwhelmed, talk to a health worker or counsellor. Have a plan, where to go to and how to seek help for physical and mental health needs if required.",
                        "ধূমপান, তামাকজাত দ্রব্য, অ্যালকোহল বা অন্য কোন নেশাজাত দ্রব্য গ্রহণ করে আপনার মনের চাপ দূর করার চেষ্টা করবেন না।\n\nনিজের উপর যদি খুব বেশি চাপ বা স্ট্রেস বোধ করতে থাকেন তবে নিকটস্থ স্বাস্থ্য কর্মীর সাথে কথা বলুন। যদি প্রয়োজন হয় তবে কীভাবে-কার কাছ থেকে, কোথায় আপনি শারীরিক বা মানসিক সমস্যার জন্য সাহায্য গ্রহণ করবেন তার একটি আগাম পরিকল্পনা তৈরি করে রাখুন।",
                        false,
                        false),
                new TopicDetails("D-4",
                        "null",
                        "Get the facts. Gather information that will help you accurately determine your risk so that you can take reasonable precautions. Find a credible source you can trust such as WHO website or, a local or state public health agency.",
                        "কেবলমাত্র সঠিক তথ্য সংগ্রহ করুন। বিশ্বাসযোগ্য সূত্র থেকে এমন তথ্য নিন যেগুলো আপনাকে ঝুঁকি সম্পর্কে সতর্ক করবে এবং প্রয়োজনীয় ব্যবস্থা গ্রহণে সাহায্য করবে। তথ্যের এমন একটি বিশ্বাসযোগ্য বিজ্ঞানসম্মত উৎস ঠিক করে রাখুন যে কেবলমাত্র সেগুলোর উপর ভরসা করবেন- যেমন বিশ্ব স্বাস্থ্য সংস্থার ওয়েবসাইট বা সরকার হতে দায়িত্বপ্রাপ্ত সংশ্লিষ্ট প্রতিষ্ঠান।",
                        false,
                        true),
                new TopicDetails("D-5",
                        "null",
                        "Limit worry and agitation by lessening the time you and your family spend watching or listening to media coverage that you perceive as upsetting.",
                        "দুশ্চিন্তা আর অস্থিরতা কমাতে, আপনি এবং আপনার পরিবার প্রচার মাধ্যমে করোনা ভাইরাস সংক্রমণ আর এর পরিণতি নিয়ে বিপর্যস্তকর সংবাদ শোনা বা দেখা কমিয়ে দিন।",
                        false,
                        false),
                new TopicDetails("D-6",
                        "null",
                        "Draw on skills you have used in the past that have helped you to manage previous life’s adversities and use those skills to help you manage your emotions during the challenging time of this outbreak.",
                        "অতীতে প্রতিকূল পরিস্থিতি মোকাবেলায় আপনার দক্ষতাগুলোর সাথে আবার মনে করুন। সেই অভিজ্ঞতার আলোকে করোনা ভাইরাস সংক্রমণের সময় আপনার মানসিক চাপ কমাতে পূর্বের দক্ষতাকে কাজে লাগিয়ে ভালো থাকার চেষ্টা করুন।",
                        false,
                        true)
        )));

        Topic topic2 = new Topic();
        topic2.setId("SL-3");
        topic2.setTitle_En("Helping children cope with stress during the COVID-19 outbreak");
        topic2.setTitle_Bn("শিশুদের মানসিক চাপ মুক্ত রাখতে কি করবেন");
        topic2.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Children may respond to stress in different ways such as being more clingy, anxious, withdrawing, angry or agitated, bed-wetting etc.\n\nRespond to your child’s reactions in a supportive way, listen to their concerns and give them extra love and attention.",
                        "যেকোন মানসিক চাপে শিশুরা বড়দের চাইতে ভিন্নভাবে প্রতিক্রিয়া দেখায়। তারা বাবা-মাকে আঁকড়ে ধরে রাখতে চায়, উদ্বিগ্ন হয়ে পড়ে, নিজেকে গুটিয়ে রাখে, রাগ করে, অস্থির হয়ে ওঠে কিংবা বিছানায় প্রস্রাব করে।\n\nশিশুর মানসিক চাপজনিত এই প্রতিক্রিয়া গুলোর প্রতি আপনি সাহায্যের হাত বাড়িয়ে দিন, তাদের কথাগুলো মন দিয়ে আন্তরিকতার সাথে শুনুন, তাদেরকে একটু বেশি ভালবাসা দিন এবং তাদের প্রতি মনোযোগী হোন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "Children need adults’ love and attention during difficult times. Give them extra time and attention.\n\nRemember to listen to your children, speak kindly and re-assure them.\n\nIf possible, make opportunities for the child to play and relax.",
                        "প্রতিকূল পরিস্থিতিতে শিশুরা বড়দের ভালবাসা আর মনোযোগ একটু বেশি চায়। এই অবস্থায় আরেকটু বেশি সময় দিয়ে তাদের প্রতি মনোযোগী হোন।\n\nশিশুদের কথাগুলো মন দিয়ে শুনুন, তাদেরকে আশ্বস্ত করুন এবং তাদের প্রতি সদয় হয়ে কথা বলুন।\n\nযদি সুযোগ থাকে তবে শিশুটিকে খেলতে দিন এবং তাকে চাপমুক্ত রাখুন।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Try and keep children close to their parents and family and avoid separating children and their caregivers to the extent possible. If separation occurs (e.g. hospitalization) ensure regular contact (e.g. via phone) and re-assurance.",
                        "যতদূর সম্ভব, ভাইরাস সংক্রমণের সকল পর্যায়ে শিশুকে তার মা-বাবা এবং পরিবারের সাথেই রাখুন এবং তাদেরকে পরিবার বা যত্নপ্রদানকারীদের কাছ থেকে আলাদা করা থেকে বিরত রাখুন। হাসপাতালে ভর্তি, কোয়ারেন্টাইন বা যেকোন কারনে যদি আলাদা করতেই হয় তবে টেলিফোন বা অন্য মাধ্যমের সাহায্যে যোগাযোগ রক্ষা করুন এবং শিশুদের নিয়মিত আশ্বস্ত করুন।",
                        false,
                        false),
                new TopicDetails("D-4",
                        "null",
                        "Keep to regular routines and schedules as much as possible, or help create new ones in a new environment, including school/learning as well as time for safely playing and relaxing.",
                        "প্রতিদিনকার নিয়মিত রুটিন আর পরিকল্পনামাফিক কাজগুলো যতদূর সম্ভব আগের মতই বজায় রাখার চেষ্টা করুন অথবা প্রয়োজন হলে নতুন পরিবেশে নতুন রুটিনমত কাজ করে যেতে শিশুদের সাহায্য করুন। যেমন - স্কুলে যাওয়া, পড়ালেখা করে, নিরাপদে খেলা এবং বাড়তি চাপমুক্ত থাকা।",
                        false,
                        true),
                new TopicDetails("D-5",
                        "null",
                        "Provide facts about what has happened, explain what is going on now and give them clear information about how to reduce their risk of being infected by the disease in words that they can understand depending on their age.\n\nThis also includes providing information about what could happen in a re-assuring way (e.g. a family member and/or the child may start not feeling well and may have to go to the hospital for some time so doctors can help them feel better).",
                        "যা হচ্ছে সেই বিষয়ে শিশুকে তার বয়স উপযোগী করে প্রকৃত সত্য তথ্য প্রদান করুন, তাদেরকে প্রতিকূল পরিস্থিতির ব্যাখ্যা দিন এবং কিভাবে সে নিজেকে ঝুঁকিমুক্ত রাখতে পারবে এবং সংক্রমণ থেকে দূরে থাকবে সেগুলো সহজ ভাষায় বুঝিয়ে বলুন।\nসংক্রমণের পরিণতি সম্পর্কে শিশুকে আগাম তথ্য জানিয়ে রাখুন এবং নিরাপত্তার বিষয়ে তাকে আশ্বস্ত করুন। যেমন - শিশু বা তার পরিবারের কেউ যদি অসুস্থ বোধ করে এবং হাসপাতালে ভর্তির প্রয়োজন হয় তবে সেটি শিশুকে আগে থেকে জানিয়ে দিন, সেই সাথে জানান যে এতে আতঙ্কিত হওয়ার কিছু নেই, তাদের সুস্থতার জন্য চিকিৎসক প্রয়োজনীয় ব্যবস্থা গ্রহণ করবেন।",
                        false,
                        false)
        )));

        ArrayList<Topic> topics = new ArrayList<>(Arrays.asList(topic1, topic2));

        topicHost.setTopics(topics);

        return topicHost;
    }

    public static TopicHost communicatingSeveritySeries() {
        TopicHost topicHost = new TopicHost();
        topicHost.setId("SLH-3");
        topicHost.setTitle_En("Communicating severity");
        topicHost.setTitle_Bn("কোভিড-১৯ এবং করনীয়সমূহ");

        Topic topic1 = new Topic();
        topic1.setId("SL-1");
        topic1.setTitle_En("COVID-19 Information");
        topic1.setTitle_Bn("কোভিড-১৯ সম্পর্কিত তথ্য");
        topic1.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Know the Facts: Most people infected with COVID-19 will only have mild or moderate symptoms and fully recover. Yet, some people are more at risk. We all have to role to play protecting ourselves and others.",
                        "কোভিড-১৯ আক্রান্ত বেশিরভাগ মানুষেরই মৃদু থেকে মাঝারি ধরনের লক্ষণ দেখা যায়, যা সম্পূর্ণ নিরাময়যোগ্য। তবে কিছু মানুষের ঝুঁকি তুলনামূলক বেশি।\n\n নিজের এবং অন্যদের সুরক্ষার দায়িত্ব নিজেদেরকেই পালন করতে হবে।",
                        false,
                        false),
                new TopicDetails("D-1",
                        "null",
                        "Currently 4 of 5 people infected with COVID-19 will experience only mild or moderate symptoms, like fever and a dry cough.",
                        "বর্তমানে কোভিড-১৯ আক্রান্ত পাঁচজনের মধ্যে চারজনেরই সামান্য থেকে বাজারে লক্ষণ অনুভূত হতে পারে, যেমন - জ্বর এবং শুকনো কাশি।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Around 95% of people who have been sick with COVID-19 to date have recovered or are recovering.",
                        "কোভিড-১৯ দ্বারা আক্রান্ত ৯৫% মানুষই সুস্থ হয়ে গেছে বা হয়ে যাচ্ছে।",
                        false,
                        false),
                new TopicDetails("D-3",
                        "null",
                        "So far, children and adolescents have been far less affected by COVID-19 and their symptoms have almost always been mild.",
                        "এখনো পর্যন্ত কোভিড-১৯ দ্বারা শিশু ও বয়ঃসন্ধিদের আক্রান্ত হওয়ার সম্ভাবনা কম এবং আক্রান্তদের মধ্যে মৃদু অসুস্থতা দেখা গেছে।",
                        false,
                        true)
        )));

        Topic topic2 = new Topic();
        topic2.setId("SL-2");
        topic2.setTitle_En("While COVID-19 is often mild, it is spreading very quickly. We all need to work together now to protect the most vulnerable:");
        topic2.setTitle_Bn("কোভিড-১৯ সংক্রমনের লক্ষণ মৃদু কিন্তু এই ভাইরাস খুব দ্রুত সংক্রমিত হয়। আমাদের এমন ঝুঁকিপূর্ণ অবস্থায় আছে এমন ব্যক্তিদের জন্য সুরক্ষার ব্যবস্থা করতে হবেঃ");
        topic2.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Healthcare workers",
                        "স্বাস্থ্যসেবাদানকারী",
                        true,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "People over 60 years of age",
                        "৬০ বছরের উর্ধ্বে প্রবীণ ব্যক্তি",
                        true,
                        false),
                new TopicDetails("D-3",
                        "null",
                        "Those with underlying health conditions (e.g. heart or lung disease, diabetes, or immunocompromised)",
                        "প্রাক-বিদ্যমান চিকিৎসারত (যেমন- উচ্চরক্তচাপ, হূদরোগ, ফুসফুসের রোগ, ক্যান্সার বা ডায়াবেটিস, রোগপ্রতিরোধ ক্ষমতা কম এমন ব্যক্তি)",
                        true,
                        false)
        )));

        Topic topic3 = new Topic();
        topic3.setId("SL-3");
        topic3.setTitle_En("Protect yourself and others from COVID-19:");
        topic3.setTitle_Bn("কোভিড-১৯ সংক্রমণ হতে নিজেকে ও অন্যদের নিরাপদ রাখুনঃ");
        topic3.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Wash your hands frequently with soap and water or alcohol-based hand rub.",
                        "অ্যালকোহল ভিত্তিক হ্যান্ড স্যানিটাইজার দিয়ে আপনার হাত নিয়মিত এবং ভালভাবে পরিষ্কার করুন বা সাবান ও পানি দিয়ে ধুয়ে ফেলুন।",
                        true,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "Cover coughs and sneezes with a bent elbow. Wash hands after.",
                        "কাশি বা হাঁচির সময় আপনার কনুই দিয়ে আপনার মুখ এবং নাকটি ডেকে রাখুন। এরপর পানি দিয়ে হাত ধুয়ে ফেলুন।",
                        true,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Avoid touching your eyes, nose & mouth.",
                        "চোখ, নাক এবং মুখ স্পর্শ করা এড়িয়ে চলুন।",
                        true,
                        false),
                new TopicDetails("D-3",
                        "null",
                        "Keep 1m distance away from others.",
                        "অন্যদের থেকে নিজেকে কমপক্ষে ১ মিটার (৩ ফুট) দূরত্বে রাখুন।",
                        true,
                        true)
        )));

        ArrayList<Topic> topics = new ArrayList<>(Arrays.asList(topic1, topic2, topic3));

        topicHost.setTopics(topics);

        return topicHost;
    }

    public static TopicHost gettingWorkplaceReady() {
        TopicHost topicHost = new TopicHost();
        topicHost.setId("SLH-4");
        topicHost.setTitle_En("Getting workplace ready");
        topicHost.setTitle_Bn("কোভিড-১৯ মোকাবেলায় কাজের স্থানকে সুরক্ষিত করুন");

        Topic topic1 = new Topic();
        topic1.setId("SL-1");
        topic1.setTitle_En("Getting workplace ready");
        topic1.setTitle_Bn("কাজের স্থানকে সুরক্ষিত করুন");
        topic1.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Surfaces (like desks, tables) and objects (like telephones, keyboards) should be wiped with disinfectant regularly",
                        "জীবাণুনাশক দ্বারা নিয়মিত ডেস্ক, টেবিলের উপরিভাগ এবং টেলিফোন, কিবোর্ড পরিষ্কার করুন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "Promote regular teleworking across your organization. If there is an outbreak of COVID-19 in your community the health authorities may advise people to avoid public transport and crowded places. Teleworking will help your business keep operating while your employees stay safe.",
                        "টেলিফোন ও ইমেইলের মাধ্যমে কাজ সম্পন্ন করতে চেষ্টা করুন। কোভিড-১৯ এর প্রাদুর্ভাব দেখা দিলে বিশেষজ্ঞরা ভিড় এড়াতে ও গণপরিবহন ব্যবহার সীমিত করতে উপদেশ দিতে পারেন। সেক্ষেত্রে টেলিফোন ও ই-মেইলের মাধ্যমে কাজ সম্পন্ন করলে কাজ অক্ষুন্ন থাকবে এবং কর্মীরাও সুরক্ষিত থাকবে।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Your employees should comply with any local restrictions on travel, movement or large gatherings.",
                        "ভ্রমণে ও জনসমাগমে কর্মীদের স্থানীয় সর্তকতা অবলম্বন করা উচিত।",
                        false,
                        false),
                new TopicDetails("D-4",
                        "null",
                        "Brief your employees, contractors and customers that if coronavirus starts spreading in your community, anyone with even a mild cough or fever will need to stay at home.",
                        "স্থানীয়ভাবে করোনা ভাইরাসের সংক্রমণ ঘটলে তা কর্মীদের মাঝে অবগত করুন। কারো যদি সামান্য জ্বর বা কাশি থাকে তার কাজে না এসে বাড়িতে অবস্থান করা উচিত।",
                        false,
                        true),
                new TopicDetails("D-5",
                        "null",
                        "Advise employees and contractors to consult national travel advice before going on business trips.",
                        "যেকোনো বিজনেস ট্রিপের আগে, কর্মীদের স্থানীয় ভ্রমণ নীতিমালা অনুসরণ করতে বলুন।",
                        false,
                        false),
                new TopicDetails("D-6",
                        "null",
                        "Promote good respiratory hygiene. Ensure that surgical face masks and/or paper tissues are available at your workplaces for those who develop a runny nose or cough at work – along with closed bins for hygienic disposal of them.",
                        "শ্বাসতন্ত্রের স্বাস্থ্যবিধি মেনে চলুন।\nযাদের সর্দি-কাশি আছে তাদের জন্য প্রয়োজনীয় সার্জিক্যাল মাস্ক ও টিস্যু রাখুন। ব্যবহৃত টিস্যু ও মাস্ক ফেলতে মুখবন্ধ ডাস্টবিন ব্যবহার করুন।",
                        false,
                        true),
                new TopicDetails("D-7",
                        "null",
                        "Promote regular and thorough hand washing. Put sanitizing hand rub dispensers in prominent places around the workplace and provide access to places where staff, contractors, and customers can wash their hands with soap and water.",
                        "নিজের সুরক্ষার জন্য নিয়মিত ও সঠিক উপায়ে দুইহাত বার বার সাবান-পানি দিয়ে বা হ্যান্ড স্যানিটাইজার দিয়ে পরিষ্কার করুন।\nহ্যান্ড স্যানিটাইজার এমন জায়গায় রাখুন যেন সবাই তা ব্যবহার করতে পারে এবং হাত ধোয়া স্থানে সকলের যাতায়াত নিশ্চিত করুন।",
                        false,
                        false),
                new TopicDetails("D-8",
                        "null",
                        "• Keep workplaces clean and hygienic.\n• Promote regular and thorough hand washing.\n• Promote good respiratory hygiene.\n• Consult national travel advice before going on business travel.\n• Advise those who are sick to stay home.",
                        "• কর্মক্ষেত্র পরিষ্কার রাখুন।\n• নিয়মিত ও সঠিক নিয়মে হাত ধোয়ার অভ্যাস করুন।\n• সঠিক শ্বাসতন্ত্রের স্বাস্থ্যবিধি প্রচার করুন।\n• স্থানীয় ভ্রমণ নীতিমালা মেনে চলুন।\n• যারা অসুস্থ তাদের বাড়িতে অবস্থান করতে বলুন।",
                        false,
                        true)
        )));

        ArrayList<Topic> topics = new ArrayList<>(Arrays.asList(topic1));

        topicHost.setTopics(topics);

        return topicHost;
    }

    public static TopicHost protectYourself() {
        TopicHost topicHost = new TopicHost();
        topicHost.setId("SLH-5");
        topicHost.setTitle_En("Protect yourself");
        topicHost.setTitle_Bn("নিজেকে সুস্থ রাখুন");

        Topic topic1 = new Topic();
        topic1.setId("SL-1");
        topic1.setTitle_En("Reduce your risk of coronavirus infection:");
        topic1.setTitle_Bn("করোনা ভাইরাস সংক্রমণের ঝুঁকি কমাতে যা করতে হবেঃ");
        topic1.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Frequently clean hands by using alcohol-based hand rub or soap and water.",
                        "বারবার প্রয়োজনমতো সাবান ও পানি দিয়ে হাত ধুয়ে ফেলুন বা অ্যালকোহল যুক্ত হ্যান্ডরাব দিয়ে হাত পরিষ্কার করুন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "When coughing and sneezing cover mouth and nose with flexed elbow or tissue – throw tissue away immediately in a closed bin and wash hands.",
                        "সর্দি-কাশির সময় টিস্যু পেপার দিয়ে নাক-মুখ ঢেকে ফেলুন। টিস্যু পেপার না থাকলে অন্ততঃ কনুই ভাজ করে নাক-মুখ ঢেকে ফেলুন। ব্যবহারের পরপর টিস্যু পেপার দ্রুত বিনে ফেলুন ও হাত ধুয়ে ফেলুন।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Avoid close contact with anyone that has fever and cough.",
                        "সর্দি-কাশি ও জ্বরে আক্রান্ত ব্যক্তির কাছে যাওয়া থেকে বিরত থাকুন।",
                        false,
                        false),
                new TopicDetails("D-4",
                        "null",
                        "Thoroughly cook meat and eggs.",
                        "মাংস ও ডিম পর্যাপ্ত তাপমাত্রায় রান্না করুন।",
                        false,
                        true),
                new TopicDetails("D-5",
                        "null",
                        "Avoid unprotected contact with live wild or farm animals.",
                        "গৃহপালিত বা অন্য কোন প্রানীর সংস্পর্শ পরিহার করুন।",
                        false,
                        false)
        )));

        Topic topic2 = new Topic();
        topic2.setId("SL-2");
        topic2.setTitle_En("Wash your hands");
        topic2.setTitle_Bn("আপনার হাত ধুয়ে ফেলুন");
        topic2.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "• after coughing or sneezing\n• when caring for the sick\n• before, during and after you prepare food\n• before eating\n• after toilet use\n• when hands are visibly dirty\n• after handling animals or animal waste",
                        "• সর্দি-কাশির পরে\n• আক্রান্ত ব্যক্তির সংস্পর্শে যাওয়ার বা তাঁকে বহন করার পরে\n• খাবার তৈরির আগে, তৈরি করার সময় ও পরে\n• খাবার আগে\n• টয়লেট ব্যাবহারের পরে\n• হাত ময়লা দেখা গেলে\n• পশু বা পশুর বর্জ্য নিয়ে",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "Wash your hands with soap and running water when hands are visibly dirty.",
                        "আপনার হাতে ময়লা দেখা গেলে সাবান ও পানি দিয়ে ধুয়ে ফেলুন।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "If your hands are not visibly dirty, frequently clean them by using alcohol-based hand rub or soap and water.",
                        "আপনার হাতে ময়লা দেখা না গেলেও বারবার প্রয়োজনমতো সাবান ও পানি দিয়ে হাত ধুয়ে ফেলুন বা অ্যালকোহল যুক্ত হ্যান্ডরাব দিয়ে হাত পরিষ্কার করুন।",
                        false,
                        false)
        )));

        Topic topic3 = new Topic();
        topic3.setId("SL-3");
        topic3.setTitle_En("Protect others from getting sick");
        topic3.setTitle_Bn("অন্যদের ঝুঁকিমুক্ত রাখুন");
        topic3.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "When coughing and sneezing cover mouth and nose with flexed elbow or tissue – throw tissue away immediately and wash hands.",
                        "সর্দি-কাশির সময় টিস্যু পেপার দিয়ে নাক-মুখ ঢেকে ফেলুন। টিস্যু পেপার না থাকলে অন্ততঃ কনুই ভাজ করে নাক-মুখ ঢেকে ফেলুন। ব্যবহারের পরপর টিস্যু পেপার বিনে ফেলে দিয়ে দ্রুত হাত ধুয়ে ফেলুন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "Throw tissue into a closed bin immediately after use.",
                        "ব্যবহার করার পরপরই টিস্যু পেপার দ্রুত ঢাকনাযুক্ত বিনে ফেলুন।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Clean hands with alcohol-based hand rub or soap and water after coughing or sneezing and when caring for the sick.",
                        "আক্রান্ত ব্যক্তিকে বহন করার পর প্রয়োজনমতো সাবান ও পানি দিয়ে হাত ধুয়ে ফেলুন বা অ্যালকোহল যুক্ত হ্যান্ডরাব দিয়ে হাত পরিষ্কার করুন।",
                        false,
                        false),
                new TopicDetails("D-4",
                        "null",
                        "Avoid close contact when you are experiencing cough and fever.",
                        "সর্দি-কাশি বা জ্বর হলে অন্যের কাছে যাওয়া থেকে বিরত থাকুন।",
                        false,
                        true),
                new TopicDetails("D-5",
                        "null",
                        "Avoid spitting in public.",
                        "যেখানে সেখানে থুতু বা কফ ফেলবেন না।",
                        false,
                        false),
                new TopicDetails("D-6",
                        "null",
                        "If you have fever, cough, and difficulty breathing seek medical care early and share previous travel history with your health care provider.",
                        "যদি আপনার জ্বর, কাশি এবং শ্বাস-প্রশ্বাসে কষ্ট থাকে তাহলে জরুরী ভিত্তিতে স্বাস্থ্যসেবা গ্রহণ করুন এবং স্বাস্থ্য কর্মীকে আপনার ভ্রমণ বৃত্তান্ত জানান।",
                        false,
                        true)
        )));

        Topic topic4 = new Topic();
        topic4.setId("SL-4");
        topic4.setTitle_En("Practise food safety");
        topic4.setTitle_Bn("নিরাপদ খাদ্যভ্যাস করুন");
        topic4.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Use different chopping boards and knives for raw meat and cooked foods.",
                        "কাঁচা মাংস কাটা এবং রান্না করা খাবারের জন্য আলাদা আলাদা বোর্ড ও ছুরি ব্যবহার করুন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "Wash your hands between handling raw and cooked food.",
                        "তাজা খাবার তৈরি করার সময় ও রান্না করা খাবার পরিবেশন এর মাঝে হাত ধুয়ে ফেলুন।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Sick animals and animals that have died of diseases should not be eaten.",
                        "অসুস্থ প্রাণী এবং অসুস্থতার কারণে মৃত প্রাণী খাওয়া পরিহার করুন।",
                        false,
                        false),
                new TopicDetails("D-4",
                        "null",
                        "Even in areas experiencing outbreaks, meat products can be safely consumed if these items are cooked thoroughly and properly handled during food preparation.",
                        "করোনা ভাইরাসের প্রাদুর্ভাব আছে এমন স্থানে মাংস জাতীয় খাবার পর্যাপ্ত তাপমাত্রায় রান্না করা প্রয়োজন।",
                        false,
                        true)
        )));

        Topic topic5 = new Topic();
        topic5.setId("SL-5");
        topic5.setTitle_En("Working in wet markets?");
        topic5.setTitle_Bn("কাঁচা বাজারে কাজ করার সময়?");
        topic5.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Wear protective gowns, gloves, masks and facial protection while handling animals and animal products.",
                        "প্রাণী ও প্রাণিজ সামগ্রী স্পর্শ করার পূর্বে সুরক্ষাকারী কাপড় পরিধান করুন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "Remove protective clothing after work, wash aprons daily and leave at the work site.",
                        "কাজের শেষে সুরক্ষাকারী কাপড় খুলে ধুয়ে ফেলুন এবং তা কাজের জায়গায় সুরক্ষিত রাখুন।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Avoid exposing family members to soiled work clothing and shoes.",
                        "ব্যবহৃত কাপড় ও জুতা যেন পরিবারের সদস্যদের সংস্পর্শে না আসে তা লক্ষ্য রাখুন।",
                        false,
                        false),
                new TopicDetails("D-4",
                        "null",
                        "Frequently wash your hands with soap and water after touching animals and animal products.",
                        "প্রাণী ও প্রাণিজ সামগ্রী সংস্পর্শে আসার কিছুক্ষণ পরপর সাবান ও পানি দিয়ে হাত পরিষ্কার করুন।",
                        false,
                        true),
                new TopicDetails("D-5",
                        "null",
                        "Clean and disinfect equipment and working area at least once a day.",
                        "দিনে অন্তত একবার কাজের জায়গা পরিষ্কার ও জীবাণুমুক্ত করুন।",
                        false,
                        false)
        )));

        ArrayList<Topic> topics = new ArrayList<>(Arrays.asList(topic1, topic2, topic3, topic4, topic5));

        topicHost.setTopics(topics);

        return topicHost;
    }

    public static TopicHost healthyTraveling() {
        TopicHost topicHost = new TopicHost();
        topicHost.setId("SLH-6");
        topicHost.setTitle_En("Healthy travelling");
        topicHost.setTitle_Bn("স্বাস্থ্যকর ভ্রমণ");

        Topic topic = new Topic();
        topic.setId("SL-1");
        topic.setTitle_En("Stay healthy while traveling");
        topic.setTitle_Bn("ভ্রমণের সময় স্বাস্থ্য সুরক্ষা করুন");
        topic.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Avoid travel if you have a fever and cough.",
                        "যদি জ্বর ও কাশি থাকে, তবে ভ্রমণে বিরত থাকুন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "If you have a fever, cough and difficulty breathing seek medical care early and share previous travel history with your health care provider.",
                        "যদি আপনার জ্বর, কাশি এবং শ্বাস-প্রশ্বাসে কষ্ট থাকে তাহলে জরুরী ভিত্তিতে স্বাস্থ্যসেবা গ্রহণ করুন এবং স্বাস্থ্যকর্মীকে আপনার ভ্রমণ বৃত্তান্ত জানান।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Avoid close contact with people suffering from a fever and cough.",
                        "জ্বর ও কাশি আছে এমন ব্যক্তির কাছে যাওয়া থেকে বিরত থাকুন।",
                        false,
                        false),
                new TopicDetails("D-4",
                        "null",
                        "Frequently clean hands by using alcohol-based hand rub or soap and water.",
                        "প্রতিনিয়ত অ্যালকোহলযুক্ত হ্যান্ডরাব অথবা সাবান ও পানি দিয়ে হাত পরিষ্কার করুন।",
                        false,
                        true),
                new TopicDetails("D-5",
                        "null",
                        "Avoid touching eyes, nose or mouth.",
                        "অনবরত চোখ, নাক ও মুখ স্পর্শ করা থেকে বিরত থাকুন।",
                        false,
                        false),
                new TopicDetails("D-6",
                        "null",
                        "When coughing or sneezing cover mouth and nose with flexed elbow or tissue - throw tissue away immediately and wash hands.",
                        "হাঁচি অথবা কাশির সময় কনুইয়ের ভাজেঁ অথবা টিস্যু দিয়ে মুখ ও নাক ঢাকুন - দ্রুত টিস্যুটি ডাস্টবিনে ফেলুন এবং হাত ধুয়ে ফেলুন।",
                        false,
                        true),
                new TopicDetails("D-7",
                        "null",
                        "If you choose to wear a mask, be sure to cover mouth and nose – avoid touching mask once it’s on.",
                        "যদি আপনি মাস্ক পরে থাকেন তাহলে খেয়াল রাখবেন যেন তা ভালভাবে নাক-মুখ ঢেকে থাকে-অযথা মাস্ক ধরবেন না।",
                        false,
                        false),
                new TopicDetails("D-8",
                        "null",
                        "Immediately discard single-use mask after each use and wash hands after removing masks.",
                        "প্রতিবার ব্যবহারের পর মাস্কটি ভালভাবে বিনে ফেলুন এবং হাত ধুয়ে ফেলুন।",
                        false,
                        true),
                new TopicDetails("D-9",
                        "null",
                        "If you become sick while travelling, inform crew and seek medical care early.",
                        "ভ্রমণের সময় অসুস্থ বোধ করলে স্বাস্থ্যসেবার সাহায্যের জন্য ভ্রমণ কর্মীকে জানান।",
                        false,
                        false),
                new TopicDetails("D-10",
                        "null",
                        "If you seek medical attention, share travel history with your health care provider.",
                        "জরুরী স্বাস্থ্যসেবার জন্য স্বাস্থ্যসেবা প্রদানকারীকে আপনার ভ্রমণ বৃত্তান্ত জানান।",
                        false,
                        true),
                new TopicDetails("D-11",
                        "null",
                        "Eat only well-cooked food.",
                        "পর্যাপ্ত তাপমাত্রায় রান্না করা খাবার গ্রহণ করুন।",
                        false,
                        false),
                new TopicDetails("D-12",
                        "null",
                        "Avoid spitting in public.",
                        "যেখানে সেখানে থুতু বা কফ ফেলবেন না।",
                        false,
                        true),
                new TopicDetails("D-13",
                        "null",
                        "Avoid close contact and travel with animals that are sick.",
                        "অসুস্থ প্রাণীদের থেকে দূরে থাকুন এবং ভ্রমনে বিরত থাকুন।",
                        false,
                        false)
        )));

        ArrayList<Topic> topics = new ArrayList<>(Arrays.asList(topic));

        topicHost.setTopics(topics);

        return topicHost;
    }

    public static TopicHost socialDistance() {
        TopicHost topicHost = new TopicHost();
        topicHost.setId("SLH-7");
        topicHost.setTitle_En("Social distance & wearing gloves");
        topicHost.setTitle_Bn("সামাজিক দূরত্ব বজায় রাখা এবং গ্লাভস পরা");

        Topic topic1 = new Topic();
        topic1.setId("SL-1");
        topic1.setTitle_En("Should I avoid shaking hands because of the new coronavirus?");
        topic1.setTitle_Bn("করোনা ভাইরাসের কারণে আমি কি হাত মেলানো বন্ধ করবো?");
        topic1.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Yes. Respiratory viruses can be passed by shaking hands and touching your eyes, nose, and mouth.\nGreet people with a wave, a nod or a bow instead.",
                        "হ্যাঁ, শ্বাসতন্ত্রের ভাইরাস হাত মেলানো এবং চোখ, নাক ও মুখে হাত দেয়ার মাধ্যমে সংক্রমিত হতে পারে।\nবরং হাত বা মাথা নাড়িয়ে অথবা শরীর ঝুঁকিয়ে শুভেচ্ছা জানাতে পারেন।",
                        false,
                        false)
        )));

        Topic topic2 = new Topic();
        topic2.setId("SL-2");
        topic2.setTitle_En("How should I greet another person to avoid catching the new coronavirus?");
        topic2.setTitle_Bn("করোনা ভাইরাসের সংস্পর্শ এড়িয়ে কিভাবে অন্যদেরকে শুভেচ্ছা জানাবো?");
        topic2.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "To prevent COVID-19 it is safest to avoid physical contact when greeting.\nSafe greetings include a wave, a nod, or a bow.",
                        "কোভিড-১৯ প্রতিরোধে শুভেচ্ছা বিনিময়ের সময়ে শারীরিক সংস্পর্শ এড়িয়ে চলায় সবচেয়ে নিরাপদ।\nনিরাপদ উপায় হলো মাথা নাড়ানো অথবা শরীর ঝুঁকিয়ে শুভেচ্ছা জানানো",
                        false,
                        false)
        )));

        Topic topic3 = new Topic();
        topic3.setId("SL-3");
        topic3.setTitle_En("Is wearing rubber gloves while out in public effective in preventing the new coronavirus infection?");
        topic3.setTitle_Bn("করোনা ভাইরাস সংক্রমণ প্রতিরোধে ঘরের বাইরে রাবারের হাতমোজা পরা কি কার্যকর উপায়?");
        topic3.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "No. Regularly washing your bare hands offers more protection against catching COVID-19 than wearing rubber gloves.\nYou can still pick up COVID-19 contamination on rubber gloves. If you then touch your face, the contamination goes from your glove to your face and can infect you.",
                        "না, রাবারের হাতমোজা পরার চেয়ে খোলা হাত নিয়মিত ধোওয়াই কোভিড-১৯ প্রতিরোধে আপনাকে বেশি সুরক্ষা দিতে পারে।\nরাবারের হাতমোজার উপরও কোভিড-১৯ জীবাণু লেগে যেতে পারে। তারপর মুখে হাত দিলে জীবাণু হাতমোজা থেকে মুখে যেতে পারে এবং আপনাকে সংক্রমিত করতে পারে।",
                        false,
                        false)
        )));

        ArrayList<Topic> topics = new ArrayList<>(Arrays.asList(topic1, topic2, topic3));

        topicHost.setTopics(topics);

        return topicHost;
    }

    public static TopicHost maskGuidance() {
        TopicHost topicHost = new TopicHost();
        topicHost.setId("SLH-8");
        topicHost.setTitle_En("When and how to use masks");
        topicHost.setTitle_Bn("কখন এবং কীভাবে মাস্ক ব্যবহার করবেন");

        Topic topic1 = new Topic();
        topic1.setId("SL-1");
        topic1.setTitle_En("Reduce risk of coronavirus infection");
        topic1.setTitle_Bn("করোনা ভাইরাস সংক্রমণের ঝুঁকি কমাতে যা করতে হবে");
        topic1.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Frequently clean hands by using alcohol-based hand rub or soap and water.",
                        "বারবার প্রয়োজনমতো সাবান ও পানি দিয়ে হাত ধুয়ে ফেলুন বা অ্যালকোহল যুক্ত হ্যান্ডরাব দিয়ে হাত পরিষ্কার করুন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "When coughing and sneezing cover mouth and nose with flexed elbow or tissue – throw tissue away immediately and wash hands.",
                        "সর্দি-কাশির সময় টিস্যু পেপার দিয়ে নাক-মুখ ঢেকে ফেলুন। টিস্যু পেপার না থাকলে অন্ততঃ কনুই ভাজ করে নাক-মুখ ঢেকে ফেলুন। ব্যবহারের পরপর টিস্যু পেপার দ্রুত বিনে ফেলুন ও হাত ধুয়ে ফেলুন।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Avoid close contact with anyone that has fever and cough.",
                        "সর্দি-কাশি ও জ্বরে আক্রান্ত ব্যক্তির কাছে যাওয়া থেকে বিরত থাকুন।",
                        false,
                        false)
        )));

        Topic topic2 = new Topic();
        topic2.setId("SL-2");
        topic2.setTitle_En("When to use a mask");
        topic2.setTitle_Bn("মাস্ক কখন ব্যবহার করবেন");
        topic2.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "If you are healthy, you only need to wear a mask if you are taking care of a person with suspected 2019-nCoV infection.",
                        "আপনি যদি সুস্থ থাকেন, কেবল করোনা ভাইরাস আক্রান্ত রোগীকে সেবা দেওয়ার সময় মাস্ক ব্যবহার করুন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "Wear a mask if you are coughing or sneezing.",
                        "আপনি যখন হাঁচি বা কাশি দিচ্ছেন তখন মাস্ক ব্যবহার করুন।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Masks are effective only when used in combination with frequent hand-washing with alcohol-based hand rub or soap and water.",
                        "মাস্ক ব্যবহার তখনই কার্যকরী যখন অ্যালকোহলযুক্ত হ্যান্ডরাব দিয়ে হাত ঘষে নেয়া হয় বা সাবান-পানি দিয়ে হাত ধোয়া হয়।",
                        false,
                        false),
                new TopicDetails("D-4",
                        "null",
                        "If you wear a mask then you must know how to use it and dispose of it properly.",
                        "মাস্ক ব্যবহার করলে অবশ্যই আপনাকে এর ব্যবহারবিধি জানতে হবে।",
                        false,
                        true)
        )));

        Topic topic3 = new Topic();
        topic3.setId("SL-3");
        topic3.setTitle_En("If you wear a mask then you must know how to use it and dispose of it properly");
        topic3.setTitle_Bn("মাস্ক কিভাবে পড়তে, ব্যবহার করতে, খুলতে ও ফেলে দিতে হয়");
        topic3.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Before putting on a mask, wash hands with alcohol-based hand rub or soap and water.",
                        "মাস্ক ব্যবহারের আগে অ্যালকোহলযুক্ত হ্যান্ডরাব দিয়ে ঘষে বা সাবান-পানি দিয়ে হাত ধুয়ে নিন।",
                        false,
                        false),
                new TopicDetails("D-2",
                        "null",
                        "Cover mouth and nose with mask and make sure there are no gaps between your face and the mask.\nAvoid touching the mask while using it; if you do, clean your hands with alcohol-based hand rub or soap and water.",
                        "নাক-মুখ মাস্ক দিয়ে এমনভাবে ঢাকুন যাতে মুখমণ্ডল ও মাস্ক এর মাঝে কোন ফাঁকা না থাকে। ব্যবহৃত মাস্কে হাত দেয়া যাবে না, যদি দিয়েই ফেলেন, তাহলে অ্যালকোহলযুক্ত হ্যান্ডরাব দিয়ে ঘষে বা সাবান-পানি দিয়ে হাত ধুয়ে ফেলতে হবে।",
                        false,
                        true),
                new TopicDetails("D-3",
                        "null",
                        "Replace the mask with a new one as soon as it is damp and do not reuse single-use masks.",
                        "ব্যবহৃত মাস্কটি ভেজা ভেজা হয়ে গেলে সেটি বদলে ফেলুন। ব্যবহৃত মাস্ক কখনোই পুনরায় ব্যবহার করা যাবে না।",
                        false,
                        false),
                new TopicDetails("D-4",
                        "null",
                        "To remove the mask: remove it from behind (do not touch the front of mask); discard immediately in a closed bin; wash hands with alcohol-based hand rub or soap and water.",
                        "মাস্ক খোলার সময় পিছন দিক থেকে খোলা শুরু করুন, কোনমতেই যেন সামনের অংশে হাত না লাগে। তারপর ঢাকনাযুক্ত বিনে ফেলুন। অ্যালকোহলযুক্ত হ্যান্ডরাব বা সাবান-পানি দিয়ে হাত ঘষে ধুয়ে নিন।",
                        false,
                        true)
        )));

        ArrayList<Topic> topics = new ArrayList<>(Arrays.asList(topic1, topic2, topic3));

        topicHost.setTopics(topics);

        return topicHost;
    }

    public static TopicHost mythsAndRumours() {
        TopicHost topicHost = new TopicHost();
        topicHost.setId("SLH-9");
        topicHost.setTitle_En("Myths & Rumours");
        topicHost.setTitle_Bn("কাল্পনিক ও গুজব");

        Topic topic1 = new Topic();
        topic1.setId("SL-1");
        topic1.setTitle_En("Can eating garlic help prevent infection with the new coronavirus?");
        topic1.setTitle_Bn("রসুন খাওয়া কি করোনাভাইরাসের সংক্রমণ প্রতিরোধে কাজ করবে?");
        topic1.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Garlic is a healthy food that may have some antimicrobial properties."
                                + "\n" +
                                "However, there is no evidence from the current outbreak that eating garlic has protected people from COVID-19.",
                        "নভেল করোনাভাইরাসের বিরুদ্ধে রসুন কার্যকর এমন কোন প্রমাণ পাওয়া যায়নি।"
                                + "\n" +
                                "তবে রসুন একটি উপকারী খাবার কিছু জীবাণুনাশক গুনাগুন থাকতে পারে।",
                        false,
                        false)
        )));

        Topic topic2 = new Topic();
        topic2.setId("SL-2");
        topic2.setTitle_En("Does sesame oil block the coronavirus from entering the body?");
        topic2.setTitle_Bn("তিলের তেল কি করোনভাইরাস শরীরে প্রবেশ করতে বাধা দেয়?");
        topic2.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "No, Sesame oil does not kill the new coronavirus."
                                + "\n\n" +
                                "There are some chemical disinfectants that can kill the virus from surfaces. These include bleach/chlorine-based disinfectants, 75% ethanol, peracetic acid and chloroform. However, they have little or no impact on the skin or under your nose. It can be dangerous to put these chemicals on your skin.",
                        "না, তিলের তেল করোনভাইরাস ধ্বংস করেনা।"
                                + "\n\n" +
                                "কিছু রাসায়নিক জীবাণুনাশক রয়েছে যা ভূপৃষ্ঠ থেকে ভাইরাসটিকে হত্যা করতে পারে। এর মধ্যে রয়েছে ব্লিচ/ক্লোরিন-ভিত্তিক জীবাণুনাশক, ৭৫% ইথানল, পেরাসেটিক অ্যাসিড এবং ক্লোরোফর্ম। তবে ত্বকে বা আপনার নাকের নীচে এগুলির সামান্য বা কোনও প্রভাব নেই। আপনার ত্বকে এই রাসায়নিকগুলি রাখা বিপজ্জনক হতে পারে।",
                        false,
                        false)
        )));

        Topic topic4 = new Topic();
        topic4.setId("SL-4");
        topic4.setTitle_En("Is it safe to receive a letter or a package from China?");
        topic4.setTitle_Bn("চীন থেকে আসা কোন চিঠি বা পার্সেল গ্রহণ করা কি নিরাপদ?");
        topic4.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Yes, it is safe. People receiving packages from China are not at risk of contracting the new coronavirus."
                                + "\n\n" +
                                "From previous analysis, we know coronaviruses do not survive long on objects, such as letters or packages.",
                        "হ্যাঁ, নিরাপদ। চীন থেকে আসা কোন চিঠি বা পার্সেল যদি কেউ গ্রহণ করে তবে তিনি করোনাভাইরাসের সংক্রমণের ঝুঁকিতে পরবেনা।"
                                + "\n\n" +
                                "ইতিমধ্যে পাওয়া তথ্যের ভিত্তিতে আমরা জানি যে, মানবদেহের বাইরে এই ভাইরাস বেশিক্ষণ বাঁচেনা।",
                        false,
                        false)
        )));

        Topic topic5 = new Topic();
        topic5.setId("SL-5");
        topic5.setTitle_En("Can pets at home spread COVID-19?");
        topic5.setTitle_Bn("গৃহপালিত প্রাণী কি করোনাভাইরাস ছড়াতে পারে?");
        topic5.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "At present, there is no evidence that companion animals/pets such as dogs or cats can be infected with the new coronavirus. However, it is always a good idea to wash your hands with soap and water after contact with pets."
                                + "\n" +
                                "This protects you against various common bacteria such as E. Coli and Salmonella that can pass between pets and humans.",
                        "ঘরের পোষা প্রাণী (যেমন- বিড়াল, কুকুর ইত্যাদি) নভেল করোনাভাইরাস দিয়ে আক্রান্ত হয় এমন কোন প্রমাণ এখনও পাওয়া যায়নি। তবে পোষা প্রাণীর সংস্পর্শে আসার পর সব সময় সাবান-পানি দিয়ে হাত ধোয়া উত্তম।"
                                + "\n" +
                                "এই অভ্যাসের কারণে পোষা প্রাণী থেকে মানবদেহে রোগ ছড়ায় এমন ব্যাকটেরিয়া (যেমন- ই-কোলাই, সালমনেলা ইত্যাদি) থেকে সুরক্ষা পাওয়া যায়।",
                        false,
                        false)
        )));

        Topic topic6 = new Topic();
        topic6.setId("SL-6");
        topic6.setTitle_En("Can the new coronavirus be transmitted through mosquito bites");
        topic6.setTitle_Bn("মশার কামড়ে কোভিড-১৯ ছড়ায় না");
        topic6.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "To date there has been no information nor evidence to suggest that the new coronavirus could be transmitted by mosquitoes."
                                + "\n\n" +
                                "The new coronavirus is a respiratory virus which spreads primarily through droplets generated when an infected person coughs or sneezes. Or through droplets of saliva of discharge from the nose. To protect yourself, clean your hands frequently with an alcohol-based hand rub or wash them with soap and water. Also, avoid close contact with anyone who is coughing and sneezing.",
                        "মশার কামড়ে কোভিড-১৯ ছড়ায় এমন কোন তথ্য/প্রমাণ পাওয়া যায়নি।"
                                + "\n\n" +
                                "নভেল করোনাভাইরাস শ্বাসতন্ত্রের রোগ। আক্রান্ত ব্যক্তির হাঁচি-কাশির মাধ্যমে এই রোগ ছড়ায়। নিজের সুরক্ষায় বারবার সাবান ও পানি দিয়ে হাত ধুয়ে ফেলুন, সর্দি-কাশির সময় টিস্যু পেপার দিয়ে অথবা কনুই ভাঁজ করে নাক-মুখ ঢেকে ফেলুন এবং হাঁচি-কাশি আছে এমন ব্যক্তির সংস্পর্শ এড়িয়ে চলুন।",
                        false,
                        false)
        )));

        Topic topic7 = new Topic();
        topic7.setId("SL-7");
        topic7.setTitle_En("Can the new coronavirus survive in hot and humid climates?");
        topic7.setTitle_Bn("নভেল করোনাভাইরাস উষ্ণ ও আর্দ্র আবহাওয়ায় বাঁচতে পারে?");
        topic7.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Yes, COVID-19 has spread to countries with both hot and humid climates, as well as cold and dry."
                                + "\n\n" +
                                "Wherever you live, whatever the climate, is important to follow precautions. Wash your hands frequently and cover mouth and nose when you cough and sneeze with a tissue or a bend elbow. Throw the tissue in the bin and wash your hands immediately.",
                        "হ্যাঁ, কোভিড-১৯ ঠান্ডা ও শুষ্ক আবহাওয়ার দেশের পাশাপাশি উষ্ণ ও আর্দ্র আবহাওয়ার দেশেও বিস্তার লাভ করেছে।"
                                + "\n\n" +
                                "যেখানেই থাকুন, যেভাবেই থাকুক না কেন, সর্তকতা অবলম্বন করা জরুরী। বারবার হাত ধুয়ে ফেলুন, সর্দি-কাশির সময় টিস্যু পেপার দিয়ে অথবা কনুই ভাঁজ করে নাক-মুখ ঢেকে ফেলুন এবং ব্যবহৃত টিস্যুটি ঢাকনাযুক্ত বিনে ফেলুন।",
                        false,
                        false)
        )));

        Topic topic8 = new Topic();
        topic8.setId("SL-8");
        topic8.setTitle_En("Are hand dryers effective in killing the coronavirus?");
        topic8.setTitle_Bn("হ্যান্ড ড্রায়ার কি করোনাভাইরাস ধ্বংসে কার্যকরী?");
        topic8.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "No, Hand dryers are not effective in killing the new coronavirus."
                                + "\n\n" +
                                "To protect yourself against the new coronavirus, you should frequently clean your hands with an alcohol-based hand rub or wash them with soap and water. Once your hands are cleaned, you should dry them thoroughly by using paper towels or a warm air dryer.",
                        "না, হ্যান্ড ড্রায়ার নভেল করোনাভাইরাস ধ্বংসে কার্যকরী নয়।"
                                + "\n\n" +
                                "নিজের সুরক্ষার জন্য দুইহাত বারবার সাবান ও পানি দিয়ে বা হ্যান্ড স্যানিটাইজার দিয়ে পরিষ্কার করুন। হাত পরিষ্কারের পর টিস্যু দিয়ে মুছে ফেলুন।",
                        false,
                        false)
        )));

        Topic topic9 = new Topic();
        topic9.setId("SL-9");
        topic9.setTitle_En("Can ultraviolet disinfection lamp kill the new coronavirus?");
        topic9.setTitle_Bn("আল্ট্রা-ভায়োলেট জীবাণুনাশক ল্যাম্প কি করোনাভাইরাস ধ্বংস করতে পারে?");
        topic9.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "UV lamps should not be used to sterilize hands or other areas of skin as UV radiation can cause skin irritation.",
                        "হাত বা শরীরের অন্য কোন অংশ জীবাণুমুক্ত করার জন্য আল্ট্রাভায়োলেট ল্যাম্প ব্যবহার করা উচিত না। এর ফলে ত্বকে সমস্যা হতে পারে।",
                        false,
                        false)
        )));

        Topic topic10 = new Topic();
        topic10.setId("SL-10");
        topic10.setTitle_En("Does smoking have an effect on the new coronavirus infection COVID-19?");
        topic10.setTitle_Bn("ধূমপানে কি কোভিড-১৯ সংক্রমণে কোন প্রভাব পরে?");
        topic10.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Smoking does not protect against COVID-19."
                                + "\n\n" +
                                "In fact, smoking is deadly. More than 8 million people die each year as a result of tobacco use. People with underlying health conditions such as heart disease, which can be exacerbated by smoking, are at higher risk of severe COVID-19.",
                        "ধূমপান অভিনয় সংক্রমণে কোন সুরক্ষা দেয়না।"
                                + "\n\n" +
                                "ধূমপান শরীরের জন্য ক্ষতিকর। প্রতিবছর ৪ মিলিয়ন মানুষ ধূমপানের জন্য মৃত্যুবরণ করে। ধূমপানের ফলে বা যাদের আগে থেকে কোন অসুস্থতা আছে (যেমন- হূদরোগ) এমন ব্যক্তির গুরুতর কোভিড-১৯ হবার ঝুঁকি বেশি।",
                        false,
                        false)
        )));

        Topic topic11 = new Topic();
        topic11.setId("SL-11");
        topic11.setTitle_En("Does COVID-19 spread through the air (e.g. through air conditioning or via e-cigarette emissions)?");
        topic11.setTitle_Bn("কোভিড-১৯ কি বাতাসে ছড়ায় (যেমনঃ এয়ারকন্ডিশন বা ই-সিগারেটের মাধ্যমে)?");
        topic11.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Current evidence suggests the new coronavirus spreads primarily through close contact with an infected person or the droplets released when they cough or sneeze."
                                + "\n\n" +
                                "These released droplets typically travel less than a meter and do not hang in the air but can settle on surfaces. This is why it is important to wash hands and cover mouth and nose when coughing and sneezing.",
                        "বর্তমান প্রমাণ সাপেক্ষে দেখা গেছে যে, আক্রান্ত ব্যক্তির কাছাকাছি থাকলে অথবা তার হাঁচি-কাশির মাধ্যমে কোভিড-১৯ দ্বারা আক্রান্ত হবার সম্ভাবনা থাকে।"
                                + "\n\n" +
                                "এই হাঁচি-কাশির মাধ্যমে ভাইরাস এক মিটারের বেশি যেতে পারেনা, বাতাসেও ভাসতে পারেনা কিন্তু যে কোন কিছুর উপরিভাগে অবস্থান নিতে পারে। এইজন্য হাত পরিষ্কার করা এবং কাশির সময় নাক-মুখ ঢাকা অত্যন্ত জরুরী।",
                        false,
                        false)
        )));

        Topic topic12 = new Topic();
        topic12.setId("SL-12");
        topic12.setTitle_En("Can the smoke and gas from fireworks and firecrackers prevent COVID-19?");
        topic12.setTitle_Bn("বাজীর ধোয়া বা গ্যাস কি কোভিড-১৯ থেকে সুরক্ষা দেয়?");
        topic12.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "No, Breathing in the smoke and gas from a firework or firecracker is dangerous and does not kill the new coronavirus."
                                + "\n\n" +
                                "The smoke from fireworks and firecrackers contain Sulphur dioxide, a mildly toxic gas that some people are allergic to. It can irritate your eyes, nose, throat and lungs and could even cause an asthma attack. Also, you risk getting burned if you are near enough to a firework to breathe in its smoke.",
                        "না, বাজীর ধোয়া বা গ্যাস কোভিড-১৯ থেকে সুরক্ষা দেয় না বরং তার শরীরের জন্য ক্ষতিকর।"
                                + "\n\n" +
                                "বাজীর ধোয়া বা গ্যাসে সালফার-ডাই-অক্সাইড আছে যা বিষাক্ত। এটা চোখে, নাকে, গলায় এবং ফুসফুসে জ্বালা ধরায়। এতে পুড়ে যাওয়ার সম্ভাবনা থাকে।",
                        false,
                        false)
        )));

        Topic topic13 = new Topic();
        topic13.setId("SL-13");
        topic13.setTitle_En("Does drinking alcohol prevents the new coronavirus?");
        topic13.setTitle_Bn("অ্যালকোহল(মদ) পান করলে কি কোভিড-১৯ থেকে সুরক্ষা পাওয়া যায়?");
        topic13.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "No, Drinking alcohol does not protect you from COVID-19 infection."
                                + "\n\n" +
                                "Alcohol should always be consumed in moderation, and people who do not drink alcohol should not start drinking in an attempt to prevent COVID-19 infection.",
                        "না, অ্যালকোহল(মদ) পান করলে কোভিড-১৯ থেকে সুরক্ষা পাওয়া যায় না।",
                        false,
                        false)
        )));

        Topic topic14 = new Topic();
        topic14.setId("SL-14");
        topic14.setTitle_En("Can spraying alcohol or chlorine all over your body kill the coronavirus?");
        topic14.setTitle_Bn("সারা গায়ে অ্যালকোহল বা ক্লোরিন ছিটিয়ে কি করোনাভাইরাস মেরে ফেলা সম্ভব?");
        topic14.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "No, Spraying alcohol or chlorine all over your body will not kill viruses that have already entered your body."
                                + "\n\n" +
                                "Spraying such substances can be harmful to clothes or mucous membranes (i.e. eye, mouth). Be aware that both alcohol and chlorine can be useful to disinfect surfaces, but they need to be used under appropriate recommendations.",
                        "না, করোনাভাইরাস শরীরে প্রবেশ করলে অ্যালকোহল বা ক্লোরিন ছিটিয়ে তা মেরে ফেলা সম্ভব নয়।"
                                + "\n\n" +
                                "এই সকল পদার্থ ব্যবহার চোখ-মুখের জন্য ক্ষতিকর। যথোপযুক্ত নির্দেশনা ছাড়া এসব পদার্থ ব্যবহার করা উচিত নয়।",
                        false,
                        false)
        )));

        Topic topic15 = new Topic();
        topic15.setId("SL-15");
        topic15.setTitle_En("Is there risk of being infected with the new coronavirus by touching coins, banknotes or credit cards and other objects?");
        topic15.setTitle_Bn("ব্যাংকনোট, টাকা/পয়সা বা ক্রেডিট কার্ডের মাধ্যমে কি করোনাভাইরাস ছড়াতে পারে?");
        topic15.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "With proper hand cleaning, the risk of being infected with the new coronavirus by touching objects, including coins, banknotes is reduced."
                                + "\n\n" +
                                "Best protection is to clean your hands frequently with alcohol-based hand rub or wash them with soap and water. An object may be contaminated with the new coronavirus by an infected person coughing or sneezing or touching the object. Preliminary information suggests the new coronavirus can survive on surfaces for a few hours or more.",
                        "ভালভাবে হাত ধুলে টাকা-পয়সার মাধ্যমে নভেল করোনাভাইরাস ছড়ানোর ঝুঁকি কম।"
                                + "\n\n" +
                                "নিজের সুরক্ষার জন্য দুইহাত বারে বারে সাবান-পানি দিয়ে বা হ্যান্ড স্যানিটাইজার দিয়ে পরিষ্কার করুন। তবে, করোনাভাইরাস দ্বারা আক্রান্ত ব্যক্তির স্পর্শে জিনিসপত্র দূষিত হতে পারে। সমীক্ষণে দেখা গেছে, নভেল করোনাভাইরাস যে কোন জিনিসের উপর বেশ কয়েকঘণ্টা জীবিত থাকতে পারে।",
                        false,
                        false)
        )));

        Topic topic16 = new Topic();
        topic16.setId("SL-16");
        topic16.setTitle_En("Does the new coronavirus affect older people, or are younger people also susceptible?");
        topic16.setTitle_Bn("শুধু কি বয়স্করাই আক্রান্ত হবে, নাকি তরুণরাও ঝুঁকিতে?");
        topic16.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "People of all ages can be infected by the new coronavirus."
                                + "\n\n" +
                                "Older people, and people with pre-existing medical conditions (such as asthma, diabetes, heart disease) appear to be vulnerable to becoming severely ill with the virus.",
                        "যেকোনো বয়সের ব্যক্তি নভেল করোনাভাইরাস দ্বারা আক্রান্ত হতে পারেন।"
                                + "\n\n" +
                                "বয়স্ক এবং যাদের আগে থেকে কোন অসুস্থতা আছে (যেমন- এজমা, ডায়াবেটিস, হূদরোগ), এমন ব্যক্তির গুরুতর অসুস্থ হওয়ার ঝুঁকি বেশি।",
                        false,
                        false)
        )));

        Topic topic17 = new Topic();
        topic17.setId("SL-17");
        topic17.setTitle_En("Are antibiotics effective in preventing and treating the new coronavirus?");
        topic17.setTitle_Bn("অ্যান্টিবায়োটিক কি নভেল করোনাভাইরাসের চিকিৎসা বা প্রতিরোধে কার্যকরী?");
        topic17.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "No, Antibiotics do not work against viruses, only against bacteria."
                                + "\n\n" +
                                "The new coronavirus is a virus and therefore antibiotics should not be used as a means of prevention or treatment. However, if you are hospitalized for the COVID-19, you may receive antibiotics since bacterial co-infection is possible.",
                        "না, অ্যান্টিবায়োটিক ভাইরাসের বিরুদ্ধে নয়, ব্যাকটেরিয়ার বিরুদ্ধে কার্যকরী।"
                                + "\n\n" +
                                "নভেল করোনাভাইরাস এক ধরনের ভাইরাস বিদায় এর চিকিৎসা ও প্রতিরোধে অ্যান্টিবায়োটিক ব্যবহার করা উচিত নয়। তবে কেউ যদি করোনাভাইরাসে আক্রান্ত হয়ে হাসপাতালে ভর্তি হন, তিনি ব্যাকটেরিয়ার দ্বারা সহ-সংক্রমণের জন্য অ্যান্টিবায়োটিক পেতে পারেন।",
                        false,
                        false)
        )));

        Topic topic18 = new Topic();
        topic18.setId("SL-18");
        topic18.setTitle_En("Are there any specific medicines to prevent or treat the new coronavirus?");
        topic18.setTitle_Bn("নভেল করোনাভাইরাসের চিকিৎসা বা প্রতিরোধে কার্যকরী কোন ওষুধ আছে কি?");
        topic18.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "To date there is no specific medicine recommended to prevent or treat the new coronavirus."
                                + "\n\n" +
                                "However, those infected with the virus should receive appropriate care to relieve and treat symptoms, and those with severe illness should receive optimized supportive care. Some specific treatments are under investigation, and will be tested through clinical trials. WHO is helping to accelerate research and development efforts with a range of partners.",
                        "না, এখনো পর্যন্ত নভেল করোনাভাইরাসের চিকিৎসা বা প্রতিরোধে কার্যকরী কোন ওষুধ নেই।"
                                + "\n\n" +
                                "কিন্তু আক্রান্ত ব্যক্তিদের উপসর্গ উপশমের জন্য উপযুক্ত চিকিৎসা এবং গুরুতর অসুস্থদের জন্য পর্যাপ্ত স্বাস্থ্য সেবা দিতে হবে।\nসুনির্দিষ্ট চিকিৎসা ব্যবস্থা পরীক্ষাধীন, যা ক্লিনিক্যাল ট্রায়ালের মাধ্যমে সম্পন্ন হবে। বিশ্ব স্বাস্থ্য সংস্থা ও তার সহযোগী প্রতিষ্ঠানসমূহ এই সংক্রান্ত গবেষণা ত্বরান্বিত করার জন্য সহযোগিতা করছে।",
                        false,
                        false)
        )));

        Topic topic19 = new Topic();
        topic19.setId("SL-19");
        topic19.setTitle_En("Do vaccines against pneumonia protect you against the new coronavirus?");
        topic19.setTitle_Bn("করোনাভাইরাস প্রতিরোধে নিউমোনিয়া ভ্যাকসিনের কোন ভূমিকা আছে?");
        topic19.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "No, Vaccines against pneumonia, such as Pneumococcal vaccine and Haemophilus influenza type B (Hib) vaccine, do not provide protection against the new coronavirus."
                                + "\n\n" +
                                "The virus is new and different and it needs its own vaccine. Researchers are trying to develop a vaccine against the new coronavirus and WHO is supporting the efforts.",
                        "না, করোনাভাইরাস জনিত রোগে নিউমোনিয়া ভ্যাকসিনের কোন ভূমিকা নেই।"
                                + "\n\n" +
                                "করোনাভাইরাস সম্পূর্ণ নতুন হাওয়ায় এর জন্য আলাদা ভ্যাকসিন এর প্রয়োজন হবে। বর্তমানে বিশ্ব স্বাস্থ্য সংস্থার সহায়তায় গবেষকরা এই ভ্যাকসিন উদ্ভাবনের কাজ চালাচ্ছে।",
                        false,
                        false)
        )));

        Topic topic20 = new Topic();
        topic20.setId("SL-20");
        topic20.setTitle_En("Can regularly rinsing your nose with saline help prevent infection with new coronavirus?");
        topic20.setTitle_Bn("স্যালাইন দিয়ে নিয়মিত নাক পরিষ্কার করে কি করোনাভাইরাস সংক্রমণ প্রতিরোধ সম্ভব?");
        topic20.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "No, There is no evidence that regularly rinsing the nose with saline has protected people from infection with the new coronavirus."
                                + "\n\n" +
                                "There is some limited evidence that regularly rinsing the nose with saline can help people recover more quickly from common cold. However, regularly rinsing the nose has not been shown to prevent respiratory infections.",
                        "না স্যালাইন দিয়ে নিয়মিত নাক পরিষ্কার করলে করোনাভাইরাস সংক্রমণ প্রতিরোধ সম্ভব এমন কোন নিশ্চিত প্রমাণ পাওয়া যায়নি।"
                                + "\n\n" +
                                "দেখা গেছে, স্যালাইন দিয়ে নিয়মিত নাক পরিষ্কার করলে সাধারন ঠান্ডা থেকে দ্রুত উপশম হয়। কিন্তু এর ফলে শ্বাসতন্ত্রের সংক্রমণ প্রতিরোধ হয় তা জানা যায়নি।",
                        false,
                        false)
        )));

        Topic topic21 = new Topic();
        topic21.setId("SL-21");
        topic21.setTitle_En("If drinking water alleviates a sore throat, does this also protect against COVID-19 infection?");
        topic21.setTitle_Bn("পর্যাপ্ত পানি পান করলে কি কোভিড-১৯ থেকে সুরক্ষা পাওয়া যাবে?");
        topic21.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "While staying hydrated by drinking water is important for overall health, it dose not prevent coronavirus infection.\n\nIf you have fever, cough and difficulty breathing, seek medical care early and share previous travel history with your health care provider. If possible, call ahead so your health care provider can prepare for your visit.",
                        "পর্যাপ্ত পানি পান করা শরীরের জন্য উপকারী কিন্তু তা কোভিড-১৯ সংক্রমণ থেকে সুরক্ষা দেয় না।"
                                + "\n\n" +
                                "যদি জ্বর, কাশি ও শ্বাসকষ্ট হয়, দ্রুত স্বাস্থ্য সেবা গ্রহণ করতে হবে এবং স্বাস্থ্যকর্মীকে পূর্ববর্তী ভ্রমণের ইতিহাস জানাতে হবে। স্বাস্থ্যকেন্দ্রে যাওয়ার আগেই জানিয়ে যেতে হবে।",
                        false,
                        false)
        )));

        Topic topic22 = new Topic();
        topic22.setId("SL-22");
        topic22.setTitle_En("What type of disinfectant can I use to wipe slide_up surfaces to protect against COVID-19?");
        topic22.setTitle_Bn("কোভিড-১৯ প্রতিরোধে কী ধরনের জীবাণুনাশক ব্যবহার করবো?");
        topic22.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "If a surface is dirty, first wipe it slide_up with regular household soap or detergent and rinse with water. Then use a regular household disinfectant like bleach – its active ingredient (Sodium hypochlorite) kills bacteria, fungi and viruses."
                                + "\n\n" +
                                "Always protect your hand when using bleach (e.g. wear rubber gloves). Dilute bleach with water according to directions on the package.",
                        "যদি কোন কিছুর উপরিভাগ ময়লা থাকে সাধারণ সাবান ও পানি দিয়ে তা পরিষ্কার করা যাবে। এর উপাদান সমূহ (সোডিয়াম হাইপোক্লোরাইড) ব্যাকটেরিয়া, ফাঙ্গাস এবং ভাইরাস দমনে সাহায্য করে।"
                                + "\n\n" +
                                "সাবান বা ক্ষার ব্যবহারের সময় নিজের হাত সুরক্ষিত রাখতে হবে। প্যাকেটের গায়ে নির্দেশনা মেনে তা ব্যবহার করতে হবে।",
                        false,
                        false)
        )));

        Topic topic23 = new Topic();
        topic23.setId("SL-23");
        topic23.setTitle_En("What should I do if shops are sold out of hand sanitizer?");
        topic23.setTitle_Bn("দোকানে হ্যান্ড স্যানিটাইজার শেষ হয়ে গেলে কি করবো?");
        topic23.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "That’s okay. Washing hands using regular soap and water is also effective against COVID-19."
                                + "\n\n" +
                                "Remember to wash between fingers, the backs of your hands and around your nails.",
                        "সাধারণ সাবান দিয়ে হাত ধুলেও কোভিড-১৯ থেকে সুরক্ষা সম্ভব।"
                                + "\n\n" +
                                "মনে রাখতে হবে আঙুলের ভাজে, সামনে ও নখের চারপাশ ভালভাবে পরিষ্কার করা জরুরি।",
                        false,
                        false)
        )));

        Topic topic24 = new Topic();
        topic24.setId("SL-24");
        topic24.setTitle_En("How do I ensure cloths and bedlinen don’t spread novel coronavirus?");
        topic24.setTitle_Bn("কিভাবে নিশ্চিত হবো যে, কাপড় ও বিছানার চাদর দিয়ে কোভিড-১৯ ছড়ায় না?");
        topic24.setDetails(new ArrayList<>(Arrays.asList(
                new TopicDetails("D-1",
                        "null",
                        "Don’t carry dirty linen or cloths against your body. Wash them in hot water (between 60-90C) with laundry detergent or soap."
                                + "\n\n" +
                                "If available, add bleach. Follow the directions on the package. Machine dry on a high temperature or dry in direct sunlight.",
                        "অপরিষ্কার কাপড় পরিধান করা উচিত না। গরম পানি, ডিটারজেন্ট বা সাবান দিয়ে ধুয়ে তা পরিধান করা উচিত।"
                                + "\n\n" +
                                "সম্ভব হলে প্যাকেটের গায়ে নির্দেশিকামত ক্ষার ব্যবহার করা উচিত, সূর্যের তাপে, মেশিন দিয়ে শুকিয়ে পরিধান করা উচিত।",
                        false,
                        false)
        )));

        ArrayList<Topic> topics = new ArrayList<>(Arrays.asList(
                topic1, topic2, topic4, topic5, topic6, topic7, topic8, topic9, topic10, topic11, topic12,
                topic13, topic14, topic15, topic16, topic17, topic18, topic19, topic20, topic21, topic22, topic23, topic24
        ));

        topicHost.setTopics(topics);

        return topicHost;
    }
}
