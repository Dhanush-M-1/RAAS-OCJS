#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, re = 0, out = 0;
  cin >> a >> b;
  while (a > 0 || out >= b) {
    re += a;
    out += a;
    a = out / b;
    out = out % b;
  }
  cout << re;
  return 0;
}
