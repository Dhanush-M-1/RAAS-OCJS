#include <bits/stdc++.h>
using namespace std;
const int N = 1000005;
int x[N], y[N], w[N], s[N], v[N];
vector<pair<int, int>> e[N];
vector<int> ans;
int n, m;
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> m;
  for (int i = 1; i <= m; i++) {
    cin >> x[i] >> y[i];
    w[i] = 1;
    ++s[x[i]];
    ++s[y[i]];
    e[max(x[i], y[i])].push_back({min(x[i], y[i]), i});
  }
  for (int i = 1; i <= n; i++) {
    set<int> st;
    for (auto &j : e[i]) {
      if (!v[j.first]) v[j.first] = 1, w[j.second] = 0, --s[i];
      st.insert(s[j.first]);
    }
    for (auto &j : e[i]) {
      if (!st.count(s[i])) break;
      ++s[i];
      v[j.first] = 0;
      ++w[j.second];
    }
  }
  for (int i = 1; i <= n; i++)
    if (v[i]) ans.push_back(i);
  cout << ans.size() << endl;
  for (auto &i : ans) cout << i << ' ';
  cout << endl;
  for (int i = 1; i <= m; i++)
    cout << x[i] << ' ' << y[i] << ' ' << w[i] << '\n';
  return 0;
}
