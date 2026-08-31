#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  while (q--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
      continue;
    }
    int cnt = (r + d) / d;
    cout << cnt * d << endl;
  }
  return 0;
}
