package com.example.nicha.finalproject;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.os.Vibrator;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.example.nicha.finalproject.Model.Tracking;
import com.example.nicha.finalproject.Service.Database;
import com.example.nicha.finalproject.Service.TrackingProcess;
import com.example.nicha.finalproject.Service.TrackingService;
import com.example.nicha.finalproject.activity.MainActivity;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.awareness.Awareness;
import com.google.android.gms.awareness.fence.AwarenessFence;
import com.google.android.gms.awareness.fence.DetectedActivityFence;
import com.google.android.gms.awareness.fence.FenceState;
import com.google.android.gms.awareness.fence.FenceUpdateRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;

import static com.example.nicha.finalproject.R.id.tvBike;
import static com.example.nicha.finalproject.R.id.tvWalk;

public class TrackingActivity extends AppCompatActivity {
    private GoogleApiClient mGoogleApiClient;
    private static final String TAG = "Awareness";
    private final String FENCE_RECEIVER_ACTION = "FENCE_RECEIVER_ACTION";
    private FenceReceiver mFenceReceiver;
    private PendingIntent mFencePendingIntent;
    SQLiteDatabase mDb;
    TrackingService voTracking;
    Database mHelper;
    TextView tvStill;
    TextView tvWalk;
    TextView tvRun;
    TextView tvBike;
    TextView tvDrive;
    Tracking track;
    long startTime = 0;
    long walkingTime = 0;
    long runningTime = 0;
    long drivingTime = 0;
    long bikingTime = 0;
    long stillTime = 0;
    long walkingMillis = 0;
    long runningMillis = 0;
    long drivingMillis = 0;
    long bikingMillis = 0;
    long stillMillis = 0;
    long timeBuffer = 0;
    Handler handlerwalkingMillis = new Handler();
    Handler handlerrunningMillis = new Handler();
    Handler handlerdrivingMillis = new Handler();
    Handler handlerbikingMillis = new Handler();
    Handler handlerstillMillis = new Handler();
    Runnable runwalkingMillis = new Runnable() {

        @Override
        public void run() {
            // We use mills to calculate the time by below equation then we get time
            //Also, keep mills to be data of activity's time

            walkingMillis = (System.currentTimeMillis() - startTime);
            int seconds = (int) (walkingMillis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            tvWalk.setText(String.format("%d:%02d", minutes, seconds));
            handlerwalkingMillis.postDelayed(this, 500);
        }
    };

    Runnable runrunningMillis = new Runnable() {

        @Override
        public void run() {
            // We use mills to calculate the time by below equation then we get time
            //Also, keep mills to be data of activity's time

            runningMillis = (System.currentTimeMillis() - startTime);
            int seconds = (int) (runningMillis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            tvRun.setText(String.format("%d:%02d", minutes, seconds));
            handlerrunningMillis.postDelayed(this, 500);
        }
    };
    Runnable rundrivingMillis = new Runnable() {

        @Override
        public void run() {
            // We use mills to calculate the time by below equation then we get time
            //Also, keep mills to be data of activity's time

            drivingMillis = (System.currentTimeMillis() - startTime);
            int seconds = (int) (drivingMillis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            tvDrive.setText(String.format("%d:%02d", minutes, seconds));
            handlerdrivingMillis.postDelayed(this, 500);
        }
    };
    Runnable runbikingMillis = new Runnable() {

        @Override
        public void run() {
            // We use mills to calculate the time by below equation then we get time
            //Also, keep mills to be data of activity's time

            bikingMillis = (System.currentTimeMillis() - startTime);
            int seconds = (int) (bikingMillis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            tvBike.setText(String.format("%d:%02d", minutes, seconds));
            handlerbikingMillis.postDelayed(this, 500);
        }
    };
    Runnable runstillMillis = new Runnable() {

        @Override
        public void run() {
            // We use mills to calculate the time by below equation then we get time
            //Also, keep mills to be data of activity's time

            stillMillis = (System.currentTimeMillis() - startTime);
            int seconds = (int) (stillMillis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;
            tvStill.setText(String.format("%d:%02d", minutes, seconds));
            handlerstillMillis.postDelayed(this, 500);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        mHelper = new Database(this);
        tvStill = (TextView) findViewById(R.id.tvStill);
        tvWalk = (TextView) findViewById(R.id.tvWalk);
        tvRun = (TextView) findViewById(R.id.tvRun);
        tvBike = (TextView) findViewById(R.id.tvBike);
        tvDrive = (TextView) findViewById(R.id.tvDrive);
        voTracking = new TrackingService(this);

        track = voTracking.getTrack();
        stillTime = Long.parseLong(track.getStillTime());
        walkingTime = Long.parseLong(track.getWalkingTime());
        runningTime = Long.parseLong(track.getRunningTime());
        bikingTime = Long.parseLong(track.getBikingTime());
        drivingTime = Long.parseLong(track.getDrivingTime());

        tvStill.setText(timeFormat(stillTime));
        tvWalk.setText(timeFormat(walkingTime));
        tvRun.setText(timeFormat(runningTime));
        tvBike.setText(timeFormat(bikingTime));
        tvDrive.setText(timeFormat(drivingTime));
        stillMillis = stillTime;
        walkingMillis = walkingTime;
        runningMillis = runningTime;
        bikingMillis = bikingTime;
        drivingMillis = drivingTime;


        // Tracking with Awareness part
        mGoogleApiClient = new GoogleApiClient.Builder(TrackingActivity.this)
                .addApi(Awareness.API)
                .build();
        mGoogleApiClient.connect();
        mFenceReceiver = new FenceReceiver();
        Intent intent = new Intent(FENCE_RECEIVER_ACTION);
        mFencePendingIntent = PendingIntent.getBroadcast(TrackingActivity.this,
                10001,
                intent,
                0);

    }



    @Override
    protected void onStart() {
        super.onStart();
       /* if(isMyServiceRunning(TrackingProcess.class)) {
            stopService(new Intent(TrackingActivity.this, TrackingProcess.class));*/
            //getTrack();
            track = voTracking.getTrack();
            stillTime = Long.parseLong(track.getStillTime());
            walkingTime = Long.parseLong(track.getWalkingTime());
            runningTime = Long.parseLong(track.getRunningTime());
            bikingTime = Long.parseLong(track.getBikingTime());
            drivingTime = Long.parseLong(track.getDrivingTime());

            tvStill.setText(timeFormat(stillTime));
            tvWalk.setText(timeFormat(walkingTime));
            tvRun.setText(timeFormat(runningTime));
            tvBike.setText(timeFormat(bikingTime));
            tvDrive.setText(timeFormat(drivingTime));
            stillMillis = stillTime;
            walkingMillis = walkingTime;
            runningMillis = runningTime;
            bikingMillis = bikingTime;
            drivingMillis = drivingTime;
        //}

        setupFence(DetectedActivityFence.RUNNING,"Running");
        setupFence(DetectedActivityFence.ON_BICYCLE,"Biking");
        setupFence(DetectedActivityFence.IN_VEHICLE,"Driving");
        setupFence(DetectedActivityFence.STILL,"Still");
        setupFence(DetectedActivityFence.WALKING,"Walking");
        registerReceiver(mFenceReceiver, new IntentFilter(FENCE_RECEIVER_ACTION));

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("data","on stop");
        unregisterFences(DetectedActivityFence.RUNNING,"Running");
        unregisterFences(DetectedActivityFence.ON_BICYCLE,"Biking");
        unregisterFences(DetectedActivityFence.IN_VEHICLE,"Driving");
        unregisterFences(DetectedActivityFence.STILL,"Still");
        unregisterFences(DetectedActivityFence.WALKING,"Walking");
        stillTime = stillMillis;
        walkingTime = walkingMillis;
        runningTime = runningMillis;
        bikingTime = bikingMillis;
        drivingTime = drivingMillis;
        voTracking.updateStill(stillTime);
        voTracking.updateWalk(walkingTime);
        voTracking.updateRun(runningTime);
        voTracking.updateDrive(drivingTime);
        voTracking.updateBike(bikingTime);
        handlerbikingMillis.removeCallbacks(runbikingMillis);
        handlerwalkingMillis.removeCallbacks(runwalkingMillis);
        handlerrunningMillis.removeCallbacks(runrunningMillis);
        handlerdrivingMillis.removeCallbacks(rundrivingMillis);
        handlerstillMillis.removeCallbacks(runstillMillis);
        unregisterReceiver(mFenceReceiver);
       // startService(new Intent(TrackingActivity.this, TrackingProcess.class));
        //updateTrack();

    }
/*
    @Override
    protected void onPause() {
        super.onPause();
        unregisterFences(DetectedActivityFence.RUNNING,"Running");
        unregisterFences(DetectedActivityFence.ON_BICYCLE,"Biking");
        unregisterFences(DetectedActivityFence.IN_VEHICLE,"Driving");
        unregisterFences(DetectedActivityFence.STILL,"Still");
        unregisterFences(DetectedActivityFence.WALKING,"Walking");
        stillTime = stillMillis;
        walkingTime = walkingMillis;
        runningTime = runningMillis;
        bikingTime = bikingMillis;
        drivingTime = drivingMillis;
        voTracking.updateStill(stillTime);
        voTracking.updateWalk(walkingTime);
        voTracking.updateRun(runningTime);
        voTracking.updateDrive(drivingTime);
        voTracking.updateBike(bikingTime);
        handlerbikingMillis.removeCallbacks(runbikingMillis);
        handlerwalkingMillis.removeCallbacks(runwalkingMillis);
        handlerrunningMillis.removeCallbacks(runrunningMillis);
        handlerdrivingMillis.removeCallbacks(rundrivingMillis);
        handlerstillMillis.removeCallbacks(runstillMillis);
        unregisterReceiver(mFenceReceiver);
        startService(new Intent(TrackingActivity.this, TrackingProcess.class));
        //updateTrack();

    }
*/
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    private void setupFence(int detectedActivityFence, final String fenceKey) {
        // Create a fence.
        AwarenessFence fence = DetectedActivityFence.during(detectedActivityFence);
        Awareness.FenceApi.updateFences(
                mGoogleApiClient,
                new FenceUpdateRequest.Builder()
                        .addFence(fenceKey, fence, mFencePendingIntent)
                        .build())
                .setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {
                        if (status.isSuccess()) {
                            Log.i(TAG, "Fence " + fenceKey + " was successfully registered.");
                        } else {
                            Log.e(TAG, "Fence " + fenceKey + " could not be registered: " + status);
                        }
                    }
                });

    }

    private void unregisterFences(int detectedActivityFence, final String fenceKey) {
        Awareness.FenceApi.updateFences(
                mGoogleApiClient,
                new FenceUpdateRequest.Builder()
                        .removeFence(fenceKey)
                        .build()).setResultCallback(new ResultCallbacks<Status>() {
            @Override
            public void onSuccess(@NonNull Status status) {
                Log.i(TAG, "Fence " + fenceKey + " successfully removed.");
            }

            @Override
            public void onFailure(@NonNull Status status) {
                Log.i(TAG, "Fence " + fenceKey + " could NOT be removed.");
            }
        });
    }



    /**
     * A basic BroadcastReceiver to handle intents from from the Awareness API.
     */

    public class FenceReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            FenceState fenceState = FenceState.extract(intent);

            Log.d(TAG, "Fence " + fenceState.getFenceKey() + " Receiver Received");
            //Test = (TextView) findViewById(R.id.TestState);


            if(fenceState.getCurrentState() == 2) {
                Log.i(TAG, "Fence " + fenceState.getFenceKey() + " are ACTIVE.");
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v.vibrate(1000);

                if (fenceState.getFenceKey().equals("Walking")) {
                    timeBuffer = walkingTime;
                    startTime = (System.currentTimeMillis() - timeBuffer);
                    handlerwalkingMillis.postDelayed(runwalkingMillis, 0);
                } else if (fenceState.getFenceKey().equals("Running")) {
                    timeBuffer = runningTime;
                    startTime = (System.currentTimeMillis() - timeBuffer);
                    handlerrunningMillis.postDelayed(runrunningMillis, 0);
                } else if (fenceState.getFenceKey().equals("Driving")) {
                    timeBuffer = drivingTime;
                    startTime = (System.currentTimeMillis() - timeBuffer);
                    handlerdrivingMillis.postDelayed(rundrivingMillis, 0);
                } else if (fenceState.getFenceKey().equals("Still")) {
                    timeBuffer = stillMillis;

                    startTime = (System.currentTimeMillis() - timeBuffer);
                    handlerstillMillis.postDelayed(runstillMillis, 0);
                } else if (fenceState.getFenceKey().equals("Biking")) {
                    timeBuffer = bikingTime;
                    startTime = (System.currentTimeMillis() - timeBuffer);
                    handlerbikingMillis.postDelayed(runbikingMillis, 0);
                }

            }
            // set timer

            else if(fenceState.getCurrentState() == 1){
                Log.i(TAG, "Fence " + fenceState.getFenceKey() + " are NOT ACTIVE.");

                if (fenceState.getFenceKey().equals("Walking")) {
                    walkingTime = walkingMillis;
                    handlerwalkingMillis.removeCallbacks(runwalkingMillis);
                    voTracking.updateWalk(walkingTime);
                } else if (fenceState.getFenceKey().equals("Running")) {
                    runningTime = runningMillis;
                    handlerrunningMillis.removeCallbacks(runrunningMillis);
                    voTracking.updateRun(runningTime);
                } else if (fenceState.getFenceKey().equals("Driving")) {
                    drivingTime = drivingMillis;
                    handlerdrivingMillis.removeCallbacks(rundrivingMillis);
                    voTracking.updateDrive(drivingTime);
                } else if (fenceState.getFenceKey().equals("Biking")) {
                    bikingTime = bikingMillis;
                    handlerbikingMillis.removeCallbacks(runbikingMillis);
                    voTracking.updateBike(bikingTime);
                } else if (fenceState.getFenceKey().equals("Still")) {
                    stillTime = stillMillis;
                    handlerstillMillis.removeCallbacks(runstillMillis);
                    voTracking.updateStill(stillTime);
                }
            }
        }

    }

    public  String timeFormat(long time){
        int seconds = (int) (time / 1000);
        int minutes = seconds / 60;
        seconds = seconds % 60;
        return String.format("%d:%02d", minutes, seconds);
    }



}
