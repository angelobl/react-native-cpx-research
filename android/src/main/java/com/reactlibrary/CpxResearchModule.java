package com.cpxresearch;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import com.cpx_research.CPXResearch;
import com.cpx_research.models.CPXSettings;
import com.cpx_research.models.CPXSettingsBuilder;

public class CpxResearchModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    private CPXResearch cpxResearch;

    public CpxResearchModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "CpxResearch";
    }

    @ReactMethod
    public void init(String appId, String userId) {
        CPXSettings cpxSettings = new CPXSettingsBuilder(appId, userId)
               /* CUSTOMIZATION */
               .build();

       cpxResearch = CPXResearch.Companion.init(getCurrentActivity(), cpxSettings);
    }

    @ReactMethod
    public void openSurveyWall() {
        cpxResearch.openSurveyWall();
    }
    

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
