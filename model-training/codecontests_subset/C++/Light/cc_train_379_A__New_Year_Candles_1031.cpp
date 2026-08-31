#include <bits/stdc++.h>
using namespace std;
int f(int a, int b) {
  int l = 0, t = 0;
  while (1) {
    t += a;
    l += a % b;
    a /= b;
    a += l / b;
    l %= b;
    if (a == 0) return t;
  }
}
int main() {
  int a, b;
  cin >> a >> b;
  cout << f(a, b) << endl;
  return 0;
}
