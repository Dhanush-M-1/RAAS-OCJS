#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  cin >> a >> b;
  cout << a << " " << b << endl;
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    string x, y;
    cin >> x >> y;
    if (a == x) {
      a = y;
    } else {
      b = y;
    }
    cout << a << " " << b << endl;
  }
  return 0;
}
