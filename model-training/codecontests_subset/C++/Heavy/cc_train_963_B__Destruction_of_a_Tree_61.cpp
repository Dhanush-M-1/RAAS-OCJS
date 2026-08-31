#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int maxn = 2e5 + 5;
int n;
vector<int> adj[maxn];
int deg[maxn];
bool used[maxn];
int sz[maxn];
void dfsSize(int i, int p) {
  sz[i] = 1;
  for (int j : adj[i]) {
    if (j == p) continue;
    dfsSize(j, i);
    sz[i] += sz[j];
  }
}
vector<int> ans;
void dfs(int i, int p) {
  for (int j : adj[i]) {
    if (j == p) continue;
    if (!(sz[j] & 1)) {
      dfs(j, i);
    }
  }
  ans.push_back(i);
  for (int j : adj[i]) {
    if (j == p) continue;
    if (sz[j] & 1) {
      dfs(j, i);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  if (!(n & 1)) {
    cout << "NO\n";
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    int p;
    cin >> p;
    if (p != 0) {
      adj[i].push_back(p);
      adj[p].push_back(i);
      deg[i]++;
      deg[p]++;
    }
  }
  dfsSize(1, 1);
  dfs(1, 1);
  cout << "YES\n";
  for (int i : ans) {
    cout << i << '\n';
  }
}
