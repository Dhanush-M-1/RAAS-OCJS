#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
const int mod = 1e9 + 7;
int n, a, b, p[maxn], sum[maxn], nex[maxn][21], ans, l;
inline int read() {
  int x = 0, f = 1;
  char c = getchar();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 1) + (x << 3) + c - '0';
    c = getchar();
  }
  return x * f;
}
string s[maxn];
int main() {
  n = read(), a = read(), b = read() + 1;
  for (int i = 1; i <= n; i++) cin >> s[i], p[i] = s[i].size() + 1;
  for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + p[i];
  for (int i = 1; i <= n; i++)
    nex[i][0] = upper_bound(sum + 1, sum + n + 1, sum[i - 1] + b) - sum;
  nex[n + 1][0] = n + 1;
  for (int i = 1; i <= 20; i++)
    for (int j = 1; j <= n + 1; j++) nex[j][i] = nex[nex[j][i - 1]][i - 1];
  for (int i = 1; i <= n; i++) {
    int r = i;
    for (int j = 0; j <= 20; j++)
      if (a >> j & 1) r = nex[r][j];
    if (ans < r - i) ans = r - i, l = i;
  }
  while (ans) {
    for (int i = l; i < nex[l][0]; i++)
      cout << s[i] << (i == nex[l][0] - 1 ? '\n' : ' ');
    ans -= nex[l][0] - l;
    l = nex[l][0];
  }
  return 0;
}
