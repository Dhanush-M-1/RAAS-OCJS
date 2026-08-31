#include <bits/stdc++.h>
using namespace std;
struct node {
  bool visited[2];
  vector<int> neighs;
};
vector<node> graph;
void bfs(int mode, int v, int no) {
  node currN = graph[v];
  currN.visited[mode] = true;
  queue<int> q;
  for (int i = 0; i < currN.neighs.size(); i++) {
    q.push(currN.neighs[i]);
  }
  while (q.size()) {
    int nv = q.front();
    q.pop();
    if (!graph[nv].visited[mode] && nv != no) {
      graph[nv].visited[mode] = true;
      int sz = graph[nv].neighs.size();
      for (int i = 0; i < sz; i++) q.push(graph[nv].neighs[i]);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    graph.clear();
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    graph.resize(n + 1);
    for (int i = 0; i < m; i++) {
      int v1, v2;
      cin >> v1 >> v2;
      graph[v1].neighs.push_back(v2);
      graph[v2].neighs.push_back(v1);
    }
    bfs(0, a, b);
    bfs(1, b, a);
    long long int ca = 0;
    long long int cb = 0;
    for (int i = 1; i < n + 1; i++) {
      node currN = graph[i];
      if (currN.visited[0] && !currN.visited[1] && i != a) {
        ca++;
      } else if (!currN.visited[0] && currN.visited[1] && i != b) {
        cb++;
      }
    }
    cout << ca * cb << '\n';
  }
  return 0;
}
