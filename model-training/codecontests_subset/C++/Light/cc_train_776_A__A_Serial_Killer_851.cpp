#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b, x, y;
  int n;
  cin >> a >> b >> n;
  cout << a << " " << b << endl;
  for (int i = 0; i < n; i++) {
    cin >> x >> y;
    if (x == a) {
      a = "";
      a += y;
    } else if (x == b) {
      b = "";
      b += y;
    }
    cout << a << " " << b << endl;
  }
}
