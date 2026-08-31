#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5;
int n, s;
int a[maxn], b[maxn];
int idx[maxn];
bool CmpI(int i, int j) { return a[i] < a[j]; }
int p[maxn];
int Find(int x) { return x == p[x] ? x : p[x] = Find(p[x]); }
void Unite(int x, int y) { p[Find(x)] = Find(y); }
int _1[maxn], _2[maxn];
void Pre(void) {
  int cnt = 0;
  for (int i = 0; i < n; ++i) {
    if (a[i] != b[i]) idx[cnt++] = i;
  }
  sort(idx, idx + cnt, CmpI);
  int cur = 0;
  for (int i = 0; i < n; ++i) {
    if (a[i] != b[i])
      _1[idx[cur++]] = i;
    else
      _1[i] = i;
  }
}
int FindN(int i) {
  for (int j = i + 1; j < n; ++j) {
    if (a[j] == b[j]) continue;
    if (b[j] != b[i]) break;
    return j;
  }
  return -1;
}
void Solve(void) {
  for (int i = 0; i < n; ++i) p[i] = i;
  Pre();
  for (int i = 0; i < n; ++i) Unite(i, _1[i]);
  for (int i = 0; i < n; ++i) _2[_1[i]] = i;
  for (int i = 0; i < n; ++i) {
    if (a[i] == b[i]) continue;
    int j = FindN(i);
    if (j != -1) {
      if (Find(i) != Find(j)) {
        Unite(i, j);
        int i2 = _2[i], j2 = _2[j];
        _1[i2] = j;
        _1[j2] = i;
        _2[i] = j2;
        _2[j] = i2;
      }
    }
  }
}
int cnt_cycle, first[maxn];
bool vis[maxn];
void FindCycles(void) {
  cnt_cycle = 0;
  fill(first, first + n, -1);
  for (int i = 0; i < n; ++i) {
    if (a[i] == b[i]) continue;
    if (!vis[i]) {
      for (int u = _1[i];; u = _1[u]) {
        vis[u] = true;
        if (u == i) break;
      }
      first[cnt_cycle++] = i;
    }
  }
}
int main(void) {
  scanf("%d%d", &n, &s);
  for (int i = 0; i < n; ++i) {
    scanf("%d", a + i);
  }
  copy(a, a + n, b);
  sort(b, b + n);
  int self = 0;
  for (int i = 0; i < n; ++i) {
    self += a[i] == b[i];
  }
  Solve();
  int least = n - self;
  if (least > s) {
    puts("-1");
    return 0;
  }
  FindCycles();
  int merge = min(cnt_cycle, s - least);
  if (merge <= 2) {
    merge = 0;
  }
  vector<vector<int> > ans;
  if (merge) {
    ans.push_back(vector<int>());
    for (int i = 0; i < merge; ++i) {
      ans.back().push_back(first[i]);
    }
    ans.push_back(vector<int>());
    for (int i = merge - 1; i >= 0; --i) {
      for (int u = _1[first[i]];; u = _1[u]) {
        ans.back().push_back(u);
        if (u == first[i]) break;
      }
    }
  }
  for (int i = merge; i < cnt_cycle; ++i) {
    ans.push_back(vector<int>());
    for (int u = _1[first[i]];; u = _1[u]) {
      ans.back().push_back(u);
      if (u == first[i]) break;
    }
  }
  printf("%d\n", (int)ans.size());
  for (auto v : ans) {
    printf("%d\n", (int)v.size());
    for (auto p : v) {
      printf("%d ", p + 1);
    }
    puts("");
  }
}
