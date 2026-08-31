#include <bits/stdc++.h>
using namespace std;
template <typename T>
void in(T &x) {
  T c = getchar();
  while (((c < 48) || (c > 57)) && (c != '-')) c = getchar();
  bool neg = false;
  if (c == '-') neg = true;
  x = 0;
  for (; c < 48 || c > 57; c = getchar())
    ;
  for (; c > 47 && c < 58; c = getchar()) x = (x * 10) + (c - 48);
  if (neg) x = -x;
}
const int MAXN = 1e6 + 10;
const long long INF = 1e15;
bool blocked[MAXN];
int cost[MAXN];
int R[MAXN];
int n, m, k;
int main() {
  in(n), in(m), in(k);
  for (int i = 0; i < m; i++) {
    int p;
    in(p);
    blocked[p] = true;
  }
  if (blocked[0]) {
    puts("-1");
    return 0;
  }
  for (int i = 1; i <= k; i++) {
    in(cost[i]);
  }
  int rt = -1;
  for (int i = n; i >= 0; i--) {
    if (blocked[i] == false) {
      rt = i;
    }
    R[i] = rt;
  }
  long long ans = INF;
  for (int j = 1; j <= k; j++) {
    bool ok = true;
    long long cnt = 0;
    for (int pos = n; pos > 0;) {
      int nxt = max(0, pos - j);
      if (R[nxt] == -1 || R[nxt] >= pos) {
        ok = false;
        break;
      }
      pos = R[nxt];
      cnt++;
    }
    if (ok) ans = min(ans, cnt * cost[j]);
  }
  printf("%lld\n", ans == INF ? -1ll : ans);
  return 0;
}
