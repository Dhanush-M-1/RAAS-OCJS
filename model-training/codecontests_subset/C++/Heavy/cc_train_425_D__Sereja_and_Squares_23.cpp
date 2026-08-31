#include <bits/stdc++.h>
using namespace std;
const int max_N = 100000 + 10;
const int N = 100000;
const int sq = 320;
vector<int> h[max_N], v[max_N];
unordered_map<int, bool> mark[max_N];
int main() {
  int n, x, y;
  long long ans(0);
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d %d", &x, &y);
    h[y].push_back(x);
    mark[x][y] = true;
  }
  for (int i = 0; i <= N; i++) {
    int sz = (int)h[i].size();
    if (sz > sq) {
      for (int x : h[i]) v[x].push_back(i);
      continue;
    }
    for (int j = 0; j < sz; j++) {
      int a = h[i][j];
      for (int k = j + 1; k < sz; k++) {
        int b = h[i][k];
        int t = abs(a - b);
        if (i + t <= N && mark[a][i + t] && mark[b][i + t]) ans++;
        if (i - t >= 0 && mark[a][i - t] && mark[b][i - t]) ans++;
      }
      mark[a][i] = false;
    }
  }
  for (int i = 0; i <= N; i++) {
    int sz = (int)v[i].size();
    for (int j = 0; j < sz; j++) {
      for (int k = j + 1; k < sz; k++) {
        int a = v[i][j], b = v[i][k];
        int t = abs(a - b);
        if (mark[i + t][a] && mark[i + t][b]) ans++;
      }
    }
  }
  printf("%lld\n", ans);
  return 0;
}
