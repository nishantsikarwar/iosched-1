/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.funkyandroid.droidcon.uk.iosched.io;

import com.funkyandroid.droidcon.uk.iosched.util.Lists;

import android.content.ContentProviderOperation;
import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;
import java.util.ArrayList;

import static com.funkyandroid.droidcon.uk.iosched.util.LogUtils.LOGE;
import static com.funkyandroid.droidcon.uk.iosched.util.LogUtils.LOGI;
import static com.funkyandroid.droidcon.uk.iosched.util.LogUtils.makeLogTag;

public class AnnouncementsFetcher {
    private static final String TAG = makeLogTag(AnnouncementsFetcher.class);
    private Context mContext;

    public AnnouncementsFetcher(Context context) {
        mContext = context;
    }

    public ArrayList<ContentProviderOperation> fetchAndParse() throws IOException {
        final ArrayList<ContentProviderOperation> batch = Lists.newArrayList();

        // Set up the main Google+ class
        /*
            TODO: Replace with Facebook or Twitter

        ActivityFeed activities;
        try {
            activities = plus.activities().list(Config.ANNOUNCEMENTS_PLUS_ID, "public")
                    .setMaxResults(100l)
                    .execute();
            if (activities == null || activities.getItems() == null) {
                throw new IOException("Activities list was null.");
            }

        } catch (IOException e) {
            LOGE(TAG, "Error fetching announcements", e);
            return batch;
        }

        LOGI(TAG, "Updating announcements data");

        // Clear out existing announcements
        batch.add(ContentProviderOperation
                .newDelete(ScheduleContract.addCallerIsSyncAdapterParameter(
                        Announcements.CONTENT_URI))
                .build());

        StringBuilder sb = new StringBuilder();
        for (Activity activity : activities.getItems()) {
            // Filter out anything not including the conference hashtag.
            sb.setLength(0);
            appendIfNotEmpty(sb, activity.getAnnotation());
            if (activity.getObject() != null) {
                appendIfNotEmpty(sb, activity.getObject().getContent());
            }

            if (!sb.toString().contains(UIUtils.CONFERENCE_HASHTAG)) {
                continue;
            }

            // Insert announcement info
            batch.add(ContentProviderOperation
                    .newInsert(ScheduleContract
                            .addCallerIsSyncAdapterParameter(Announcements.CONTENT_URI))
                    .withValue(SyncColumns.UPDATED, System.currentTimeMillis())
                    .withValue(Announcements.ANNOUNCEMENT_ID, activity.getId())
                    .withValue(Announcements.ANNOUNCEMENT_DATE, activity.getUpdated().getValue())
                    .withValue(Announcements.ANNOUNCEMENT_TITLE, activity.getTitle())
                    .withValue(Announcements.ANNOUNCEMENT_ACTIVITY_JSON, activity.toPrettyString())
                    .withValue(Announcements.ANNOUNCEMENT_URL, activity.getUrl())
                    .build());
        }

        return batch;
         */
        return batch;
    }

    private static void appendIfNotEmpty(StringBuilder sb, String s) {
        if (!TextUtils.isEmpty(s)) {
            sb.append(s);
        }
    }
}
