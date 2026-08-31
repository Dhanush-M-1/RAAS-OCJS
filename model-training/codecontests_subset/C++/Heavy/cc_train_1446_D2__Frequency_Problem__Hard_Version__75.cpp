#include <bits/stdc++.h>
using namespace std;
const int maxn = 200005, maxt = 505;
int n, maxx, cnt, ans, S, val;
int a[maxn], tot[maxn], sum[maxn], t[maxn * 2], cnt1[maxn], cnt2[maxn];
vector<int> v;
inline void modify(int x, int v) {
  cnt2[cnt1[x]]--;
  cnt1[x] += v;
  cnt2[cnt1[x]]++;
}
int main() {
  scanf("%d", &n), S = sqrt(n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    tot[a[i]]++;
  }
  for (int i = 1; i <= n; i++) {
    if (tot[i] == maxx) cnt++;
    if (tot[i] > maxx) cnt = 1, maxx = tot[i];
  }
  if (cnt > 1) {
    printf("%d\n", n);
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    if (tot[i] == maxx)
      val = i;
    else if (tot[i] > S)
      v.push_back(i);
  }
  for (int i = 0; i < v.size(); i++) {
    int k = v[i];
    for (int j = 1; j <= n; j++)
      sum[j] = sum[j - 1] + (a[j] == k ? -1 : (a[j] == val ? 1 : 0));
    for (int j = -n; j <= n; j++) t[n + j] = 1000000000;
    for (int j = 1; j <= n; j++) {
      ans = max(ans, j - t[n + sum[j]] + 1);
      t[n + sum[j - 1]] = min(t[n + sum[j - 1]], j);
    }
  }
  for (int i = 1; i <= S; i++) {
    for (int j = 1; j <= n; j++) cnt1[j] = cnt2[j] = 0;
    int l = 1, r = 0;
    while (r < n) {
      r++, modify(a[r], 1);
      while (cnt1[a[r]] > i) modify(a[l], -1), l++;
      if (cnt2[i] >= 2) ans = max(ans, r - l + 1);
    }
  }
  printf("%d\n", ans);
  return 0;
}
