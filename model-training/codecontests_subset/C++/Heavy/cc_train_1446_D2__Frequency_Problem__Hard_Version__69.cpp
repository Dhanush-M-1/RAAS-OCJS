#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 9;
vector<int> g[N];
int a[N], cnt[N], b[N << 1], c[N << 1];
int *vis = b + N, *val = c + N;
set<int> S, now;
int main() {
  int n;
  scanf("%d", &n);
  for (int i = (1); i < (n + 1); ++i)
    scanf("%d", &a[i]), cnt[a[i]]++, g[a[i]].push_back(i);
  int maxn = 0, p = 0;
  for (int i = (1); i < (n + 1); ++i) {
    if (maxn < cnt[i]) {
      maxn = cnt[i];
      p = i;
    }
  }
  if (maxn == n) {
    puts("0");
    return 0;
  }
  int ans = 0;
  for (auto v : g[p]) S.insert(v);
  vector<int> temp;
  int key = 0;
  for (int i = (1); i < (n + 1); ++i) {
    if (p == i) continue;
    now.clear();
    temp.clear();
    for (auto v : g[i]) {
      auto it = S.lower_bound(v);
      if (it != S.end()) {
        now.insert(*it);
        S.erase(it);
      }
      it = S.lower_bound(v);
      if (it != S.end()) {
        now.insert(*it);
        S.erase(it);
      }
      it = S.lower_bound(v);
      if (it != S.begin()) {
        --it;
        now.insert(*it);
        S.erase(it);
      }
      it = S.lower_bound(v);
      if (it != S.begin()) {
        --it;
        now.insert(*it);
        S.erase(it);
      }
    }
    for (auto v : now) temp.push_back(v);
    for (auto v : g[i]) now.insert(v);
    int pos = -1, sum = 0;
    for (auto v : now) {
      if (v > pos) ++key;
      if (vis[sum] != key) {
        vis[sum] = key;
        val[sum] = v;
      }
      if (a[v] == p) ++sum;
      if (a[v] == i) --sum;
      auto it = S.lower_bound(v);
      if (it == S.end())
        pos = n + 1;
      else
        pos = *it;
      if (vis[sum] == key) {
        int l, r;
        int vv = val[sum];
        auto it = now.lower_bound(vv);
        if (it == now.begin())
          l = 0;
        else
          l = *prev(it);
        it = now.lower_bound(v);
        ++it;
        if (it == now.end())
          r = n + 1;
        else
          r = *it;
        ans = max(r - l - 1, ans);
      }
    }
    for (auto v : temp) S.insert(v);
  }
  printf("%d\n", ans);
}
