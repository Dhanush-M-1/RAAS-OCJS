#include <bits/stdc++.h>
const int MAX_N = 1e5 + 5;
const int INF = 1e9;
const int dx[8] = {-1, -1, -1, 0, 1, 1, 1, 0};
const int dy[8] = {-1, 0, 1, 1, 1, 0, -1, -1};
struct data {
  int r, a, b;
};
bool operator<(data lhs, data rhs) { return lhs.r < rhs.r; }
int n, a, b, x, y;
std::map<std::pair<int, int>, int> map;
std::queue<std::pair<int, int>> q;
int main() {
  scanf("%d%d%d%d%d", &a, &b, &x, &y, &n);
  for (int i = 0; i < n; ++i) {
    int r, a, b;
    scanf("%d%d%d", &r, &a, &b);
    for (int j = a; j <= b; ++j) map[{r, j}] = -1;
  }
  map[{a, b}] = 0;
  for (q.push({a, b}); !q.empty(); q.pop()) {
    std::pair<int, int> cur = q.front();
    for (int i = 0; i < 8; ++i) {
      std::pair<int, int> tar = {cur.first + dx[i], cur.second + dy[i]};
      if (map.count(tar) && map[tar] == -1) {
        map[tar] = map[cur] + 1;
        q.push(tar);
      }
    }
  }
  if (map[{x, y}] == 0)
    printf("-1\n");
  else
    printf("%d\n", map[{x, y}]);
  return 0;
}
