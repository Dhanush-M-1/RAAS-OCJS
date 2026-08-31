#include <bits/stdc++.h>
using namespace std;
vector<long long> disc;
const long long inf = 1e18;
struct edge {
  int to;
  long long cost;
};
vector<vector<edge> > g;
bool ok = true;
void dfs(int v) {
  for (edge& e : g[v]) {
    dfs(e.to);
    if (!ok) {
      return;
    }
    if (disc[e.to] > 0) {
      disc[v] += disc[e.to];
      disc[e.to] = 0;
    }
  }
  for (edge& e : g[v]) {
    if (disc[e.to] < 0) {
      long long d = -disc[e.to];
      if (e.cost >= (disc[v] + inf + d - 1) / d) {
        ok = false;
        break;
      }
      disc[v] -= d * e.cost;
    }
  }
  if (v == 0 && disc[v] < 0) {
    ok = false;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  disc.resize(n);
  for (int i = 0; i < n; ++i) {
    cin >> disc[i];
  }
  for (int i = 0; i < n; ++i) {
    long long val;
    cin >> val;
    disc[i] -= val;
  }
  g.resize(n);
  for (int i = 1; i < n; ++i) {
    int p;
    cin >> p;
    --p;
    long long cost;
    cin >> cost;
    g[p].push_back({i, cost});
  }
  ok = true;
  dfs(0);
  cout << (ok ? "YES\n" : "NO\n");
}
