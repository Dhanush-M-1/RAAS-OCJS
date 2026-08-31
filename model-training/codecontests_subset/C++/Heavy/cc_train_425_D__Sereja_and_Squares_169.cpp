#include <bits/stdc++.h>
using namespace std;
struct HashMap {
  vector<pair<int, int> > g[1000007];
  void ins(int x, int y) {
    int id = ((long long)(x)*1000000007 + y) % 1000007;
    g[id].push_back(make_pair(x, y));
  }
  bool get(int x, int y) {
    int id = ((long long)(x)*1000000007 + y) % 1000007;
    for (int i = 0; i < g[id].size(); i++) {
      if (g[id][i].first == x && g[id][i].second == y) return true;
    }
    return false;
  }
};
HashMap mp;
vector<int> g[100010];
int x[100010], y[100010], id[100010];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &x[i], &y[i]);
    g[x[i]].push_back(y[i]);
    mp.ins(x[i], y[i]);
  }
  int sz, cnt = 0, ans = 0;
  sz = (int)(sqrt(n * 1.0));
  for (int i = 0; i <= 100000; i++) {
    sort(g[i].begin(), g[i].end());
    if (g[i].size() >= sz) {
      id[cnt++] = i;
    } else {
      int m = g[i].size();
      for (int j = 0; j < m; j++) {
        for (int k = j + 1; k < m; k++) {
          int dx = g[i][k] - g[i][j];
          if (i - dx >= 0 && mp.get(i - dx, g[i][j]) &&
              mp.get(i - dx, g[i][k])) {
            ans++;
          }
          if (i + dx <= 100000 && g[i + dx].size() >= sz) {
            if (mp.get(i + dx, g[i][j]) && mp.get(i + dx, g[i][k])) {
              ans++;
            }
          }
        }
      }
    }
  }
  for (int ii = 0; ii < cnt; ii++) {
    for (int jj = ii + 1; jj < cnt; jj++) {
      int i = id[ii], j = id[jj];
      int p1 = 0, p2 = 0;
      while (p1 < g[i].size() && p2 < g[j].size()) {
        if (g[i][p1] < g[j][p2])
          p1++;
        else if (g[i][p1] > g[j][p2])
          p2++;
        else {
          int dx = j - i, y = g[i][p1];
          if (mp.get(i, y + dx) && mp.get(j, y + dx)) ans++;
          p1++;
          p2++;
        }
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
