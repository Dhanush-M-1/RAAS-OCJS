#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, c;
  while (cin >> a >> b >> c) {
    if (b >= a)
      puts("0");
    else {
      int can = (a - b) * c / b;
      can = max(can - 5, 0);
      while (true) {
        if ((a - b) * c <= can * b) break;
        ++can;
      }
      cout << can << endl;
    }
  }
  return 0;
}
