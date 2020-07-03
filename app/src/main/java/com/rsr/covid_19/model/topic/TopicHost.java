package com.rsr.covid_19.model.topic;

import java.io.Serializable;
import java.util.List;

public class TopicHost implements Serializable {

    private String      id;
    private String      title_En;
    private String      title_Bn;
    private List<Topic> topics;

    public TopicHost() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle_En() {
        return title_En;
    }

    public void setTitle_En(String title_En) {
        this.title_En = title_En;
    }

    public String getTitle_Bn() {
        return title_Bn;
    }

    public void setTitle_Bn(String title_Bn) {
        this.title_Bn = title_Bn;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}

