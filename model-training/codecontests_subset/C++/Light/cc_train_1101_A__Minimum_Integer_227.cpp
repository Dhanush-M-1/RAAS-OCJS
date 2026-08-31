#include <bits/stdc++.h>
using namespace std;
int main() {
  std::ios::sync_with_stdio(false);
  int q;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l || d > r)
      cout << d << endl;
    else {
      long long t = r / d;
      cout << (t + 1) * d << endl;
    }
  }
  return 0;
}
