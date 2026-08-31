#include <bits/stdc++.h>
using namespace std;
int n, i;
int main() {
  string a, b, c, d;
  cin >> a >> b;
  cin >> n;
  cout << a << " " << b << endl;
  for (i = 0; i < n; i++) {
    cin >> c >> d;
    if (a == c) {
      a = d;
    } else
      b = d;
    cout << a << " " << b << endl;
  }
}
