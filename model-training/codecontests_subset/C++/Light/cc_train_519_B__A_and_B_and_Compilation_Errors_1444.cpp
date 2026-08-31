#include <bits/stdc++.h>
using namespace std;
int main() {
  long long unsigned n, x = 0, y = 0, z = 0, a, b, c;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    x = x + a;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b;
    y = y + b;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c;
    z = z + c;
  }
  cout << x - y << endl;
  cout << y - z;
  return 0;
}
