#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, sum = 0, m, r, k;
  cin >> a >> b;
  k = a;
  while (a >= b) {
    m = a / b;
    r = a % b;
    a = r + m;
    sum = sum + m;
  }
  cout << k + sum << endl;
  return 0;
}
