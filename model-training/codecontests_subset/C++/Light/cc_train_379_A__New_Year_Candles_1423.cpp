#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, n, c = 0;
  cin >> a >> b;
  n = a;
  while (a >= b) {
    c = a % b;
    a /= b;
    n += a;
    a += c;
  }
  cout << n;
  return 0;
}
