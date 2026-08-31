#include <bits/stdc++.h>
using namespace std;
string a, b, c, f;
int d;
int main() {
  cin >> a >> b >> d;
  for (int e = 0; e < d; e++) {
    cout << a << " " << b << endl;
    cin >> c >> f;
    if (a == c) {
      a = f;
    } else {
      b = f;
    }
  }
  cout << a << " " << b << endl;
  return 0;
}
