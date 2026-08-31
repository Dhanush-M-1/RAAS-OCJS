#include <bits/stdc++.h>
using namespace std;
bool was[10000], ansb;
int t, n, m, a, ans;
int main() {
  cin >> t;
  for (int j = 0; j < t; j++) {
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
      cin >> a;
      was[a] = true;
    }
    for (int i = 0; i < m; i++) {
      cin >> a;
      if (was[a] == true) {
        ansb = true;
        ans = a;
      }
    }
    if (ansb) {
      cout << "YES" << endl << 1 << " " << ans << endl;
    } else {
      cout << "NO" << endl;
    }
    for (int i = 0; i <= 1000; i++) {
      was[i] = false;
    }
    ansb = false;
  }
}
