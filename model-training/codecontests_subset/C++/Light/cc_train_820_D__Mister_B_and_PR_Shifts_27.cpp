#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long x = 0, f = 1;
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
long long n, p[2000200];
long long cnt[2], kind[2000200];
vector<long long> G[2000200];
long long ans = 1ll << 60, ret = -1, now;
void work(long long u) {
  now += abs(p[u] - u);
  if (p[u] <= u)
    cnt[0]++, kind[u] = 0;
  else
    cnt[1]++, kind[u] = 1;
  if (p[u] <= u) {
    G[n - u].push_back(u);
    if (p[u]) G[n - u + p[u]].push_back(u);
  } else {
    G[p[u] - u].push_back(u);
    G[p[u] - u + n - p[u]].push_back(u);
  }
}
int main() {
  n = read();
  for (long long i = 0; i < n; i++) p[i] = read() - 1;
  for (long long i = 0; i < n; i++) work(i);
  if (now < ans) ans = now, ret = 0;
  for (long long k = 1; k < n; k++) {
    long long sz = G[k].size();
    for (long long j = 0; j < sz; j++) {
      long long x = G[k][j];
      cnt[kind[x]]--;
      kind[x] ^= 1;
      if (kind[x] == 1) {
        now -= abs(n - 1 - p[x]), now += p[x];
        if (p[x] == 0) kind[x] ^= 1;
      } else
        now--;
    }
    now += cnt[0], now -= cnt[1];
    if (ans > now) ans = now, ret = k;
    for (long long j = 0; j < sz; j++) {
      long long x = G[k][j];
      cnt[kind[x]]++;
    }
  }
  printf("%lld %lld\n", ans, ret);
}
