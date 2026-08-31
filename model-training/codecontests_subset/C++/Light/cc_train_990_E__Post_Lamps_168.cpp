#include <bits/stdc++.h>
using namespace std;
long long n, m, k, a, ans = 1e18;
const long long INF = 1e18;
const int N = 1e6 + 5;
int lst[N], sz[N];
long long cnt(int l) {
  int r = 0, i = -1;
  long long rs = 0;
  while (r < n) {
    if (lst[r] <= i) return INF;
    rs++;
    i = lst[r];
    r = lst[r] + l;
  }
  return rs;
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; i++) {
    scanf("%d", &a);
    lst[a] = -1;
  }
  if (lst[0] == -1) {
    cout << -1;
    return 0;
  }
  for (int i = 0; i < k; i++) scanf("%d", &sz[i]);
  for (int i = 0; i <= n; i++)
    if (lst[i] != -1)
      lst[i] = i;
    else
      lst[i] = lst[i - 1];
  for (int l = 0; l < k; l++) {
    long long t = cnt(l + 1);
    if (t != INF) ans = min(ans, t * sz[l]);
  }
  ans = (ans == INF) ? -1 : ans;
  cout << ans;
  return 0;
}
