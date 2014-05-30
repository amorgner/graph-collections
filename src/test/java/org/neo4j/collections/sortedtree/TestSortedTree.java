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
package org.neo4j.collections.sortedtree;

import org.junit.Test;
import org.neo4j.collections.Neo4jTestCase;
import org.neo4j.graphdb.Node;

public class TestSortedTree extends Neo4jTestCase {

	private SortedTree longTree;
	private SortedTree stringTree;

	class IdComparator implements java.util.Comparator<Node> {

		@Override
		public int compare(Node n1, Node n2) {
			long l1 = n1.getId();
			long l2 = n2.getId();
			if (l1 == l2) {
				return 0;
			} else if (l1 < l2) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	class NameComparator implements java.util.Comparator<Node> {

		@Override
		public int compare(Node n1, Node n2) {
			String s1 = (String) n1.getProperty("name");
			String s2 = (String) n2.getProperty("name");
			return s1.compareTo(s2);
		}
	}

	@Override
	public void setUp() {
		super.setUp();
		longTree = new SortedTree(graphDb(), new IdComparator(), true, "Unique long test");
		stringTree = new SortedTree(graphDb(), new NameComparator(), false, "Non unique string test");
	}

	@Override
	public void tearDown() {
		longTree.delete();
		stringTree.delete();
		super.tearDown();
	}

	@Test
	public void testSortedTree() {
		Node node1 = graphDb().createNode();
		node1.setProperty("name", "nodehsakjgh1");
		Node node2 = graphDb().createNode();
		node2.setProperty("name", "nodeweiutyp2");
		Node node3 = graphDb().createNode();
		node3.setProperty("name", "nodehsdpfgh3");
		Node node4 = graphDb().createNode();
		node4.setProperty("name", "nodedkfkjgh4");
		Node node5 = graphDb().createNode();
		node5.setProperty("name", "nodeaaaaa5");
		Node node6 = graphDb().createNode();
		node6.setProperty("name", "nodepayghaj6");
		Node node7 = graphDb().createNode();
		node7.setProperty("name", "nodeaupghkj7");
		Node node8 = graphDb().createNode();
		node8.setProperty("name", "nodespfiugy8");
		Node node9 = graphDb().createNode();
		node9.setProperty("name", "nodespfgiuy9");
		Node node10 = graphDb().createNode();
		node10.setProperty("name", "nodesdfgiou10");
		Node node11 = graphDb().createNode();
		node11.setProperty("name", "nodezzzzzzz11");
		Node node12 = graphDb().createNode();
		node12.setProperty("name", "nodefgiuios12");
		Node node13 = graphDb().createNode();
		node13.setProperty("name", "nodespdfiuo13");
		Node node14 = graphDb().createNode();
		node14.setProperty("name", "nodesgdfiogu14");
		Node node15 = graphDb().createNode();
		node15.setProperty("name", "nodedfkgsdff15");
		Node node16 = graphDb().createNode();
		node16.setProperty("name", "nodesgupiohnd16");
		Node node17 = graphDb().createNode();
		node17.setProperty("name", "nodedgfipoufd17");
		Node node18 = graphDb().createNode();
		node18.setProperty("name", "nodegapiugffs18");
		Node node19 = graphDb().createNode();
		node19.setProperty("name", "nodeapgyadgaf19");
		Node node20 = graphDb().createNode();
		node20.setProperty("name", "nodepsuiyhfps20");
		Node node21 = graphDb().createNode();
		node21.setProperty("name", "nodespdfuigyg21");
		Node node22 = graphDb().createNode();
		node22.setProperty("name", "nodeypiusdfygi22");
		Node node23 = graphDb().createNode();
		node23.setProperty("name", "nodejuroerhgio23");
		Node node24 = graphDb().createNode();
		node24.setProperty("name", "nodefihitbhhiu24");
		Node node25 = graphDb().createNode();
		node25.setProperty("name", "nodeisdshdfijgh25");
		Node node26 = graphDb().createNode();
		node26.setProperty("name", "nodesdufgypiuhsg26");
		Node node27 = graphDb().createNode();
		node27.setProperty("name", "nodesdiuhyughds27");
		Node node28 = graphDb().createNode();
		node28.setProperty("name", "nodehspdfpghsdf28");
		Node node29 = graphDb().createNode();
		node29.setProperty("name", "nodesdfhgfdioh29");
		Node node30 = graphDb().createNode();
		node30.setProperty("name", "nodesodfgiosdfg30");
		Node node31 = graphDb().createNode();
		node31.setProperty("name", "nodejsdhfghiohet31");
		Node node32 = graphDb().createNode();
		node32.setProperty("name", "nodesdgjisdfgsdf32");
		Node node33 = graphDb().createNode();
		node33.setProperty("name", "nodesfgphnhiotre33");
		Node node34 = graphDb().createNode();
		node34.setProperty("name", "nodehwpiothgergt34");
		Node node35 = graphDb().createNode();
		node35.setProperty("name", "nodehipsdfhgier35");
		Node node36 = graphDb().createNode();
		node36.setProperty("name", "nodehwiehrgweg36");
		Node node37 = graphDb().createNode();
		node37.setProperty("name", "nodehwegbnsdkjfgn37");
		Node node38 = graphDb().createNode();
		node38.setProperty("name", "nodesdhfgpsdhnfgo38");
		Node node39 = graphDb().createNode();
		node39.setProperty("name", "nodegsdhfgiojsdfg39");

		assertTrue(!longTree.iterator().hasNext());

		longTree.addNode(node1);
		longTree.addNode(node2);
		longTree.addNode(node3);
		longTree.addNode(node4);
		longTree.addNode(node5);
		longTree.addNode(node6);
		longTree.addNode(node7);
		longTree.addNode(node8);
		longTree.addNode(node9);
		longTree.addNode(node10);
		longTree.addNode(node11);
		longTree.addNode(node12);
		longTree.addNode(node13);
		longTree.addNode(node14);
		longTree.addNode(node15);
		longTree.addNode(node16);
		longTree.addNode(node17);
		longTree.addNode(node18);
		longTree.addNode(node19);
		longTree.addNode(node20);
		longTree.addNode(node21);
		longTree.addNode(node22);
		longTree.addNode(node23);
		longTree.addNode(node24);
		longTree.addNode(node25);
		longTree.addNode(node26);
		longTree.addNode(node27);
		longTree.addNode(node28);
		longTree.addNode(node29);
		longTree.addNode(node30);
		longTree.addNode(node31);
		longTree.addNode(node32);
		longTree.addNode(node33);
		longTree.addNode(node34);
		longTree.addNode(node35);
		longTree.addNode(node36);
		longTree.addNode(node37);
		longTree.addNode(node38);
		longTree.addNode(node39);

		assertTrue(longTree.iterator().hasNext());
		int count = 0;
		for (Node n : longTree) {
			count++;
		}
		assertTrue(count == 39);

		assertTrue(!stringTree.iterator().hasNext());

		stringTree.addNode(node1);
		stringTree.addNode(node2);
		stringTree.addNode(node3);
		stringTree.addNode(node4);
		stringTree.addNode(node5);
		stringTree.addNode(node6);
		stringTree.addNode(node7);
		stringTree.addNode(node8);
		stringTree.addNode(node9);
		stringTree.addNode(node10);
		stringTree.addNode(node11);
		stringTree.addNode(node12);
		stringTree.addNode(node13);
		stringTree.addNode(node14);
		stringTree.addNode(node15);
		stringTree.addNode(node16);
		stringTree.addNode(node17);
		stringTree.addNode(node18);
		stringTree.addNode(node19);
		stringTree.addNode(node20);
		stringTree.addNode(node21);
		stringTree.addNode(node22);
		stringTree.addNode(node23);
		stringTree.addNode(node24);
		stringTree.addNode(node25);
		stringTree.addNode(node26);
		stringTree.addNode(node27);
		stringTree.addNode(node28);
		stringTree.addNode(node29);
		stringTree.addNode(node30);
		stringTree.addNode(node31);
		stringTree.addNode(node32);
		stringTree.addNode(node33);
		stringTree.addNode(node34);
		stringTree.addNode(node35);
		stringTree.addNode(node36);
		stringTree.addNode(node37);
		stringTree.addNode(node38);
		stringTree.addNode(node39);

		assertTrue(stringTree.iterator().hasNext());
		assertEquals(39, count(stringTree));
		count = 0;
		for (Node n : stringTree) {
			count++;
			if (count == 1) {
				assertEquals("nodeaaaaa5", n.getProperty("name"));
			}
			if (count == 39) {
				assertEquals("nodezzzzzzz11", n.getProperty("name"));
			}

		}
		assertTrue(stringTree.containsNode(node2));
		stringTree.remove(node2);
		assertEquals(38, count(stringTree));
		assertTrue(!stringTree.containsNode(node2));
		stringTree.remove(node4);
		assertEquals(37, count(stringTree));
		stringTree.remove(node6);
		assertEquals(36, count(stringTree));
		stringTree.remove(node8);
		assertEquals(35, count(stringTree));
		stringTree.remove(node10);
		assertEquals(34, count(stringTree));
		stringTree.remove(node12);
		assertEquals(33, count(stringTree));
		stringTree.remove(node14);
		assertEquals(32, count(stringTree));
		stringTree.remove(node16);
		assertEquals(31, count(stringTree));
		stringTree.remove(node18);
		assertEquals(30, count(stringTree));
		stringTree.remove(node20);
		assertEquals(29, count(stringTree));
		stringTree.remove(node22);
		assertEquals(28, count(stringTree));
		stringTree.remove(node24);
		assertEquals(27, count(stringTree));
		stringTree.remove(node26);
		assertEquals(26, count(stringTree));
		stringTree.remove(node28);
		assertEquals(25, count(stringTree));
		stringTree.remove(node30);
		assertEquals(24, count(stringTree));
		stringTree.remove(node32);
		assertEquals(23, count(stringTree));
		stringTree.remove(node34);
		assertEquals(22, count(stringTree));
		stringTree.remove(node36);
		assertEquals(21, count(stringTree));
		stringTree.remove(node38);
		assertEquals(20, count(stringTree));

		stringTree.remove(node1);
		stringTree.remove(node3);
		stringTree.remove(node5);
		stringTree.remove(node7);
		stringTree.remove(node9);
		stringTree.remove(node11);
		stringTree.remove(node13);
		stringTree.remove(node15);
		stringTree.remove(node17);
		stringTree.remove(node19);
		stringTree.remove(node21);
		stringTree.remove(node23);
		stringTree.remove(node25);
		stringTree.remove(node27);
		stringTree.remove(node29);
		stringTree.remove(node31);
		stringTree.remove(node33);
		stringTree.remove(node35);
		stringTree.remove(node37);
		stringTree.remove(node39);
		assertEquals(0, count(stringTree));
	}

	private int count(final SortedTree tree) {
		int count = 0;
		for (Node n : tree) {
			System.out.println(n.getId() + " " + n.getProperty("name"));
			count++;
		}
		System.out.println();
		return count;
	}
}
