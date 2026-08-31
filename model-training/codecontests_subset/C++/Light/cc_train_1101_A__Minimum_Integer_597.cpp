#include <bits/stdc++.h>
#pragma GCC target("sse2")
#pragma GCC optimization("Ofast")
#pragma GCC optimization("unroll-loops")
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int q;
  cin >> q;
  while (q--) {
    long long int l, r, x;
    cin >> l >> r >> x;
    if (x < l || x > r) {
      cout << x << ' ';
      continue;
    }
    long long int y = r + (x - (r % x));
    cout << y << ' ';
  }
  return 0;
}
