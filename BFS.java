// Bidirectional BFS
int bi_bfs(Set<Integer> visited, Set<Integer> set1, Set<Integer> set2, int level, List<Integer>[] adj_matrix) {
  if (set1.isEmpty()) return 0;

  if (set1.size() > set2.size()) return bi_bfs(visited, set2, set1, level, adj_matrix);

  Set<Integer> newSet = new HashSet<>();

  for (int cur : set1) {
    for(int neighbour : adj_matrix[cur]){
      if(visited.add(neighbour)){
        if(set2.contains(neighbour)) return level+1;
        newSet.add(neighbour);
      }
    }
  }

  return bi_bfs(visited, set2, newSet, level + 1, adj_matrix);
}
