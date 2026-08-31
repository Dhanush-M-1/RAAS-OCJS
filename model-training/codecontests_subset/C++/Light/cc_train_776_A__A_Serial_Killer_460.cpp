#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b, x, y;
  int n;
  cin >> a >> b >> n;
  n++;
  while (n--) {
    cout << a << " " << b << '\n';
    cin >> x >> y;
    if (x == a)
      a = y;
    else if (x == b)
      b = y;
  }
}
