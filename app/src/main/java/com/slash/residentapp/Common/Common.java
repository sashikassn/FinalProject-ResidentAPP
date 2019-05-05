package com.slash.residentapp.Common;

import com.slash.residentapp.Remote.FCMClient;
import com.slash.residentapp.Remote.GoogleMapApi;
import com.slash.residentapp.Remote.IFCMService;
import com.slash.residentapp.Remote.IGoogleAPI;

public class Common {
    public static final String driver_tbl = "TrashCollectors";
    public static final String user_driver_tbl = "CollectorInformation";
    public static final String user_rider_tbl = "ResidentInformation";
    public static final String pickup_request_tbl = "TrashPickupRequest";
    public static final String token_tbl = "Tokens";

    private static double base_fare = 2.55;
    private static double time_rate = 0.35;
    private static double distance_rate = 1.75;

    public static double getPrice(double km, int min){
        return (base_fare+(time_rate*min)+(distance_rate*km));
    }

    public static final String fcmURL = "https://fcm.googleapis.com/";
    public static final String GoogleAPIUrl = "https://maps.googleapis.com/";

    public static IFCMService getFCMService(){
        return FCMClient.getClient(fcmURL).create(IFCMService.class);
    }

    public static IGoogleAPI getGoogleService(){
        return GoogleMapApi.getClient(GoogleAPIUrl).create(IGoogleAPI.class);
    }
}
