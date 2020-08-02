class Node {
    char c;
    Node[] children = new Node[26];
    boolean end;
    public Node(char c){
        this.c = c;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node('0');
    }

    public void insert(String word, int index) {
      Node cur = root;
      for (char c: word.toCharArray()) {
          cur.children[c-'a'] = cur.children[c-'a'] == null ? new Node(c) : cur.children[c-'a'];
          cur = cur.children[c-'a'];
      }
      cur.end = true;
    }

    public boolean find(String word){
      Node cur = root;
      for (char c: word.toCharArray()){
        if(cur.children[c-'a']==null) return false;
        cur = cur.children[c-'a'];
      }
      return cur.end;
    }

}
