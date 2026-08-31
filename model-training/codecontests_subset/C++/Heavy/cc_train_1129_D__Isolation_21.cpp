#include <bits/stdc++.h>
using namespace std;
namespace ywy {
inline int get() {
  int n = 0;
  char c;
  while ((c = getchar()) || 23333) {
    if (c >= '0' && c <= '9') break;
    if (c == '-') goto s;
  }
  n = c - '0';
  while ((c = getchar()) || 23333) {
    if (c >= '0' && c <= '9')
      n = n * 10 + c - '0';
    else
      return (n);
  }
s:
  while ((c = getchar()) || 23333) {
    if (c >= '0' && c <= '9')
      n = n * 10 - c + '0';
    else
      return (n);
  }
}
long long dp[100001];
int val[290][200001], tag[100001], f[100001], pre[100001], ints[100001],
    ld[100001];
long long ans = 0;
int k, n;
inline void add(int l, int r, int num) {
  int lbd = l / 350, rbd = r / 350;
  if (lbd == rbd) {
    for (register int i = l; i <= r; i++) {
      if (f[i] + tag[lbd] == k + 1 && num == -1)
        ans = (ans + dp[i]) % 998244353;
      if (f[i] + tag[lbd] == k && num == 1)
        ans = (ans + 998244353 - dp[i]) % 998244353;
      val[lbd][f[i] + 100000] =
          (val[lbd][f[i] + 100000] + 998244353 - dp[i]) % 998244353;
      f[i] += num;
      val[lbd][f[i] + 100000] = (val[lbd][f[i] + 100000] + dp[i]) % 998244353;
    }
    return;
  }
  for (register int i = l; i < (lbd + 1) * 350; i++) {
    if (f[i] + tag[lbd] == k + 1 && num == -1) ans = (ans + dp[i]) % 998244353;
    if (f[i] + tag[lbd] == k && num == 1)
      ans = (ans + 998244353 - dp[i]) % 998244353;
    val[lbd][f[i] + 100000] =
        (val[lbd][f[i] + 100000] + 998244353 - dp[i]) % 998244353;
    f[i] += num;
    val[lbd][f[i] + 100000] = (val[lbd][f[i] + 100000] + dp[i]) % 998244353;
  }
  for (register int i = rbd * 350; i <= r; i++) {
    if (f[i] + tag[rbd] == k + 1 && num == -1) ans = (ans + dp[i]) % 998244353;
    if (f[i] + tag[rbd] == k && num == 1)
      ans = (ans + 998244353 - dp[i]) % 998244353;
    val[rbd][f[i] + 100000] =
        (val[rbd][f[i] + 100000] + 998244353 - dp[i]) % 998244353;
    f[i] += num;
    val[rbd][f[i] + 100000] = (val[rbd][f[i] + 100000] + dp[i]) % 998244353;
  }
  for (register int i = lbd + 1; i < rbd; i++) {
    if (num == 1)
      ans = (ans + 998244353 - val[i][k - tag[i] + 100000]) % 998244353;
    if (num == -1) ans = (ans + val[i][k - tag[i] + 100001]) % 998244353;
    tag[i] += num;
  }
}
void ywymain() {
  n = get();
  k = get();
  ans = 1;
  dp[0] = 1;
  val[0][100000] = 1;
  for (register int i = 1; i <= n; i++) {
    ints[i] = get();
    pre[i] = ld[ints[i]];
    ld[ints[i]] = i;
  }
  for (register int i = 1; i <= n; i++) {
    add(pre[i], i - 1, 1);
    if (pre[i]) add(pre[pre[i]], pre[i] - 1, -1);
    dp[i] = ans;
    ans = (ans + dp[i]) % 998244353;
    val[i / 350][100000] = (val[i / 350][100000] + dp[i]) % 998244353;
  }
  cout << dp[n] << endl;
}
}  // namespace ywy
int main() {
  ywy::ywymain();
  return (0);
}
