#include <bits/stdc++.h>
const long double eps = 1e-8;
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t = 1;
  cin >> t;
  while (t--) {
    long long int n;
    cin >> n;
    long long int a[n + 1][n + 1];
    string temp;
    for (long long int i = 1; i < n + 1; i++) {
      cin >> temp;
      for (long long int j = 0; j < n; j++) {
        a[i][j + 1] = temp[j] - '0';
      }
    }
    long long int x = a[1][2];
    long long int y = a[2][1];
    long long int p = a[n][n - 1];
    long long int q = a[n - 1][n];
    if (x == y) {
      if (p == q) {
        if (p != x)
          cout << 0 << "\n";
        else {
          cout << 2 << "\n";
          cout << "1 2"
               << "\n";
          cout << "2 1"
               << "\n";
        }
      } else {
        if (p == x) {
          cout << 1 << "\n";
          cout << n << " " << n - 1 << "\n";
        } else {
          cout << 1 << "\n";
          cout << n - 1 << " " << n << "\n";
        }
      }
    } else {
      if (p == q) {
        cout << 1 << "\n";
        if (x == p) {
          cout << "1 2"
               << "\n";
        } else
          cout << "2 1"
               << "\n";
      } else {
        cout << 2 << "\n";
        if (x == p) {
          cout << "1 2"
               << "\n";
          cout << n - 1 << " " << n << "\n";
        } else {
          cout << "1 2"
               << "\n";
          cout << n << " " << n - 1 << "\n";
        }
      }
    }
  }
}
