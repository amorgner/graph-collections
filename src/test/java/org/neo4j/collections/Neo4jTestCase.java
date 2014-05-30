/**
 * Copyright (c) 2002-2013 "Neo Technology," Network Engine for Objects in Lund
 * AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.collections;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestCase;
import org.neo4j.collections.graphdb.DatabaseService;
import org.neo4j.collections.graphdb.impl.EmbeddedGraphDatabase;
import org.neo4j.graphdb.Transaction;

public abstract class Neo4jTestCase extends TestCase {

	private static File basePath = new File("target/var");
	private static File dbPath = new File(basePath, "neo4j-db");
	private static DatabaseService graphDb;
	private Transaction tx;

	public void setUp() {
		deleteFileOrDirectory(dbPath);
		graphDb = new EmbeddedGraphDatabase(dbPath.getAbsolutePath());
		tx = graphDb.beginTx();
	}

	public void tearDown() {
		if (!manageMyOwnTxFinish()) {
			finishTx(true);
		}
		graphDb.shutdown();
	}

	protected boolean manageMyOwnTxFinish() {
		return false;
	}

	protected void finishTx(boolean commit) {
		if (tx == null) {
			return;
		}

		if (commit) {
			tx.success();
		}
		tx.close();
		tx = null;
	}

	protected Transaction beginTx() {
		if (tx == null) {
			tx = graphDb.beginTx();
		}
		return tx;
	}

	protected File getBasePath() {
		return basePath;
	}

	protected File getDbPath() {
		return dbPath;
	}

	public static void deleteFileOrDirectory(File file) {
		if (file.exists()) {
			if (file.isDirectory()) {
				for (File child : file.listFiles()) {
					deleteFileOrDirectory(child);
				}
			}
			file.delete();
		}
	}

	protected void restartTx() {
		restartTx(true);
	}

	protected void restartTx(boolean success) {
		if (success) {
			tx.success();
		} else {
			tx.failure();
		}
		tx.close();
		tx = graphDb.beginTx();
	}

	protected static org.neo4j.graphdb.GraphDatabaseService graphDb() {
		return graphDb.getGraphDatabaseService();
	}

	protected static DatabaseService graphDbExt() {
		return graphDb;
	}

	public static <T> void assertCollection(Collection<T> collection,
		T... expectedItems) {
		String collectionString = join(", ", collection.toArray());
		assertEquals(collectionString, expectedItems.length,
			collection.size());
		for (T item : expectedItems) {
			assertTrue(collection.contains(item));
		}
	}

	public static <T> void assertCollection(Iterable<T> items, T... expectedItems) {
		assertCollection(asCollection(items), expectedItems);
	}

	public static <T> Collection<T> asCollection(Iterable<T> iterable) {
		List<T> list = new ArrayList<T>();
		for (T item : iterable) {
			list.add(item);
		}
		return list;
	}

	public static <T> String join(String delimiter, T... items) {
		StringBuffer buffer = new StringBuffer();
		for (T item : items) {
			if (buffer.length() > 0) {
				buffer.append(delimiter);
			}
			buffer.append(item.toString());
		}
		return buffer.toString();
	}

	protected <T> int countIterable(Iterable<T> iterable) {
		int counter = 0;
		Iterator<T> itr = iterable.iterator();
		while (itr.hasNext()) {
			itr.next();
			counter++;
		}
		return counter;
	}
}
