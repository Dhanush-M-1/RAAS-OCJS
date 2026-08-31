#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long num = 0, neg = 1;
  char c = getchar();
  while (!isdigit(c)) {
    if (c == '-') neg = -1;
    c = getchar();
  }
  while (isdigit(c)) {
    num = (num << 3) + (num << 1) + c - '0';
    c = getchar();
  }
  return num * neg;
}
int p, lmt;
int n, cnt[200010], a[200010], sum[200010];
int exs[200010], exs1[200010], ans, first[400010];
vector<int> loc;
map<int, int> used;
inline bool check() {
  int mx = 0, tot = 0;
  for (int i = 1; i <= n; i++) {
    if (cnt[i] > mx) mx = cnt[i], tot = 0, p = i;
    if (cnt[i] == mx) tot++;
  }
  return tot > 1;
}
int main() {
  n = read();
  lmt = 400;
  for (int i = 1; i <= n; i++) {
    a[i] = read();
    cnt[a[i]]++;
  }
  if (check()) {
    printf("%d\n", n);
    return 0;
  }
  for (int i = 1; i <= n; i++)
    if (a[i] == p) loc.push_back(i);
  for (int u = 1; u <= n; u++)
    if (cnt[u] > lmt && u != p) {
      for (int i = 0; i <= 2 * n; i++) first[i] = n + 1;
      first[n] = 0, sum[0] = n;
      for (int i = 1; i <= n; i++) {
        sum[i] = sum[i - 1] + (a[i] == u) - (a[i] == p);
        if (first[sum[i]] <= n)
          ans = max(ans, i - first[sum[i]]);
        else
          first[sum[i]] = i;
      }
    }
  vector<pair<int, int> > seg;
  for (int len = 1; len <= lmt + 1; len++) {
    seg.clear();
    for (int i = 0; i < loc.size(); i++) {
      int j = i + len - 1;
      if (j >= loc.size()) break;
      int l = (i == 0 ? 1 : loc[i - 1] + 1),
          r = (j == loc.size() - 1 ? n : loc[j + 1] - 1);
      seg.push_back(make_pair(l, r));
    }
    int l = 1, r = 0, mx = 0;
    memset(exs, 0, sizeof(exs));
    memset(exs1, 0, sizeof(exs1));
    for (int i = 0; i < seg.size(); i++) {
      while (r < seg[i].second) {
        mx += 2;
        r++;
        if (a[r] != p) {
          exs1[exs[a[r]]]--;
          exs[a[r]]++;
          exs1[exs[a[r]]]++;
        }
        while (!exs1[mx] && mx) mx--;
      }
      while (l < seg[i].first) {
        mx += 2;
        if (a[l] != p) {
          exs1[exs[a[l]]]--;
          exs[a[l]]--;
          exs1[exs[a[l]]]++;
        }
        l++;
        while (!exs1[mx] && mx) mx--;
      }
      if (mx >= len) ans = max(ans, r - l + 1);
    }
  }
  cout << ans;
  return 0;
}
