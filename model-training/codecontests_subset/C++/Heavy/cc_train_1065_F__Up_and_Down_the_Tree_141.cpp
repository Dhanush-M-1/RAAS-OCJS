#include <bits/stdc++.h>
using namespace std;
void init() { ios_base::sync_with_stdio(0); }
const int duzo = 1000007;
vector<int> g[duzo];
int uciek[duzo], max_uciek[duzo], max_zost[duzo];
int n, k;
void dfs(int w) {
  if ((int)g[w].size() == 0) {
    uciek[w] = k;
    max_uciek[w] = max_zost[w] = 1;
    return;
  }
  int suma_uciek = 0;
  int gz = 0, gz_ucieki = 0;
  for (auto x : g[w]) {
    dfs(x);
    if (uciek[x]) {
      suma_uciek += max_uciek[x];
      gz = max(gz, max_zost[x] - max_uciek[x]);
      gz_ucieki = max(gz_ucieki, uciek[x]);
    } else {
      gz = max(gz, max_zost[x]);
    }
  }
  if (gz_ucieki) uciek[w] = gz_ucieki - 1;
  max_uciek[w] = suma_uciek;
  max_zost[w] = suma_uciek + gz;
}
int main() {
  init();
  cin >> n >> k;
  int oj;
  for (int i = 2; i <= n; ++i) {
    cin >> oj;
    g[oj].push_back(i);
  }
  dfs(1);
  cout << max_zost[1];
  return 0;
}
