/*
  Copyright (c) 2018-present, SurfStudio LLC, Maxim Tuev.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package ru.surfstudio.android.core.ui.delegate.activity;

import android.app.Activity;

import ru.surfstudio.android.core.ui.delegate.base.CompletelyDestroyChecker;

/**
 * проверяет что активити полностю уничтожена
 */

public class ActivityCompletelyDestroyChecker implements CompletelyDestroyChecker {
    private Activity activity;

    public ActivityCompletelyDestroyChecker(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean check() {
        return activity.isFinishing();
    }
}
