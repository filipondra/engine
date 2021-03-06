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
package io.lumeer.engine.api.data;

/**
 * Carries statistics about database or collection usage.
 *
 * @author <a href="mailto:marvenec@gmail.com">Martin Večeřa</a>
 */
public class DataStorageStats {

   /**
    * Name of the database.
    */
   private String databaseName;

   /**
    * Name of the collection when applicable.
    */
   private String collectionName;

   /**
    * Number of collections in the database when applicable.
    */
   private long collections;

   /**
    * Number of documents in the database or collection.
    */
   private long documents;

   /**
    * Size of actual data in the database or collection.
    */
   private long dataSize;

   /**
    * Size allocated on the drive for the database or collection. This is equal or larger to {@link #dataSize}.
    * It includes even pre-allocated space.
    */
   private long storageSize;

   /**
    * Number of indexes in the database or collection.
    */
   private long indexes;

   /**
    * Size of space allocated to store indexes in the database or collection.
    */
   private long indexSize;

   public String getDatabaseName() {
      return databaseName;
   }

   public void setDatabaseName(final String databaseName) {
      this.databaseName = databaseName;
   }

   public String getCollectionName() {
      return collectionName;
   }

   public void setCollectionName(final String collectionName) {
      this.collectionName = collectionName;
   }

   public long getCollections() {
      return collections;
   }

   public void setCollections(final long collections) {
      this.collections = collections;
   }

   public long getDocuments() {
      return documents;
   }

   public void setDocuments(final long documents) {
      this.documents = documents;
   }

   public long getDataSize() {
      return dataSize;
   }

   public void setDataSize(final long dataSize) {
      this.dataSize = dataSize;
   }

   public long getStorageSize() {
      return storageSize;
   }

   public void setStorageSize(final long storageSize) {
      this.storageSize = storageSize;
   }

   public long getIndexes() {
      return indexes;
   }

   public void setIndexes(final long indexes) {
      this.indexes = indexes;
   }

   public long getIndexSize() {
      return indexSize;
   }

   public void setIndexSize(final long indexSize) {
      this.indexSize = indexSize;
   }

   @Override
   public String toString() {
      return "DataStorageStats{" +
            "databaseName='" + databaseName + '\'' +
            ", collectionCode='" + collectionName + '\'' +
            ", collections=" + collections +
            ", documents=" + documents +
            ", dataSize=" + dataSize +
            ", storageSize=" + storageSize +
            ", indexes=" + indexes +
            ", indexSize=" + indexSize +
            '}';
   }

   @Override
   public boolean equals(final Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }

      final DataStorageStats that = (DataStorageStats) o;

      if (collections != that.collections) {
         return false;
      }
      if (documents != that.documents) {
         return false;
      }
      if (dataSize != that.dataSize) {
         return false;
      }
      if (storageSize != that.storageSize) {
         return false;
      }
      if (indexes != that.indexes) {
         return false;
      }
      if (indexSize != that.indexSize) {
         return false;
      }
      if (databaseName != null ? !databaseName.equals(that.databaseName) : that.databaseName != null) {
         return false;
      }
      return collectionName != null ? collectionName.equals(that.collectionName) : that.collectionName == null;
   }

   @Override
   public int hashCode() {
      int result = databaseName != null ? databaseName.hashCode() : 0;
      result = 31 * result + (collectionName != null ? collectionName.hashCode() : 0);
      result = 31 * result + (int) (collections ^ (collections >>> 32));
      result = 31 * result + (int) (documents ^ (documents >>> 32));
      result = 31 * result + (int) (dataSize ^ (dataSize >>> 32));
      result = 31 * result + (int) (storageSize ^ (storageSize >>> 32));
      result = 31 * result + (int) (indexes ^ (indexes >>> 32));
      result = 31 * result + (int) (indexSize ^ (indexSize >>> 32));
      return result;
   }

}
