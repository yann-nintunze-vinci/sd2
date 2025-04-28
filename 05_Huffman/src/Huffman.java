import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Huffman {

  public static class Node {

    private char ch;
    private int freq;
    private final Node left, right;

    public Node(char ch, int freq, Node left, Node right) {
      this.ch = ch;
      this.freq = freq;
      this.left = left;
      this.right = right;
    }

    public Node(int freq, Node left, Node right) {
      this('\0', freq, left, right);
    }

    public boolean isLeaf() {
      return left == null && right == null;
    }

    public char getCh() {
      return ch;
    }

    public int getFreq() {
      return freq;
    }

    public Node getLeft() {
      return left;
    }

    public Node getRight() {
      return right;
    }
  }

  // renvoie une map qui a comme clé les lettres de la chaine de
  // caractère donnée en paramètre et comme valeur la fréquence de
  // ces lettres
  public static Map<Character, Integer> computeFreq(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    return map;
  }

  // renvoie l'arbre de Huffman obtenu à partir de la map des fréquences des lettres
  public static Node buildTree(Map<Character, Integer> freq) {
    PriorityQueue<Node> file = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

    for (Entry<Character, Integer> entry : freq.entrySet()) {
      file.add(new Node(entry.getKey(), entry.getValue(), null, null));
    }

    while (file.size() > 1) {
      Node node1 = file.poll();
      Node node2 = file.poll();

      int freqTotale = node1.freq + node2.freq;

      Node fusion = new Node(freqTotale, node1, node2);
      file.add(fusion);
    }

    return file.poll();
  }

  // renvoie une map qui associe chaque lettre à son code (suite de 0 et de 1).
  // Ce code est obtenu en parcourant l'arbre de Huffman donné en paramètre
  public static Map<Character, String> buildCode(Node root) {
    var map = new HashMap<Character, String>();
    buildCode(root, map, "");
    return map;
  }

  private static void buildCode(Node root, Map<Character, String> map, String str) {
    if (root.isLeaf()) {
      map.put(root.ch, str);
      return;
    }
    buildCode(root.left, map, str + "0");
    buildCode(root.right, map, str + "1");
  }


  // encode la chaine de caractère prise en paramètre en une chaine de
  // bit (0 et 1) en utilisant la map des codes codeMap
  public static String compress(String s, Map<Character, String> codeMap) {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      str.append(codeMap.get(c));
    }

    return str.toString();
  }

  // Cette méthode décode une chaine de 0 et de 1 codé à l'aide de l'algorithme de Huffman
  // En paramètre, en plus de la chaine à décoder, est spécifié la racine de l'arbre de
  // Huffman
	public static String expand(Node root, String t) {
		StringBuilder result = new StringBuilder();
		Node current = root;

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);

			if (c == '0') {
				current = current.left;
			} else if (c == '1') {
				current = current.right;
			}

			if (current.isLeaf()) {
				result.append(current.ch);
				current = root;
			}
		}

		return result.toString();
	}
}
