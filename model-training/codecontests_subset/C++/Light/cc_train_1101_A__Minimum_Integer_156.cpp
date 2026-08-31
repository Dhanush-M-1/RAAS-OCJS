#include <bits/stdc++.h>
using namespace std;
int main() {
  long long l, r, d, q;
  cin >> q;
  for (long long i = 0; i < q; i++) {
    cin >> l >> r >> d;
    if (l > d)
      cout << d << "\n";
    else
      cout << (r / d + 1) * d << "\n";
  }
}
