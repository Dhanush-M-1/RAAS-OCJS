#include <bits/stdc++.h>
using namespace std;
int main() {
  long long t;
  cin >> t;
  while (t--) {
    long long l, r, d;
    cin >> l >> r >> d;
    long long a, b;
    if (d < l)
      cout << d << endl;
    else {
      a = r / d;
      b = (a + 1) * d;
      cout << b << endl;
    }
  }
  return 0;
}
