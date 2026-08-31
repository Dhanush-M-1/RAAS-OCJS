#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) {
    int l, r, d, m, s;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
    } else {
      s = ((r / d) + 1) * d;
      cout << s << endl;
    }
  }
}
