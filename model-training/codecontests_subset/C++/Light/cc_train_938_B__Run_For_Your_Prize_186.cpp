#include <bits/stdc++.h>
using namespace std;
int main() {
  int a = 1, b, c = 0, d = 0, e = 0, f, i = 0, k = 0, j = 0, n = 0, t = 0,
      l = 0, m = 0, h[3000] = {0};
  string s, x;
  cin >> t;
  n = 1000000;
  for (i = 0; i < t; i++) {
    cin >> b;
    j = max(j, min(b - 1, 1000000 - b));
  }
  cout << j;
  return 0;
}
