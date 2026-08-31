#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops")
#pragma GCC optimize("no-stack-protector,fast-math")
using namespace std;
int dx[8] = {1, 0, -1, 0, -1, 1, -1, 1};
int dy[8] = {0, 1, 0, -1, -1, 1, 1, -1};
int a, b, c, d, t;
map<pair<int, int>, int> dist, s;
queue<pair<int, int>> q;
int bfs(pair<int, int> src, pair<int, int> dest) {
  q.push(src);
  dist[src] = 1;
  while (!q.empty()) {
    auto front = q.front();
    q.pop();
    for (int k = 0; k < 8; k++) {
      pair<int, int> v;
      v.first = front.first + dx[k];
      v.second = front.second + dy[k];
      if (s[v] == 0 || dist.count(v) != 0) continue;
      dist[v] = dist[front] + 1;
      q.push(v);
      if (v.first == c && v.second == d) return dist[v] - 1;
    }
  }
  return -1;
}
int main() {
  scanf("%d %d %d %d", &a, &b, &c, &d);
  scanf("%d", &t);
  for (int i = 1; i <= t; i++) {
    int r, from, to;
    scanf("%d %d %d", &r, &from, &to);
    for (int j = from; j <= to; j++) {
      s[make_pair(r, j)] = 1;
    }
  }
  pair<int, int> source, destination;
  source.first = a, source.second = b;
  destination.first = c, destination.second = d;
  printf("%d\n", bfs(source, destination));
  return 0;
}
