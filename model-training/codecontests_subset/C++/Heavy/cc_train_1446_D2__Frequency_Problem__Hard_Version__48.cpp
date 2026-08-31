#include <bits/stdc++.h>
using namespace std;
const long long INF(0x3f3f3f3f3f3f3f3fll);
const long long inf(0x3f3f3f3f);
const long long N = 5e5 + 10;
long long n, a[N], cnt[N], vis[N];
long long s, c, ma, ans, pre[N], num[N];
void solve1(long long x) {
  long long sum = n;
  for (long long i = 1; i <= n; i++) pre[i] = pre[i + n] = inf;
  pre[n] = 0;
  for (long long i = 1; i <= n; i++) {
    if (a[i] == ma)
      sum++;
    else if (a[i] == x)
      sum--;
    ans = max(ans, i - pre[sum]);
    pre[sum] = min(pre[sum], i);
  }
}
void solve2(long long x) {
  for (long long i = 1; i <= n; i++) num[i] = 0;
  long long l = 1, res = 0;
  num[a[l]]++;
  if (num[a[l]] == x) res++;
  for (long long i = 2; i <= n; i++) {
    num[a[i]]++;
    if (num[a[i]] == x)
      res++;
    else if (num[a[i]] > x) {
      while (num[a[i]] > x && l <= i) {
        num[a[l]]--;
        if (num[a[l]] == x - 1) res--;
        l++;
      }
    }
    if (res >= 2) ans = max(ans, i - l + 1);
  }
}
signed main() {
  std::ios::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  cin >> n;
  s = sqrt(n), c = 0;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i], cnt[a[i]]++;
    if (cnt[a[i]] > c) c = cnt[a[i]], ma = a[i];
  }
  for (long long i = 1; i <= n; i++)
    if (cnt[a[i]] >= s && a[i] != ma && !vis[a[i]]) {
      solve1(a[i]);
      vis[a[i]] = 1;
    }
  for (long long i = 1; i <= s; i++) solve2(i);
  cout << ans << '\n';
  return 0;
}
