#include <bits/stdc++.h>
using namespace std;
string a, b;
string c, d;
int main() {
  cin >> a >> b;
  cout << a << " " << b << endl;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> c >> d;
    if (c == a) {
      a = d;
    } else {
      b = d;
    }
    cout << a << " " << b << endl;
  }
  return 0;
}
