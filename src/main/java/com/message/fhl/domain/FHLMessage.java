package com.message.fhl.domain;

import java.io.Serializable;
import java.util.List;

public class FHLMessage implements Serializable {
    private String mawbNo;
    private List<HAWBMessage> hawbs;

    public String getMawbNo() {
        return mawbNo;
    }

    public void setMawbNo(String mawbNo) {
        this.mawbNo = mawbNo;
    }

    public List<HAWBMessage> getHawbs() {
        return hawbs;
    }

    public void setHawbs(List<HAWBMessage> hawbs) {
        this.hawbs = hawbs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FHLMessage that = (FHLMessage) o;

        if (!mawbNo.equals(that.mawbNo)) return false;
        return hawbs.equals(that.hawbs);

    }

    @Override
    public int hashCode() {
        int result = mawbNo.hashCode();
        result = 31 * result + hawbs.hashCode();
        return result;
    }
}
