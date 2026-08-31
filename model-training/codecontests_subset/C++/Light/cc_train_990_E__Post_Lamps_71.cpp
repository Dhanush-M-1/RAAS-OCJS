#include <bits/stdc++.h>
using namespace std;
const int N = 1000005;
const long long MOD = 1e9 + 7;
int dX[] = {0, 0, 1, -1};
int dY[] = {1, -1, 0, 0};
int n, m, k, cst[N], nearest[N];
long long ans;
bool block[N];
int calc(int S) {
  int cur = 0, ret = 0;
  while (cur < n) {
    ret++;
    if (cur + S >= n) return ret;
    if (cur == nearest[cur + S]) return 0;
    cur = nearest[cur + S];
  }
  return ret;
}
int main() {
  scanf("%d", &n);
  scanf("%d", &m);
  scanf("%d", &k);
  int x;
  for (int i = 0; i <= n; ++i) nearest[i] = i;
  for (int i = 0; i < m; ++i) {
    scanf("%d", &x);
    if (x == 0) return puts("-1");
    nearest[x] = nearest[x - 1];
  }
  for (int i = 1; i <= k; ++i) scanf("%d", &cst[i]);
  ans = 4000000000000000100;
  for (int i = 1; i <= k; ++i) {
    int cnt = calc(i);
    if (cnt) ans = min(ans, cnt * 1LL * cst[i]);
  }
  if (ans == 4000000000000000100)
    puts("-1");
  else
    printf("%lld", ans);
  return 0;
}
