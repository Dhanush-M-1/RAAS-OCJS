#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;
  if (a == 0 && b == 0 && c == 0 && d == 0 && e == 0) {
    cout << -1;
    return 0;
  }
  if ((a + b + c + d + e) % 5 == 0) {
    a = (a + b + c + d + e) / 5;
    cout << a;
  } else {
    cout << -1;
  }
  return 0;
}
