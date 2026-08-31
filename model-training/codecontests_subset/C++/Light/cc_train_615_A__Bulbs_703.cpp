#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-9;
const int INF = 1000000007;
const int MOD = 1000000007;
const int MAXN = 100055;
int main() {
  int n, m;
  cin >> n >> m;
  vector<bool> on(m + 1, false);
  while (n--) {
    int cnt;
    cin >> cnt;
    while (cnt--) {
      int idx;
      cin >> idx;
      on[idx] = true;
    }
  }
  bool yes = true;
  for (int i = 1; i <= m; ++i) {
    yes &= on[i];
  }
  cout << (yes ? "YES" : "NO") << endl;
  return 0;
}
