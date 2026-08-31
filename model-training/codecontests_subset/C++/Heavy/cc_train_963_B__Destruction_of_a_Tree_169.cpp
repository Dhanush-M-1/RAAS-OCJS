#include <bits/stdc++.h>
#pragma GCC optimize("O3")
#pragma GCC target("sse4")
using namespace std;
const double PI = acos(-1.0);
const double EPS = 1e-6;
const long long INF = 1e9;
const long long LINF = 1e18;
const long long mod = 1e9 + 9;
const long long MAX = 2e5 + 47;
int root;
vector<int> g[MAX];
bool A[MAX], IS[MAX];
void dfs(int v, int par, bool d) {
  if (d) {
    cout << v << '\n';
    IS[v] = false;
    for (int to : g[v])
      if (to != par && IS[to]) dfs(to, v, 1);
    return;
  }
  for (int to : g[v]) {
    if (to != par && IS[to]) {
      dfs(to, v, d);
      A[v] ^= (A[to] ^ 1) && IS[to];
    }
  }
  if (A[v] ^ (v == root)) {
    cout << v << '\n';
    IS[v] = false;
    for (int to : g[v])
      if (to != par && IS[to]) dfs(to, v, 1);
  }
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  if (!(n & 1)) {
    cout << "NO";
    return 0;
  }
  for (int i = (1); i < (n + 1); ++i) {
    IS[i] = true;
    int p;
    cin >> p;
    if (p) {
      g[p].push_back(i);
      g[i].push_back(p);
    } else
      root = i;
  }
  cout << "YES\n";
  dfs(root, -1, 0);
  return 0;
}
