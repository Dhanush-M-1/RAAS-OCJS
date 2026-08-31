#include <bits/stdc++.h>
using namespace std;
map<pair<int, int>, int> m;
queue<pair<int, int> > q;
const int LAR = 1000000000;
int main() {
  int x0, y0, x1, y1;
  scanf("%d%d%d%d", &x0, &y0, &x1, &y1);
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int r, a, b;
    scanf("%d%d%d", &r, &a, &b);
    for (int j = a; j <= b; j++) m[make_pair(r, j)] = LAR;
  }
  m[make_pair(x0, y0)] = 0;
  q.push(make_pair(x0, y0));
  while (!q.empty()) {
    pair<int, int> u = q.front();
    q.pop();
    int d = m[u];
    if (u == make_pair(x1, y1)) {
      printf("%d\n", d);
      return 0;
    }
    for (int d1 = -1; d1 <= 1; d1++)
      for (int d2 = -1; d2 <= 1; d2++) {
        pair<int, int> v = make_pair(u.first + d1, u.second + d2);
        if (m.find(v) != m.end() && d + 1 < m[v]) {
          m[v] = d + 1;
          q.push(v);
        }
      }
  }
  printf("-1\n");
  return 0;
}
