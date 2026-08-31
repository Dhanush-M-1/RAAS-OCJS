#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int tc;
  cin >> tc;
  while (tc--) {
    long long int n;
    cin >> n;
    char ar[n + 1][n + 1];
    for (long long int i = 0; i < n; i++)
      for (long long int j = 0; j < n; j++) cin >> ar[i][j];
    long long int a, b, c, d;
    a = ar[0][1];
    b = ar[1][0];
    c = ar[n - 2][n - 1];
    d = ar[n - 1][n - 2];
    if (a == b and c == d and c == a) {
      cout << 2 << endl;
      cout << n - 1 << " " << n << endl << n << " " << n - 1 << endl;
    } else if (a != b and c != d) {
      cout << 2 << endl;
      if (a != c)
        cout << 1 << " " << 2 << endl << n - 1 << " " << n << endl;
      else if (a != d)
        cout << 1 << " " << 2 << endl << n << " " << n - 1 << endl;
    } else if (a == b and c != d) {
      cout << 1 << endl;
      if (c == a)
        cout << n - 1 << " " << n << endl;
      else if (d == a)
        cout << n << " " << n - 1 << endl;
    } else if (a != b and c == d) {
      cout << 1 << endl;
      if (a == c)
        cout << 1 << " " << 2 << endl;
      else if (b == c)
        cout << 2 << " " << 1 << endl;
    } else if (((a == b) and (c == d)) and c != a)
      cout << 0 << endl;
  }
  return 0;
}
