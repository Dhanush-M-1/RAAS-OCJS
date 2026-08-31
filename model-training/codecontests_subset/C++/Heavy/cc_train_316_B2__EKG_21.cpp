#include <bits/stdc++.h>
using namespace std;
int go(int curr, vector<int> &vis, vector<vector<int>> &adj, int num) {
  vis[curr] = num;
  int ret = 1;
  for (int x : adj[curr]) {
    if (vis[x] == -1) {
      ret += go(x, vis, adj, num + 1);
    }
  }
  return ret;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, x;
  cin >> n >> x;
  vector<vector<int>> adj(n + 1);
  vector<int> par(n + 1, -1);
  for (int i = 1; i <= n; i++) {
    int y;
    cin >> y;
    if (y) {
      adj[i].push_back(y);
      adj[y].push_back(i);
      par[i] = y;
    }
  }
  vector<int> vis(n + 1, -1);
  int mySize;
  int myBefore, myAfter;
  vector<int> coins;
  for (int i = 1; i <= n; i++) {
    int sz = 0;
    if (adj[i].size() <= 1 && vis[i] == -1) {
      sz = go(i, vis, adj, 1);
    }
    if (sz) {
      if (vis[x] != 0 && vis[x] != -1) {
        mySize = sz;
        myBefore = vis[x] - 1;
        myAfter = mySize - vis[x];
        vis[x] = 0;
      } else
        coins.push_back(sz);
    }
  }
  myBefore = 0;
  while (par[x] != -1) {
    x = par[x];
    myBefore++;
  }
  vector<bool> pos(n + 1, 0);
  pos[0] = true;
  for (int i = 0; i < coins.size(); i++) {
    for (int w = n; w >= 0; w--) {
      if (pos[w] && w + coins[i] <= n) pos[w + coins[i]] = true;
    }
  }
  for (int i = 0; i + mySize <= n; i++) {
    int left = i;
    int right = n - mySize - left;
    if (pos[left] || pos[right]) {
      cout << i + myBefore + 1 << '\n';
    }
  }
  return 0;
}
