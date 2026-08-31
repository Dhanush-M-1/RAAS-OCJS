#include <bits/stdc++.h>
using namespace std;
int main() {
  srand(chrono::duration_cast<chrono::nanoseconds>(
            chrono::high_resolution_clock::now().time_since_epoch())
            .count());
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    map<int, int> z;
    for (int i = 0; i < n; ++i) {
      int val;
      cin >> val;
      z[val] = 1;
    }
    int found = -1;
    for (int j = 0; j < m; ++j) {
      int val;
      cin >> val;
      if (z[val]) found = val;
    }
    if (found == -1) {
      cout << "NO\n";
    } else {
      cout << "YES\n" << 1 << ' ' << found << '\n';
    }
  }
  return 0;
}
