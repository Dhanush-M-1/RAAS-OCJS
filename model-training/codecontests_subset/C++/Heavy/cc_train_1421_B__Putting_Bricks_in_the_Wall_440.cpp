#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t, n, i, j, y, ans;
  string s;
  char ch;
  cin >> t;
  while (t--) {
    cin >> n;
    vector<int> a(4);
    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        cin >> ch;
        if (i == 0 && j == 1) {
          a[0] = ch - '0';
        }
        if (i == 1 && j == 0) {
          a[1] = ch - '0';
        }
        if (i == n - 2 && j == n - 1) {
          a[2] = ch - '0';
        }
        if (i == n - 1 && j == n - 2) {
          a[3] = ch - '0';
        }
      }
    }
    if (a[0] != a[1]) {
      if (a[2] == a[3]) {
        if (a[0] != a[2]) {
          cout << 1 << "\n"
               << "2 1"
               << "\n";
        } else {
          cout << 1 << "\n"
               << "1 2"
               << "\n";
        }
      } else {
        if (a[0] == a[2]) {
          cout << 2 << "\n"
               << "2 1"
               << "\n"
               << (n - 1) << " " << n << "\n";
        } else {
          cout << 2 << "\n"
               << "2 1"
               << "\n"
               << (n) << " " << (n - 1) << "\n";
        }
      }
    } else {
      if (a[2] == a[3]) {
        if (a[0] != a[2]) {
          cout << 0 << "\n";
        } else {
          cout << 2 << "\n"
               << n - 1 << " " << n << "\n"
               << n << " " << n - 1 << "\n";
        }
      } else {
        if (a[0] == a[2]) {
          cout << 1 << "\n" << n - 1 << " " << n << "\n";
        } else {
          cout << 1 << "\n" << n << " " << n - 1 << "\n";
        }
      }
    }
  }
}
