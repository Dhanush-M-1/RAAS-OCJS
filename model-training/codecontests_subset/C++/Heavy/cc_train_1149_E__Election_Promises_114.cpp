#include <bits/stdc++.h>
using namespace std;
const int maxN = 200002;
int mex(vector<int>& cands) {
  static bool flags[maxN];
  for (int i = 0; i <= cands.size(); ++i) {
    flags[i] = false;
  }
  for (int x : cands) {
    flags[x] = true;
  }
  int res = 0;
  while (flags[res]) {
    ++res;
  }
  return res;
}
static bool used[maxN];
static int level[maxN];
static int xorSum[maxN];
static vector<int> edge[maxN];
static int h[maxN];
static int maxLevel = 0;
void dfs(int u) {
  if (used[u]) {
    return;
  }
  used[u] = true;
  vector<int> cands;
  for (int v : edge[u]) {
    dfs(v);
    cands.push_back(level[v]);
  }
  level[u] = mex(cands);
}
int main(int argc, char** argv) {
  std::ios::sync_with_stdio(false);
  for (int i = 0; i < maxN; ++i) {
    used[i] = false;
    level[i] = 0;
    xorSum[i] = 0;
  }
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; ++i) {
    cin >> h[i];
  }
  for (int i = 0; i < m; ++i) {
    int x, y;
    cin >> x >> y;
    edge[--x].push_back(--y);
  }
  for (int i = 0; i < n; ++i) {
    dfs(i);
  }
  for (int i = 0; i < n; ++i) {
    xorSum[level[i]] ^= h[i];
  }
  int maxLevel = n - 1;
  while (maxLevel >= 0 && xorSum[maxLevel] == 0) {
    --maxLevel;
  }
  if (maxLevel < 0) {
    cout << "LOSE" << endl;
    return 0;
  }
  int u = 0;
  while (level[u] != maxLevel || h[u] < (xorSum[maxLevel] ^ h[u])) {
    ++u;
  }
  h[u] = xorSum[maxLevel] ^ h[u];
  xorSum[maxLevel] = 0;
  for (int v : edge[u]) {
    if (xorSum[level[v]] != 0) {
      h[v] ^= xorSum[level[v]];
      xorSum[level[v]] = 0;
    }
  }
  cout << "WIN" << endl;
  for (int i = 0; i < n; ++i) {
    cout << h[i] << ' ';
  }
  cout << endl;
  return 0;
}
