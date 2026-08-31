#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b, c, d;
  int n;
  cin >> a >> b;
  cin >> n;
  cout << a << " " << b << endl;
  for (int i = 0; i < n; i++) {
    cin >> c >> d;
    if (c == a)
      a = d;
    else if (c == b)
      b = d;
    else if (d == a)
      a = c;
    else if (d == b)
      b = c;
    cout << a << " " << b << endl;
  }
  return 0;
}
