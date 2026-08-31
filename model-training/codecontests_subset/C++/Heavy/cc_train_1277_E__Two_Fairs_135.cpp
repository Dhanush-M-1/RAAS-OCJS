#include <bits/stdc++.h>
using namespace std;
vector<long long int> adj[200001];
long long int vis[200001];
long long int co[200001][2];
long long int ind, x;
long long int dfs(long long int no) {
  for (long long int j = 0; j < adj[no].size(); j++) {
    long long int i = adj[no][j];
    if (vis[i] == 1) {
      continue;
    }
    if (i == x) {
      continue;
    }
    vis[i] = 1;
    co[i][ind]++;
    dfs(i);
  }
  return 0;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, m, aa, bb;
    cin >> n >> m >> aa >> bb;
    long long int ac, bc;
    aa--;
    bb--;
    for (long long int i = 0; i < n; i++) {
      adj[i].clear();
    }
    for (long long int i = 0; i < m; i++) {
      cin >> ac >> bc;
      adj[ac - 1].push_back(bc - 1);
      adj[bc - 1].push_back(ac - 1);
    }
    for (long long int i = 0; i < n; i++) {
      vis[i] = 0;
      co[i][0] = 0;
      co[i][1] = 0;
    }
    x = bb;
    ind = 0;
    vis[aa] = 1;
    dfs(aa);
    for (long long int i = 0; i < n; i++) {
      vis[i] = 0;
    }
    x = aa;
    ind = 1;
    vis[bb] = 1;
    dfs(bb);
    long long int coo[2];
    coo[0] = 0;
    coo[1] = 0;
    for (long long int i = 0; i < n; i++) {
      if (co[i][0] == 1 and co[i][1] == 1) {
        continue;
      }
      coo[0] += co[i][0];
      coo[1] += co[i][1];
    }
    cout << coo[0] * coo[1] << endl;
  }
  return 0;
}
