/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.core.data.repository

import com.google.samples.apps.nowinandroid.core.data.Syncable
import com.google.samples.apps.nowinandroid.core.model.data.Author
import kotlinx.coroutines.flow.Flow

interface AuthorsRepository : Syncable {
    /**
     * Gets the available Authors as a stream
     */
    fun getAuthorsStream(): Flow<List<Author>>

    /**
     * Sets the user's currently followed authors
     */
    suspend fun setFollowedAuthorIds(followedAuthorIds: Set<String>)

    /**
     * Toggles the user's newly followed/unfollowed author
     */
    suspend fun toggleFollowedAuthorId(followedAuthorId: String, followed: Boolean)

    /**
     * Returns the users currently followed authors
     */
    fun getFollowedAuthorIdsStream(): Flow<Set<String>>
}