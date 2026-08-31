#include <bits/stdc++.h>
using namespace std;
vector<int> g[100010];
int n;
bool has(int x, int y) {
  if (x < 0 || x > 100000 || y < 0 || y > 100000) return false;
  return binary_search(g[x].begin(), g[x].end(), y);
}
int main() {
  scanf("%d", &n);
  int x, y;
  for (int i = 1; i <= n; ++i) {
    scanf("%d%d", &x, &y);
    g[x].push_back(y);
  }
  for (int i = 0; i <= 100000; ++i) sort(g[i].begin(), g[i].end());
  int ans = 0, z = sqrt(n), d;
  for (int i = 0; i <= 100000; ++i) {
    if (g[i].size() <= z) {
      for (int j = 0; j < g[i].size(); ++j)
        for (int k = j + 1; k < g[i].size(); ++k) {
          d = g[i][k] - g[i][j];
          if (has(i + d, g[i][j]) && has(i + d, g[i][k])) ++ans;
        }
    } else {
      for (int j = i + 1; j <= 100000; ++j) {
        d = j - i;
        for (int k = 0; k < g[j].size(); ++k)
          if (has(i, g[j][k]) && has(i, g[j][k] + d) && has(j, g[j][k] + d))
            ++ans;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
