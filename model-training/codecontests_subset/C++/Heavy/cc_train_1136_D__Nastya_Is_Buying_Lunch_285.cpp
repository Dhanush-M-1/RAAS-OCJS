#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using vi = vector<int>;
using ii = pair<int, int>;
using vii = vector<ii>;
set<int> g[300000];
vi h;
int p[300000], q[300000];
bool bad[300000];
int badnum;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  for (int i = 0; i < n; ++i) {
    cin >> p[i];
    p[i]--;
    q[p[i]] = i;
  }
  for (int i = 0; i < m; ++i) {
    int u, v;
    cin >> u >> v;
    g[u - 1].insert(v - 1);
    if (v - 1 == p[n - 1]) h.push_back(u - 1);
  }
  sort(h.begin(), h.end(), [](int a, int b) { return q[a] > q[b]; });
  int pos = n - 1, sol = 0;
  for (int x : h) {
    for (int i = q[x] + 1; i < pos; ++i) bad[p[i]] = true, badnum++;
    int cnt = 0;
    for (int y : g[x])
      if (bad[y]) cnt++;
    if (cnt == badnum)
      sol++;
    else
      bad[x] = true, badnum++;
    pos = q[x];
  }
  cout << sol;
}
