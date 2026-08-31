#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b;
  cin >> a >> b;
  cout << a << " " << b << "\n";
  int n;
  cin >> n;
  while (n--) {
    string x, y;
    cin >> x >> y;
    if (x == a) {
      a = y;
    } else {
      b = y;
    }
    cout << a << " " << b << "\n";
  }
}
