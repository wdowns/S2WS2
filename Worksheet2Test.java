import static org.junit.Assert.*;

import org.junit.Test;

/** 
 * Tests for Worksheet 2.
 * @author William Downs
 * @version 21/01/16
 */
public class Worksheet2Test {

	@Test
	/**
	 * Ex2 
	 * Testing for the mirrored tree.
	 */
	public void ex2Test1() {
		Tree t1 = new Tree(7,new Tree(3,new Tree(1,new Tree(), new Tree()),
				new Tree(5,new Tree(), new Tree())),
				new Tree(8,new Tree(6,new Tree(),new Tree()),new Tree()));
	
		Tree expected = new Tree(7,new Tree(8,new Tree(),new Tree(6,
				new Tree(),new Tree())),new Tree(3,new Tree(5,new Tree(),
						new Tree()),new Tree(1,new Tree(),new Tree())));
		
		assertEquals(Worksheet2.mirror(t1),expected);
		
	}
	@Test
	public void ex2Test2() {
		Tree t1 = new Tree(6,new Tree(2,new Tree(1,new Tree(), new Tree()),
				new Tree(5,new Tree(), new Tree())),
				new Tree(9,new Tree(8,new Tree(),new Tree()),new Tree()));
	
		Tree expected = new Tree(6,new Tree(9,new Tree(),new Tree(8,
				new Tree(),new Tree())),new Tree(2,new Tree(5,new Tree(),
						new Tree()),new Tree(1,new Tree(),new Tree())));
		
		assertEquals(Worksheet2.mirror(t1),expected);
		
	}
	@Test
	/**
	 * Ex5
	 * Testing isSearchTree 'a' a binary search tree. Returns
	 * true if correct.
	 * test 1 - height
	 */
	
	public void ex5test1() {
		Tree rl = new Tree(8);
		Tree l = new Tree(5);
		Tree r = new Tree(9, rl, new Tree());
		Tree t = new Tree(6, l, r);
		assertEquals("Heights don't match",3,t.getHeight());
		
	}
	
	@Test
	/**
	 * Ex5 
	 * test 2 - height (single node)
	 */
	public void ex5test2() {
		Tree t = new Tree(6);
		assertEquals("Heights don't match",1,t.getHeight());
		
	}
	
	
	@Test
	/**
	 * Ex5 
	 * test 3 - height (Empty tree)
	 */
	public void ex5test3() {
		Tree t = new Tree();
		assertEquals("Heights don't match",0,t.getHeight());
		
	}
	


	@Test
	/**
	 * Ex6
	 * Testing showDescending method that returns
	 * the values as a String in descending order.
	 * 
	 */
		public void ex6Test1() {
	Tree t1 = new Tree(6,new Tree(3,new Tree(1,new Tree(), new Tree()),
			new Tree(4,new Tree(), new Tree())),
			new Tree(8,new Tree(7,new Tree(),new Tree()),new Tree()));
		
	String expected = "8 7 6 4 3 1";
	
	assertEquals(Worksheet2.printDescending(t1), expected );
		
	}
	@Test
	public void ex6Test2() {
		Tree t1 = new Tree(6,new Tree(2,new Tree(1,new Tree(), new Tree()),
				new Tree(5,new Tree(), new Tree())),
				new Tree(9,new Tree(8,new Tree(),new Tree()),new Tree()));
			
		String expected = "9 8 6 5 2 1";
		
		assertEquals(Worksheet2.printDescending(t1), expected );
			
		}
	@Test
	/**
	 * Ex7
	 * Testing for the maximum value in a binary search tree 
	 */
	public void ex7Test1() {
	Tree t1 = new Tree(6,new Tree(3,new Tree(1,new Tree(), new Tree()),
			new Tree(4,new Tree(), new Tree())),
			new Tree(8,new Tree(7,new Tree(),new Tree()),new Tree()));
	
	int expected = 8;
	
	assertEquals(Worksheet2.max(t1),expected);
	}
	@Test
	public void ex7Test2() {
		Tree t1 = new Tree(6,new Tree(3,new Tree(1,new Tree(), new Tree()),
				new Tree(4,new Tree(), new Tree())),
				new Tree(9,new Tree(7,new Tree(),new Tree()),new Tree()));
		
		int expected = 9;
		
		assertEquals(Worksheet2.max(t1),expected);
		}
	@Test
	/**Ex8
	 * Deleting 7 from t1
	 */
	public void ex8Test1() {
		Tree t1 = new Tree(5,new Tree(3,new Tree(1,new Tree(), new Tree()),
				new Tree(4,new Tree(), new Tree())),
				new Tree(8,new Tree(7,new Tree(),new Tree()),new Tree()));
	
		Tree expected = new Tree(5,new Tree(3,new Tree(1,new Tree(), new Tree()),
				new Tree(4,new Tree(), new Tree())),
				new Tree(8,new Tree(),new Tree()));
		
		assertEquals(Worksheet2.delete(t1, 7),expected);
	}
	@Test
	/**Ex8
	 * Deleting 8 from t1
	 */
	public void ex8Test2() {
		Tree t1 = new Tree(6,new Tree(2,new Tree(1,new Tree(), new Tree()),
				new Tree(5,new Tree(), new Tree())),
				new Tree(9,new Tree(8,new Tree(),new Tree()),new Tree()));
	
		Tree expected = new Tree(6,new Tree(2,new Tree(1,new Tree(), new Tree()),
				new Tree(5,new Tree(), new Tree())),
				new Tree(9,new Tree(),new Tree()));
		
		assertEquals(Worksheet2.delete(t1, 8),expected);
	}
	@Test
	/**
	 * Ex9 
	 * test 1 - unbalanced tree
	 */
	public void ex9test1() {
		Tree rl = new Tree(8,new Tree(9), new Tree());
		Tree l = new Tree(5);
		Tree r = new Tree(10, rl, new Tree());
		Tree t = new Tree(6, l, r);
		assertFalse(Worksheet2.isHeightBalanced(t));
		
	}	
	
	@Test
	/**
	 * Ex9 
	 * test 2 - single node
	 */
	public void ex9test2() {
		Tree t = new Tree(8);
		assertTrue(Worksheet2.isHeightBalanced(t));

		
	}
	
	
	@Test
	/**
	 * Ex9
	 * test 3 - Empty tree
	 */
	public void ex9test3() {
		Tree t = new Tree();
		assertTrue(Worksheet2.isHeightBalanced(t));
		
	}
	
	@Test
	/**
	 * Ex10 
	 * test 1 - insert (right-left rotation)
	 */
	public void ex10test1() {
		Tree rl = new Tree(8);
		Tree l = new Tree(5);
		Tree r = new Tree(10, rl, new Tree());
		Tree t = new Tree(6, l, r);
		
		Tree erl = new Tree(8);
		Tree err = new Tree(10);
		Tree er = new Tree (9, erl, err);
		Tree el = new Tree(5); 
		Tree et = new Tree(6,el,er);
		
		assertEquals("Trees don't match",et,Worksheet2.insertHB(9, t));
		

	}	
	
	@Test
	/**
	 * Ex10 
	 * test 2 - insert (left rotation)
	 */
	public void ex10test2() {
		Tree rl = new Tree(7);
		Tree l = new Tree(3);
		Tree r = new Tree(9, rl, new Tree());
		Tree t = new Tree(5, l, r);
		
	    Tree erl = new Tree(6);
		Tree err = new Tree(9);
		Tree er = new Tree (7, erl, err);
		Tree el = new Tree(3); 
		Tree et = new Tree(5,el,er);
		
		assertEquals("Trees don't match",et,Worksheet2.insertHB(6, t));
		

	}	
	
	@Test
	/**
	 * Ex10 
	 * test 3 - insert (right rotation with side-swap)
	 */
	public void ex10test3() {
		Tree rl = new Tree(7);
		Tree l = new Tree(5);
		Tree r = new Tree(9, rl, new Tree());
		Tree t = new Tree(6, l, r);
		
		Tree er = new Tree(9, new Tree(), new Tree(11));
		Tree el = new Tree(6,new Tree(5), new Tree(7) );
		Tree et = new Tree(9, el, er);
		
		Tree first = Worksheet2.insertHB(9,t);
		
		assertEquals("Trees don't match",et,Worksheet2.insertHB(11, first));
		
	}	
	@Test
	/**
	 * Ex10 
	 * test 4 - insert (left-right rotation)
	 */
	public void ex10test4() {
		Tree l = new Tree(2, new Tree(), new Tree (5));
		Tree r = new Tree(10);
		Tree t = new Tree(6, l, r);
		
		Tree el = new Tree(4, new Tree(2), new Tree (5));
		Tree er = new Tree(10);
		Tree et = new Tree(6, el, er);
		
		assertEquals("Trees don't match",et,Worksheet2.insertHB(4, t));
		

	}	
	@Test
	/**
	 * Ex10 
	 * test 5 - insert (no rotation)
	 */
	public void ex10test5() {
		Tree rl = new Tree(8);
		Tree l = new Tree(5);
		Tree r = new Tree(9, rl, new Tree());
		Tree t = new Tree(6, l, r);
		
		Tree erl = new Tree(8);
		Tree el = new Tree(5);
		Tree er = new Tree(9, erl, new Tree(12));
		Tree et = new Tree(6, el, er);
		assertEquals("Trees don't match",et,Worksheet2.insertHB(12, t));
		
	}
	@Test
	/**
	 * Ex10 
	 * test 6 - delete
	 */
	public void ex10test6() {
		Tree rl = new Tree(8);
		Tree l = new Tree(4);
		Tree r = new Tree(10, rl, new Tree());
		Tree t = new Tree(6, l, r);

		Tree et = new Tree(8, new Tree(6), new Tree(10));
		assertEquals("Trees don't match",et,Worksheet2.deleteHB(t,4));
		}
	
	@Test
	/**
	 * Ex10 
	 * test 7 - delete root
	 */
	public void ex10test7() {
		
	Tree l = new Tree(3, new Tree(2), new Tree (4));
	Tree r = new Tree(9);
	Tree t = new Tree(5, l, r);
		
	Tree el = new Tree(3, new Tree(2), new Tree ());
	Tree er = new Tree(9);
	Tree et = new Tree(4, el, er);
	
	assertEquals("Trees don't match",et,Worksheet2.deleteHB(t, 5));
	}
	
	@Test
	/**
	 * Ex10 
	 * test 8 - delete 
	 */
	public void ex10test8() {
		
	Tree rl = new Tree(8);
	Tree l = new Tree(5);
	Tree r = new Tree(9, rl, new Tree(11));
	Tree t = new Tree(6, l, r);
	 
	 Tree el = new Tree(5);
	 Tree er = new Tree(8, new Tree(), new Tree(11));
	 Tree et = new Tree(6, el, er);
	
	assertEquals("Trees don't match",et,Worksheet2.deleteHB(t, 9));
	}
	
}


	

