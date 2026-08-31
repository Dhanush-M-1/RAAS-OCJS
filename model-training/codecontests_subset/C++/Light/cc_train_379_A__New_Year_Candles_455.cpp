#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, t1, t2, res;
  cin >> a >> b;
  res = a;
  for (;;) {
    t1 = a / b;
    res = res + t1;
    t2 = a % b;
    if (t1 + t2 > 0) {
      a = t1 + t2;
    }
    if (a / b == 0) {
      break;
    }
  }
  cout << res << endl;
}
