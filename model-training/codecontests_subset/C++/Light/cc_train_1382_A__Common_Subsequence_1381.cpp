#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<int> ar(n);
    vector<int> ar2(m);
    int ans = -1;
    for (int i = 0; i < n; ++i) {
      cin >> ar[i];
    }
    for (int i = 0; i < m; ++i) {
      cin >> ar2[i];
    }
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (ar[i] == ar2[j]) ans = ar[i];
      }
    }
    if (ans == -1)
      cout << "NO" << endl;
    else {
      cout << "YES" << endl;
      cout << 1 << " " << ans << endl;
    }
  }
}
