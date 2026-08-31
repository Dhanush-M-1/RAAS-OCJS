#include <bits/stdc++.h>
using namespace std;
const int N = 2e5;
const int M = 1e4;
const int mod = 1e9 + 7;
const int inf = 1e9;
int read() {
  int s = 0;
  register bool neg = 0;
  register char c = getchar();
  for (; c < '0' || c > '9'; c = getchar()) neg |= (c == '-');
  for (; c >= '0' && c <= '9'; s = s * 10 + (c ^ 48), c = getchar())
    ;
  s = (neg ? -s : s);
  return s;
}
int a, s[N + 5], cnt[N + 5], p[N * 2 + 5], q[N + 5];
signed main() {
  a = read();
  int mx = 0;
  for (int i = (1); i <= (a); ++i)
    s[i] = read(), ++cnt[s[i]], mx = max(mx, s[i]);
  int x = 0, y = 0;
  for (int i = (1); i <= (mx); ++i) {
    if (cnt[i] > cnt[x]) {
      x = i;
      y = 1;
    } else if (cnt[i] == cnt[x])
      ++y;
  }
  if (y >= 2) {
    printf("%d", a);
    return 0;
  }
  if (cnt[x] == a) {
    printf("0");
    return 0;
  }
  int b = sqrt(a), ans = 0;
  for (int i = (1); i <= (mx); ++i) {
    if (cnt[i] <= b || i == x) continue;
    memset(p, 0, sizeof(p));
    int now = 0;
    for (int j = (1); j <= (a); ++j) {
      now += (s[j] == x);
      now -= (s[j] == i);
      if (!now) ans = max(ans, j);
      if (!p[now + a])
        p[now + a] = j;
      else
        ans = max(ans, j - p[now + a]);
    }
  }
  memset(p, 0, sizeof(p));
  for (int i = (1); i <= (b); ++i) {
    memset(p, 0, sizeof(p));
    memset(q, 0, sizeof(q));
    for (int l = 1, r = 1; r <= a; ++r) {
      if (p[s[r]]) --q[p[s[r]]];
      ++p[s[r]];
      ++q[p[s[r]]];
      while (l <= r && p[s[r]] > i) {
        --q[p[s[l]]];
        --p[s[l]];
        ++q[p[s[l]]];
        ++l;
      }
      if (q[i] >= 2) ans = max(ans, r - l + 1);
    }
  }
  printf("%d", ans);
  return 0;
}
