#include <bits/stdc++.h>
using namespace std;
const int maxik = 2e5 + 10;
int g[maxik];
vector<int> rodes[maxik];
void dfs(int curr) {
  bool us[rodes[curr].size() + 1];
  memset(us, 0, rodes[curr].size() + 1);
  for (int i = 0; i < rodes[curr].size(); i++) {
    int neighbour = rodes[curr][i];
    if (g[neighbour] == -1) {
      dfs(neighbour);
    }
    if (g[neighbour] <= rodes[curr].size()) {
      us[g[neighbour]] = 1;
    }
  }
  for (int i = 0; i > -1; i++) {
    if (us[i] == 0) {
      g[curr] = i;
      break;
    }
  }
}
int main() {
  int n, m;
  cin >> n >> m;
  int tax[n], value[n];
  for (int i = 0; i < n; i++) {
    cin >> tax[i];
    value[i] = 0;
    g[i] = -1;
  }
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    u--;
    v--;
    rodes[u].push_back(v);
  }
  for (int i = 0; i < n; i++) {
    if (g[i] == -1) {
      dfs(i);
    }
    value[g[i]] = value[g[i]] ^ tax[i];
  }
  for (int i = n - 1; i >= 0; i--) {
    if (value[i]) {
      int befor = -1;
      for (int j = 0; j < n; j++) {
        if (g[j] == i && (value[i] ^ tax[j]) < tax[j]) {
          befor = j;
        }
      }
      tax[befor] = value[i] ^ tax[befor];
      value[i] = 0;
      for (int j = 0; j < rodes[befor].size(); j++) {
        int neighbour = rodes[befor][j];
        tax[neighbour] = value[g[neighbour]] ^ tax[neighbour];
        value[g[neighbour]] = 0;
      }
      cout << "WIN\n";
      for (int j = 0; j < n; j++) {
        cout << tax[j] << ' ';
      }
      return 0;
    }
  }
  cout << "LOSE";
}
