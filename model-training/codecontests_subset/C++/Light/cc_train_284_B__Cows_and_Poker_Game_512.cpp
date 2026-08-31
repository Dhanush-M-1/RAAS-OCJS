#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, i, c = 0, x, y, z;
  cin >> a;
  char s[200001];
  cin >> s;
  x = count(s, s + a, 'A');
  y = count(s, s + a, 'I');
  z = count(s, s + a, 'F');
  if (y == 1) {
    cout << "1";
  } else if (y == 0) {
    cout << x;
  } else {
    cout << "0";
  }
}
