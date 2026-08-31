#include <bits/stdc++.h>
using namespace std;
int n, k;
vector<int> v[1000007];
int lvl[1000007];
int cnt[1000007];
int mndepth[1000007];
int noreturn[1000007];
void init(int vertex) {
  int sz = v[vertex].size();
  if (sz == 0) {
    cnt[vertex] = 1;
    mndepth[vertex] = lvl[vertex];
    return;
  }
  mndepth[vertex] = 1000007;
  for (int i = 0; i < sz; ++i) {
    int h = v[vertex][i];
    lvl[h] = lvl[vertex] + 1;
    init(h);
    if (mndepth[h] <= lvl[vertex] + k) {
      cnt[vertex] += cnt[h];
      mndepth[vertex] = min(mndepth[vertex], mndepth[h]);
    }
  }
}
void dfs(int vertex) {
  int sz = v[vertex].size();
  if (sz == 0) {
    noreturn[vertex] = 1;
    return;
  }
  for (int i = 0; i < sz; ++i) {
    dfs(v[vertex][i]);
  }
  for (int i = 0; i < sz; ++i) {
    int h = v[vertex][i];
    int aux = cnt[vertex];
    if (mndepth[h] <= lvl[vertex] + k) {
      aux -= cnt[h];
    }
    noreturn[vertex] = max(noreturn[vertex], aux + noreturn[h]);
  }
}
void input() {
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; ++i) {
    int x;
    scanf("%d", &x);
    v[x].push_back(i);
  }
}
void solve() {
  init(1);
  dfs(1);
  printf("%d\n", noreturn[1]);
}
int main() {
  ios_base ::sync_with_stdio(false);
  cin.tie(NULL);
  input();
  solve();
  return 0;
}
