#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  for (int k = 0; k < q; k++) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l || d > r)
      cout << d << " ";
    else {
      long long tmp = r % d;
      cout << r + d - tmp << " ";
    }
  }
}
