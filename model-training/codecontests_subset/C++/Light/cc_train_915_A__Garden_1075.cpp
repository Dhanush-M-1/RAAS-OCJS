#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, y, z, a;
  cin >> x >> y;
  a = y;
  for (int i = 0; i < x; i++) {
    cin >> z;
    if (y % z == 0 && a > (y / z)) {
      a = y / z;
    }
  }
  cout << a;
}
