#include <bits/stdc++.h>
using namespace std;
int n, z, x, g, c;
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> g;
    z += g;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> g;
    x += g;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> g;
    c += g;
  }
  cout << z - x << endl << x - c;
  return 0;
}
