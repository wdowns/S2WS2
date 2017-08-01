/**
 * This class also contains the solution for Worksheet2
 * 
 * @author William Downs
 * @version 21/01/16
 * 
 */

public class Worksheet2 implements Worksheet2Interface {
//	// Exercise 1
//
//	public static Tree negateAll(Tree t) {
//			if (t.isEmpty()) {
//					return t;
//			} else {
//					return new Tree(-t.getValue(), negateAll(t.getLeft()),
//													negateAll(t.getRight()));
//			}
//	}
//

	/**
	 * Ex2 Given a tree a, construct and return a tree that is the mirror image
	 * of a along the left-right axis.
	 * 
	 * @param a
	 * @return tree that is mirror image of tree a
	 */
	public static Tree mirror(Tree a) {
		if (a.isEmpty()) {
			return a;
		} else {
			return new Tree(a.getValue(), mirror(a.getRight()), // right in left position
																
					mirror(a.getLeft())); // left in right position

		}
	}
	// Exercise 2
	
//	public static Tree mirror(Tree t) {
//			if (t.isEmpty()) {
//					return t;
//			} else {
//					return new Tree(t.getValue(), mirror(t.getRight()),
//													mirror(t.getLeft()));
//			}
//	}
//
	//
//	// Exercise 3
//
//	/**
//	 * Postorder means visiting: - left - right - this node
//	 *
//	 * However if we visit the left first, then we need to 'append' new elements
//	 * to the list when we visit right. Append requires searching through the
//	 * list to reach the end. So, the resulting code `postorderSlow' takes
//	 * O(n^2) time.
//	 *
//	 * To avoid this, create a helper function with an accumulating parameter
//	 * that holds the list obtained from the remaining tree. This works in O(n)
//	 * time.
//	 */
//	
//	public static List postorderSlow(Tree t) {
//			if (t.isEmpty())
//					return List.empty();
//			else {
//					return ListOps.append(postorder(t.getLeft()),
//							ListOps.append(postorder(t.getRight()),
//								 List.cons(t.getValue(), List.empty())));
//			}
//	}
//
//	public static List postorder(Tree t) {
//			return postorder(t, List.empty());
//	}
//
//	// Helper function for postorder( Tree ).
//	// add the postorder traversal list of t
//	// at the front of ls
//
//	private static List postorder(Tree t, List ls) {
//			if (t.isEmpty()) {
//					return ls;
//			} else {
//					return postorder(t.getLeft(),
//							 postorder(t.getRight(), List.cons(t.getValue(), ls)));
//			}
//	}
//
//	// Exercise 4
//
//	public static boolean allPositive(Tree a) {
//			if (a.isEmpty()) {
//					return true;
//			} else {
//					/*
//					 * Note that a.value *must* be first, as this is taking advantage of
//					 * short circuiting.
//					 * 
//					 * Alternatively an if statement could be used.
//					 */
//					return a.getValue() >= 0 && allPositive(a.getLeft())
//							&& allPositive(a.getRight());
//			}
//	}
//
//

	/**
	 * Ex5 Given a tree of integers a, write a method that returns a boolean
	 * value indicating whether a is a binary search tree.
	 * 
	 * @param a
	 * @return boolean value indicating whether a is binary search tree
	 */
	public static boolean isSearchTree(Tree a) {
		if (a.isEmpty()) {
			return true;
		} else {
			return isSearchTree(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
	}

	// A Helper function for isSearchTree which returns a boolean to say whether
	// `a' is a search tree in which the values are within the range between
	// `lowerBound' and `upperBound'.

	private static boolean isSearchTree(Tree a, int upperBound, int lowerBound) {
		if (a.isEmpty()) {
			return true;
		} else if (a.getValue() > upperBound || a.getValue() < lowerBound) {
			return false;
		} else {
			int value = a.getValue();

			int newUpper = Math.min(value, upperBound);
			int newLower = Math.max(value, lowerBound);

			return isSearchTree(a.getLeft(), lowerBound, newUpper)
					&& isSearchTree(a.getRight(), newLower, upperBound);
		}
	}
//	//Exercise 5
//
///* We need helper function to check if a tree is a search tree.
// * See below.
// */
//
//public static boolean isSearchTree( Tree a )
//{
//    if ( a.isEmpty() ) {
//        return true;
//    } else {
//        return isSearchTree( a, Integer.MIN_VALUE, Integer.MAX_VALUE );
//    }
//}
//
//// Helper function for isSearchTree.
//// Returns a boolean to say whether `a' is a search tree whose
//// values are within the range between `lowerBound' and `upperBound'.
//
//private static boolean isSearchTree( Tree a, 
//																			 int lowerBound, int upperBound )
//{
//    if ( a.isEmpty() ) {
//        return true;
//    } else if(a.getValue()<lowerBound || a.getValue()>upperBound){
//					return false;
//    }else{
//        int value = a.getValue();
//
//        int newLower = Math.max( value, lowerBound );
//        int newUpper = Math.min( value, upperBound );
//
//        return isSearchTree( a.getLeft() , lowerBound, newUpper   ) &&
//							   isSearchTree( a.getRight(), newLower  , upperBound ) ;
//    }
//}
//
//
	/**
	 * Ex6 Given a binary search tree of integers a, write a method that prints
	 * the values stored in it in descending order. Do this without building a
	 * separate list of the values.
	 * 
	 * @param a
	 * @return values stored in descending order
	 */
	public static String printDescending(Tree a) {

		if (a.isEmpty())
			return "";
		else if (a.getLeft().isEmpty() && a.getRight().isEmpty())
			return a.getValue() + "";
		else if (a.getLeft().isEmpty())
			return printDescending(a.getRight()) + " " + a.getValue();
		else if (a.getRight().isEmpty())
			return a.getValue() + " " + printDescending(a.getLeft());
		else
			return printDescending(a.getRight()) + " " + a.getValue() + " "
					+ printDescending(a.getLeft());
	}
//  //Exercise 6
//		public static void printDescending( Tree a )
//		{
//				if ( ! a.isEmpty() ) {
//						printDescending( a.getRight() );
//						System.out.println( a.getValue() );
//						printDescending( a.getLeft() );
//				}
//		}
//
	/**
	 * Ex7 Assuming that the argument tree a is a binary search tree, write an
	 * efficient method to find the maximum value stored in the tree. Your
	 * method must not visit and compare all the nodes in the tree. Rather, it
	 * must traverse at most one path in the tree from the root node.
	 * 
	 * @param a
	 * @return maximum value stored in tree
	 */
	public static int max(Tree a) {

		if (a.isEmpty()) {
			throw new IllegalStateException(
					"Empty tree, max value doesn't exist");

		} else {
			Tree right = a.getRight();
			if (right.isEmpty()) {
				return a.getValue();
			} else
				return max(right);
		}
	}
//	//Exercise 7
//
///**
// * You should:
// *  - handle empty trees
// *  - never looks at left
// *  - never compares values, i.e. a < right, as no need if it's
// *    search tree. 
// *  - returns right value as soon as found
// *
// */
//
//public static int max( Tree a )
//{
//    if ( a.isEmpty() ) {
//        throw new IllegalStateException( "empty tree given, no max value exists" );
//    } else {
//        Tree right = a.getRight();
//
//        if ( right.isEmpty() ) {
//            return a.getValue();
//        } else {
//            return max( right );
//        }
//    }
//}
//
//
	/**
	 * Ex8 Assuming that the argument tree a is a binary search tree, this
	 * method must delete the value x from a and return the resulting tree. If
	 * there are multiple copies of x in the tree, you need to delete only one
	 * copy of x. The original tree a must not be altered. Rather, you should
	 * build a new tree that contains all the values of a except for one copy of
	 * x. The resulting tree must again be a binary search tree.
	 * 
	 * @param a
	 * @param x
	 * @return a new binary search tree that contains all the values of a except
	 *         for one copy of x
	 */
	public static Tree delete(Tree a, int x) {

		if (a.isEmpty()) {
			throw new IllegalStateException("Value not in tree so delete");
		} else {
			int value = a.getValue();
			Tree left = a.getLeft();
			Tree right = a.getRight();
			if (x > value) {
				Tree newRight = delete(right, x);
				return new Tree(a.getValue(), left, newRight);
			} else if (x < value) {
				Tree newLeft = delete(left, x);
				return new Tree(a.getValue(), newLeft, right);
			} else {
				if (left.isEmpty()) { // Deletion part
					return right;
				} else if (right.isEmpty()) {
					return left;
				} else {
					// If Neither subtree is empty, we delete the maximum from
					// the left subtree.
					int predecessor = max(left);
					return new Tree(predecessor, delete(left, predecessor),
							right);
				}
			}
		}
	}
//  // Exercise 8
//
//  /**
//   * Deletes the value 'x' from the given tree,
//   * if it exists, and returns the new Tree.
//   *
//   * Otherwise, the original tree will be returned. 
//   */
//  public static Tree delete( Tree a, int x )
//  {
//      if ( a.isEmpty() ) {
//          return a;
//      } else {
//          int value  = a.getValue();
//          Tree left  = a.getLeft();
//          Tree right = a.getRight();
//
//          if ( x > value ) {
//              Tree newRight = delete( right , x );
//
//								return new Tree( a.getValue(), left, newRight );
//          } else if ( x < value ) {
//              Tree newLeft = delete( left , x );
//
//								return new Tree( a.getValue(), newLeft, right );
//
//          } else {
//								// The deletion!
//              if ( left.isEmpty() ) {
//                  return right;
//              } else if ( right.isEmpty() ) {
//                  return left;
//										/*
//										 * Neither subtree is empty.
//										 * So one subtree is going to lose a node.
//										 * Let it be the left.
//										 * We delete the maximum from the left subtree.
//										 */
//              } else {
//										int predecessor = max( left );
//                  return new Tree(predecessor,
//										delete( left, predecessor ),
//												right);
//              }
//          }
//      }
//  }
//
//
	/**
	 * Ex9 Given a tree of integers a, check to see if it is height-balanced,
	 * returning a boolean value.
	 * 
	 * @param a
	 * @return boolean value indicating whether tree is height-balanced
	 */
	public static boolean isHeightBalanced(Tree a) {
		if (a.isEmpty())
			return true;
		else {
			int leftHeight = height(a.getLeft());
			int rightHeight = height(a.getRight());
			if ((Math.abs(leftHeight - rightHeight)) <= 1) {
				return (isHeightBalanced(a.getLeft()) && isHeightBalanced(a
						.getRight()));
			} else
				return false;
		}
	}

	public static int height(Tree t) {
		return (int) t.getHeight();
	}
//  //Exercise 9
//
//  public static boolean isHeightBalanced(Tree t) {
//				if (t.isEmpty())
//						return true;
//				else {
//						int lh = t.getLeft().getHeight();
//						int rh = t.getRight().getHeight();
//						if ((Math.abs(lh-rh)) <= 1) {
//								return (isHeightBalanced(t.getLeft()) &&
//												isHeightBalanced(t.getRight()));
//						}
//						else
//								return false;
//				}
//  }
//
//  

	/**
	 * Ex10 Write modified version of insert and delete methods that maintains
	 * the height-balanced property of trees. You should assume that the input
	 * trees are height-balanced and produce results that are height-balanced.
	 * 
	 * @param x
	 * @param a
	 * @return height-balanced tree
	 */
	public static Tree insertHB(int x, Tree a) {
		if (a.isEmpty())
			return new Tree(x, new Tree(), new Tree());
		else if (x <= a.getValue()) {
			Tree result = rebalanceLeft(new Tree(a.getValue(), insertHB(x,
					a.getLeft()), a.getRight()));
			assert isSearchTree(result) && isHeightBalanced(result);
			return result;
		} else {
			Tree result = rebalanceRight(new Tree(a.getValue(), a.getLeft(),
					insertHB(x, a.getRight())));
			assert isSearchTree(result) && isHeightBalanced(result);
			return result;
		}
	}

	/**
	 * @param a
	 * @param x
	 * @return height-balanced tree
	 */
	public static Tree deleteHB(Tree a, int x) {
		if (a.isEmpty())
			throw new IllegalStateException("deleteHB as value is not in tree");
		else {
			Tree left = a.getLeft();
			Tree right = a.getRight();
			int value = a.getValue();

			if (x > value) {
				Tree newRight = deleteHB(right, x);
				return rebalanceLeft(new Tree(a.getValue(), left, newRight));
			} else if (x < value) {
				Tree newLeft = deleteHB(left, x);
				return rebalanceRight(new Tree(a.getValue(), newLeft, right));

			} else {
				if (left.isEmpty()) {
					return right;
				} else if (right.isEmpty()) {
					return left;
				} else {
					int predecessor = max(left);
					return rebalanceRight(new Tree(predecessor, deleteHB(left,
							predecessor), right));
				}
			}
		}
	}

	// 'rebalanceLeft' is called when the left subtree of 't' may have
	// grown taller by one notch. If it is taller than the right subtree by two,
	// we need to return a height-balanced version of 't' using single or double
	// rotations.

	private static Tree rebalanceLeft(Tree t) {
		if (height(t.getLeft()) <= height(t.getRight()) + 1)
			return t;
		else {
			Tree l = t.getLeft(); // height h+2
			Tree r = t.getRight(); // height h
			Tree ll = l.getLeft(); // height h+1?
			Tree lr = l.getRight(); // height h+1?
			if (height(ll) > height(r)) { // LL rotation (single)
				return new Tree(l.getValue(), ll, new Tree(t.getValue(), lr, r));
			} else {
				assert height(lr) > height(r); // LR rotation (double)
				return new Tree(lr.getValue(), new Tree(l.getValue(),
						l.getLeft(), lr.getLeft()), new Tree(t.getValue(),
						lr.getRight(), t.getRight()));
			}
		}
	}

	private static Tree rebalanceRight(Tree t) {
		if (height(t.getRight()) <= height(t.getLeft()) + 1)
			return t;
		else {
			Tree l = t.getLeft(); // height h
			Tree r = t.getRight(); // height h+2
			Tree rl = r.getLeft(); // height h+1?
			Tree rr = r.getRight(); // height h+1?
			if (height(rr) > height(l)) { // RR rotation (single)
				return new Tree(r.getValue(), new Tree(t.getValue(), l, rl), rr);
			} else {
				assert height(rl) > height(l); // RL rotation (double)
				return new Tree(rl.getValue(), new Tree(t.getValue(),
						t.getLeft(), rl.getLeft()), new Tree(r.getValue(),
						rl.getRight(), r.getRight()));
			}
		}
	}
}

//    //Exercise 10a
//
//    public static Tree insertHB(int n, Tree t) {
//				if (t.isEmpty())
//						return new Tree(n);
//				else if (n <= t.getValue()) {
//						Tree newLeft = insertHB(n, t.getLeft());
//						return rebalanceForLeft(
//											new Tree(t.getValue(), newLeft, t.getRight()));
//				}
//				else {
//						Tree newRight = insertHB(n, t.getRight());
//						return rebalanceForRight(
//														 new Tree(t.getValue(), t.getLeft(),newRight));
//				}
//    }
//
//    
//    //Exercise 10b
//    public static Tree deleteHB( Tree a, int x ) {
//				if ( a.isEmpty() ) 
//            throw new IllegalStateException( 
//													"deleteHB: value is not in the tree" );
//				else {
//            int value  = a.getValue();
//            Tree left  = a.getLeft();
//            Tree right = a.getRight();
//
//            if ( x > value ) {
//                Tree newRight = deleteHB( right , x );
//								return rebalanceForLeft(
//													 new Tree( a.getValue(), left, newRight ));
//            } else if ( x < value ) {
//                Tree newLeft = deleteHB( left , x );
//								return rebalanceForRight(
//												 new Tree( a.getValue(), newLeft, right ));
//
//            } else {
//                if ( left.isEmpty() ) {
//                    return right;
//                } else if ( right.isEmpty() ) {
//                    return left;
//                } else {
//										int predecessor = max( left );
//                    return rebalanceForRight(
//															 new Tree( predecessor,
//																				 deleteHB( left, predecessor ),
//																				 right));
//								}
//						}
//				}
//    }
//
//		// We define a static function for height for convenience
//
//		private static int height(Tree t) {
//				return t.getHeight();
//		}
//
//    // rebalanceForLeft is called when the left subtree of t may have
//    // grown taller by one notch.
//    // If it is indeed taller than the right subtree by two notches,
//    // return a height-balanced version of t using single or double rotations.
//    // The subtrees of t are assumed to be already height-balanced and
//    // no effort is made to rebalance them.
//
//    private static Tree rebalanceForLeft(Tree t) {
//				if (height(t.getLeft()) <= height(t.getRight()) + 1)
//						return t;
//				else {
//						Tree l = t.getLeft();	// height h+2
//						Tree r = t.getRight();	// height h
//						Tree ll = l.getLeft();	// height h+1?
//						Tree lr = l.getRight(); // height h+1?
//						if (height(ll) > height(r)) {
//								// LL rotation - single
//								return new Tree(l.getValue(),
//																ll,
//																new Tree(t.getValue(), lr, r));
//						}
//						else {
//								assert height(lr) > height(r);
//								// LR rotation - double
//								return new Tree(lr.getValue(),
//																new Tree(l.getValue(),
//																				 l.getLeft(),
//																				 lr.getLeft()),
//																new Tree(t.getValue(),
//																				 lr.getRight(),
//																				 t.getRight())
//																);
//						}
//				}
//    }
//
//    private static Tree rebalanceForRight(Tree t) {
//				if (height(t.getRight()) <= height(t.getLeft()) + 1)
//						return t;
//				else {
//						Tree l = t.getLeft();	// height h
//						Tree r = t.getRight();	// height h+2
//						Tree rl = r.getLeft();	// height h+1?
//						Tree rr = r.getRight(); // height h+1?
//						if (height(rr) > height(l)) {
//								// RR rotation - single
//								return new Tree(r.getValue(),
//																new Tree(t.getValue(), l, rl),
//																rr);
//						}
//						else {
//								assert height(rl) > height(l);
//								// RL rotation - double
//								return new Tree(rl.getValue(),
//																new Tree(t.getValue(),
//																				 t.getLeft(),
//																				 rl.getLeft()),
//																new Tree(r.getValue(),
//																				 rl.getRight(),
//																				 r.getRight())
//																);
//						}
//				}
//    }
//
//}
