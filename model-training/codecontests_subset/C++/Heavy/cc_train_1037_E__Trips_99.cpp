#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 7;
int deg[N], del[N], u[N], v[N], aa[N], edg[N];
vector<pair<int, int> > adj[N];
int remove(queue<int> &q, int k) {
  int ans = 0;
  while (!q.empty()) {
    int x = q.front();
    q.pop();
    if (!del[x]) del[x] = 1, ans--;
    for (auto z : adj[x]) {
      int idx = z.second, y = z.first;
      if (edg[idx]) continue;
      edg[idx] = 1;
      deg[x]--;
      deg[y]--;
      if (deg[y] < k && !del[y]) {
        q.push(y);
      }
    }
  }
  return ans;
}
int main() {
  ios_base ::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  for (int i = 1; i <= m; i++) {
    cin >> u[i] >> v[i];
    adj[u[i]].push_back({v[i], i});
    adj[v[i]].push_back({u[i], i});
    deg[u[i]]++;
    deg[v[i]]++;
  }
  int ans = n;
  queue<int> q;
  for (int i = 1; i <= n; i++)
    if (deg[i] < k) q.push(i);
  ans += remove(q, k);
  for (int i = m; i >= 1; i--) {
    aa[i] = ans;
    if (edg[i]) continue;
    deg[u[i]]--;
    deg[v[i]]--;
    edg[i] = 1;
    if (!del[u[i]] && deg[u[i]] < k) q.push(u[i]);
    if (!del[v[i]] && deg[v[i]] < k) q.push(v[i]);
    ans += remove(q, k);
  }
  for (int i = 1; i <= m; i++) cout << aa[i] << "\n";
}
