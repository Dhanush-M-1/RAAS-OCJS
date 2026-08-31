#include <bits/stdc++.h>
using namespace std;
template <typename T>
void read(T &t) {
  char ch = getchar();
  int f = 1;
  t = 0;
  while ('0' > ch || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  do {
    (t *= 10) += ch - '0';
    ch = getchar();
  } while ('0' <= ch && ch <= '9');
  t *= f;
}
const int maxn = 1000010;
int n, m, k, mx, cnt[maxn];
bool d[maxn];
long long s[maxn], ans = 1LL << 60;
int main() {
  read(n);
  read(m);
  read(k);
  for (int i = 1; i <= m; i++) {
    int x;
    read(x);
    d[x] = 1;
  }
  if (d[0]) {
    printf("-1\n");
    return 0;
  }
  for (int i = 0; i < n; i++) {
    if (!d[i]) continue;
    cnt[i] = 1;
    if (i) cnt[i] += cnt[i - 1];
    mx = max(mx, cnt[i]);
  }
  for (int i = 1; i <= k; i++) read(s[i]);
  for (int i = 1; i <= k; i++) {
    int pos = 0, cntcnt = 0;
    while (pos < n) {
      if (d[pos]) {
        if (cnt[pos] == i) break;
        pos -= cnt[pos];
      } else {
        cntcnt++;
        pos += i;
      }
    }
    if (pos >= n) ans = min(ans, s[i] * cntcnt);
  }
  if (ans >= 1LL << 60) ans = -1;
  printf("%I64d\n", ans);
  return 0;
}
