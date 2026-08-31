#include <bits/stdc++.h>
using namespace std;
int dr[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int dc[] = {-1, 0, 1, -1, 1, -1, 0, 1};
struct node {
  int r, c, dist;
  node() {}
  node(int _r, int _c, int _dist) : r(_r), c(_c), dist(_dist) {}
};
set<pair<int, int> > valid, visited;
int main() {
  int r0, c0, r1, c1, n;
  int i, j, r, a, b;
  scanf("%d%d%d%d%d", &r0, &c0, &r1, &c1, &n);
  for (i = 1; i <= n; ++i) {
    scanf("%d%d%d", &r, &a, &b);
    for (j = a; j <= b; ++j) valid.insert(make_pair(r, j));
  }
  int ans = -1;
  queue<node> Q;
  Q.push(node(r0, c0, 0));
  visited.insert(make_pair(r0, c0));
  while (Q.size() > 0) {
    node cur = Q.front();
    Q.pop();
    if (cur.c == c1 && cur.r == r1) {
      ans = cur.dist;
      break;
    }
    for (i = 0; i < 8; ++i) {
      int r2 = cur.r + dr[i];
      int c2 = cur.c + dc[i];
      if (valid.find(make_pair(r2, c2)) != valid.end() &&
          visited.find(make_pair(r2, c2)) == visited.end()) {
        visited.insert(make_pair(r2, c2));
        Q.push(node(r2, c2, cur.dist + 1));
      }
    }
  }
  printf("%d", ans);
  return 0;
}
