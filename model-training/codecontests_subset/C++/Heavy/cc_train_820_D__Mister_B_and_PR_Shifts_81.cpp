#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000009;
int cnt[maxn << 2], p[maxn];
int n, L, R, lim, rec;
long long now, ans;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
void update(int x, int opt) {
  if (x <= lim)
    L += opt;
  else
    R += opt;
  cnt[x]++;
}
int main() {
  n = read();
  lim = n;
  for (int i = 1; i <= n; i++) {
    p[i] = read();
    now += abs(p[i] - i);
    update(p[i] - i + lim, 1);
  }
  ans = now;
  rec = 0;
  for (int i = n; i >= 2; i--) {
    update(p[i] - n + lim, -1);
    now -= abs(p[i] - n);
    now -= R;
    now += L;
    now += abs(p[i] - 1);
    lim++;
    R -= cnt[lim];
    L += cnt[lim];
    update(p[i] - 1 + lim, 1);
    if (now < ans) rec = n - i + 1, ans = now;
  }
  printf("%I64d %d\n", ans, rec);
  return 0;
}
