#include <bits/stdc++.h>
using namespace std;
void testcase() {
  int n, chng = 0;
  cin >> n;
  vector<string> a(n);
  vector<pair<int, int>> b;
  for (int i = 0; i < n; i++) cin >> a[i];
  if (a[0][1] == a[1][0]) {
    if (a[n - 1][n - 2] == a[n - 2][n - 1]) {
      if (a[n - 1][n - 2] != a[0][1]) {
        cout << 0 << endl;
        return;
      } else {
        cout << 2 << endl;
        cout << n << " " << n - 1 << endl;
        cout << n - 1 << " " << n << endl;
      }
    } else {
      if (a[n - 1][n - 2] == a[0][1]) {
        cout << 1 << endl;
        cout << n << " " << n - 1 << endl;
      } else {
        cout << 1 << endl;
        cout << n - 1 << " " << n << endl;
      }
    }
  } else {
    if (a[n - 1][n - 2] == a[n - 2][n - 1]) {
      if (a[0][1] == a[n - 1][n - 2]) {
        cout << 1 << endl;
        cout << 1 << " " << 2 << endl;
      } else {
        cout << 1 << endl;
        cout << 2 << " " << 1 << endl;
      }
    } else {
      cout << 2 << endl;
      if (a[0][1] == '1')
        cout << 1 << " " << 2 << endl;
      else {
        cout << 2 << " " << 1 << endl;
      }
      if (a[n - 1][n - 2] == '0')
        cout << n << " " << n - 1 << endl;
      else {
        cout << n - 1 << " " << n << endl;
      }
    }
  }
}
int main() {
  long long t;
  cin >> t;
  while (t--) {
    testcase();
  }
}
