#include <bits/stdc++.h>
using namespace std;
template <typename T>
void out(T x) {
  cout << x << endl;
  exit(0);
}
const int maxn = 1e6 + 5;
vector<int> g[maxn];
int n, k;
int nfree[maxn];
int npay[maxn];
int depth[maxn];
void dfs(int at) {
  if (g[at].empty()) {
    depth[at] = 0;
    nfree[at] = 1;
    npay[at] = 0;
    return;
  }
  depth[at] = 1e9;
  int finale = 0;
  int tot = 0;
  for (int to : g[at]) {
    dfs(to);
    depth[at] = min(depth[at], 1 + depth[to]);
    finale = max(finale, npay[to]);
    tot += nfree[to];
  }
  npay[at] = finale;
  if (depth[at] < k) {
    nfree[at] += tot;
  } else {
    npay[at] += tot;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  for (int i = 1; i < n; i++) {
    int p;
    cin >> p;
    --p;
    g[p].push_back(i);
  }
  dfs(0);
  cout << nfree[0] + npay[0] << endl;
  return 0;
}
