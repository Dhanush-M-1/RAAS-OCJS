#include <bits/stdc++.h>
using namespace std;
struct hash_pair {
  template <class T1, class T2>
  size_t operator()(const pair<T1, T2>& p) const {
    auto hash1 = hash<T1>{}(p.first);
    auto hash2 = hash<T2>{}(p.second);
    return hash1 ^ hash2;
  }
};
int r1, c1, r2, c2, n, ri, ai, bi, dx[8] = {1, -1, 0, 0, 1, 1, -1, -1},
                                   dy[8] = {0, 0, 1, -1, 1, -1, 1, -1};
map<pair<int, int>, int> p;
map<pair<int, int>, bool> vis, a;
bool valid(int rr, int cc) {
  pair<int, int> pp = make_pair(rr, cc);
  if (min(rr, cc) > 0 && max(rr, cc) <= (int)1e9 &&
      (vis.find(pp) == vis.end()) && (a.find(pp) != a.end()))
    return 1;
  return 0;
}
int Bfs(int r, int c) {
  queue<pair<int, int>> q;
  q.push(make_pair(r, c));
  while (!q.empty()) {
    pair<int, int> v = q.front();
    q.pop();
    if (v.first == r2 && v.second == c2) return p[v];
    for (int i = 0; i < 8; ++i) {
      int ni = v.first + dx[i], nj = v.second + dy[i];
      if (valid(ni, nj)) {
        vis[make_pair(ni, nj)] = 1;
        p[make_pair(ni, nj)] = p[v] + 1;
        q.push(make_pair(ni, nj));
      }
    }
  }
  return -1;
}
int main() {
  scanf("%d%d%d%d%d", &r1, &c1, &r2, &c2, &n);
  for (int i = 0; i < n; ++i) {
    scanf("%d%d%d", &ri, &ai, &bi);
    for (int ci = ai; ci <= bi; ++ci) a[make_pair(ri, ci)] = 1;
  }
  p[make_pair(r1, c1)] = 0;
  int ans = Bfs(r1, c1);
  printf("%d\n", ans);
  return 0;
}
