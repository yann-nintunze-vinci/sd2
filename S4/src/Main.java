import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    Tree l1 = new Tree(1);
    Tree l3 = new Tree(3);
    Tree l5 = new Tree(5);
    Tree l7 = new Tree(7);

    Tree t2 = new Tree(2, new Tree[]{l1, l3});
    Tree t6 = new Tree(6, new Tree[]{l7});

    Tree t4 = new Tree(4, new Tree[]{t2, l5, t6});

    Tree binaire = new Tree(4,
        new Tree[]{new Tree(2,
            new Tree[]{new Tree(1)}),
            new Tree(6,
                new Tree[]{new Tree(3), new Tree(7),})});

    System.out.println("nbrLeaves");
    System.out.println(Trees.nbrLeaves(t4));

    Tree[] ls = Trees.flattenLeaves(t4);
    System.out.println("Les " + ls.length + " feuilles");
    int i = 0;
    while (i != ls.length) {
      System.out.println(ls[i].getValue());
      i++;
    }

    System.out.println("Path V1");
    Trees.pathV1(l7);

    System.out.println("Path V2");
    Trees.pathV2(l7);

    System.out.println("nbrNode");
    System.out.println(Trees.nbrNode(t4));//Attendu : 7

    System.out.println("min");
    System.out.println(Trees.min(t4));//Attendu : 1

    System.out.println("sum");
    System.out.println(Trees.sum(t4));//Attendu : 28

    System.out.println("equals");
    System.out.println(Trees.equals(t4, t2));//Attendu : false

    System.out.println("depth");
    System.out.println(Trees.depth(t4));//Attendu : 2

    System.out.println("sameOne");
    System.out.println(Trees.sameOne(l3, t2));//Attendu : true

    System.out.println("dfsPrint");
    Trees.dfsPrint(t4);//4 - 2 - 1 - 3 - 5 - 6 - 7

    System.out.println("bfsPrint");
    Trees.bfsPrint(t4);//4 - 2 - 5 - 6 - 1 - 3 - 7

    System.out.println("printPathV1");
    Trees.printPathV1(l3);//4 - 2 - 3

    System.out.println("printPathV2");
    Trees.printPathV2(l3);//idem

    System.out.println("printPathV3");
    Trees.printPathV3(t4, 7);//4 - 6 - 7

    System.out.println("toArray");
    System.out.println(Arrays.deepToString(Trees.toArray(binaire)));

    int[][] t4Array = {{4, 2, 1, 6, 3, 7}, {1, 2, -1, 4, -1, -1}, {3, -1, -1, 5, -1, -1}};

    System.out.println("toTree");
    System.out.println(Trees.toTree(t4Array));
  }
}
