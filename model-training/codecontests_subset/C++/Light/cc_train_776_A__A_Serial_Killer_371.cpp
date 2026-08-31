#include <bits/stdc++.h>
using namespace std;
int main(void) {
  int n;
  string a, b, c, d;
  cin >> a >> b;
  cout << a << " " << b << endl;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> c >> d;
    if (b != c) {
      cout << b << " " << d << endl;
      a = d;
    } else {
      cout << a << " " << d << endl;
      b = d;
    }
  }
}
