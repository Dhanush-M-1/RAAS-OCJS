#include <bits/stdc++.h>
using namespace std;
int main() {
  int m = 0, p = 0, i, u = 0, l = 0, z, k, n = 0;
  string x;
  cin >> x;
  k = x.size();
  if (x[k - 1]) m = 1;
  for (i = 0; i < k; i += 2) {
    if (x[i] % 3 == 0) {
      l = 1;
      n = i;
    }
    if (x[i] % 3 == 2) {
      p = 1;
      u = i;
    }
  }
  for (i = 0; i < k; i += 2) {
    if (x[i] % 3 == 1 && i != k - 1)
      cout << x[i] << '+';
    else if (x[i] % 3 == 1 && i == k - 1 && (p == 1 || l == 1))
      cout << x[i] << '+';
    else if (x[i] % 3 == 1 && i == k - 1 && (p == 0 || l == 0))
      cout << x[i];
  }
  for (i = 0; i < k; i += 2) {
    if (x[i] % 3 == 2 && i != u) cout << x[i] << '+';
    if (x[i] % 3 == 2 && i == u && l == 0) cout << x[i];
    if (x[i] % 3 == 2 && i == u && l == 1) cout << x[i] << '+';
  }
  for (i = 0; i < k; i += 2) {
    if (x[i] % 3 == 0 && i != n) cout << x[i] << '+';
    if (x[i] % 3 == 0 && i == n) cout << x[i];
  }
  return 0;
}
