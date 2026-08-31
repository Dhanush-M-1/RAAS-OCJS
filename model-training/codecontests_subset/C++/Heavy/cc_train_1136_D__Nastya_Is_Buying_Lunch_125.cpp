#include <bits/stdc++.h>
using namespace std;
set<int> r;
set<int> d[300005];
vector<int> in;
int main() {
  int n, m;
  cin >> n >> m;
  in.resize(n);
  for (int i = 0; i < n; i++) {
    cin >> in[i];
  }
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> u >> v;
    d[u].insert(v);
  }
  int ret = 0;
  r.insert(in.back());
  for (int i = n - 2; i >= 0; i--) {
    bool swappable = false;
    if (d[in[i]].size() >= r.size()) {
      swappable = true;
      for (int x : r) {
        if (d[in[i]].find(x) == d[in[i]].end()) {
          swappable = false;
          break;
        }
      }
    }
    if (swappable) {
      ret++;
    } else {
      r.insert(in[i]);
    }
  }
  cout << ret << endl;
  return 0;
}
