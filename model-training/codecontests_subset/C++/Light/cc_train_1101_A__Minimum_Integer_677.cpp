#include <bits/stdc++.h>
using namespace std;
uint64_t minmul(uint64_t l, uint64_t r, uint64_t d) {
  if (d < l || d > r) return d;
  uint64_t mod = r % d;
  return r + (d - mod);
}
int main() {
  uint64_t q;
  cin >> q;
  uint64_t l, r, d;
  for (uint64_t i = 0; i < q; i++) {
    cin >> l >> r >> d;
    cout << minmul(l, r, d) << endl;
  }
  return 0;
}
