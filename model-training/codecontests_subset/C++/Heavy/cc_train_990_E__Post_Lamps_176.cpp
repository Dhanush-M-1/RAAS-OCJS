#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 1e6 + 100;
const long long MOD = 1e9 + 7;
const long long INF = 1e18;
long long cost[MAXN];
bool block[MAXN];
long long le[MAXN];
int main(int argc, char const *argv[]) {
  long long n, m, p;
  while (cin >> n >> m >> p) {
    memset(block, 0, sizeof block);
    for (long long i = 0; i < m; ++i) {
      long long tem;
      scanf("%lld", &tem);
      block[tem] = 1;
    }
    for (long long i = 1; i <= p; ++i) scanf("%lld", &cost[i]);
    if (block[0]) {
      puts("-1");
      continue;
    }
    long long lb = 0, cur = 0;
    for (long long i = 0; i < n; ++i) {
      if (block[i]) {
        cur++;
        lb = max(lb, cur);
        le[i] = le[i - 1];
      } else {
        cur = 0;
        le[i] = i;
      }
    }
    long long ans = INF;
    for (long long i = lb + 1; i <= p; ++i) {
      long long cans = 0;
      for (long long j = 0; j < n; j += i) {
        if (block[j]) {
          j = le[j] - i;
          continue;
        }
        cans += cost[i];
      }
      ans = min(ans, cans);
    }
    if (ans == INF) {
      puts("-1");
    } else {
      printf("%lld\n", ans);
    }
  }
  return 0;
}
