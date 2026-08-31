#include <bits/stdc++.h>
using LL = long long;
using namespace std;
const int N = (int)1e5 + 10, L = 320;
int n;
vector<int> xps[N], yps[N];
unordered_set<int> xhs[N], yhs[N];
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    xps[x].push_back(y);
    xhs[x].insert(y);
  }
  for (int i = 0; i < N; i++) sort(xps[i].begin(), xps[i].end());
  LL ans = 0;
  for (int i = 0; i < N; i++) {
    int l = xps[i].size();
    if (l <= L) {
      for (int j = 0; j < l; j++) {
        int y2 = xps[i][j];
        for (int k = 0; k < j; k++) {
          int y1 = xps[i][k], d = y2 - y1;
          if (i - d >= 0 && xps[i - d].size() > L) {
            ans += xhs[i - d].count(y1) && xhs[i - d].count(y2);
          }
          if (i + d < N) ans += xhs[i + d].count(y1) && xhs[i + d].count(y2);
        }
      }
    } else {
      for (int y : xps[i]) {
        yps[y].push_back(i);
        yhs[y].insert(i);
      }
    }
  }
  for (int i = 0; i < N; i++) {
    int l = yps[i].size();
    for (int j = 0; j < l; j++) {
      int x2 = yps[i][j];
      for (int k = 0; k < j; k++) {
        int x1 = yps[i][k], d = x2 - x1;
        if (i - d >= 0 && yps[i - d].size() > L) {
          ans += yhs[i - d].count(x1) && yhs[i - d].count(x2);
        }
        if (i + d < N) ans += yhs[i + d].count(x1) && yhs[i + d].count(x2);
      }
    }
  }
  printf("%lld\n", ans);
}
