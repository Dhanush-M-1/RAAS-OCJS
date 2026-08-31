#include <bits/stdc++.h>
using namespace std;
template <typename T>
bool chkmax(T &x, T y) {
  return x < y ? x = y, true : false;
}
template <typename T>
bool chkmin(T &x, T y) {
  return x > y ? x = y, true : false;
}
int readint() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x * f;
}
int n, s;
int a[200005], f[200005], to[200005];
pair<int, int> b[200005];
bool vis[200005];
vector<vector<int> > ans;
int getf(int x) { return x == f[x] ? x : f[x] = getf(f[x]); }
int main() {
  n = readint();
  s = readint();
  for (int i = 1; i <= n; i++) a[i] = readint(), b[i] = make_pair(a[i], i);
  sort(b + 1, b + n + 1);
  for (int i = 1; i <= n; i++) to[b[i].second] = i;
  for (int i = 1; i <= n; i++)
    while (i != to[i] && a[to[i]] == b[to[i]].first)
      swap(b[to[i]].second, b[to[to[i]]].second), swap(to[to[i]], to[i]);
  for (int i = 1; i <= n; i++) f[i] = i;
  int all = n, cnt = 0;
  for (int i = 1; i <= n; i++) {
    if (i == to[i]) all--;
    if (vis[i] || i == to[i]) continue;
    vis[i] = 1;
    cnt++;
    for (int j = to[i]; j != i; j = to[j]) vis[j] = 1, f[j] = i;
  }
  int lst = 0;
  for (int i = 1; i <= n; i++) {
    if (b[i].second == i) continue;
    if (!lst || b[i].first != b[lst].first) {
      lst = i;
      continue;
    }
    if (getf(b[lst].second) != getf(b[i].second)) {
      f[f[b[i].second]] = f[b[lst].second];
      swap(to[b[i].second], to[b[lst].second]);
      swap(b[i].second, b[lst].second);
      cnt--;
    }
  }
  if (all > s) return printf("-1\n"), 0;
  int tmp = s - all, num = 0;
  vector<int> now(0), rem(0);
  for (int i = 1; i <= n; i++) {
    if (i == to[i]) continue;
    if (i != f[i]) continue;
    now.push_back(i);
    for (int j = to[i]; j != i; j = to[j]) now.push_back(j);
    rem.push_back(i);
    num++;
    if (num >= tmp) {
      ans.push_back(now);
      reverse(rem.begin(), rem.end());
      if (rem.size() > 1) ans.push_back(rem);
      now.clear(), rem.clear();
    }
  }
  if (now.size()) ans.push_back(now);
  reverse(rem.begin(), rem.end());
  if (rem.size() > 1) ans.push_back(rem);
  printf("%d\n", ans.size());
  for (auto v : ans) {
    printf("%d\n", v.size());
    for (auto x : v) printf("%d ", x);
    printf("\n");
  }
  return 0;
}
