#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int l, r, k;
    cin >> l >> r >> k;
    if (k < l) {
      cout << k << endl;
    } else {
      cout << (r / k + 1) * k << endl;
    }
  }
  return 0;
}
