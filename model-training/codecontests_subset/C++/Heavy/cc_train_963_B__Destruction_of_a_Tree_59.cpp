#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
int n, root;
vector<int> adj[N];
int dp[N][2], deg[N];
bool mark[N];
void dfs(int u, int pre) {
  for (int v : adj[u]) {
    if (v == pre) continue;
    dfs(v, u);
  }
  for (int p = 0, _n = (2); p < _n; p++) {
    int d = (deg[u] + ((p == 0 && pre != -1) ? -1 : 0));
    vector<int> ban;
    for (int v : adj[u])
      if (v != pre) {
        if (!dp[v][0]) ban.push_back(v);
      }
    bool flag = false;
    for (int v : ban) {
      if (!dp[v][1]) {
        flag = true;
        break;
      }
    }
    if (flag) continue;
    if ((d - ban.size()) % 2 == 1) {
      flag = true;
      for (int v : adj[u])
        if (v != pre && dp[v][0]) {
          if (dp[v][1]) flag = false;
        }
      if (flag) continue;
    }
    dp[u][p] = 1;
  }
}
void print_ans(int u, int pre, int p) {
  int d = (deg[u] + ((p == 0 && pre != -1) ? -1 : 0)), cnt = 0;
  for (int v : adj[u])
    if (v != pre) {
      if (!dp[v][0]) {
        cnt++;
        print_ans(v, u, 1);
        mark[v] = 1;
      }
    }
  if ((d - cnt) % 2 == 1) {
    for (int v : adj[u])
      if (v != pre && dp[v][0] && dp[v][1]) {
        print_ans(v, u, 1);
        mark[v] = 1;
        break;
      }
  }
  cout << u << '\n';
  for (int v : adj[u])
    if (v != pre && !mark[v]) print_ans(v, u, 0);
}
int main(int argc, char const *argv[]) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  clock_t tStart = clock();
  cin >> n;
  for (int i = (1), _b = (n); i <= _b; i++) {
    int j;
    cin >> j;
    if (j == 0)
      root = i;
    else {
      adj[i].push_back(j);
      adj[j].push_back(i);
      deg[i]++;
      deg[j]++;
    }
  }
  dfs(root, -1);
  if (!dp[root][0]) {
    cout << "NO" << '\n';
    return 0;
  } else {
    cout << "YES" << '\n';
    print_ans(root, -1, 0);
  }
  fprintf(stderr, "Time taken: %.2fs\n",
          (double)(clock() - tStart) / CLOCKS_PER_SEC);
  return 0;
}
