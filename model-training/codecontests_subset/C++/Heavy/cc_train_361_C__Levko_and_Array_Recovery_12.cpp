#include <bits/stdc++.h>
using namespace std;
const int N = 5555;
const int INF = 1000000000;
int a[N], s[N];
set<int> S[N];
int C[N];
int main() {
  int n, m;
  set<int>::iterator it;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i) a[i] = INF;
  for (int c = 1; c <= m; ++c) {
    int t, l, r, v;
    cin >> t >> l >> r >> v;
    if (t == 1) {
      for (int i = l; i <= r; ++i) a[i] += v, s[i] += v;
    } else {
      int ok = 1;
      for (int i = l; i <= r; ++i) {
        if (a[i] == v) {
          C[c]++;
          S[i].insert(c);
        }
        if (a[i] > v) {
          a[i] = v;
          for (it = S[i].begin(); it != S[i].end(); ++it)
            if (!(--C[*it])) ok = 0;
          S[i].clear();
          C[c]++;
          S[i].insert(c);
        }
      }
      if (!C[c]) ok = 0;
      if (!ok) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  for (int i = 1; i <= n; ++i) cout << a[i] - s[i] << " ";
  cout << endl;
  return 0;
}
