#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,unroll-loops")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,avx2")
using namespace std;
template <typename T>
void read(T &x) {
  x = 0;
  char ch = getchar();
  long long f = 1;
  while (!isdigit(ch)) {
    if (ch == '-') f *= -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + ch - 48;
    ch = getchar();
  }
  x *= f;
}
int a[200010];
int cnt[200010], cnt2[200010];
int fk[400010];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  int n, m = 400;
  int ma = 0, v, ans = 0;
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i];
    if (++cnt[a[i]] > ma) {
      ma = cnt[a[i]];
      v = a[i];
    }
  }
  for (int i = 1; i <= m; ++i) {
    memset(cnt2, 0, sizeof(cnt2));
    int sum = 0;
    for (int l = 1, r = 1; r <= n; ++r) {
      if (++cnt2[a[r]] == i) ++sum;
      while (cnt2[a[r]] > i) {
        if (cnt2[a[l++]]-- == i) --sum;
      }
      if (sum > 1) ans = max(ans, r - l + 1);
    }
  }
  for (int i = 1; i <= n; ++i) {
    if (i == v || cnt[i] <= m) continue;
    int sum = n;
    memset(fk, -1, sizeof(fk));
    fk[sum] = 0;
    for (int j = 1; j <= n; ++j) {
      if (a[j] == v)
        ++sum;
      else if (a[j] == i)
        --sum;
      if (fk[sum] == -1)
        fk[sum] = j;
      else
        ans = max(ans, j - fk[sum]);
    }
  }
  cout << ans << endl;
  return 0;
}
