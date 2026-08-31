#include <bits/stdc++.h>
using namespace std;
vector<vector<int>> g;
vector<int> ans;
vector<int> kek;
void destroy(int v, int p) {
  if (kek[v] % 2 == 0) {
    kek[v] = -99999;
    ans.push_back(v);
    for (auto i : g[v]) {
      --kek[i];
      if (i != p) {
        destroy(i, v);
      }
    }
  }
}
void dfs(int v, int p) {
  for (auto i : g[v]) {
    if (p != i) {
      dfs(i, v);
    }
  }
  destroy(v, p);
}
int main() {
  int n;
  cin >> n;
  g.resize(n);
  kek.resize(n);
  for (int i = 0; i < n; ++i) {
    int a;
    cin >> a;
    --a;
    if (a != -1) {
      g[i].push_back(a);
      g[a].push_back(i);
      kek[i]++;
      kek[a]++;
    }
  }
  if (n % 2 == 0) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << endl;
  dfs(0, -1);
  for (int i = 0; i < ans.size(); ++i) {
    cout << ans[i] + 1 << endl;
  }
}
