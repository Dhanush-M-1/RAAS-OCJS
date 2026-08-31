#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y, long long m);
long long modInverse(long long n, long long m);
long long nCr(long long n, long long r, long long m);
long long ceiling(long long x, long long y);
bool sortbyth(const tuple<long long, int, int>& a,
              const tuple<long long, int, int>& b) {
  if (get<0>(a) != get<0>(b))
    return get<0>(a) > get<0>(b);
  else
    return get<1>(a) < get<1>(b);
}
int dx[] = {-1, -1, -1, 0, 1, 1, 1, 0};
int dy[] = {-1, 0, 1, 1, 1, 0, -1, -1};
void aksayushx() {
  int n;
  cin >> n;
  vector<vector<int>> adj(n);
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    --x;
    if (x >= 0) {
      adj[i].push_back(x);
      adj[x].push_back(i);
    }
  }
  vector<int> degree(n, 0);
  for (int i = 0; i < n; i++) degree[i] = (long long)adj[i].size();
  if (n % 2 == 0) {
    cout << "NO\n";
    return;
  }
  int root = -1;
  vector<int> ans, dep(n);
  vector<bool> seen(n, false);
  function<void(int, int, int)> dfs = [&](int x, int p, int d) {
    dep[x] = d;
    for (int i : adj[x]) {
      if (i != p) dfs(i, x, d + 1);
    }
  };
  dfs(0, 0, 0);
  priority_queue<pair<int, int>> q;
  for (int i = 0; i < n; i++) q.push({dep[i], i});
  while (!q.empty()) {
    pair<int, int> x = q.top();
    q.pop();
    if (seen[x.second] || degree[x.second] % 2) continue;
    seen[x.second] = true;
    ans.push_back(x.second + 1);
    for (int u : adj[x.second]) {
      if (seen[u]) continue;
      degree[u]--;
      q.push({dep[u], u});
    }
  }
  cout << "YES\n";
  for (int u : ans) cout << u << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  while (t--) aksayushx();
  return 0;
}
long long power(long long x, long long y, long long m) {
  long long res = 1;
  x = x % m;
  if (x == 0) return 0;
  while (y > 0) {
    if (y & 1) res = (res * x) % m;
    y = y >> 1;
    x = (x * x) % m;
  }
  return res;
}
long long modInverse(long long n, long long m) { return power(n, m - 2, m); }
long long ceiling(long long x, long long y) { return (x + y - 1) / y; }
