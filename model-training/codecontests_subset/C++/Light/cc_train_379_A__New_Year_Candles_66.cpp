#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, e, g, s;
  cin >> n >> m;
  s = n;
  while (1) {
    e = n % m;
    g = n / m;
    s += g;
    g += e;
    n = g;
    if (g < m) {
      break;
    }
  }
  cout << s;
}
