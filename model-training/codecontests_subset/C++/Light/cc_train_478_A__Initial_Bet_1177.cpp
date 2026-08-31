#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d, e;
  cin >> a >> b >> c >> d >> e;
  int x = a + b + c + d + e;
  if (x % 5 == 0 and x > 0) {
    cout << x / 5 << endl;
  } else {
    cout << -1 << endl;
  }
}
