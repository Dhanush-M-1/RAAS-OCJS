#include <bits/stdc++.h>
using namespace std;
int DEBUG = 0;
const int maxn = 2e5;
map<pair<int, int>, int> ok;
pair<int, int> q[maxn];
map<pair<int, int>, int> d;
int x0, y123, x1, y179;
int bfs() {
  int qb = 0, qe = 1;
  d[make_pair(x0, y123)] = 1;
  q[qb] = make_pair(x0, y123);
  while (qb != qe) {
    pair<int, int> v = q[qb++];
    if (DEBUG) printf("v=%d %d %d\n", v.first, v.second, d[v]);
    int l = d[v];
    for (int dx = -1; dx < 2; dx++) {
      for (int dy = (int)-1; dy < (int)2; dy++) {
        if (ok[make_pair(v.first + dx, v.second + dy)]) {
          if (d.count(make_pair(v.first + dx, v.second + dy)) == 0 ||
              d[make_pair(v.first + dx, v.second + dy)] > l + 1) {
            d[make_pair(v.first + dx, v.second + dy)] = l + 1;
            q[qe++] = make_pair(v.first + dx, v.second + dy);
          }
        }
      }
    }
  }
  if (d.count(make_pair(x1, y179)) == 0) return -1;
  return d[make_pair(x1, y179)] - 1;
}
int main() {
  scanf("%d%d%d%d", &x0, &y123, &x1, &y179);
  int n;
  int r, a, b;
  scanf("%d", &n);
  for (int i = 0; i < (int)n; i++) {
    scanf("%d%d%d", &r, &a, &b);
    for (int i = (int)a; i < (int)b + 1; i++) {
      ok[make_pair(r, i)] = 1;
    }
  }
  for (map<pair<int, int>, int>::iterator it = ok.begin(); it != ok.end(); it++)
    if (DEBUG) printf("%d %d\n", it->first.first, it->first.second);
  printf("%d", bfs());
}
