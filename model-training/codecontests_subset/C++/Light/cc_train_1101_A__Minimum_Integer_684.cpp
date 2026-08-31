#include <bits/stdc++.h>
using namespace std;
int d, l, r, n;
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> l >> r >> d;
    if (l > d) {
      cout << d << endl;
      continue;
    }
    cout << (r / d + 1) * d << endl;
  }
  return 0;
}
