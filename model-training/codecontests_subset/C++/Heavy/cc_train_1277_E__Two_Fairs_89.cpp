#include <bits/stdc++.h>
using namespace std;
const long long N = 2e5 + 1;
vector<long long> v[N];
vector<long long> vis(N);
long long cnt = 0;
void dfs(long long x, long long p) {
  vis[x] = 1;
  cnt++;
  for (auto i : v[x]) {
    if (i == p) continue;
    if (vis[i] == 1) continue;
    dfs(i, x);
  }
}
vector<long long> bfs(long long a, long long b, long long n) {
  vector<long long> vis(n + 1, 0);
  set<long long> s;
  for (auto x : v[b]) s.insert(x);
  queue<long long> q;
  q.push(a);
  vis[a] = 1;
  while (!q.empty()) {
    long long x = q.front();
    q.pop();
    for (auto i : v[x]) {
      if (vis[i]) continue;
      if (i == b) {
        s.erase(x);
      } else {
        q.push(i);
        vis[i] = 1;
      }
    }
  }
  vector<long long> res;
  for (auto x : s) res.push_back(x);
  return res;
}
void solve() {
  long long n, m, a, b;
  cin >> n >> m >> a >> b;
  for (long long i = 0; i < m; i++) {
    long long x, y;
    cin >> x >> y;
    v[x].push_back(y);
    v[y].push_back(x);
  }
  vector<long long> vb = bfs(a, b, n);
  vector<long long> va = bfs(b, a, n);
  v[b] = vb;
  v[a] = va;
  long long ans = 0;
  for (long long i = 1; i < n + 1; i++) vis[i] = 0;
  cnt = 0;
  dfs(a, a);
  ans = (cnt - 1);
  cnt = 0;
  dfs(b, b);
  ans *= (cnt - 1);
  cout << ans << endl;
  for (long long i = 0; i < n + 1; i++) v[i].clear();
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tc;
  cin >> tc;
  while (tc--) solve();
}
