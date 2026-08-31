#include <bits/stdc++.h>
using namespace std;
void read(long long &x) {
  char ch = getchar();
  x = 0;
  while (!isdigit(ch)) ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - 48, ch = getchar();
}
const long long N = 77;
long long n, k, f[N][N], g[N][N];
pair<long long, pair<long long, long long> > a[N];
vector<long long> res, ans;
signed main() {
  long long T;
  read(T);
  while (T--) {
    read(n), read(k);
    k = min(k, n);
    for (long long i = 1; i <= n; ++i)
      read(a[i].second.first), read(a[i].first), a[i].second.second = i;
    if (k == 1) {
      puts("1");
      long long w = 0;
      for (long long i = 1; i <= n; ++i)
        if (a[i].second.first > a[w].second.first) w = i;
      printf("%lld\n", w);
      continue;
    }
    sort(a + 1, a + n + 1);
    memset(f, 0xcf, sizeof(f));
    f[0][0] = 0;
    for (long long i = 1; i <= n; ++i)
      for (long long j = 0; j <= i && j <= k; ++j) {
        if (j && f[i][j] <
                     f[i - 1][j - 1] + a[i].second.first + a[i].first * (k - 1))
          f[i][j] = f[i - 1][j - 1] + a[i].second.first + a[i].first * (j - 1),
          g[i][j] = 1;
        if (f[i][j] < f[i - 1][j] + a[i].first * (k - 1))
          f[i][j] = f[i - 1][j] + a[i].first * (k - 1), g[i][j] = 0;
      }
    res.clear();
    ans.clear();
    for (long long i = n, j = k; i; --i) {
      if (g[i][j])
        res.push_back(a[i].second.second), --j;
      else
        ans.push_back(a[i].second.second);
    }
    reverse(res.begin(), res.end());
    printf("%lld\n", (long long)res.size() + ans.size() * 2);
    for (long long i = 0; i < k - 1; ++i) printf("%lld ", res[i]);
    for (long long i : ans) printf("%lld %lld ", i, -i);
    printf("%lld\n", res[k - 1]);
  }
  return 0;
}
