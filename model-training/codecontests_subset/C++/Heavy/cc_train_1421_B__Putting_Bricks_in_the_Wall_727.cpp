#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    char a[n + 1][n + 1];
    for (int i = 1; i <= n; ++i)
      for (int j = 1; j <= n; ++j) cin >> a[i][j];
    int a12 = a[1][2] - '0', a21 = a[2][1] - '0', anl = a[n][n - 1] - '0',
        anu = a[n - 1][n] - '0';
    if (a12 == a21 && anl == anu) {
      if (a12 == anl)
        cout << "2\n1 2\n2 1\n";
      else
        cout << "0\n";
    } else if (a12 == a21) {
      if (anl == a12)
        cout << "1\n" << n << ' ' << n - 1 << '\n';
      else
        cout << "1\n" << n - 1 << ' ' << n << '\n';
    } else if (anl == anu) {
      if (anl == a12)
        cout << "1\n" << 1 << ' ' << 2 << '\n';
      else
        cout << "1\n" << 2 << ' ' << 1 << '\n';
    } else {
      cout << 2 << '\n';
      if (a12 == 0)
        cout << "1 2\n";
      else
        cout << "2 1\n";
      if (anl == 1)
        cout << n << ' ' << n - 1 << '\n';
      else
        cout << n - 1 << ' ' << n << '\n';
    }
  }
}
