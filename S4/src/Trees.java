import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Trees {

  // *******************************************************
  // Un premier exemple: le nombre de feuilles d'un arbre
  // *******************************************************
  public static int nbrLeaves(Tree t) {
    int r;
    if (t.isLeaf()) {
      r = 1;
    } else {
      r = 0;
      for (Tree child : t) {
        r += nbrLeaves(child);
      }
    }
    return r;
  }

  // *******************************************************
  // Un deuxième exemple: aplanir un arbre
  // *******************************************************
  public static Tree[] flattenLeaves(Tree t) {
    int nl = nbrLeaves(t);
    Tree[] r = new Tree[nl];
    flattenLeaves(t, r, 0);
    return r;
  }

  private static int flattenLeaves(Tree t, Tree[] a, int idx) {
    int r;
    if (t.isLeaf()) {
      a[idx] = t;
      r = 1;
    } else {
      r = 0;
      for (Tree child : t) {
        r += flattenLeaves(child, a, idx + r);
      }
    }
    return r;
  }

  // *******************************************************
  // Un troisième exemple:
  // tous les algorithmes ne sont pas récursifs
  // *******************************************************
  public static void pathV1(Tree t) {
    System.out.println(t.getValue());
    if (t.getParent() != null) {
      pathV1(t.getParent());
    }
  }

  public static void pathV2(Tree t) {
    while (t != null) {
      System.out.println(t.getValue());
      t = t.getParent();
    }
  }

  // *******************************************************
  // Exercices 1
  // *******************************************************

  // 1.1)
  public static int nbrNode(Tree t) {
    int nb = 1;
    if (!t.isLeaf()) {
      for (Tree child : t.getChildren()) {
        nb += nbrNode(child);
      }
    }
    return nb;
  }

  // 1.2)
  public static int min(Tree t) {
    int min = t.getValue();

    for (Tree child : t.getChildren()) {
      int childMin = min(child);
      if (childMin < min) {
        min = childMin;
      }
    }
    return min;
  }

  // 1.3)
  public static int sum(Tree t) {
    int sum = t.getValue();

    for (Tree child : t.getChildren()) {
      sum += sum(child);

    }
    return sum;
  }

  // 1.4)
  public static boolean equals(Tree t1, Tree t2) {
    if (t1.nbrChildren() != t2.nbrChildren()) {
      return false;
    }

    if (t1.getValue() != t2.getValue()) {
      return false;
    }

    for (int i = 0; i < t1.nbrChildren(); i++) {
      if (!equals(t1.getChildren()[i], t2.getChildren()[i])) {
        return false;
      }
    }

    return true;
  }

  // 1.5)
  public static int depth(Tree n) {
    if (n.isLeaf()) {
      return 0;
    }

    int maxChildDepth = 0;
    for (Tree c : n.getChildren()) {
      int childDepth = depth(c);
      if (childDepth > maxChildDepth) {
        maxChildDepth = childDepth;
      }
    }

    return 1 + maxChildDepth;
  }

  // 1.6)
  public static boolean sameOne(Tree n1, Tree n2) {
    if (n1 == n2) {
      return true;
    }

    if (n1 == null || n2 == null) {
      return false;
    }

    return sameOne(n1.getParent(), n2) || sameOne(n1, n2.getParent());
  }

  // 1.7)
  public static void dfsPrint(Tree t) {
    System.out.println(t.getValue());
    for (Tree child : t.getChildren()) {
      dfsPrint(child);
    }
  }

  // 1.8)
  public static void bfsPrint(Tree t) {
    List<Tree> niveau = new ArrayList<>();
    niveau.add(t);

    bfsPrintLvl(niveau);
  }

  private static void bfsPrintLvl(List<Tree> niveau) {
    if (niveau.isEmpty()) {
      return;
    }

    List<Tree> nxtLvl = new ArrayList<>();

    for (Tree t : niveau) {
      System.out.println(t.getValue());
      nxtLvl.addAll(Arrays.asList(t.getChildren()));
    }

    bfsPrintLvl(nxtLvl);
  }

  // *******************************************************
  // Exercices 2
  // *******************************************************

  // 2.1)
  static void printPathV1(Tree node) {
    if (node == null) {
      return;
    }

    printPathV1(node.getParent());

    System.out.println(node.getValue());
  }

  // 2.2)
  static void printPathV2(Tree node) {
    Deque<Tree> deque = new ArrayDeque<>();

    while (node != null) {
      deque.addFirst(node);
      node = node.getParent();
    }

    while (!deque.isEmpty()) {
      System.out.println(deque.poll().getValue());
    }
  }

  // 2.3
  static void printPathV3(Tree t, int v) {
    if (t.getValue() == v) {
      printPathV1(t);
      return;
    }

    for (Tree child : t.getChildren()) {
      printPathV3(child, v);
    }
  }

  // *******************************************************
  // Exercices 3
  // *******************************************************

  // 3.1
  public static int[][] toArray(Tree t) {
    int[][] array = new int[3][nbrNode(t)];

    toArray(array, t, 0);

    return array;
  }

  private static int toArray(int[][] array, Tree t, int index) {
    array[0][index] = t.getValue();

    int myIndex = index;
    index++;

    if (t.isLeaf()) {
      array[1][myIndex] = -1;
      array[2][myIndex] = -1;
    } else {

      array[1][myIndex] = index;

      index = toArray(array, t.getChildren()[0], index);

      if (t.nbrChildren() > 1) {
        array[2][myIndex] = index;
        index = toArray(array, t.getChildren()[1], index);
      } else {
        array[2][myIndex] = -1;
      }
    }

    return index;
  }


  // 3.2
  public static Tree toTree(int[][] t) {
    return toTree(t, 0);
  }

  private static Tree toTree(int[][] t, int idx) {
    int val = t[0][idx];

    int nodeL = t[1][idx];
    int nodeR = t[2][idx];

    if (nodeL == -1 && nodeR == -1) {
      return new Tree(val);
    }

    List<Tree> children = new ArrayList<>();

    if (nodeL != -1) {
      children.add(toTree(t, nodeL));
    }

    if (nodeR != -1) {
      children.add(toTree(t, nodeR));
    }

    return new Tree(val, children.toArray(new Tree[0]));
  }

  // *******************************************************
  // Exercices 4
  // *******************************************************

  public static Tree lca(Tree n1, Tree n2) {
    return null;
  }
}