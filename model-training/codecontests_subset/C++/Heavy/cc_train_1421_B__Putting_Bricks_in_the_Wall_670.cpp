#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  ;
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    vector<string> v(n);
    for (int i = 0; i < n; i++) {
      cin >> v[i];
    }
    int up = (v[0][1] - 48) + (v[1][0] - 48);
    int down = (v[n - 1][n - 2] - 48) + (v[n - 2][n - 1] - 48);
    if (up == down) {
      if (up == 1) {
        cout << 2 << "\n";
        if (v[0][1] == '1')
          cout << "1 2"
               << "\n";
        if (v[1][0] == '1')
          cout << "2 1"
               << "\n";
        if (v[n - 1][n - 2] == '0') cout << n << " " << n - 1 << "\n";
        if (v[n - 2][n - 1] == '0') cout << n - 1 << " " << n << "\n";
      } else {
        cout << 2 << "\n";
        cout << "1 2"
             << "\n";
        cout << "2 1"
             << "\n";
      }
    } else {
      if (abs(up - down) == 2) {
        cout << 0 << "\n";
      } else {
        cout << 1 << "\n";
        if (up == 1) {
          if (down == 0) {
            if (v[0][1] == '0')
              cout << "1 2"
                   << "\n";
            if (v[1][0] == '0')
              cout << "2 1"
                   << "\n";
          } else {
            if (v[0][1] == '1')
              cout << "1 2"
                   << "\n";
            if (v[1][0] == '1')
              cout << "2 1"
                   << "\n";
          }
        } else {
          if (up == 0) {
            if (v[n - 1][n - 2] == '0') cout << n << " " << n - 1 << "\n";
            if (v[n - 2][n - 1] == '0') cout << n - 1 << " " << n << "\n";
          } else {
            if (v[n - 1][n - 2] == '1') cout << n << " " << n - 1 << "\n";
            if (v[n - 2][n - 1] == '1') cout << n - 1 << " " << n << "\n";
          }
        }
      }
    }
  }
}
