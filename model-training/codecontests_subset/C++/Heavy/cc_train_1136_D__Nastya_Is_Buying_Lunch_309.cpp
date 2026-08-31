#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
int dx8[] = {0, 0, 1, 1, 1, -1, -1, -1};
int dy8[] = {1, -1, -1, 0, 1, -1, 0, 1};
int kx8[] = {1, 1, 2, 2, -1, -1, -2, -2};
int ky8[] = {2, -2, 1, -1, 2, -2, 1, -1};
long long poww(long long a, long long b) {
  if (b == 0) return 1;
  long long x = poww(a, b / 2);
  x = x * x;
  if (b % 2 == 1) x = x * a;
  return x;
}
long long bigmod(long long a, long long b, long long c) {
  if (b == 0) return 1 % c;
  long long x = bigmod(a, b / 2, c);
  x = x * x % c;
  if (b % 2 == 1) x = x * a % c;
  return x;
}
long long mod_inverse(long long a, long long mod) {
  return bigmod(a, mod - 2, mod);
}
const int M = 100005 * 3;
int idx[M], a[M];
set<int> adj[M], adjj[M];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    idx[a[i]] = i;
  }
  for (int i = 0; i < (m); i++) {
    int u, v;
    cin >> u >> v;
    adj[u].insert(idx[v]);
    adjj[v].insert(u);
  }
  int res = 0;
  for (int i = n - 1; i >= 1; i--) {
    int x = a[i];
    int cnt = n - i - res;
    for (auto y : adj[x]) {
      if (y > i) cnt--;
    }
    if (cnt == 0) {
      res++;
      for (auto y : adjj[x]) {
        adj[y].erase(adj[y].find(idx[x]));
      }
    }
  }
  cout << res << endl;
  return 0;
}
