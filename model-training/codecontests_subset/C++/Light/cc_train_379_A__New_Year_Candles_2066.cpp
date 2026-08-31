#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, a, b, c, i(0), j, t;
  cin >> n >> m;
  a = n;
  t = n;
  for (b = m; b <= a; b += m) {
    t++;
    a++;
  }
  cout << t;
  return 0;
}
