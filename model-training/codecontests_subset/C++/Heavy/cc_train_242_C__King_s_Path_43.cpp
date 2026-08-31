#include <bits/stdc++.h>
using namespace std;
queue<pair<int, int> > que;
map<pair<int, int>, int> mm;
int x[8] = {1, -1, 0, 0, -1, -1, 1, 1};
int y[8] = {0, 0, 1, -1, 1, -1, 1, -1};
int main() {
  int x0, y0, x1, y1, n, i;
  while (scanf("%d%d%d%d", &y0, &x0, &y1, &x1) != EOF) {
    scanf("%d", &n);
    mm.clear();
    while (n--) {
      int r, a, b;
      scanf("%d%d%d", &r, &a, &b);
      for (i = a; i <= b; i++) mm[make_pair(i, r)] = -1;
    }
    mm[make_pair(x0, y0)] = 0;
    mm[make_pair(x1, y1)] = -1;
    que.push(make_pair(x0, y0));
    while (!que.empty()) {
      int tx = que.front().first;
      int ty = que.front().second;
      que.pop();
      for (i = 0; i < 8; i++)
        if (mm[make_pair(tx + x[i], ty + y[i])] < 0) {
          mm[make_pair(tx + x[i], ty + y[i])] = mm[make_pair(tx, ty)] + 1;
          que.push(make_pair(tx + x[i], ty + y[i]));
        }
    }
    printf("%d\n", mm[make_pair(x1, y1)]);
  }
  return 0;
}
