#include <bits/stdc++.h>
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("O3")
using namespace std;
int a[1000], b[1000];
map<int, bool> mk;
int main() {
  iostream::sync_with_stdio(0);
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    b[i] = a[i];
  }
  sort(a, a + n);
  int m;
  cin >> m;
  for (int i = 0; i < m; i++) {
    mk.clear();
    int pos, k;
    cin >> k >> pos;
    vector<int> g;
    g.clear();
    for (int j = n - 1; j >= n - k; j--) {
      int p;
      for (int u = 0; u < n; u++)
        if (!mk[u] && b[u] == a[j]) {
          p = u;
          mk[u] = 1;
          break;
        }
      g.push_back(p);
    }
    sort(g.begin(), g.end());
    cout << b[g[pos - 1]] << "\n";
  }
}
