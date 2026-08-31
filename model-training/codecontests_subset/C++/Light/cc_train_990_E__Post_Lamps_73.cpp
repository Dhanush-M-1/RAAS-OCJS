#include <bits/stdc++.h>
using namespace std;
const int maxn = 2000000 + 10;
int n, m, K;
int a[maxn];
int maxlen;
bool block[maxn];
int last[maxn];
inline void init() {
  scanf("%d%d%d", &n, &m, &K);
  for (int i = 1, p; i <= m; i++) {
    scanf("%d", &p);
    block[p] = 1;
  }
  for (int i = 1; i <= K; i++) scanf("%d", &a[i]);
  int cnt = block[0];
  int pos = block[0] ? -1 : 0;
  for (int i = 1; i <= n; i++) {
    if (block[i])
      cnt++;
    else {
      maxlen = max(maxlen, cnt);
      cnt = 0;
      pos = i;
    }
    last[i] = pos;
  }
  for (int i = 1; i <= K; i++) last[n + i] = n;
}
inline void exec() {
  if (block[0] || maxlen >= K) {
    puts("-1");
    return;
  }
  long long ans = 1e18;
  for (int len = 1; len <= K; len++) {
    int pos = 0;
    long long res = 0;
    while (pos < n) {
      res += a[len];
      if (last[pos + len] <= pos) break;
      pos += len;
      pos = last[pos];
    }
    if (pos >= n) ans = min(ans, res);
  }
  printf("%lld\n", ans);
}
int main() {
  if (fopen("F.in", "r") != NULL) {
    freopen("F.in", "r", stdin);
    freopen("F.out", "w", stdout);
  }
  init();
  exec();
  return 0;
}
