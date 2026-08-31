#include <bits/stdc++.h>
using namespace std;
int q;
int main() {
  cin >> q;
  long long l, r, d;
  while (q--) {
    cin >> l >> r >> d;
    if (l > d)
      cout << d << endl;
    else
      cout << ((r + d) / d) * d << endl;
  }
  return 0;
}
