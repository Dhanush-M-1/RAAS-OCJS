#include <bits/stdc++.h>
using namespace std;
string a, b, c, d;
int main() {
  int n;
  cin >> a >> b;
  cout << a << ' ' << b << endl;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> c >> d;
    if (c == a)
      cout << d << ' ' << b << endl, a = d;
    else if (c == b)
      cout << a << ' ' << d << endl, b = d;
  }
  return 0;
}
