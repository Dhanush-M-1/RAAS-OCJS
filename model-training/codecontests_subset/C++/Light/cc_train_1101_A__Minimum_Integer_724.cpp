#include <bits/stdc++.h>
using namespace std;
long long l, d, r, temp = 0, temp2, i;
int main() {
  int q;
  cin >> q;
  while (q--) {
    cin >> l >> r >> d;
    if (d < l || d > r) {
      cout << d << endl;
      continue;
    }
    temp = ((r + d) / d) * d;
    cout << temp << endl;
  }
  return 0;
}
