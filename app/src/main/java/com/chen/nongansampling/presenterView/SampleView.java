package com.chen.nongansampling.presenterView;

public interface SampleView   {
    void getMarketList(Object resultData);
    void getOperatorList(Object resultData);

    void getSamplingName(Object resultData);

    void getDeTypeAndName(Object resultData);


    void getInsertSamplingResponseInfo(Object resultData);


    void onError(String result);

}
