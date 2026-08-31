#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    string m[n];
    for (int i = 0; i < n; i++) cin >> m[i];
    char a = m[1][0], b = m[0][1], c = m[n - 1][n - 2], d = m[n - 2][n - 1];
    if (a == b && c == d) {
      if (a == c)
        cout << "2\n2 1\n1 2\n";
      else
        cout << 0 << endl;
    } else if (a == b) {
      if (c == a)
        cout << "1\n" << n << ' ' << n - 1 << endl;
      else
        cout << "1\n" << n - 1 << ' ' << n << endl;
    } else if (c == d) {
      if (c == a)
        cout << "1\n2 1\n";
      else
        cout << "1\n1 2\n";
    } else {
      if (a == c)
        cout << "2\n2 1\n" << n - 1 << ' ' << n << endl;
      else
        cout << "2\n2 1\n" << n << ' ' << n - 1 << endl;
    }
  }
}
