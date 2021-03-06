/*
 * Lumeer: Modern Data Definition and Processing Platform
 *
 * Copyright (C) since 2017 Answer Institute, s.r.o. and/or its affiliates.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.lumeer.storage.mongodb.dao.system;

import io.lumeer.api.model.UserLoginEvent;
import io.lumeer.storage.api.dao.UserLoginDao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import org.bson.Document;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author <a href="mailto:marvenec@gmail.com">Martin Večeřa</a>
 */
@ApplicationScoped
public class MongoUserLoginDao extends SystemScopedDao implements UserLoginDao {

   @PostConstruct
   public void initDb() {
      createLoginRepository();
   }

   @Override
   public void userLoggedIn(final String userId) {
      database.getCollection(COLLECTION_NAME, UserLoginEvent.class).insertOne(new UserLoginEvent(userId));
   }

   @Override
   public void createLoginRepository() {
      if (database.getCollection(COLLECTION_NAME) == null) {
         database.createCollection(COLLECTION_NAME);

         MongoCollection<Document> groupCollection = database.getCollection(COLLECTION_NAME);
         groupCollection.createIndex(Indexes.ascending(UserLoginEvent.USER_ID, UserLoginEvent.DATE), new IndexOptions().unique(true));
      }
   }
}
