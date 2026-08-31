#include <bits/stdc++.h>
using namespace std;
int n, x, y;
int main() {
  while (cin >> n >> x >> y) {
    int nd = (n * y + 99) / 100;
    if (nd <= x)
      puts("0");
    else
      cout << nd - x << endl;
  }
}
