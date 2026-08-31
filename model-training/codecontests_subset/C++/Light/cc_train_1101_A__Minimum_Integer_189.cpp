#include <bits/stdc++.h>
using namespace std;
int x, y, a, b, c;
int main() {
  cin >> x;
  for (int i = 0; i < x; i++) {
    cin >> a >> b >> c;
    y = a % c;
    if (a <= c) {
      y = b % c;
      cout << b + c - y;
    } else {
      cout << c;
    }
    if (i < x - 1) {
      cout << endl;
    }
  }
}
