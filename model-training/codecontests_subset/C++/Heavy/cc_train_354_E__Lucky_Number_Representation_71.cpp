#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const double eps = 1e-8;
const double PI = acos(-1.0);
const int MAXN = 1e5 + 5;
const int MOD = 1e9 + 7;
int sgn(double x) {
  if (fabs(x) < eps) return 0;
  if (x < 0)
    return -1;
  else
    return 1;
}
long long pw(long long a, long long n, long long mod) {
  long long ret = 1;
  while (n) {
    if (n & 1) ret = ret * a % mod;
    a = a * a % mod;
    n >>= 1;
  }
  return ret;
}
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
int cnt4[20], cnt7[20];
long long ans[20];
bool dfs(long long n, int k) {
  if (n < 0) return false;
  if (!n) {
    memset(ans, 0, sizeof(ans));
    for (int i = k - 1; i >= 0; i--) {
      for (int j = 1; j <= cnt4[i]; j++) ans[j] = ans[j] * 10 + 4;
      for (int j = cnt4[i] + 1; j <= cnt4[i] + cnt7[i]; j++)
        ans[j] = ans[j] * 10 + 7;
      for (int j = cnt4[i] + cnt7[i] + 1; j <= 6; j++) ans[j] *= 10;
    }
    for (int i = 1; i <= 6; i++) printf("%I64d ", ans[i]);
    printf("\n");
    return true;
  }
  for (int i = 0; i <= 6; i++)
    for (int j = 0; i + j <= 6; j++)
      if ((4 * i + 7 * j) % 10 == n % 10) {
        cnt4[k] = i;
        cnt7[k] = j;
        if (dfs(n / 10 - (4 * i + 7 * j) / 10, k + 1)) return true;
      }
  return false;
}
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    long long n;
    scanf("%I64d", &n);
    if (!dfs(n, 0)) puts("-1");
  }
}
