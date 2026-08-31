#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, t = 0, c = 0;
  cin >> a >> b;
  t += a;
  while (b <= a) {
    c = a % b;
    a /= b;
    t += a;
    a += c;
  }
  cout << t << endl;
  return 0;
}
