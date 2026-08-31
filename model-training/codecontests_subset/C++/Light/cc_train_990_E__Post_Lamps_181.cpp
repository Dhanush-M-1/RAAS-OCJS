#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
const long long inf = 1e18;
int n, m, k;
int s[maxn], a[maxn];
int pos[maxn];
int lst[maxn];
int get_num(int x) {
  int r = 0, i = -1, res = 0;
  while (r < n) {
    if (lst[r] <= i)
      return -1;
    else {
      i = lst[r];
      r = lst[r] + x;
      ++res;
    }
  }
  return res;
}
int main() {
  while (scanf("%d%d%d", &n, &m, &k) != EOF) {
    fill(pos, pos + maxn, 1);
    memset(lst, 0, sizeof(lst));
    for (int i = 0; i < m; i++) scanf("%d", &s[i]);
    for (int i = 1; i <= k; i++) scanf("%d", &a[i]);
    for (int i = 0; i < m; i++) pos[s[i]] = 0;
    if (pos[0] == 0) {
      printf("-1\n");
      continue;
    } else {
      for (int i = 1; i < n; i++) {
        if (pos[i] == 1)
          lst[i] = i;
        else
          lst[i] = lst[i - 1];
      }
      long long mincost = inf;
      for (int i = 1; i <= k; i++) {
        int cnt = get_num(i);
        if (cnt == -1)
          continue;
        else {
          long long ans = (long long)cnt * a[i];
          if (mincost > ans) mincost = ans;
        }
      }
      if (mincost == inf)
        printf("-1\n");
      else
        printf("%I64d\n", mincost);
    }
  }
  return 0;
}
