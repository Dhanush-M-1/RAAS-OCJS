#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 5;
const int mod = 998244353;
inline int read() {
  char c = getchar();
  int t = 0, f = 1;
  while (!isdigit(c)) {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (isdigit(c)) {
    t = (t << 3) + (t << 1) + (c ^ 48);
    c = getchar();
  }
  return t * f;
}
int n, len[maxn], t[20];
long long a[maxn], sum[20][20];
long long wmh[10], cnt;
void fenjie(long long x) {
  if (x == 0) {
    cnt = 1;
    wmh[1] = 0;
  }
  cnt = 0;
  while (x) {
    wmh[++cnt] = x % 10;
    x /= 10;
  }
  return;
}
long long p[20];
int main() {
  n = read();
  for (int i = 1; i <= n; i++) a[i] = read();
  p[0] = 1;
  for (int i = 1; i <= 19; i++) p[i] = p[i - 1] * 10 % mod;
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    fenjie(a[i]);
    len[i] = cnt;
    t[len[i]]++;
    for (int j = cnt; j >= 1; j--) sum[cnt][j] += wmh[j];
  }
  for (int i = 1; i <= n; i++) {
    fenjie(a[i]);
    for (int j = 1; j <= 10; j++) {
      if (!t[j]) continue;
      if (j <= cnt) {
        for (int k = cnt; k > j; k--) {
          ans = (ans + wmh[k] * p[j + k - 1] % mod * t[j] % mod) % mod;
        }
        for (int k = j; k >= 1; k--) {
          ans = ((ans + wmh[k] * p[k * 2 - 1] % mod * t[j] % mod) % mod +
                 sum[j][k] * p[k * 2 - 2] % mod) %
                mod;
        }
      } else {
        for (int k = j; k > cnt; k--) {
          ans = (ans + sum[j][k] * p[cnt + k - 1] % mod) % mod;
        }
        for (int k = cnt; k >= 1; k--) {
          ans = ((ans + wmh[k] * p[2 * k - 1] % mod * t[j] % mod) % mod +
                 sum[j][k] * p[k * 2 - 2] % mod) %
                mod;
        }
      }
    }
  }
  printf("%I64d\n", ans);
  return 0;
}
