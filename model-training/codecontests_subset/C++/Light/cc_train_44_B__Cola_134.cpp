#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, i, j, r = 0, t;
  cin >> n >> a >> b >> c;
  n *= 2;
  for (i = 0; i <= c; i++) {
    for (j = 0; j <= b; j++) {
      t = n - 4 * i - 2 * j;
      if (t < 0) break;
      if (t <= a) r++;
    }
  }
  cout << r;
}
