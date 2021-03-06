// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.firebase_messaging;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class FlutterFirebaseInstanceIDService extends FirebaseInstanceIdService {

  public static final String ACTION_TOKEN = "io.flutter.plugins.firebase_messaging.TOKEN";
  public static final String EXTRA_TOKEN = "token";

  public static void broadcastToken(Context context) {
    Intent intent = new Intent(ACTION_TOKEN);
    intent.putExtra(EXTRA_TOKEN, FirebaseInstanceId.getInstance().getToken());
    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
  }

  /** Called if InstanceID token is updated. */
  @Override
  public void onTokenRefresh() {
    broadcastToken(this);
  }
}
