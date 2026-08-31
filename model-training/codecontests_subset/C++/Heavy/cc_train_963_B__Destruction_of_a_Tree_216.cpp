#include <bits/stdc++.h>
using namespace std;
int p[200001];
vector<int> adj[200001];
int deg[200001];
int pt = 0;
int order[200001];
int ret[200001];
void dfs(int cur) {
  for (auto e : adj[cur]) dfs(e);
  order[++pt] = cur;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  if (n & 1)
    cout << "YES\n";
  else {
    cout << "NO\n";
    return 0;
  }
  int root = 0;
  for (int i = 1; i <= n; i++) {
    cin >> p[i];
    adj[p[i]].push_back(i);
    if (p[i] == 0)
      root = i;
    else {
      deg[p[i]]++;
      deg[i]++;
    }
  }
  dfs(root);
  vector<int> ret;
  vector<int> ret2;
  for (int i = 1; i <= n; i++) {
    int e = order[i];
    if (deg[e] % 2 == 0) {
      ret.push_back(e);
      deg[p[e]]--;
    } else
      ret2.push_back(e);
  }
  ret.insert(ret.end(), ret2.rbegin(), ret2.rend());
  for (int i = 0; i < n; i++) cout << ret[i] << '\n';
  return 0;
}
