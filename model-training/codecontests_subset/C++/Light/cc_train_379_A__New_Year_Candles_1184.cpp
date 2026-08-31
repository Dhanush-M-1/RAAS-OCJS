#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, h = 0;
  cin >> a >> b;
  while (true) {
    if (a >= b) {
      h += b;
      a -= (b - 1);
    } else {
      h += a;
      break;
    }
  }
  cout << h << "\n";
}
