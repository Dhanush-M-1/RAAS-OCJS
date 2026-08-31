#include <bits/stdc++.h>
using namespace std;
int main() {
  int test;
  cin >> test;
  while (test--) {
    int l, r, d;
    cin >> l >> r >> d;
    int left = l / d;
    int right = r / d;
    if (left > 1)
      cout << d << "\n";
    else if (left == 1 && l % d != 0)
      cout << d << "\n";
    else {
      cout << d * (right + 1) << "\n";
    }
  }
  return 0;
}
