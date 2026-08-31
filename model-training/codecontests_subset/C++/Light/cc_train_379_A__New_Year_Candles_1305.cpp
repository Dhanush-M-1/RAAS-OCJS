#include <bits/stdc++.h>
using namespace std;
const int oo = 0x3f3f3f3f;
int main() {
  int a, b, res = 0;
  cin >> a >> b;
  res = a;
  while (a / b > 0) {
    res += a / b;
    a = a / b + a % b;
  }
  cout << res << endl;
  return 0;
}
