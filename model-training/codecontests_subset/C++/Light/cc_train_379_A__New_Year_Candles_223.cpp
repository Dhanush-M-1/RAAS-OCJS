#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, t = 0;
  cin >> a >> b;
  t += a;
  while (a >= b) {
    t += (a / b);
    a = a / b + (a % b);
  }
  cout << t;
  return 0;
}
