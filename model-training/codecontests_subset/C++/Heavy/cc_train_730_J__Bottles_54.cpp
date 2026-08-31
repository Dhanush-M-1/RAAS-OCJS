#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1.0);
const long double eps = 1e-10;
const int INF = 0x3f3f3f3f;
const long long LINF = 0x3f3f3f3f3f3f3f3f;
const int MX = 100 + 7;
const int mod = 1e9 + 7;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long quimod(long long a, long long k) {
  long long res = 1;
  while (k) {
    if (k & 1) res = (res * a) % mod;
    a = (a * a) % mod;
    k >>= 1;
  }
  return res;
}
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
struct node {
  int r, v;
  inline bool operator<(const node& w) const { return v > w.v; }
} a[MX];
int dp[MX][MX * MX];
int main() {
  memset(dp, -1, sizeof(dp));
  ;
  int n;
  scanf("%d", &n);
  int tot_r = 0, tot_v = 0;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i].r);
    tot_r += a[i].r;
  }
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i].v);
    tot_v += a[i].v;
  }
  sort(a + 1, a + 1 + n);
  int now = 0;
  int num = 0;
  for (int i = 1; i <= n; ++i) {
    now += a[i].v;
    if (now >= tot_r) {
      num = i;
      break;
    }
  }
  dp[0][0] = 0;
  for (int i = 1; i <= n; ++i) {
    for (int j = num; j > 0; --j) {
      for (int k = tot_v; k >= a[i].v; --k) {
        if (dp[j - 1][k - a[i].v] != -1)
          dp[j][k] = max(dp[j][k], dp[j - 1][k - a[i].v] + a[i].r);
      }
    }
  }
  int res = 0;
  for (int i = tot_r; i <= tot_v; ++i) {
    res = max(res, dp[num][i]);
  }
  printf("%d %d\n", num, tot_r - res);
  return 0;
}
