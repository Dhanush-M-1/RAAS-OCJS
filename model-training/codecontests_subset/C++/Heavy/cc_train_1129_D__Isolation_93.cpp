#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long x = 0;
  int ch = getchar(), f = 1;
  while (!isdigit(ch) && (ch != '-') && (ch != EOF)) ch = getchar();
  if (ch == '-') {
    f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = (x << 1) + (x << 3) + ch - '0';
    ch = getchar();
  }
  return x * f;
}
const int N = 1e5 + 10, mod = 998244353;
int n, k, a[N], b[N], pos[N], Pos[N], dp[N];
int block, id[N], sum[320][700], Sum[320];
inline void Mod(int &x, int y) { x += y, x = (x >= mod) ? x - mod : x; }
inline void ReBuild(int pos) {
  int l = (pos - 1) * block + 1, r = min(n, pos * block), suf = block;
  for (register int i = (0); i <= (block << 1); i++) sum[pos][i] = 0;
  for (register int i = (r); i >= (l); i--)
    suf += b[i], Mod(sum[pos][suf], dp[i - 1]);
  for (register int i = (1); i <= (block << 1); i++)
    Mod(sum[pos][i], sum[pos][i - 1]);
  Sum[pos] = suf - block;
}
inline int Query(int x) {
  int pos = id[x], l = (pos - 1) * block + 1, suf = 0, ans = 0;
  for (register int i = (x); i >= (l); i--)
    suf += b[i], Mod(ans, (suf <= k) * dp[i - 1]);
  for (register int i = (pos - 1); i >= (1); i--) {
    if (k - suf + block >= 0)
      Mod(ans, sum[i][min(block << 1, k - suf + block)]);
    suf += Sum[i];
  }
  return ans;
}
int main() {
  n = read(), k = read(), block = sqrt(n);
  for (register int i = (1); i <= (n); i++)
    a[i] = read(), id[i] = (i - 1) / block + 1;
  dp[0] = 1;
  for (register int i = (1); i <= (n); i++) {
    b[i] = 1;
    if (pos[a[i]]) {
      if (Pos[a[i]]) b[Pos[a[i]]] = 0, ReBuild(id[Pos[a[i]]]);
      Pos[a[i]] = pos[a[i]], b[pos[a[i]]] = -1, ReBuild(id[pos[a[i]]]);
    }
    pos[a[i]] = i, dp[i] = Query(i);
    if (i != n && id[i + 1] != id[i]) ReBuild(id[i]);
  }
  printf("%d\n", dp[n]);
}
