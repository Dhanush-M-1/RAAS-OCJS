#include <bits/stdc++.h>
using namespace std;
const int INF = (int)1e9 + 7;
const int MAXN = (int)1e6 + 7;
int n;
int x[MAXN];
int y[MAXN];
vector<int> cnt[2][MAXN];
inline bool is(const int &x, const int &y) {
  return binary_search(cnt[0][x].begin(), cnt[0][x].end(), y);
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &x[i], &y[i]);
    cnt[0][x[i]].push_back(y[i]);
    cnt[1][y[i]].push_back(x[i]);
  }
  for (int i = 0; i <= n; i++) {
    sort(cnt[0][i].begin(), cnt[0][i].end());
    sort(cnt[1][i].begin(), cnt[1][i].end());
  }
  int ans = 0;
  for (int i = 0; i < n; i++) {
    int s0 = upper_bound(cnt[0][x[i]].begin(), cnt[0][x[i]].end(), y[i]) -
             cnt[0][x[i]].begin();
    int s1 = upper_bound(cnt[1][y[i]].begin(), cnt[1][y[i]].end(), x[i]) -
             cnt[1][y[i]].begin();
    if (s0 < s1) {
      for (auto yy : cnt[0][x[i]]) {
        if (yy >= y[i]) break;
        int xx = x[i] - (y[i] - yy);
        if (xx >= 0) ans += (is(x[i], yy) && is(xx, yy) && is(xx, y[i]));
      }
    } else {
      for (auto xx : cnt[1][y[i]]) {
        if (xx >= x[i]) break;
        int yy = y[i] - (x[i] - xx);
        if (xx >= 0) ans += (is(x[i], yy) && is(xx, yy) && is(xx, y[i]));
      }
    }
  }
  cout << ans;
  return 0;
}
