#include <bits/stdc++.h>
using namespace std;
int main() {
  pair<int, int> start, target;
  scanf("%d %d %d %d", &start.first, &start.second, &target.first,
        &target.second);
  int n;
  set<pair<int, int> > mat;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    for (int q = b; q <= c; q++) mat.insert(make_pair(a, q));
  }
  map<pair<int, int>, int> dist;
  queue<pair<int, int> > q;
  q.push(start);
  int dx[] = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
  int dy[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
  mat.erase(start);
  dist[start] = 0;
  while (!q.empty()) {
    pair<int, int> u = q.front();
    q.pop();
    if (u == target) break;
    for (int i = 0; i < 9; i++) {
      pair<int, int> tmp = make_pair(u.first + dx[i], u.second + dy[i]);
      if (!mat.count(tmp)) continue;
      dist[tmp] = dist[u] + 1;
      q.push(tmp);
      mat.erase(tmp);
    }
  }
  printf("%d\n", dist.count(target) ? dist[target] : -1);
  return 0;
}
