package eccrm.base.employee.domain;

import com.ycrl.base.common.CommonDomain;

/**
* Generated by liuxq on 2014-10-22.
*/

public class BlankList extends CommonDomain {
    private String titleTxt;
    private String busMatter;
    /**
     * 岗位id
     */
    private String dutyId;

    public String getTitleTxt() {
        return titleTxt;
    }

    public void setTitleTxt(String titleTxt) {
        this.titleTxt = titleTxt;
    }

    public String getBusMatter() {
        return busMatter;
    }

    public void setBusMatter(String busMatter) {
        this.busMatter = busMatter;
    }

    public String getDutyId() {
        return dutyId;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId;
    }
}
