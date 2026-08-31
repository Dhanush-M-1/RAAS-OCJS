#include <bits/stdc++.h>
using namespace std;
void ipgraph(int m);
void dfs(int u, int par);
const int mod = 1000000007;
const int N = 3e5, M = N;
int main() {
  int m, n, t, tt;
  cin >> t;
  while (t--) {
    set<int> as;
    vector<int> b;
    int res = -1;
    cin >> m >> n;
    b.resize(n);
    for (int i = 0; i < m; i++) {
      cin >> tt;
      as.insert(tt);
    }
    for (int i = 0; i < n; i++) {
      cin >> tt;
      if (as.find(tt) != as.end()) res = tt;
    }
    if (res != -1) {
      cout << "YES" << endl;
      cout << 1 << " " << res << endl;
    } else {
      cout << "NO" << endl;
    }
  }
  return 0;
}
