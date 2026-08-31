#include <bits/stdc++.h>
using namespace std;
int n, sx, sy, ex, ey;
int fx[] = {-1, 0, 1, 1, 1, 0, -1, -1};
int fy[] = {-1, -1, -1, 0, 1, 1, 1, 0};
set<long long> mp, use;
map<long long, int> len;
inline long long getpoint(int x, int y) {
  return ((long long)x * 1000000010) + y;
}
int bfs() {
  queue<long long> que;
  que.push(getpoint(sx, sy));
  use.insert(getpoint(sx, sy));
  long long en = getpoint(ex, ey);
  while (!que.empty()) {
    int leng = len[que.front()];
    int x = que.front() / 1000000010;
    int y = que.front() % 1000000010;
    que.pop();
    for (int i = 0; i < 8; ++i) {
      long long point = getpoint(x + fx[i], y + fy[i]);
      if (mp.find(point) == mp.end()) continue;
      if (use.find(point) != use.end()) continue;
      que.push(point);
      use.insert(point);
      len[point] = leng + 1;
      if (en == point) return leng + 1;
    }
  }
  return -1;
}
int main() {
  scanf("%d%d%d%d%d", &sx, &sy, &ex, &ey, &n);
  int r, a, b;
  for (int i = 0; i < n; ++i) {
    scanf("%d%d%d", &r, &a, &b);
    for (int j = a; j <= b; ++j) mp.insert(getpoint(r, j));
  }
  printf("%d\n", bfs());
  return 0;
}
