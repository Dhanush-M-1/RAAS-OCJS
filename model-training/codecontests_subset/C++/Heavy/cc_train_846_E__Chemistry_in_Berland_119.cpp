#include <bits/stdc++.h>
using namespace std;
const int MXN = 1e5 + 1;
set<pair<long long, long long> > adj, g[MXN];
long long N, B[MXN], A[MXN];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> N;
  for (int x = 0, qwe = N; x < qwe; x++) cin >> B[x];
  for (int x = 0, qwe = N; x < qwe; x++) cin >> A[x], A[x] -= B[x];
  for (int x = 1, qwe = N; x < qwe; x++) {
    int xj, kj;
    cin >> xj >> kj;
    xj--;
    g[x].insert({xj, 1});
    g[xj].insert({x, kj});
  }
  for (int x = 0, qwe = N; x < qwe; x++) adj.insert({((int)(g[x]).size()), x});
  bool valid = 1;
  while (adj.size() > 1) {
    int u = adj.begin()->second;
    adj.erase(adj.begin());
    int v = g[u].begin()->first;
    long long other_c = g[v].lower_bound({u, 0})->second;
    g[v].erase(g[v].lower_bound({u, 0}));
    adj.erase({((int)(g[v]).size()) + 1, v});
    adj.insert({((int)(g[v]).size()), v});
    if (A[u] <= 0)
      A[v] += A[u] / g[u].begin()->second;
    else {
      long long val = other_c * A[u];
      if (other_c == 0 || val / other_c == A[u])
        A[v] += other_c * A[u];
      else
        valid = 0;
      valid &= A[v] <= 2 * 1e17;
    }
  }
  valid &= A[adj.begin()->second] <= 0;
  cout << (valid ? "YES" : "NO") << "\n";
}
