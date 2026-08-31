#include <bits/stdc++.h>
using namespace std;
#pragma warning(disable : 4996)
const int N = 2e5 + 5;
long long h[N], s[N];
int w[N];
vector<int> g[N];
bool used[N];
void dfs(int node) {
  if (used[node]) return;
  used[node] = 1;
  vector<int> t;
  for (int to : g[node]) {
    dfs(to);
    t.push_back(w[to]);
  }
  sort(t.begin(), t.end());
  t.erase(unique(t.begin(), t.end()), t.end());
  while (w[node] < t.size() && t[w[node]] == w[node]) w[node]++;
  s[w[node]] ^= h[node];
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; i++) {
    cin >> h[i];
  }
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    a--, b--;
    g[a].push_back(b);
  }
  for (int i = 0; i < n; i++) {
    dfs(i);
  }
  int mx = -1;
  for (int i = 0; i < n; i++) {
    if (s[i] != 0) {
      mx = max(mx, i);
    }
  }
  if (mx != -1) {
    cout << "WIN\n";
    for (int i = 0; i < n; i++) {
      if (w[i] == mx && (s[mx] ^ h[i]) < h[i]) {
        h[i] = s[mx] ^ h[i];
        for (int to : g[i]) {
          if (s[w[to]] != 0) {
            h[to] = s[w[to]] ^ h[to];
            s[w[to]] = 0;
          }
        }
        break;
      }
    }
    for (int i = 0; i < n; i++) cout << h[i] << " ";
  } else {
    cout << "LOSE";
  }
  return 0;
}
