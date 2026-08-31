#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c, d;
  cin >> a;
  while (a--) {
    cin >> b >> c >> d;
    if (d < b || d > c) {
      cout << d << endl;
    } else
      cout << ((c / d) + 1) * d << endl;
  }
}
