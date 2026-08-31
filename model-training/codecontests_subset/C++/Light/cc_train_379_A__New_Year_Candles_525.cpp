#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, p, q, i, j, r, n;
  cin >> a >> b;
  p = a;
  while (a >= b) {
    q = a / b;
    p += q;
    r = a % b;
    a = q + r;
  }
  cout << p << endl;
  return 0;
}
