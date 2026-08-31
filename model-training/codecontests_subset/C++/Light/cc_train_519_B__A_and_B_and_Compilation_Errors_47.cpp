#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  int i, n, a, x1, x2, x3;
  cin >> n;
  x1 = x2 = x3 = 0;
  for (i = 0; i < n; ++i) {
    cin >> a;
    x1 ^= a;
  }
  for (i = 0; i < n - 1; ++i) {
    cin >> a;
    x2 ^= a;
  }
  for (i = 0; i < n - 2; ++i) {
    cin >> a;
    x3 ^= a;
  }
  cout << (x1 ^ x2) << endl << (x2 ^ x3) << endl;
  return 0;
}
