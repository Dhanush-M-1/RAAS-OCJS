#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
const int inf = 1e9;
bool block[maxn];
vector<int> go(maxn);
inline int get(int x, int n, int m) {
  int it = 0, pos = 0;
  if (m && block[0]) return inf;
  int res = 1;
  while (pos + x < n) {
    res++;
    int start = pos;
    pos += x;
    pos = go[pos];
    if (pos == start) return inf;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(nullptr);
  int n, m, k;
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; ++i) {
    int pos;
    scanf("%d", &pos);
    block[pos] = 1;
  }
  for (int i = 0; i <= n; ++i) {
    if (block[i]) {
      if (block[i - 1])
        go[i] = go[i - 1];
      else
        go[i] = i - 1;
    } else
      go[i] = i;
  }
  long long ans = -1;
  for (int i = 1; i <= k; ++i) {
    int cost;
    scanf("%d", &cost);
    int cnt = get(i, n, m);
    if (cnt != inf) {
      if (ans == -1)
        ans = 1LL * cnt * cost;
      else
        ans = min(ans, 1LL * cnt * cost);
    }
  }
  printf("%I64d", ans);
  return 0;
}
