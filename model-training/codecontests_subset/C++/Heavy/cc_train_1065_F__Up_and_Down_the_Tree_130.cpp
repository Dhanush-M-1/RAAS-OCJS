#include <bits/stdc++.h>
using namespace std;
int n, k;
int p[1000001];
vector<int> c[1000001];
int dep[1000001];
int dep2cnt[1000001 + 1000001];
int depkleafcnt[1000001];
int depgekleafcnt[1000001];
int cntleaf[1000001];
int dp0[1000001];
int dp1[1000001];
void dfs(int u, int d) {
  dep[u] = d;
  if (c[u].empty()) {
    dep2cnt[d]++;
    cntleaf[u] = 1;
  }
  int tmp = dep2cnt[d + k];
  for (int v : c[u]) {
    dfs(v, d + 1);
    depgekleafcnt[u] += depgekleafcnt[v];
    cntleaf[u] += cntleaf[v];
  }
  depkleafcnt[u] = dep2cnt[d + k] - tmp;
  depgekleafcnt[u] += depkleafcnt[u];
}
void work(int u) {
  for (int v : c[u]) {
    work(v);
  }
  if (c[u].empty()) {
    dp0[u] = dp1[u] = 1;
    return;
  }
  if (cntleaf[u] == depgekleafcnt[u]) {
    dp0[u] = 0;
  } else {
    for (int v : c[u]) {
      dp0[u] += dp0[v];
    }
  }
  for (int v : c[u]) {
    if (cntleaf[v] > depgekleafcnt[v]) {
      dp1[u] += dp0[v];
    }
  }
  int delta = 0;
  for (int v : c[u]) {
    delta = max(delta, dp1[v] - dp0[v]);
  }
  dp1[u] += delta;
}
int main() {
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    cin >> p[i];
    c[p[i]].push_back(i);
  }
  dfs(1, 0);
  work(1);
  cout << dp1[1] << endl;
  return 0;
}
