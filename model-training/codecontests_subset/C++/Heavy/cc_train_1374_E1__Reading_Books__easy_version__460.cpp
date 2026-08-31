#include <bits/stdc++.h>
const int factor_N = 10000005;
using namespace std;
int read() {
  char c = getchar();
  int x = 0, f = 1;
  for (; !isdigit(c); c = getchar())
    if (c == '-') f = -1;
  for (; isdigit(c); c = getchar()) x = x * 10 + c - 48;
  return x * f;
}
struct Node {
  int t, a, b;
};
const int N = 2e5 + 5;
int n, k;
int a[N], b[N], c[N];
int cnta, cntb, cntc, t, aa, bb;
int ans;
int main() {
  n = read();
  k = read();
  for (int i = (1); i <= (n); ++i) {
    t = read();
    aa = read();
    bb = read();
    if (aa == 0 && bb != 0)
      a[++cnta] = t;
    else if (aa != 0 && bb == 0)
      b[++cntb] = t;
    else if (aa == 1 && bb == 1)
      c[++cntc] = t;
  }
  if (cnta + cntc < k || cntb + cntc < k) {
    cout << -1 << endl;
    return 0;
  }
  sort(a + 1, a + 1 + cnta);
  sort(b + 1, b + 1 + cntb);
  sort(c + 1, c + 1 + cntc);
  int t = min(cnta, cntb);
  for (int i = 1; i <= k && i <= t; ++i) ans += a[i];
  for (int i = 1; i <= k && i <= t; ++i) ans += b[i];
  if (t < k) {
    for (int i = 1; i <= k - t; ++i) ans += c[i];
    int tt = k - t + 1;
    while (c[tt] < a[t] + b[t] && tt <= cntc)
      ans -= a[t], ans -= b[t], ans += c[tt], tt++, t--;
    cout << ans << endl;
    return 0;
  }
  int tt = 1;
  while (c[tt] < a[k] + b[k] && tt <= cntc) {
    ans -= a[k];
    ans -= b[k];
    ans += c[tt];
    tt++;
    k--;
  }
  cout << ans << endl;
  return 0;
}
