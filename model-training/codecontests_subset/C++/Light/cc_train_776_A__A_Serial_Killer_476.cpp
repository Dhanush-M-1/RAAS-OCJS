#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b, c, d;
  int t = 0, n = 0;
  cin >> a >> b;
  scanf("%d", &t);
  cout << a << " " << b << endl;
  while (t--) {
    cin >> c >> d;
    if (c == a)
      a = d;
    else if (c == b)
      b = d;
    else if (d == a)
      a = c;
    else
      b = c;
    cout << a << " " << b << endl;
  }
  return 0;
}
