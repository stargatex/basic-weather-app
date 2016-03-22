package com.example.lkj.weatherapp.view;

import com.example.lkj.weatherapp.R;

/**
 * Created by LKJ .
 */
public class WeaterIcon {
    public static int getIconString(int id, String wid){
        int newId=id/100;
        if(id==800){
            return (wid=="01d")? R.string.wi_wu_clear : R.string.wi_night_clear;

        }else{
            switch(newId){
                case 2 : return (wid=="11d")?  R.string.wi_owm_day_200 : R.string.wi_owm_night_200;
                case 3 : return (wid=="09d")?  R.string.wi_owm_day_300 : R.string.wi_owm_night_300;
                case 5 : return  R.string.wi_owm_500;
                case 6 : return (wid=="13d")?  R.string.wi_owm_day_600 : R.string.wi_owm_night_600;
                case 7 : return (wid=="50d")?  R.string.wi_owm_day_701 : R.string.wi_owm_night_701;
                case 8 : return  R.string.wi_owm_801;
                case 9 : return R.string.wi_owm_900 ;
            }

        }
        return R.string.wi_wu_unknown;
    }
}
