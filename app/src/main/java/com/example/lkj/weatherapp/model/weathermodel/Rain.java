
package com.example.lkj.weatherapp.model.weathermodel;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class Rain {

    @SerializedName("1h")
    @Expose
    private double _1h;

    /**
     * 
     * @return
     *     The _1h
     */
    public double get1h() {
        return _1h;
    }

    /**
     * 
     * @param _1h
     *     The 1h
     */
    public void set1h(double _1h) {
        this._1h = _1h;
    }

}
