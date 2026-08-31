#include <bits/stdc++.h>
using namespace std;
int main() {
  long n, x = 0, y = 0, z = 0, xx;
  cin >> n;
  for (long i = 1; i <= n; i++) {
    cin >> xx;
    x += xx;
  }
  for (long i = 1; i <= n - 1; i++) {
    cin >> xx;
    y += xx;
  }
  for (long i = 1; i <= n - 2; i++) {
    cin >> xx;
    z += xx;
  }
  cout << x - y << endl << y - z;
  return 0;
}
