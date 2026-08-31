#include <bits/stdc++.h>
using namespace std;
const int MAX = 5 * (1e5 + 1);
int n, m, p[MAX], u[MAX], v[MAX];
int marked[MAX];
vector<int> adj[MAX];
set<int> tb;
int main() {
  cin >> n >> m;
  for (int i = 0; i < n; i++) cin >> p[i];
  for (int i = 0; i < m; i++) {
    int x, y;
    cin >> x >> y;
    adj[y].push_back(x);
  }
  memset(marked, 0, sizeof(marked));
  int t = p[n - 1], ans = 0;
  for (int i : adj[t]) tb.insert(i);
  for (int i = n - 2; i >= 0; i--) {
    if (tb.find(p[i]) != tb.end())
      if (marked[p[i]] == n - 2 - i - ans) {
        ans++;
        continue;
      }
    for (int j : adj[p[i]]) marked[j]++;
  }
  cout << ans;
}
