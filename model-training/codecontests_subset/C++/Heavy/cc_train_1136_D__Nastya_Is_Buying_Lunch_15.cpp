#include <bits/stdc++.h>
using namespace std;
const int maxn = 100010;
int p[3 * maxn];
vector<int> g[3 * maxn];
bool marked[3 * maxn];
bool bachahua[3 * maxn];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n = 0, m = 0, x = 0, y = 0;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) {
    cin >> x;
    p[x] = i;
  }
  for (int i = 0; i < m; ++i) {
    cin >> x >> y;
    g[p[x]].push_back(p[y]);
    if (p[y] == n) marked[p[x]] = true;
  }
  int res = 0, sz = 0;
  for (int i = n - 1; i >= 1; --i) {
    if (marked[i]) {
      if (sz > (int)g[i].size()) {
        bachahua[i] = true;
        ++sz;
        continue;
      }
      int poss = 0;
      for (auto j : g[i])
        if (bachahua[j]) ++poss;
      if (poss != sz) {
        bachahua[i] = true;
        ++sz;
        continue;
      }
      ++res;
    } else {
      bachahua[i] = true;
      ++sz;
    }
  }
  cout << res;
}
