#include <bits/stdc++.h>
using namespace std;
long long read() {
  long long ans = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) ans = (ans * 10) + (ch ^ '0'), ch = getchar();
  return ans * f;
}
struct node {
  long long a, b;
  bool operator<(const node &x) const { return b > x.b; }
} c[110];
long long n, ans, suma, sumb, k = 0, f[15000][110];
signed main() {
  n = read();
  for (long long i = 1; i <= n; i++) {
    c[i].a = read(), suma += c[i].a;
  }
  for (long long i = 1; i <= n; i++) c[i].b = read();
  sort(c + 1, c + 1 + n);
  while (sumb < suma) sumb += c[++k].b;
  memset(f, 128, sizeof(f));
  f[0][0] = 0;
  printf("%lld ", k);
  for (long long i = 1; i <= n; i++)
    for (long long j = sumb; j >= c[i].b; j--)
      for (long long kk = 1; kk <= k; kk++)
        f[j][kk] = max(f[j][kk], f[j - c[i].b][kk - 1] + c[i].a);
  for (long long i = suma; i <= sumb; i++) ans = max(ans, f[i][k]);
  cout << suma - ans;
  return 0;
}
