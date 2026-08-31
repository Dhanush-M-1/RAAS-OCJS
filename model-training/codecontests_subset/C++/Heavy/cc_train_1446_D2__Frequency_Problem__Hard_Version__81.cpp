#include <bits/stdc++.h>
using namespace std;
const int N = 250005, B = 500;
int las[N + N], vis[N + N];
int n, a[N], sum[N], cnt[N], ans = 0, rt;
void check(int x) {
  vis[n] = 1;
  for (int i = 1; i <= n; ++i) {
    if (a[i] == x)
      sum[i] = sum[i - 1] + 1;
    else if (a[i] == rt)
      sum[i] = sum[i - 1] - 1;
    else
      sum[i] = sum[i - 1];
    if (vis[sum[i] + n] != 0)
      ans = max(ans, i - las[sum[i] + n]);
    else
      vis[sum[i] + n] = 1, las[sum[i] + n] = i;
  }
  for (int i = -n; i <= n; ++i) vis[i + n] = las[i + n] = 0;
}
int shit[N];
void ins(int x, int v) {
  shit[cnt[x]]--;
  cnt[x] += v;
  shit[cnt[x]]++;
}
vector<int> vec;
signed main() {
  cin >> n;
  for (int i = 1; i <= n; ++i) cin >> a[i], cnt[a[i]]++;
  int c = *max_element(cnt + 1, cnt + n + 1), res = 0;
  for (int i = 1; i <= n; ++i)
    if (cnt[i] == c) ++res;
  if (res > 1) return cout << n, 0;
  for (int i = 1; i <= n; ++i)
    if (cnt[i] == c) rt = i;
  for (int i = 1; i <= n; ++i)
    if (i != rt && cnt[i] > B) vec.push_back(i);
  for (int v : vec) check(v);
  for (int i = 1; i <= B; ++i) {
    for (int j = 1; j <= n; ++j) cnt[j] = shit[j] = 0;
    int l = 1, r = 0;
    while (r < n) {
      ++r;
      ins(a[r], 1);
      while (l < r && cnt[a[r]] > i) ins(a[l], -1), ++l;
      if (shit[i] >= 2) ans = max(ans, r - l + 1);
    }
  }
  cout << ans;
  return 0;
}
