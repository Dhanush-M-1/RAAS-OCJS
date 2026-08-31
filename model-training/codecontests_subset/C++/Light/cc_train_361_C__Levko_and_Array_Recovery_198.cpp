#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5010;
const int INF = 1000000000;
int ans[MAXN];
int add[MAXN];
int type[MAXN], l[MAXN], r[MAXN], delta[MAXN];
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 0; i < (int)(n); ++i) ans[i] = INF;
  for (int i = 0; i < (int)(m); ++i) {
    scanf("%d %d %d %d", type + i, l + i, r + i, delta + i);
    --l[i];
    --r[i];
    if (type[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) add[j] += delta[i];
    } else {
      for (int j = l[i]; j <= r[i]; ++j)
        ans[j] = min(ans[j], delta[i] - add[j]);
    }
  }
  for (int i = 0; i < (int)(n); ++i) add[i] = 0;
  bool ok = true;
  for (int i = 0; i < (int)(m); ++i) {
    if (type[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) add[j] += delta[i];
    } else {
      int cmax = ans[l[i]] + add[l[i]];
      for (int j = l[i]; j <= r[i]; ++j) {
        cmax = max(cmax, ans[j] + add[j]);
      }
      if (cmax != delta[i]) ok = false;
    }
  }
  if (ok) {
    cout << "YES" << endl;
    for (int i = 0; i < (int)(n); ++i) cout << ans[i] << " ";
  } else {
    cout << "NO" << endl;
  }
  return 0;
}
