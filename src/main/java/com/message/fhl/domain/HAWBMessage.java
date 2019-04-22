package com.message.fhl.domain;

import java.io.Serializable;

public class HAWBMessage implements Serializable {

    private String id;
    private String mawbNo;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMawbNo() {
        return mawbNo;
    }

    public void setMawbNo(String mawbNo) {
        this.mawbNo = mawbNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HAWBMessage that = (HAWBMessage) o;

        if (!id.equals(that.id)) return false;
        if (!mawbNo.equals(that.mawbNo)) return false;
        return content.equals(that.content);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + mawbNo.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }
}