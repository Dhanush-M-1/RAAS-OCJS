#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 10;
const int base = 500;
int a[maxn], cnt[maxn], cc[maxn], cur[maxn];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d", &a[i]), ++cc[a[i]];
  int c = max_element(cc + 1, cc + 1 + n) - cc;
  int ans = 0;
  for (int i = 1; i <= min(cc[c], base); ++i) {
    int sc = 0;
    memset(cnt, 0, sizeof cnt);
    auto change = [&](int x, int val) {
      sc -= (cnt[x] == i);
      cnt[x] += val;
      sc += (cnt[x] == i);
    };
    int l = 1, r = 1;
    while (r <= n) {
      change(a[r], 1);
      while (cnt[a[r]] > i) change(a[l++], -1);
      if (sc > 1) ans = max(ans, r - l + 1);
      ++r;
    }
  }
  for (int i = 1; i <= n; ++i)
    if (i != c && cc[i] > base) {
      memset(cur, -1, sizeof cur);
      int sum = 0;
      cur[0] = 0;
      for (int j = 1; j <= n; ++j) {
        sum += (a[j] == c) - (a[j] == i);
        if (sum >= 0) {
          if (cur[sum] == -1)
            cur[sum] = j;
          else
            ans = max(ans, j - cur[sum]);
        }
      }
    }
  printf("%d\n", ans);
  return 0;
}
