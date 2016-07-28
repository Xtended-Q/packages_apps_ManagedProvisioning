/*
 * Copyright (C) 2016 The Android Open Source Project
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

package com.android.managedprovisioning.task;

import static android.provider.Settings.Secure.MANAGED_PROFILE_CONTACT_REMOTE_SEARCH;

import android.content.Context;
import android.provider.Settings;

import com.android.managedprovisioning.R;
import com.android.managedprovisioning.model.ProvisioningParams;

public class ManagedProfileSettingsTask extends AbstractProvisioningTask {

    public ManagedProfileSettingsTask(
            Context context,
            ProvisioningParams params,
            Callback callback) {
        super(context, params, callback);
    }

    @Override
    public void run(int userId) {
        // Turn on managed profile contacts remote search.
        Settings.Secure.putIntForUser(mContext.getContentResolver(),
                MANAGED_PROFILE_CONTACT_REMOTE_SEARCH,
                1, userId);
        success();
    }

    @Override
    public int getStatusMsgId() {
        return R.string.progress_finishing_touches;
    }
}
