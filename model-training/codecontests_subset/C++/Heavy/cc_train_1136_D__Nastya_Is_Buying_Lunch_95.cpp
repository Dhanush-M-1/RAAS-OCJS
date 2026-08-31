#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 10;
int n, m;
int p[maxn];
vector<int> g[maxn];
set<int> st, tmp;
int main() {
  cin >> n >> m;
  for (int i = 1; i <= n; i++) cin >> p[i];
  for (int i = 1; i <= m; i++) {
    int u, v;
    cin >> u >> v;
    g[v].push_back(u);
  }
  for (auto x : g[p[n]]) st.insert(x);
  int ans = 0;
  for (int i = n - 1; i >= 0; i--) {
    if (st.empty()) break;
    if (st.find(p[i]) != st.end())
      ans++;
    else {
      tmp.clear();
      for (auto x : st) tmp.insert(x);
      st.clear();
      for (auto x : g[p[i]])
        if (tmp.find(x) != tmp.end()) st.insert(x);
    }
  }
  cout << ans << endl;
}
