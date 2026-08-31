#include <bits/stdc++.h>
using namespace std;
int const MAX = 4e5 + 41;
int n, s;
int a[MAX];
int b[MAX];
int c[MAX];
vector<int> e[MAX];
vector<vector<int> > ans;
set<int> poses[MAX];
int cnt;
int u[MAX];
int lp[MAX];
int rp[MAX];
vector<int> getposes(vector<int> st) {
  reverse(st.begin(), st.end());
  vector<int> res;
  for (int i = 0; i <= (int)st.size() - 2; i++) {
    int x = st[i];
    int y = st[(i + 1)];
    assert((int)poses[y].size());
    int p = (*poses[y].lower_bound(lp[x]));
    assert(lp[x] <= p && rp[x] >= p);
    res.push_back(p);
    poses[y].erase(p);
  }
  return res;
}
vector<int> st;
void dfs(int x) {
  u[x] = 1;
  while ((int)e[x].size()) {
    int y = e[x].back();
    e[x].pop_back();
    dfs(y);
  }
  st.push_back(x);
}
void go(int *a, vector<int> v) {
  int vn = a[v.back()];
  for (int i = (int)v.size() - 1; i >= 1; i--) {
    a[v[i]] = a[v[i - 1]];
  }
  a[v[0]] = vn;
}
void proceed(int *a, vector<vector<int> > ans) {
  for (int i = 0; i <= (int)ans.size() - 1; i++) {
    go(a, ans[i]);
  }
}
void solve() {
  vector<int> v;
  for (int i = 1; i <= n; i++) {
    v.push_back(a[i]);
  }
  sort(v.begin(), v.end());
  v.resize(unique(v.begin(), v.end()) - v.begin());
  for (int i = 1; i <= n; i++) {
    b[i] = (int)(lower_bound(v.begin(), v.end(), a[i]) - v.begin());
  }
  memcpy(c, b, sizeof(c));
  sort(c + 1, c + n + 1);
  for (int i = 1; i <= n; i++) {
    rp[c[i]] = i;
  }
  for (int i = n; i >= 1; i--) {
    lp[c[i]] = i;
  }
  for (int i = 1; i <= n; i++) {
    if (b[i] == c[i]) continue;
    e[c[i]].push_back(b[i]);
    poses[b[i]].insert(i);
  }
  vector<vector<int> > cycles;
  for (int i = 0; i <= (int)v.size() - 1; i++) {
    if ((int)e[i].size()) {
      st.clear();
      dfs(i);
      cycles.push_back(st);
    }
  }
  int sum = 0;
  for (int i = 0; i <= (int)cycles.size() - 1; i++) {
    sum += (int)cycles[i].size() - 1;
  }
  if (sum > s) {
    printf("-1\n");
    return;
  }
  int rem = s - sum - 1;
  if (rem) {
    rem = min(rem, (int)cycles.size() - 1);
  }
  vector<int> swaps;
  if (rem) {
    for (int i = 0; i <= rem; i++) {
      int pos = (*poses[cycles[i][0]].begin());
      swaps.push_back(pos);
    }
  }
  if ((int)swaps.size()) {
    go(b, swaps);
    ans.push_back(swaps);
  }
  for (int i = 0; i <= (int)v.size() - 1; i++) {
    poses[i].clear();
  }
  for (int i = 1; i <= n; i++) {
    if (b[i] == c[i]) continue;
    e[c[i]].push_back(b[i]);
    poses[b[i]].insert(i);
  }
  int cnt = 0;
  for (int i = 0; i <= (int)v.size() - 1; i++) {
    if ((int)e[i].size()) {
      cnt++;
      st.clear();
      dfs(i);
      ans.push_back(getposes(st));
    }
  }
  printf("%d\n", (int)ans.size());
  for (int i = 0; i <= (int)ans.size() - 1; i++) {
    printf("%d\n", (int)ans[i].size());
    for (int x : ans[i]) {
      printf("%d ", x);
    }
    printf("\n");
  }
}
int main() {
  scanf("%d %d", &n, &s);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
  }
  solve();
  return 0;
}
