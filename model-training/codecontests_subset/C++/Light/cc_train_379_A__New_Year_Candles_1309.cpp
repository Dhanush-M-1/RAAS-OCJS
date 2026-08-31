#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, q, s = 0, n, r, flag = 0, x = 3, r1;
  cin >> a >> b;
  n = a;
  q = a / b;
  r = a % b;
  while (q + r >= b) {
    flag = 1;
    s += q;
    r1 = r;
    r = (q + r) % b;
    q = (q + r1) / b;
  }
  s += q;
  if (flag == 1)
    cout << s + a;
  else
    cout << q + a;
  return 0;
}
