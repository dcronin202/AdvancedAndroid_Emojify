package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

// COMPLETED (1): Create a Java class called Emojifier
public class Emojifier {

    private static final String LOG_TAG = Emojifier.class.getSimpleName();

    // COMPLETED (2): Create a static method in the Emojifier class called detectFaces() which detects and logs the number of faces in a given bitmap.
    static void detectFaces(Context context, Bitmap picture) {

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(picture).build();

        SparseArray<Face> faces = detector.detect(frame);

        Log.d(LOG_TAG, "detectFaces: number of faces = " + faces.size());

        if(faces.size() == 0) {
            Toast.makeText(context, R.string.no_faces_message, Toast.LENGTH_SHORT).show();
        }

        detector.release();

    }

}
