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
package io.lumeer.storage.api.dao;

import io.lumeer.api.model.Document;
import io.lumeer.api.model.Project;

import java.util.Collection;
import java.util.List;

public interface DocumentDao {

   void createDocumentsRepository(Project project);

   void deleteDocumentsRepository(Project project);

   Document createDocument(Document document);

   List<Document> createDocuments(List<Document> documents);

   Document updateDocument(String id, Document document);

   void deleteDocument(String id);

   void deleteDocuments(String collectionId);

   Document getDocumentById(String id);

   List<Document> getDocumentsByIds(String... ids);

   List<Document> getDocumentsByParentIds(Collection<String> parentIds);

   void setProject(Project project);

}
