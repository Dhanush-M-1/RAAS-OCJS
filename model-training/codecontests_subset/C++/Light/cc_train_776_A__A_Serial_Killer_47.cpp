#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b, c, d;
  int n;
  cin >> a >> b >> n;
  cout << a << " " << b << endl;
  for (int i = 0; i < n; i++) {
    cin >> c >> d;
    if (c == a) {
      cout << d << " " << b << endl;
      a = d;
    } else if (c == b) {
      cout << a << " " << d << endl;
      b = d;
    } else if (d == a) {
      cout << c << " " << b << endl;
      a = c;
    } else {
      cout << a << " " << c << endl;
      d = c;
    }
  }
  return 0;
}
