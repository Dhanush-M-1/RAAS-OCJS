#include <bits/stdc++.h>
using namespace std;
const int N = 4e5;
int n, val[N + 5], cnt[N + 5], x, sum[N + 5], las[2 * N + 5], ans;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &val[i]), cnt[val[i]]++;
  for (int i = 1; i <= n; i++)
    if (cnt[i] > cnt[x]) x = i;
  int lim = sqrt(n) + 1;
  for (int i = 1; i <= n; i++)
    if (cnt[i] >= lim && i != x) {
      int y = i;
      for (int j = 1; j <= n; j++)
        if (val[j] == x)
          sum[j] = 1;
        else if (val[j] == y)
          sum[j] = -1;
        else
          sum[j] = 0;
      for (int j = 0; j <= 2 * n; j++) las[j] = -1;
      las[n] = 0;
      sum[0] = n;
      for (int j = 1; j <= n; j++) {
        sum[j] += sum[j - 1];
        if (las[sum[j]] != -1)
          ans = max(ans, j - las[sum[j]]);
        else
          las[sum[j]] = j;
      }
    }
  for (int i = 1; i < lim; i++) {
    for (int j = 1; j <= n; j++) sum[j] = 0;
    int l = 1, num = 0;
    for (int j = 1; j <= n; j++) {
      sum[val[j]]++;
      if (sum[val[j]] == i)
        num++;
      else
        while (sum[val[j]] > i) {
          if (sum[val[l]] == i) num--;
          sum[val[l]]--;
          l++;
        }
      if (num >= 2) ans = max(ans, j - l + 1);
    }
  }
  printf("%d", ans);
  return 0;
}
