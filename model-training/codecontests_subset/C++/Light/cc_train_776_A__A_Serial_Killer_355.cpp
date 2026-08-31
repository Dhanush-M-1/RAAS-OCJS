#include <bits/stdc++.h>
using namespace std;
int main() {
  string a, b, c, d;
  long long n;
  cin >> a >> b;
  cin >> n;
  cout << a << " " << b << "\n";
  while (n) {
    n--;
    cin >> c >> d;
    if (c != a) {
      cout << a << " " << d << "\n";
      b = d;
    } else {
      cout << d << " " << b << "\n";
      a = d;
    }
  }
  return 0;
}
