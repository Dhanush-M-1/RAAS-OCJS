#include <bits/stdc++.h>
struct Vertex {
  bool vis;
  int head, top, dist;
  Vertex() : vis(false), head(0), top(0), dist(0) {}
} vertex[3005];
struct Edge {
  int to, next;
  Edge(int __to = 0, int __next = 0) : to(__to), next(__next) {}
} edge[6005];
int n, ptr, dist[3005][3005];
std::vector<int> circle;
void addEdge(int u, int v) {
  edge[++ptr] = Edge(v, vertex[u].head), vertex[u].head = ptr;
  edge[++ptr] = Edge(u, vertex[v].head), vertex[v].head = ptr;
}
int findCircle(int p, int f) {
  vertex[p].vis = true;
  for (int i = vertex[p].head; i; i = edge[i].next) {
    int x = edge[i].to, temp;
    if (x == f) continue;
    if (vertex[x].vis) {
      vertex[x].top = x;
      vertex[p].top = p;
      circle.push_back(x);
      circle.push_back(p);
      return 1;
    } else if (temp = findCircle(x, p)) {
      if (temp == 1 && !vertex[p].top) {
        vertex[p].top = p;
        circle.push_back(p);
        return 1;
      } else {
        return -1;
      }
    }
  }
  vertex[p].vis = false;
  return 0;
}
void BFS(int s) {
  for (int i = 1; i <= n; ++i) vertex[i].vis = false;
  std::queue<int> q;
  q.push(s), vertex[s].vis = true, dist[s][s] = 0;
  while (!q.empty()) {
    int p = q.front();
    q.pop();
    for (int i = vertex[p].head; i; i = edge[i].next) {
      int x = edge[i].to;
      if (vertex[x].vis) continue;
      vertex[x].vis = true, q.push(x);
      dist[s][x] = dist[s][p] + 1;
    }
  }
}
void findTop(int s) {
  std::queue<int> q;
  q.push(s), vertex[s].vis = true;
  while (!q.empty()) {
    int p = q.front();
    q.pop();
    for (int i = vertex[p].head; i; i = edge[i].next) {
      int x = edge[i].to;
      if (vertex[x].top) continue;
      vertex[x].top = s, q.push(x);
    }
  }
}
int main() {
  double ans = 0;
  std::cin >> n;
  for (int i = 1; i <= n; ++i) {
    int u, v;
    std::cin >> u >> v;
    addEdge(u + 1, v + 1);
  }
  findCircle(1, 0);
  for (int i = 1; i <= n; ++i) BFS(i);
  for (auto x : circle) findTop(x);
  for (int i = 1; i <= n; ++i) vertex[i].dist = dist[i][vertex[i].top];
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j) {
      double temp = 0.0;
      if (vertex[i].top == vertex[j].top) {
        temp = 1.0 / (dist[i][j] + 1);
      } else {
        double x = vertex[i].dist + vertex[j].dist + 2,
               y = dist[vertex[i].top][vertex[j].top] - 1,
               z = circle.size() - y - 2;
        temp = 1 / (x + y) + 1 / (x + z) - 1 / (x + y + z);
      }
      ans += temp;
    }
  std::cout << std::fixed << std::setprecision(9) << ans << std::endl;
  return 0;
}
