#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, f, g;
  cin >> m >> n >> f;
  if (n >= m) {
    cout << 0;
    return 0;
  }
  g = f * m - f * n;
  f = g / n;
  if (f * n < g) f++;
  cout << f;
}
