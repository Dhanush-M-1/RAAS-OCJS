#include <bits/stdc++.h>
using namespace std;
struct edge {
  long long to, cost;
  edge() {}
  edge(long long a, long long b) { to = a, cost = b; }
};
long long n;
long long a[100005], b[100005];
vector<edge> G[100005];
bool used[100005];
bool dfs(int v, long long s) {
  used[v] = true;
  s += b[v] - a[v];
  bool ret = false;
  if (G[v][0].cost >= 2) ret = true;
  if (used[G[v][0].to]) return s >= 0;
  return ret || dfs(G[v][0].to, s);
}
long long calc(long long v) {
  used[v] = true;
  long long ret = b[v] - a[v];
  for (auto e : G[v]) {
    long long res = calc(e.to);
    if (res >= 0)
      ret += res;
    else {
      if (abs(res) > 1e18 / e.cost) {
        cout << "NO" << endl;
        exit(0);
      }
      ret += res * e.cost;
    }
    if (ret < -2e17) {
      cout << "NO" << endl;
      exit(0);
    }
  }
  return ret;
}
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (long long(i) = (1); (i) <= (n); (i)++) cin >> b[i];
  for (long long(i) = (1); (i) <= (n); (i)++) cin >> a[i];
  long long x, k;
  for (long long(i) = (2); (i) <= (n); (i)++) {
    cin >> x >> k;
    G[x].push_back(edge(i, k));
  }
  if (calc(1) < 0) {
    cout << "NO" << endl;
    return 0;
  }
  for (long long(i) = (1); (i) <= (n); (i)++) {
    if (used[i]) continue;
    if (!dfs(i, 0)) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
